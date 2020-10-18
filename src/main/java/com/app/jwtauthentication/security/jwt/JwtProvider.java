package com.app.jwtauthentication.security.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.app.jwtauthentication.security.services.UserPrinciple;

@Component
public class JwtProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
	
	@Value("${com.app.jwtSecret}")
	private String jwtSecret;
	
	@Value("${com.app.jwtExpiration}")
	private int jwtExpiration;
	
	public String generateJwtToken(Authentication authentication){
		
		UserPrinciple userPrinciple = (UserPrinciple)authentication.getPrincipal();
		return Jwts.builder()
                .setSubject((userPrinciple.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
	}
	
	public boolean validateJwtToken(String authToken){
		
		try{
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		}catch(SignatureException se){
			logger.error("Invalid JWT signature -> Message: {} ", se);
		}catch(MalformedJwtException mje){
			 logger.error("Invalid JWT token -> Message: {}", mje);
		}catch(ExpiredJwtException ee){
			 logger.error("Expired JWT token -> Message: {}", ee);
		}catch(UnsupportedJwtException uje){
			logger.error("Unsupported JWT token -> Message: {}", uje);
		}catch(IllegalArgumentException iae){
			logger.error("JWT claims string is empty -> Message: {}", iae);
		}
		
		return false;
		
	}
	
	public String getUserNameFromJwtToken(String token){
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		
	}
}
