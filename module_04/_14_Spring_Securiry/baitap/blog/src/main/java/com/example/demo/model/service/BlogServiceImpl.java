package com.example.demo.model.service;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return this.iBlogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByBlogTitleContaining(String title) {
        return this.iBlogRepository.findByBlogTitleContaining(title);
    }

    @Override
    public List<Blog> findAllByCategoryCategoryId(int id) {
        return this.iBlogRepository.findAllByCategoryCategoryId(id);
    }

}
