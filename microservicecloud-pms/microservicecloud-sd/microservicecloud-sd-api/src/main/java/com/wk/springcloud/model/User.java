package com.wk.springcloud.model;

import java.io.Serializable;

public class User implements Serializable{

    private Long id;
    private String userName;
    private String password;
    private String salt;

    @Override
    public String toString() {
        return "id=" + id + " userName=" + userName + " password=" + password + " salt=" + salt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User(){

    }
}
