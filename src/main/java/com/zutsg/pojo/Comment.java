package com.zutsg.pojo;

public class Comment {
    private Integer id;

    private String content;

    private Integer userid;

    private Integer touserid;

    private Integer spaceid;

    private Integer type;

    public Comment(Integer id, String content, Integer userid, Integer touserid, Integer spaceid, Integer type) {
        this.id = id;
        this.content = content;
        this.userid = userid;
        this.touserid = touserid;
        this.spaceid = spaceid;
        this.type = type;
    }

    public Comment() {
        super();
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
        this.content = content == null ? null : content.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public Integer getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(Integer spaceid) {
        this.spaceid = spaceid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}