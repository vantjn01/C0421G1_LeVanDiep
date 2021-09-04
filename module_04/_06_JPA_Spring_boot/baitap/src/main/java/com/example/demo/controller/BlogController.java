package com.example.demo.controller;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList() {
        return new ModelAndView("/list", "blogList", iBlogService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/read/{id}")
    public ModelAndView readBlog(@PathVariable("id") Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Blog blog, RedirectAttributes attributes) {
        iBlogService.remove(blog.getBlogId());
        attributes.addFlashAttribute("message", "Removed blog id = " + blog.getBlogId());
        return "redirect:/list";
    }
}
