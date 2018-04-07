package com.zutsg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zutsg.unti.PageBean;

import java.util.Date;

public class GardenNews {
    private Integer id;

    private String cotent;

    private Integer isTop;

    private Integer userId;

    private String image;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    private PageBean pageBean;

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public GardenNews(Integer id, String cotent, Integer isTop, Integer userId, String image,Date createTime) {
        this.id = id;
        this.cotent = cotent;
        this.isTop = isTop;
        this.userId = userId;
        this.image = image;
        this.createTime = createTime;
    }

    public GardenNews() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCotent() {
        return cotent;
    }

    public void setCotent(String cotent) {
        this.cotent = cotent == null ? null : cotent.trim();
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}