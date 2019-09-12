package com.wk.springcloud.model;

import java.io.Serializable;

public class Url implements Serializable {

    private Long id;
    private String url;

    public Url(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return id + " " + url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Url(){

    }
}
