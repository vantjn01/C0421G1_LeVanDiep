package com.codegym.controller;

import com.codegym.model.bean.Mailbox;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailboxController {
    @GetMapping("/update")
    public ModelAndView showCreatform(){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("mailbox",new Mailbox("Vietnamese",5,true,"good"));
        modelAndView.addObject("languague", new String[]{"Vietnamese","English","Korean","Japanese"});
        modelAndView.addObject("size", new String[]{"5","10","15","20","25"});
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView createMailbox(@ModelAttribute Mailbox mailbox){
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("mailbox", mailbox);
        return modelAndView;
    }
}
