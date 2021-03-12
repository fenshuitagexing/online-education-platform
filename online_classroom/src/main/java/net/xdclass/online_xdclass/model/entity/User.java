package net.xdclass.online_xdclass.model.entity;

import java.util.Date;

public class User {

    private Integer id;
    private String name;
    private String pwd;
    private String headshot;
    private String phone;
    private Date creationTime;

    public User() {
    }

    public User(String name, String phone, Date creationTime) {
        this.name = name;
        this.phone = phone;
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headshot='" + headshot + '\'' +
                ", phone='" + phone + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
