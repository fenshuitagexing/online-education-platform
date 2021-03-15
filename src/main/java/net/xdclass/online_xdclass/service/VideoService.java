package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;

import java.util.List;

public interface VideoService {

    List<Video> getVideoList();

    List<VideoBanner> getHomePageVideoBanner();

    Video getVideoDetailsById(int videoId);
}
