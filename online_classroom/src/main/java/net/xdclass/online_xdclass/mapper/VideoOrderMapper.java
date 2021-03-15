package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoOrderMapper {

    // Check if the user had bought the video
    VideoOrder getByUserIdAndVideoIdAndState(@Param("user_id") int userId, @Param("video_id") int videoId, @Param("state") int state);

    int saveOrder(VideoOrder videoOrder);

    List<VideoOrder> getOrderListByUserId(@Param("user_id") Integer userId);
}