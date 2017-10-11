import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

public class RepoPageProcessor implements PageProcessor {

    // 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000)
            .addHeader("Accept","application/json")
            .addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .addHeader("Accept-Encoding","gzip, deflate, br")
            .addHeader("accept-language","zh-CN,zh;q=0.8")
            .addHeader("Referer","https://www.2redbeans.com/zh-CN/app/search")
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
            .setCharset("UTF-8")
            .setUseGzip(true)
            .addCookie("user_credentials", "c8c9234e2ae196a140855cfbbc04c0ac73ace86265e69fbbd5e4ad345f6c2af178476d37fe3ae87472fa59e0a64f9e749990a5aa0e9eeb49a598130e89dfe76d%3A%3A1902385");

    @Override
    // process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
    public void process(Page page) {
        String pageRawText = page.getRawText();
        JsonPathSelector json = new JsonPathSelector(pageRawText);
        page.putField("json", json);
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {

        Spider.create(new RepoPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("https://www.2redbeans.com/zh-CN/app/api/v5/users/?n_per_page=20&?")
                .addPipeline(new ConsolePipeline())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}