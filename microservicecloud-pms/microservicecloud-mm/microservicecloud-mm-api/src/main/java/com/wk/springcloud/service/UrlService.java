package com.wk.springcloud.service;

import com.wk.springcloud.model.Url;

import java.util.List;

public interface UrlService {

    List<Url> selectAll() throws Exception;

}
