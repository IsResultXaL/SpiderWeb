package com.caogen.spiderWeb.controller;

import com.caogen.spiderWeb.service.VisualizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/show")
public class VisualizationController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private VisualizationService visualizationService;

    @RequestMapping(value = "jiayuan", method = RequestMethod.GET)
    public String getUserByJiaYuan(Model model) {
        try {
            String json = visualizationService.getUserByJiaYuan();
            model.addAttribute("json", json);
        }catch (Exception e) {
            logger.error("getUserByJiaYuan:" + e);
            e.printStackTrace();
        }finally {
            return "show/jiayuan";
        }
    }

}
