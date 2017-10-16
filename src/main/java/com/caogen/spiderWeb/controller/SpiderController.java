package com.caogen.spiderWeb.controller;

import com.caogen.spiderWeb.dto.SpiderResult;
import com.caogen.spiderWeb.entity.UserByJiaYuan;
import com.caogen.spiderWeb.service.SpiderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/spider")
public class SpiderController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SpiderService spiderService;

    /*@Resource
    private JiaYuanPageProcessor jiaYuanPageProcessor;

    @RequestMapping("/jiayuan")
    public void SpiderByJiaYuan() {
        jiaYuanPageProcessor.getUser();
    }*/

    @RequestMapping(value = "/getUserByJiaYuan", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SpiderResult<List<UserByJiaYuan>> getUserByJiaYuan(
            @RequestParam(value="pageNum",defaultValue="1",required=false)Integer pageNum){
        SpiderResult<List<UserByJiaYuan>> spiderResult = null;
        try {
            spiderResult = spiderService.getUserByJiaYuan(pageNum);
        }catch (Exception e) {
            logger.error("getUserByJiaYuan:" + e);
            e.printStackTrace();
            spiderResult = new SpiderResult<>(false, e.getMessage());
        }finally {
            return spiderResult;
        }
    }

}
