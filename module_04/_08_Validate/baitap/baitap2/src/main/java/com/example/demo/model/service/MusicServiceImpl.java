package com.example.demo.model.service;

import com.example.demo.model.entity.Music;
import com.example.demo.model.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServiceImpl implements IMusicService{

    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return this.iMusicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        this.iMusicRepository.save(music);

    }

    @Override
    public Music findById(int id) {
        return this.iMusicRepository.findById(id).get();
    }
}
