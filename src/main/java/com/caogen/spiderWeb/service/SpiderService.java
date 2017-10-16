package com.caogen.spiderWeb.service;

import com.caogen.spiderWeb.dto.SpiderResult;
import com.caogen.spiderWeb.entity.UserByJiaYuan;

import java.util.List;

public interface SpiderService {

    SpiderResult<List<UserByJiaYuan>> getUserByJiaYuan(long pageNum);

}
