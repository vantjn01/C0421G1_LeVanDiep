package com.example.demo.controller;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Category;
import com.example.demo.model.service.IBlogService;
import com.example.demo.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categogy/api")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public ModelAndView showList() {
//        return new ModelAndView("category/list", "categoryList", iCategoryService.findAll());
//    }

    //Xem danh sách các category
    @GetMapping("/create")
    public ResponseEntity<List<Blog>> listByCategory(@PathVariable int id) {
        List<Blog> blogList = this.iBlogService.findAllByCategoryCategoryId(id);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
// Xem danh sách các bài viết
        @GetMapping
        public ResponseEntity<List<Category>> getCateList() {
            List<Category> categoryList = this.iCategoryService.findAll();

            if (categoryList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }



}
