package com.example.demo.model.service;

import com.example.demo.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
//    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);
    List<Blog> findByBlogTitleContaining(String title);

    List<Blog> findAllByCategoryCategoryId(int id);
}
