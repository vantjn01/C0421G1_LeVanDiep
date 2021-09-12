package com.example.demo.model.repository;

import com.example.demo.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByBlogTitleContaining(String title);

    List<Blog> findAllByCategoryCategoryId(Integer id);
}
