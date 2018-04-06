package com.zutsg.pojo;

public class Scientific {
    private String id;

    private String title;

    private String image;

    private String content;

    private String address;

    private Integer userid;

    private Integer status;

    public Scientific(String id, String title, String image, String content, String address, Integer userid, Integer status) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.content = content;
        this.address = address;
        this.userid = userid;
        this.status = status;
    }

    public Scientific() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}