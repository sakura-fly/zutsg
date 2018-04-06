package com.zutsg.pojo;

public class Interspace {
    private Integer id;

    private String title;

    private String image;

    private String cotent;

    private String address;

    private Integer topnum;

    public Interspace(Integer id, String title, String image, String cotent, String address, Integer topnum) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.cotent = cotent;
        this.address = address;
        this.topnum = topnum;
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

    public Integer getTopnum() {
        return topnum;
    }

    public void setTopnum(Integer topnum) {
        this.topnum = topnum;
    }
}