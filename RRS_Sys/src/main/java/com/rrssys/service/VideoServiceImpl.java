package com.rrssys.service;

import com.rrssys.entity.Video;
import com.rrssys.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements IBaseService<Video>{
    @Autowired
    private VideoRepository videoRepository;
    @Override
    public Video add(Video video) {
        if (video != null) {
            return videoRepository.save(video);
        }
        return null;
    }

    @Override
    public Video update(Long id, Video video) {
        if (video != null) {
            Video video1 = videoRepository.findById(id).get();
            if (video1 != null) {
                video1.setName(video.getName());
                video1.setCapacity(video.getCapacity());
                video1.setResolution(video.getResolution());
                video1.setSeri(video.getSeri());
                video1.setRentalPrice(video.getRentalPrice());
                video1.setQuantity(video.getQuantity());

                return videoRepository.save(video1);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        if (id >= 1) {
            Video video = videoRepository.findById(id).get();
            if (video != null) {
                videoRepository.deleteById(video.getId());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Video> getAll() {
        return (List<Video>) videoRepository.findAll();
    }

    @Override
    public Video getByID(Long id) {
        return videoRepository.findById(id).get();
    }

    @Override
    public Video getBySeri(Long seri) {
        return videoRepository.findBySeri(seri).get();
    }
}
