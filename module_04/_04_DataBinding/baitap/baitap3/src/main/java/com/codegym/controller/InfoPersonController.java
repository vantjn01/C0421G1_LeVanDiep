package com.codegym.controller;

import com.codegym.model.InfoPerson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class InfoPersonController {

    InfoPerson infoPerson = new InfoPerson();


    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("infoPerson",infoPerson);
        return "detail";
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Other");

        List<String> nationList = new ArrayList<>();
        nationList.add("Vietnamese");
        nationList.add("Chinese");
        nationList.add("Cambodia");

        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("infoPerson",infoPerson);

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String editForm(@ModelAttribute("infoPerson") InfoPerson newInfoPerson,
                           RedirectAttributes redirectAttributes) {
        infoPerson = newInfoPerson;
        ModelAndView modelAndView = new ModelAndView();
        redirectAttributes.addFlashAttribute("message", "Success");
        modelAndView.addObject("newInfoPerson", infoPerson);

        return "redirect:/detail";
    }
}
