package com.zutsg.pojo;

public class GardenNews {
    private Integer id;

    private String cotent;

    private Integer istop;

    private Integer userid;

    private String image;

    public GardenNews(Integer id, String cotent, Integer istop, Integer userid, String image) {
        this.id = id;
        this.cotent = cotent;
        this.istop = istop;
        this.userid = userid;
        this.image = image;
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

    public Integer getIstop() {
        return istop;
    }

    public void setIstop(Integer istop) {
        this.istop = istop;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }
}