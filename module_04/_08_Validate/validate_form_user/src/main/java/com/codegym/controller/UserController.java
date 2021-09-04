package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.service.IUserService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;  // thiếu private

    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/form");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute(name = "userDto") UserDto userDto, BindingResult bindingResult)
//    (BindingResult bindingResult, @Validated UserDto userDto)
    {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/form");
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        return new ModelAndView("/result", "user" , user);
    }
}
