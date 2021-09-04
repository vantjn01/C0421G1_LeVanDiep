package com.example.demo.model.bean;
import javax.persistence.*;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    private String blogTitle;
    private String blogContent;
    private String blogFooter;
    public Blog() {
    }

    public Blog(String blogTitle, String blogContent, String blogFooter) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogFooter = blogFooter;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogFooter() {
        return blogFooter;
    }

    public void setBlogFooter(String blogFooter) {
        this.blogFooter = blogFooter;
    }
}
