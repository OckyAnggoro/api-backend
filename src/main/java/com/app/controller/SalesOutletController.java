package com.app.controller;

import com.app.base.Response;
import com.app.base.SearchCriteria;
import com.app.base.SearchOperation;
import com.app.dto.SalesOutletDTO;
import com.app.model.Outlet;
import com.app.model.SalesOutlet;
import com.app.model.User;
import com.app.model.UserRole;
import com.app.service.SalesOutletService;
import com.app.service.UserRoleService;
import com.app.service.UserService;
import com.app.specification.GeneralSpecification;
import lombok.extern.flogger.Flogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/sales-outlet")
public class SalesOutletController extends BaseController{

    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserService userService;
    @Autowired
    SalesOutletService salesOutletService;


    @GetMapping("/findAllSalesOutlet")
    public ResponseEntity<UserRole> findAllSalesOutlet(@RequestParam int page,
                                                       @RequestParam int limit,
                                                       @RequestParam(required = false) String search){

        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        GeneralSpecification specificationMatch = null;
        Specification specification = null;

        if (search != null && !search.isEmpty()){
            specificationMatch = new GeneralSpecification(
                    new SearchCriteria(search, SearchOperation.MATCH, "name", "code"));

        }

        Page<UserRole> itemPage = userRoleService.findAllByRoleCode("SALES", pageable);
        itemPage.getContent().forEach(userRole -> {
            userRole.setOutletNames(userRole.getUser().getSalesOutlets().stream().map(SalesOutlet::getOutlet).map(Outlet::getName).collect(Collectors.joining(", ")));
        });
        return new ResponseEntity(new Response(itemPage.getContent(), itemPage.getTotalElements()), HttpStatus.OK);
    }

    @GetMapping("/edit")
    public ResponseEntity<User> findSalesOut(@PathVariable Integer id){
        Optional<User> users = userService.findById(id);

        if (!users.isPresent()){
            return new ResponseEntity(new Response<>("Record Not Found"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(new Response<>(users.get()), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<SalesOutlet> save(@RequestBody User user){

        user.getSalesOutlets().stream().forEach(salesOutlet -> salesOutlet.setUser(user));
        List<SalesOutlet> salesOutSaved;
        try {
           salesOutSaved = salesOutletService.saveAll(user.getSalesOutlets());
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseEntity(new Response<>(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(new Response<>(salesOutSaved.size()), HttpStatus.OK);
    }

    @GetMapping("/findAllList")
    public ResponseEntity<SalesOutlet> findAllList(){
        List<SalesOutlet> salesOutletList = salesOutletService.findAllList();

        return new ResponseEntity(new Response<>(salesOutletList), HttpStatus.OK);
    }
}
