package com.zutsg.pojo;

public class GardenEnterprise {
    private Integer id;

    private String name;

    private String image;

    private String content;

    private Integer userid;

    public GardenEnterprise(Integer id, String name, String image, String content, Integer userid) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.content = content;
        this.userid = userid;
    }

    public GardenEnterprise() {
        super();
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
        this.name = name == null ? null : name.trim();
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}