package net.xdclass.online_xdclass.model.entity;

import java.util.Date;

public class VideoOrder {

    private Integer id;
    private Integer videoId;
    private Integer userId;
    private Integer state;
    private Integer totalFee;
    private String orderNumber;
    private String videoTitle;
    private String videoImg;
    private Date creationTime;

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", userId=" + userId +
                ", state=" + state +
                ", totalFee=" + totalFee +
                ", orderNumber='" + orderNumber + '\'' +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
