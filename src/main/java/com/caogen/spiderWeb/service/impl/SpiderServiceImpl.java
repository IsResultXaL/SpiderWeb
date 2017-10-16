package com.caogen.spiderWeb.service.impl;

import com.caogen.spiderWeb.dao.SpiderDao;
import com.caogen.spiderWeb.dto.Page;
import com.caogen.spiderWeb.dto.SpiderResult;
import com.caogen.spiderWeb.entity.UserByJiaYuan;
import com.caogen.spiderWeb.service.SpiderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpiderServiceImpl implements SpiderService {

    @Resource
    private SpiderDao spiderDao;

    @Override
    public SpiderResult<List<UserByJiaYuan>> getUserByJiaYuan(long pageNum) {
        //long count = spiderDao.selectUserByJiaYuanCount();
        Page page = new Page(10, 5000000L,pageNum);
        List<UserByJiaYuan> userByJiaYuanList = spiderDao.selectUserByJiaYuan(page.getOffSet(), page.getPageSize());
        return new SpiderResult<>(true, userByJiaYuanList);
    }

}
