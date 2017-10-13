package com.caogen.spiderWeb.spider.centuryJiaYuan;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;

/**
 * 世纪佳缘的爬虫
 */
@Component
public class JiaYuanPageProcessor implements PageProcessor {

    @Resource
    private SaveJiaYuanUserPipeline saveJiaYuanUserPipeline;

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    @Override
    public void process(Page page) {
        String jsonStr = page.getRawText();
        page.putField("jsonStr", jsonStr);
    }

    @Override
    public Site getSite() {
        return site;
    }

    /**
     * 开始爬虫
     */
    public void getUser() {
        Spider spider = Spider.create(new JiaYuanPageProcessor());

        //世纪佳缘女性信息
        for (int i = 1; i <= 153153; i++) {
            spider.addUrl("http://search.jiayuan.com/v2/search_v2.php?sex=f&p=" + i);
        }

        //世纪佳缘男性信息
        for (int i = 1; i <= 224183; i++) {
            spider.addUrl("http://search.jiayuan.com/v2/search_v2.php?sex=m&p=" + i);
        }

        spider.addPipeline(saveJiaYuanUserPipeline)
                .thread(Runtime.getRuntime().availableProcessors())
                //启动爬虫
                .run();
    }

}
