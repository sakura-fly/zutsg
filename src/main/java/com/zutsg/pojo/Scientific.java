package com.zutsg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zutsg.unti.PageBean;

import java.util.Date;

public class Scientific {
    private Integer id;

    private String title;

    private String image;

    private String content;

    private String address;

    private Integer userId;

    private Integer status;

    private PageBean pageBean;

    private User user;

    private java.util.Date createTime;


    public Scientific(Integer id, String title, String image, String content, String address, Integer userId, Integer status,java.util.Date createTime) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.address = address;
        this.userId = userId;
        this.status = status;
        this.createTime=createTime;
    }

    public Scientific() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public java.util.Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
}