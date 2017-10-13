package com.caogen.spiderWeb.controller;

import com.caogen.spiderWeb.spider.centuryJiaYuan.JiaYuanPageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/spider")
public class SpiderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private JiaYuanPageProcessor jiaYuanPageProcessor;

    @RequestMapping("/jiayuan")
    public void SpiderByJiaYuan() {
        jiaYuanPageProcessor.getUser();
    }

}
