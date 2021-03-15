package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.exception.CustomException;
import net.xdclass.online_xdclass.mapper.*;
import net.xdclass.online_xdclass.model.entity.Episode;
import net.xdclass.online_xdclass.model.entity.PlayRecord;
import net.xdclass.online_xdclass.model.entity.Video;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.service.VideoOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    private final VideoOrderMapper videoOrderMapper;
    private final VideoMapper videoMapper;
    private final EpisodeMapper episodeMapper;
    private final PlayRecordMapper playRecordMapper;

    public VideoOrderServiceImpl(@Qualifier("videoOrderMapper") VideoOrderMapper videoOrderMapper,
                                 @Qualifier("videoMapper") VideoMapper videoMapper,
                                 @Qualifier("episodeMapper") EpisodeMapper episodeMapper,
                                 @Qualifier("playRecordMapper") PlayRecordMapper playRecordMapper) {
        this.videoOrderMapper = videoOrderMapper;
        this.videoMapper = videoMapper;
        this.episodeMapper = episodeMapper;
        this.playRecordMapper = playRecordMapper;
    }

    @Override
    @Transactional
    public int save(int userId, int videoId) {

        // Check if the user had bought the video
        VideoOrder videoOrder = videoOrderMapper.getByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (null != videoOrder) {
            return 0;
        }

        Video video = videoMapper.getById(videoId);
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreationTime(new Date());
        newVideoOrder.setOrderNumber(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(videoId);
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());

        int rows = videoOrderMapper.saveOrder(newVideoOrder);
        if (1 == rows) {
            Episode episode = episodeMapper.getFirstEpisodeByVideoId(videoId);
            if (null == episode) {
                throw new CustomException(-1, "Couldn't find the episode info");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreationTime(new Date());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setCurrentEpisode(episode.getGlobalOrder());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);
            playRecordMapper.saveRecord(playRecord);
        }

        return rows;
    }

    @Override
    public List<VideoOrder> getOrderListByUserId(Integer userId) {

        return videoOrderMapper.getOrderListByUserId(userId);
    }
}
