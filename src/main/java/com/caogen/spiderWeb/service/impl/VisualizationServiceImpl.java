package com.caogen.spiderWeb.service.impl;

import com.caogen.spiderWeb.dao.VisualizationDao;
import com.caogen.spiderWeb.dto.JiaYuanVisualization;
import com.caogen.spiderWeb.service.VisualizationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VisualizationServiceImpl implements VisualizationService {

    @Resource
    private VisualizationDao visualizationDao;

    @Override
    public String getUserByJiaYuan() throws Exception {
        List<JiaYuanVisualization> list = visualizationDao.getAllUserByJiaYuan();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
