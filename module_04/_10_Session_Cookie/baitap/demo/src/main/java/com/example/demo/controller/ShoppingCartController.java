package com.example.demo.controller;

import com.example.demo.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingCartController {


    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute CartDto cart){
//        ModelAndView modelAndView = new ModelAndView("/cart");
//        modelAndView.addObject("cartDto",cartDto);
//        return modelAndView;
        return new ModelAndView("cart/shop","cart",cart);
    }

}
