package com.caogen.spiderWeb.dao;

import com.caogen.spiderWeb.entity.UserByJiaYuan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpiderDao {

    /**
     * 新增世纪佳缘用户
     * @param list
     * @author 草根
     */
    void InsertUserByJiaYuan(List<UserByJiaYuan> list);

}
