package com.zutsg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zutsg.unti.PageBean;

import java.util.Date;

public class Comment {
    private Integer id;

    private String content;

    private Integer userId;

    private Integer toUserId;

    private Integer spaceId;

    private User user;

    private User toUser;

    private PageBean pageBean;

    private Integer type;

    public Comment(Integer id, String content, Integer userId, Integer toUserId, Integer spaceId, Integer type) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.toUserId = toUserId;
        this.spaceId = spaceId;
        this.type = type;
    }
    public Comment() {
        super();
    }

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date createTime;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(Integer spaceId) {
        this.spaceId = spaceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}