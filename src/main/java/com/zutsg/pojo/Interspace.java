package com.zutsg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zutsg.unti.PageBean;

import java.util.Date;

public class Interspace {
    private Integer id;

    private String title;

    private String image;

    private String cotent;

    private String address;

    private Integer topNum;

    private Integer userId;

    private User user;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

    private PageBean pageBean;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public Interspace(Integer id, String title, String image, String cotent, String address, Integer topNum, Integer userId,Date createTime) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.cotent = cotent;
        this.address = address;
        this.topNum = topNum;
        this.userId = userId;
        this.createTime = createTime;
    }

    public Interspace() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getCotent() {
        return cotent;
    }

    public void setCotent(String cotent) {
        this.cotent = cotent == null ? null : cotent.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getTopNum() {
        return topNum;
    }

    public void setTopNum(Integer topNum) {
        this.topNum = topNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}