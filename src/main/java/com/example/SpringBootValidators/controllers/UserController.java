/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootValidators.controllers;

import com.example.SpringBootValidators.model.User;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author glamb
 */
@Controller
public class UserController {

    @GetMapping("preInsertUser")
    public String preInsertUser(ModelMap mm) {

        User u = new User();
//        u.setName("Argiris");
        mm.addAttribute("formUser", u);
        return "userForm";
    }

    @PostMapping("doInsertUser")
    public String doInsertUser(@Valid @ModelAttribute("formUser") User u,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "userForm";
        }else
        return "success";
    }
}
