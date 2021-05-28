package com.example.demo.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @RequestMapping(value = "/")
    public String index(){
        return "redirect:/logon";
    }
    @RequestMapping(value = "/logon")
    public String home(ModelMap map, HttpServletRequest req, HttpServletResponse res){

        String user = req.getRemoteUser();
        System.out.println("Princial is:" + user);

        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        System.out.println("Principal is"+ name);

        if(user != null)
            return "accceuil";
        else
             return "redirect:/login";

    }

}
