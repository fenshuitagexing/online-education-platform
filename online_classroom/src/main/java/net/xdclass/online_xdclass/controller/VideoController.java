package net.xdclass.online_xdclass.controller;

import net.xdclass.online_xdclass.domain.Video;
import net.xdclass.online_xdclass.domain.VideoBanner;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("video_banner")
    public JsonData getHomePageVideoBanner() {

        List<VideoBanner> videoBanner = videoService.getHomePageVideoBanner();
        return JsonData.buildSuccess(videoBanner);
    }

    @RequestMapping("video_list")
    public JsonData getVideoList() {

        List<Video> videoList = videoService.getVideoList();
        return JsonData.buildSuccess(videoList);
    }

    @GetMapping("video_details")
    public JsonData getVideoDetailsById(@RequestParam(value = "video_id", required = true) int videoId) {

        Video video = videoService.getVideoDetailsById(videoId);
        return JsonData.buildSuccess(video);
    }
}
