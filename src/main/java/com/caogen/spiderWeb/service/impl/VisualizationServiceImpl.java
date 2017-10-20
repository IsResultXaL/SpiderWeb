package com.caogen.spiderWeb.service.impl;

import com.caogen.spiderWeb.cache.RedisCache;
import com.caogen.spiderWeb.dao.VisualizationDao;
import com.caogen.spiderWeb.service.VisualizationService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class VisualizationServiceImpl implements VisualizationService {

    @Resource
    private VisualizationDao visualizationDao;

    @Resource
    private RedisCache redisCache;

    @Override
    public String getUserByJiaYuan() throws Exception {
        return redisCache.getUserCountByJiaYuan();
    }
}
