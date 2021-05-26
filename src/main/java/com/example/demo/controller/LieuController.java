package com.example.demo.controller;


import com.example.demo.dao.ILieu;
import com.example.demo.dao.IUser;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LieuController {

    @Autowired
    private ILieu lieudao;
    @Autowired
    private IUser userdao;

    @RequestMapping(value ="Liste/liste")
    public String  liste(ModelMap model){

        List<Lieu> lieux=lieudao.findAll();
        List<User> users= userdao.findAll();

        model.put("liste_lieux",lieux);
        model.put("liste_users",users);
        return  "lieu/liste";
    }
}
