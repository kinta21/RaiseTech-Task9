package com.student.crudapi.service;

import com.student.crudapi.entity.Music;
import com.student.crudapi.exception.NotMusicFoundException;
import com.student.crudapi.mapper.MusicMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicServiceImpl implements MusicService {

    private  MusicMapper musicMapper;
    public MusicServiceImpl(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    @Override
    public List<Music> findAll(){
        return  musicMapper.findAll();
    }

    @Override
    public Music findById (int id) {
        Optional<Music> music = this.musicMapper.findById(id);
        return music.orElseThrow(() -> new NotMusicFoundException("resource not found"));
    }

    @Override
    public Music createMusic(String composer, String representativeSong) {
        Music musicData = new Music(composer, representativeSong);
        musicMapper.createMusic(musicData);
        return musicData;
    }

    @Override
    public void updateMusic(int id, String composer, String representativeSong) throws Exception {
        Music UpdateMusic = musicMapper.findById(id).orElseThrow(() -> new NotMusicFoundException("resource not found"));
    }

    @Override
    public void deleteById(int id) {
    }
}
