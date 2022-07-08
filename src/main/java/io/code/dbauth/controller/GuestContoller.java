package io.code.dbauth.controller;

import io.code.dbauth.entity.MyUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestContoller {


    @GetMapping
    public String sayGreetings(){
        //this object used to fetch user details from context
        // MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello , welcome!";
    }
}
