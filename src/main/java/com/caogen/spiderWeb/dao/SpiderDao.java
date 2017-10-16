package com.caogen.spiderWeb.dao;

import com.caogen.spiderWeb.entity.UserByJiaYuan;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 查询世纪佳缘会员总数
     * @return
     */
    long selectUserByJiaYuanCount();

    /**
     * 根据偏移量查询世纪佳缘会员信息
     * @param offset
     * @param pageSize
     * @return
     */
    List<UserByJiaYuan> selectUserByJiaYuan(@Param("offset") long offset, @Param("pageSize") int pageSize);

}
