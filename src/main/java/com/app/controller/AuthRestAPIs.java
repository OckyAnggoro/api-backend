package com.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Menu;
import com.app.model.Role;
import com.app.model.User;
import com.app.jwtauthentication.message.request.LoginForm;
import com.app.jwtauthentication.message.request.SignUpForm;
import com.app.jwtauthentication.message.response.JwtResponse;
import com.app.jwtauthentication.security.jwt.JwtProvider;
import com.app.repository.RoleRepository;
import com.app.repository.UserRepository;
import com.app.response.ResponseMessage;
import com.app.service.MenuService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginForm loginForm){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginForm.getUserName(), loginForm.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		List<String> roleCodeList = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		/*for(GrantedAuthority grantedAuthority: userDetails.getAuthorities()) {
			roleCode += grantedAuthority.getAuthority();
		}*/
		System.out.println("Role code = " + roleCodeList);
		List<Menu> treeMenu = menuService.findByRoleCodeList(roleCodeList);
		//AuthenticationDTO authenticationDTO = new AuthenticationDTO(jwt, userDetails, treeMenu); Gak jadi liat nanti
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), treeMenu));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpForm signUpForm){
		
		if(userRepository.existsByUserName(signUpForm.getUserName())){
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!")
			, HttpStatus.BAD_REQUEST);
		}
		
		if(userRepository.existsByEmail(signUpForm.getEmail())){
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use"), HttpStatus.BAD_REQUEST);
		}
		
		User user = new User(signUpForm.getName(), signUpForm.getUserName(),
				signUpForm.getEmail(), encoder.encode(signUpForm.getPassword()));

		Set<Role> roles = new HashSet<>();
		Role role = new Role("Role User", "USER"); //default role User
		roles.add(roleRepository.findByCode(role.getCode()));

		// user.setRoles(roles);
		userRepository.save(user);
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}
