package net.xdclass.online_xdclass.service.impl;

import net.xdclass.online_xdclass.mapper.UserMapper;
import net.xdclass.online_xdclass.mapper.VideoMapper;
import net.xdclass.online_xdclass.mapper.VideoOrderMapper;
import net.xdclass.online_xdclass.model.entity.VideoOrder;
import net.xdclass.online_xdclass.service.VideoOrderService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {

    private final VideoOrderMapper videoOrderMapper;
    private final UserMapper userMapper;
    private final VideoMapper videoMapper;

    public VideoOrderServiceImpl(@Qualifier("videoOrderMapper") VideoOrderMapper videoOrderMapper,
                                 @Qualifier("userMapper") UserMapper userMapper,
                                 @Qualifier("videoMapper") VideoMapper videoMapper) {
        this.videoOrderMapper = videoOrderMapper;
        this.userMapper = userMapper;
        this.videoMapper = videoMapper;
    }

    @Override
    public int save(int userId, int videoId) {

        VideoOrder videoOrder = videoOrderMapper.getByUserIdAndVideoIdAndState(userId, videoId, 1);
        if (null != videoOrder) {
            return 0;
        }

        return 0;
    }
}
