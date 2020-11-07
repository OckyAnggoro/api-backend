package com.app.jwtauthentication.security.services;

import com.app.controller.BaseController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserCurrent extends BaseController {

    public UserCurrent() {
    }

    public static UserPrinciple getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserPrinciple)principal);
        }
        return null;
    }
}
