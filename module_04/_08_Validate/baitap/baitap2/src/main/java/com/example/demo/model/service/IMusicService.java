package com.example.demo.model.service;

import com.example.demo.model.entity.Music;

import java.util.List;


public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    Music findById(int id);
}
