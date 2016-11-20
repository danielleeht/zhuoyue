/**
 *
 */
package com.zhuoyue.crawler.jd.crawler;

import com.zhuoyue.crawler.domain.category.CrawlBookCategory;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.jd.model.JdBookCatalog;
import com.zhuoyue.crawler.jd.pipeline.JdBookCatalogPipeline;
import com.zhuoyue.crawler.pipeline.CrawlerRecordPipelineFactory;
import com.zhuoyue.crawler.utils.CrawlerType;
import com.zhuoyue.utils.EnvironmentProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.model.OOSpider;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author lihaitao
 *
 */
@Component
public class JdBookCatalogCrawler {
    private static final Logger log = LoggerFactory.getLogger(JdBookCatalogCrawler.class);

	private static final String URL_LIST = "http://list.jd.com/list.html?cat=1713,3263,%s&page=1&stock=0&sort=sort_totalsales15_desc";

	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static Site site = Site.me().setUserAgent(USER_AGENT).setRetryTimes(30).setSleepTime(100);

    @Autowired
    private CrawlerRecordPipelineFactory crawlerRecordPipelineFactory;

    @Autowired
    private JdBookCatalogPipeline databasePipeline;

    @Autowired
    private SpiderListener spiderListener;

    @Autowired
    private JdBookCategoryCrawler jdBookCategoryCrawler;

    @Autowired
    private EnvironmentProvider environmentProvider;

	/**
	 * @param
	 */
	public void doCrawl() {
        log.info("开始执行图书目录爬虫程序");

        List<CrawlBookCategory> bookCategories = jdBookCategoryCrawler.findCrawlBookCategories();

		OOSpider ooSpider = OOSpider.create(site, databasePipeline, JdBookCatalog.class);
        ooSpider.setDownloader(new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe"));

        CrawlerRecordPipelineFactory.CrawlerRecordPipeline pipeline = crawlerRecordPipelineFactory.createRecordPipeline(
            new CrawlerRecord(CrawlerType.JDCATALOG, new Date()));
        ooSpider.addPipeline(pipeline);
        ooSpider.setUUID(""+pipeline.getCrawlerRecord().getId());


    	ooSpider.setSpiderListeners(Arrays.asList(spiderListener));
    	for(CrawlBookCategory bookCategory: bookCategories){
    		ooSpider.addUrl(String.format(URL_LIST, bookCategory.getCategoryString()));
            if(environmentProvider.isDevelopment()){
                log.info("开发环境只爬取一页数据");
                break;
            }

    	}

    	ooSpider.thread(4).run();
	}



}
