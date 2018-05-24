package com.zutsg.pojo;

import com.zutsg.unti.PageBean;

import java.util.Date;

public class User {
    private Integer id;

    private Integer role;

    private String phone;

    private Integer status;

    private String reason;

    private String info;

    private String password;

    private String image;

    private String header;

    private String name;

    private PageBean pageBean;

    private String message;

    private Date time;

    public User(Integer id, Integer role, String phone, Integer status, String reason, String info, String password, String image, String header, String name,String message,Date time) {
        this.id = id;
        this.role = role;
        this.phone = phone;
        this.status = status;
        this.reason = reason;
        this.info = info;
        this.password = password;
        this.image = image;
        this.header = header;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }
}