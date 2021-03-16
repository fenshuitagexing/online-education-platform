package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.config.CacheKeyManager;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoBanner;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.service.VideoService;
import net.xdclass.online_xdclass.utils.BasicCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class VideoServiceImpl implements VideoService {

    private final VideoMapper videoMapper;
    private final BasicCache basicCache;

    public VideoServiceImpl(VideoMapper videoMapper, BasicCache basicCache) {
        this.videoMapper = videoMapper;
        this.basicCache = basicCache;
    }

    @Override
    public List<Video> getVideoList() {

        try {
            Object cacheObj = basicCache.getTenMinCache().get(CacheKeyManager.HOMEPAGE_VIDEO_LIST,
                                                              videoMapper::getVideoList);
            if (cacheObj instanceof List) {
                return (List<Video>) cacheObj;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<VideoBanner> getHomePageVideoBanner() {

        try {
            Object cacheObj = basicCache.getTenMinCache().get(CacheKeyManager.HOMEPAGE_VIDEO_BANNER_KEY,
                                                            () -> {
                                                                System.out.println("Get video banner list from Database");
                                                                return videoMapper.getHomePageVideoBanner();
                                                            });
            if (cacheObj instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video getVideoDetailsById(int videoId) {

        String cacheKey = String.format(CacheKeyManager.VIDEO_DETAILS, videoId);
        try {
            Object cacheObj = basicCache.getOneHourCache().get(cacheKey, videoMapper::getVideoList);
            if (cacheObj instanceof Video) {
                Video video = (Video) cacheObj;
                return video;
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}
