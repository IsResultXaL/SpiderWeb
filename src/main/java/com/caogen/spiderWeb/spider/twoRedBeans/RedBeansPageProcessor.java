package com.caogen.spiderWeb.spider.twoRedBeans;

import com.fasterxml.jackson.databind.ObjectMapper;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 两颗红豆的爬虫
 */
public class RedBeansPageProcessor implements PageProcessor {

    public static int current_page = 1;
    ObjectMapper mapper = new ObjectMapper();

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .addHeader(":authority", "www.2redbeans.com")
            .addHeader(":method", "GET")
            .addHeader(":path", "/zh-CN/app/api/v5/users/?n_per_page=20&?")
            .addHeader(":scheme", "https")
            .addHeader("accept","application/json")
            .addHeader("accept-encoding","gzip, deflate, br")
            .addHeader("accept-language","zh-CN,zh;q=0.8")
            .addHeader("cookie", "bt=bb17fa2e9e41ab1cff54c3620c070780; bt_ts=1507700660; eu=true; user_credentials=c8c9234e2ae196a140855cfbbc04c0ac73ace86265e69fbbd5e4ad345f6c2af178476d37fe3ae87472fa59e0a64f9e749990a5aa0e9eeb49a598130e89dfe76d%3A%3A1902385; ident=exist; it=2701daa1; userty.core.s.58db81=%7B%22te%22%3Afalse%2C%22p%22%3A%22f%22%7D; _ga=GA1.2.1025624979.1507700663; _gid=GA1.2.1970452383.1507700663; __stripe_sid=db09ce85-e726-47b1-9b0c-b4bf2f333cbf; __stripe_mid=d6b44ed6-198f-4801-ae91-722bd16a1575; AWSALB=vY8yLHNBqKF4auEymUYsyFNb5+kQvCzsqM7yCcbUqE+mcy1tSxf8pTa8cDD9UBcCNAv2LxTsdOcwBmd8aIOZBqx8o0312zWh/bXg4juRfBey7UW0leDL/5oiXmvD; _dating_session=BAh7DCIYdXNlcl9jcmVkZW50aWFsc19pZGkDMQcdIglsYW5nSSIKemgtQ04GOgZFVCIQdGFibGV0X3ZpZXdGIg9zZXNzaW9uX2lkIiViYzMxMjkyNTBkNmIxZjZiYTkzYmU1OWE3YTg1ODgwZSIVdXNlcl9jcmVkZW50aWFsc0kiAYBjOGM5MjM0ZTJhZTE5NmExNDA4NTVjZmJiYzA0YzBhYzczYWNlODYyNjVlNjlmYmJkNWU0YWQzNDVmNmMyYWYxNzg0NzZkMzdmZTNhZTg3NDcyZmE1OWUwYTY0ZjllNzQ5OTkwYTVhYTBlOWVlYjQ5YTU5ODEzMGU4OWRmZTc2ZAY7AFRJIhhtYXNxdWVfcmVkaXJlY3RfdXJsBjsARkkiL2h0dHBzOi8vd3d3LjJyZWRiZWFucy5jb20vemgtQ04vYXBwL3NlYXJjaAY7AFRJIhBfY3NyZl90b2tlbgY7AEZJIjF2NXNUVGE3eFYzUWtFYk9wV2tmcm0vMHdIYmt5dTlFc0p4QzhMZ1pzRkJvPQY7AEY%3D--79136a8a216a55017f2befae8d716b60d9cb73d2")
            .addHeader("if-none-match", "W/\"7125012068fd49243797cc1377cf9ab3\"")
            .addHeader("referer","https://www.2redbeans.com/zh-CN/app/search")
            .addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
            .addHeader("x-2rb-api-version", "v3")
            .addHeader("x-2rb-webview", "2RedBeans/1.0 WebView-1/1.0.1 (Browser; Masque 1.0; locale en_US)")
            .addHeader("x-newrelic-id", "VQcPVlNbCRABV1ZQAQIBUg==");


    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {

        //说明是列表页
        if (page.getUrl().toString().indexOf("page") != -1){
            String jsonStr = page.getRawText();
            int next_page = Integer.parseInt(new JsonPathSelector("$.next_page").select(jsonStr));
            String token = new JsonPathSelector("$.pagination_token").select(jsonStr);

            if (next_page < current_page)return;
            current_page = next_page;
            page.addTargetRequest("https://www.2redbeans.com/zh-CN/app/api/v5/users/" +
                    "?&page="+current_page+"&pagination_token="+token+"");

            List<String> userList = new JsonPathSelector("$.users").selectList(jsonStr);
            for (int i = 0; i < userList.size(); i++) {
                try {
                    HashMap<String, Object> map1 = mapper.readValue(userList.get(i), HashMap.class);
                    String json = mapper.writeValueAsString(map1.get("user"));
                    HashMap<String, Object> map2 = mapper.readValue(json, HashMap.class);
                    page.addTargetRequest("https://www.2redbeans.com/zh-CN/app/api/v5/users/"+map2.get("token")+"?show_simple_options=false&show_natural=true&real_time_info=true");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else {
            //说明是内容页
            String jsonStr = page.getRawText();
            page.putField("jsonStr", jsonStr);
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new RedBeansPageProcessor())
                .addUrl("https://www.2redbeans.com/zh-CN/app/api/v5/users/?&page="+current_page+"&pagination_token=1507707456")
                .addPipeline(new ConsolePipeline())
                //开启5个线程抓取
                .thread(Runtime.getRuntime().availableProcessors())
                //启动爬虫
                .run();
    }
}
