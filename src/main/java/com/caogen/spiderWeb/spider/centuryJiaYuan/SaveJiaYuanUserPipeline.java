package com.caogen.spiderWeb.spider.centuryJiaYuan;

import com.caogen.spiderWeb.dao.SpiderDao;
import com.caogen.spiderWeb.entity.UserByJiaYuan;
import com.caogen.spiderWeb.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.selector.JsonPathSelector;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class SaveJiaYuanUserPipeline implements Pipeline {

    @Resource
    private SpiderDao spiderDao;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String jsonStr = resultItems.get("jsonStr");
        List<String> userInfo = new JsonPathSelector("$.userInfo").selectList(jsonStr);
        List<UserByJiaYuan> list = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            for (int i = 0; i < userInfo.size(); i++) {
                HashMap<String, Object> map = mapper.readValue(userInfo.get(i), HashMap.class);
                UserByJiaYuan user = new UserByJiaYuan();
                //BeanUtils.copyProperties(map, user);  //最好用Spring给我们提供的浅拷贝方法,只要保证属性一样就可以

                user.setRealUid(Long.parseLong(StringUtil.getLongString(map.get("realUid"))));
                user.setNickName(StringUtil.getString(map.get("nickname")));
                user.setSex(StringUtil.getString(map.get("sex")));
                user.setAge(Integer.parseInt(StringUtil.getLongString(map.get("age"))));
                user.setMarriage(StringUtil.getString(map.get("marriage")));
                user.setHeight(StringUtil.getString(map.get("height")));
                user.setEducation(StringUtil.getString(map.get("education")));
                user.setLocalhost(StringUtil.getString(map.get("work_location")));
                user.setImage(StringUtil.getString(map.get("image")));
                user.setRandTag(StringUtil.getString(map.get("randTag")));
                user.setRandListTag(StringUtil.getString(map.get("randListTag")));
                user.setShortnote(StringUtil.getString(map.get("shortnote")));
                user.setMatchCondition(StringUtil.getString(map.get("matchCondition")));
                user.setHelloUrl(StringUtil.getString(map.get("helloUrl")));
                list.add(user);
            }

            spiderDao.InsertUserByJiaYuan(list);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
