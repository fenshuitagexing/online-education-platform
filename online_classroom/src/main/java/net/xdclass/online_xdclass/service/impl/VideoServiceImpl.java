package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.domain.Video;
import net.xdclass.online_xdclass.domain.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getVideoList() {

        return videoMapper.getVideoList();
    }

    @Override
    public List<VideoBanner> getHomePageVideoBanner() {
        return videoMapper.getHomePageVideoBanner();
    }

    @Override
    public Video getVideoDetailsById(int videoId) {

        Video videoDetails = videoMapper.getVideoDetailsById(videoId);
        return videoDetails;
    }
}
