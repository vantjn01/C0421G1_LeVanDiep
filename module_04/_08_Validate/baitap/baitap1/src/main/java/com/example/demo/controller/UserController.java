package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/user")
    public ModelAndView showMenu(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("userObject", new UserDto());
        return modelAndView;
    }

    @PostMapping("/user")
    public ModelAndView signUser(@Valid @ModelAttribute("userObject") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        }
        return new ModelAndView("/result");

    }

}
