package com.example.demo.controller;


import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Category;
import com.example.demo.model.service.IBlogService;
import com.example.demo.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList(@PageableDefault(value = 3, sort = "createDate",
            direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("blogList", iBlogService.findAll(pageable));
        modelAndView.addObject("categoryList", iCategoryService.findAll());
        return modelAndView;
    }
    @GetMapping(value = "/list-by-category")
    public String showListByCategory(@RequestParam("categoryId") int categoryId, Model model) {
        String name = null;
        for (Category c: iCategoryService.findAll()) {
            if (c.getCategoryId() == categoryId) {
                name = c.getCategoryName();
                break;
            }
        }
        model.addAttribute("message", "Showed by category " + name);
        model.addAttribute("blogList", iBlogService.findAllByCategoryCategoryId(categoryId));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/list-by-category";
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {

        ModelAndView modelAndView = new ModelAndView("/create");
        List<Category> categoryList = iCategoryService.findAll();
        modelAndView.addObject("categoryList", categoryList);
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blog.setCreatedDate(new java.sql.Date(System.currentTimeMillis()));
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/read/{id}")
    public ModelAndView readBlog(@PathVariable("id") Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Optional<Blog> blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog, RedirectAttributes attributes) {
        iBlogService.remove(blog.getBlogId());
        attributes.addFlashAttribute("message", "Removed blog id = " + blog.getBlogId());
        return "redirect:/list";
    }
    @RequestMapping("/search")
    public String searchTitle(@RequestParam("title") String title, Model model) {
        List<Blog> blogs = iBlogService.findByBlogTitleContaining(title);
        model.addAttribute("result", blogs);
        model.addAttribute("message", "Found " + blogs.size()+ " record(s)");
        return "search";
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "blog/login";
    }
}
