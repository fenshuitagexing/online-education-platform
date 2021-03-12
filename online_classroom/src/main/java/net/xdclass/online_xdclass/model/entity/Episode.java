package net.xdclass.online_xdclass.model.entity;

import java.util.Date;

public class Episode {

    private Integer id;
    private Integer chapterId;
    private String title;
    private Integer globalOrder;
    private Integer chapterOrder;
    private String playUrl;
    private Integer free;
    private Integer videoId;
    private Date creationTime;

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", chapterId=" + chapterId +
                ", title='" + title + '\'' +
                ", globalOrder=" + globalOrder +
                ", chapterOrder=" + chapterOrder +
                ", playUrl='" + playUrl + '\'' +
                ", free=" + free +
                ", videoId=" + videoId +
                ", creationTime=" + creationTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGlobalOrder() {
        return globalOrder;
    }

    public void setGlobalOrder(Integer globalOrder) {
        this.globalOrder = globalOrder;
    }

    public Integer getChapterOrder() {
        return chapterOrder;
    }

    public void setChapterOrder(Integer chapterOrder) {
        this.chapterOrder = chapterOrder;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
