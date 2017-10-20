package com.caogen.spiderWeb.cache;

import com.caogen.spiderWeb.constant.RedisConstant;
import com.caogen.spiderWeb.dao.VisualizationDao;
import com.caogen.spiderWeb.dto.JiaYuanVisualization;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RedisCache {

    @Resource
    private JedisPool jedisPool;

    @Resource
    private VisualizationDao visualizationDao;

    /**
     * 释放redis连接
     * @param jedis
     */
    public void jedisClose(final Jedis jedis) {
        if(jedis != null)jedis.close();
    }

    /**
     * 世纪佳缘会员统计信息
     * @return
     */
    public String getUserCountByJiaYuan() throws JsonProcessingException {
        Jedis jedis = jedisPool.getResource();
        String str = jedis.get(RedisConstant.userConutByJiaYuan);
        if (StringUtils.isEmpty(str)) {
            List<JiaYuanVisualization> list = visualizationDao.getAllUserByJiaYuan();
            ObjectMapper mapper = new ObjectMapper();
            str = mapper.writeValueAsString(list);
            jedis.set(RedisConstant.userConutByJiaYuan, str);
        }
        jedisClose(jedis);
        return str;
    }

}
