package com.wk.springcloud.mapper;

import com.wk.springcloud.model.Url;

import java.util.List;

public interface UrlMapper {

    List<Url> selectAll();
}
