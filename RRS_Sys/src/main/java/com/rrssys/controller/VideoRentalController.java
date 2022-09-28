package com.rrssys.controller;

import com.rrssys.entity.Video;
import com.rrssys.service.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rental-video")
public class VideoRentalController {
    @Autowired
    private VideoServiceImpl videoService;
    @GetMapping("/list")
    public String listVideo(Model model){
        model.addAttribute("video", new Video());
        List<Video> listVideo = videoService.getAll();
        model.addAttribute("listVideo",listVideo);
        return "video";
    }
    @PostMapping("/save")
    public String save(Model model, @ModelAttribute("video")Video video) {

        videoService.add(video);
        List<Video> listVideo = videoService.getAll();
        model.addAttribute("listVideo",listVideo);
        model.addAttribute("video", video);
        return "video";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        videoService.delete(id);
        List<Video> listVideo = videoService.getAll();
        model.addAttribute("listVideo",listVideo);
        model.addAttribute("video", new Video());
        return "video";
    }
    @GetMapping("/search")
    public String findBySeri(@RequestParam("seriSeach") Long seriSeach, Model model) {
        List<Video> listVideo = new ArrayList<>();
        Video video;
        try {
            video = videoService.getBySeri(seriSeach);
            listVideo.add(video);
        } catch (Exception e) {
            video = new Video();
        }
        model.addAttribute("listVideo",listVideo);
        model.addAttribute("video", video);
        model.addAttribute("seriSeach", seriSeach);

        return "video";
    }
}
