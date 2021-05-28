package com.example.demo.controller;


import com.example.demo.dao.ILieu;
import com.example.demo.dao.IUser;
import com.example.demo.entities.Lieu;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LieuController {

    @Autowired
    private ILieu lieudao;
    @Autowired
    private IUser userdao;

    @RequestMapping(value ="Lieu/liste")
    public String  liste(ModelMap model){

        List<Lieu> lieux=lieudao.findAll();
        List<User> users= userdao.findAll();

        model.put("liste_lieux",lieux);
        model.put("liste_users",users);
        model.put("lieu" , new Lieu());
        return  "lieu/liste";
    }

    @RequestMapping(value = "/Lieu/add", method = RequestMethod.POST)
    public String add(int id, String nom, double longitude, double latitude, int idUser){
        ModelAndView modelAndView = new ModelAndView();
        Lieu lieu = new Lieu();
        lieu.setId(id);
        lieu.setNom(nom);
        lieu.setLongitude(longitude);
        lieu.setLatitude(latitude);

        User user = new User();
        user = userdao.getOne(idUser);
        lieu.setUser(user);
        try {
            lieudao.save(lieu);

        } catch (Exception ex){
            ex.printStackTrace();

        }

        modelAndView.addObject(new String("lieu/liste"));
        return "redirect:/Lieu/liste";
    }
    @RequestMapping(value = "/Lieu/delete" , method = RequestMethod.GET)
    public String delete(int id){

        try{
            lieudao.delete(lieudao.getOne(id));
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return "redirect:/Lieu/liste";
    }
    @RequestMapping(value="/Lieu/edit", method=RequestMethod.GET)
    public String edit(int id, ModelMap model){
        List<Lieu> lieux = lieudao.findAll();
        List<User> users = userdao.findAll();
        model.put("liste_lieux",lieux);
        model.put("liste_users",users);

        Lieu lieu = lieudao.getOne(id);
        model.put("lieu",lieu);

        return"lieu/liste";
    }
}
