package com.codegym.model.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBlog;
    private String name;
    private String content;
    @Column(name = "create_start_time", columnDefinition = "DATETIME")
    private String createStartTime;

    @JsonManagedReference  // thiếu
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "id_category", referencedColumnName = "idCategory")  // khóa ngoại chưa map
    private Category category;

    public Blog() {
    }

    public Blog(Integer idBlog, String name, String content, String createStartTime, Category category) {
        this.idBlog = idBlog;
        this.name = name;
        this.content = content;
        this.createStartTime = createStartTime;
        this.category = category;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer id) {
        this.idBlog = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(String createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
