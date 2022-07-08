package io.code.dbauth.controller;

import io.code.dbauth.entity.MyUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devops")
public class DevOpsController {


    @GetMapping
    public String sayGreetings(){
        MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello "+ user.getUsername() + " , welcome!";
    }
}
