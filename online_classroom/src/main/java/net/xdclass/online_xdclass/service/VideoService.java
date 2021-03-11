package net.xdclass.online_xdclass.service;

import net.xdclass.online_xdclass.domain.Video;
import net.xdclass.online_xdclass.domain.VideoBanner;

import java.util.List;

public interface VideoService {

    List<Video> getVideoList();

    List<VideoBanner> getHomePageVideoBanner();

    Video getVideoDetailsById(int videoId);
}
