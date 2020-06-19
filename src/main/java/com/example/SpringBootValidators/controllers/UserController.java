/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootValidators.controllers;

import com.example.SpringBootValidators.model.User;
import com.example.SpringBootValidators.validators.UserValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author glamb
 */
@Controller
public class UserController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserValidator userValidator;

    @InitBinder //h methodos p tha trexei prin t spring kanei binding requestParameter kai User
    // to WebDataBinder pairnei ton userValidator kai kanei to desimo metaksy User k requestParameter.
    //Prin dwsei t user, kanei oti validators exei mesa t.

    /*
    P.X. Erxetai request gia thn doInsertUser. Vlepei to @Valid k kserei oti prepei na kanei
    validation sto @ModelAttribute("formUser") User u. Leei, ti validators exw? Vlepei oti
    exoume valei binder.addValidators(userValidator); . Trexei thn methodo userValidator.supports
    k tsekarei an einai ths classhs User. Meta, trexei thn userValidator.validate k vazei
    mesa sto errors object oti errors vrei (field, errormessage). Meta lgka koitaei ti alla validations
    exei to User mesa (vlepe ta @ Annotations @Email, @Size klp. k vazei k auta ta errormessages mesa st 
    errors object.    
     */
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }

    @GetMapping("preInsertUser")
    public String preInsertUser(ModelMap mm) {

        User u = new User();
//        u.setName("Argiris");
        mm.addAttribute("formUser", u);
        mm.addAttribute("forjs", "from controller");
        return "userForm";
    }

    @PostMapping("doInsertUser")
    public String doInsertUser(@Valid @ModelAttribute("formUser") User u,
            BindingResult bindingResult,
            ModelMap mm) {

        if (bindingResult.hasErrors()) {
//            mm.addAttribute("formUser", new User());
            u = new User();
            return "userForm";
        } else {
            return "success";
        }
    }
}
