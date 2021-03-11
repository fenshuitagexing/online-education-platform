package net.xdclass.online_xdclass.mapper;

import net.xdclass.online_xdclass.domain.Video;
import net.xdclass.online_xdclass.domain.VideoBanner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoMapper {

    List<Video> getVideoList();

    List<VideoBanner> getHomePageVideoBanner();

    Video getVideoDetailsById(@Param("video_id") int videoId);
}
