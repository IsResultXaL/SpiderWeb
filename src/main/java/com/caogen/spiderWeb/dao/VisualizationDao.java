package com.caogen.spiderWeb.dao;

import com.caogen.spiderWeb.dto.JiaYuanVisualization;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisualizationDao {

    List<JiaYuanVisualization> getAllUserByJiaYuan();

}
