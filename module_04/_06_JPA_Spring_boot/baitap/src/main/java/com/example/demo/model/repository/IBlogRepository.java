package com.example.demo.model.repository;

import com.example.demo.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
