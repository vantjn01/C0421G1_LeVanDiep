package com.example.demo.dto;

import org.springframework.lang.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Pattern(regexp = "([A-Za-z0-9 ]{1,800})",  message = "Tên bài hát không được trống và tối đa 800 kí tự, không chứa kí tự đặt biệt")
    private String name;

    @NonNull
    @Pattern(regexp = "([A-Za-z0-9 ]{1,300})",  message = "Tên ca sĩ không được trống và tối đa 300 kí tự, không chứa kí tự đặt biệt")
    private String singer;

    @NonNull
    @Pattern(regexp = "([A-Za-z0-9, ]{1,300})",  message = "Tên thể loại không được trống và tối đa 300 kí tự, không chứa kí tự đặt biệt")
    private String type;

    public MusicDto() {
    }

    public MusicDto(int id, @NonNull @Pattern(regexp = "([A-Za-z0-9 ]{1,800})", message = "Tên bài hát không được trống và tối đa 800 kí tự, không chứa kí tự đặt biệt") String name, @NonNull @Pattern(regexp = "([A-Za-z0-9 ]{1,300})", message = "Tên ca sĩ không được trống và tối đa 300 kí tự, không chứa kí tự đặt biệt") String singer, @NonNull @Pattern(regexp = "([A-Za-z0-9, ]{1,300})", message = "Tên thể loại không được trống và tối đa 300 kí tự, không chứa kí tự đặt biệt") String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSinger() {
        return singer;
    }

    public void setSinger(@NonNull String singer) {
        this.singer = singer;
    }

    @NonNull
    public String getType() {
        return type;
    }

    public void setType(@NonNull String type) {
        this.type = type;
    }
}
