/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringBootValidators.validators;

import com.example.SpringBootValidators.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author glamb
 */
@Component //this annotation makes the class a springbean 
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        //which class is the validator for? 
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, field, errorCode, errorArgs, defaultMessage);

        // user mail must ends with gmail.com
        if (!user.getEmail().endsWith("@gmail.com")) {
            errors.rejectValue("email", "email.wrong");
        }

    }

}
