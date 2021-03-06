package com.wk.springcloud.service.impl;

import com.wk.springcloud.mapper.UrlMapper;
import com.wk.springcloud.model.Url;
import com.wk.springcloud.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UrlServiceImpl implements UrlService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlMapper urlMapper;

    @Override
    public List<Url> selectAll() {
        return urlMapper.selectAll();
    }
}
