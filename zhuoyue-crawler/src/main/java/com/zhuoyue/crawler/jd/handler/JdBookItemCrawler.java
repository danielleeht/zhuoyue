/**
 *
 */
package com.zhuoyue.crawler.jd.handler;

import java.util.Date;
import java.util.List;

import com.zhuoyue.crawler.domain.catalog.CatalogStatus;
import com.zhuoyue.crawler.domain.catalog.BookCatalog;
import com.zhuoyue.crawler.domain.catalog.BookCatalogRepository;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.jd.model.JdBookItem;
import com.zhuoyue.crawler.pipeline.CrawlEndEvent;
import com.zhuoyue.crawler.pipeline.CrawlerRecordPipelineFactory;
import com.zhuoyue.crawler.service.CrawlBookCatalogService;
import com.zhuoyue.crawler.utils.CrawlerSource;
import com.zhuoyue.crawler.utils.CrawlerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhuoyue.crawler.jd.pipeline.JdBookItemPipeline;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.model.OOSpider;

/**
 * @author lihaitao
 *
 */
@Component
public class JdBookItemCrawler {

    private static final Logger log = LoggerFactory.getLogger(JdBookItemCrawler.class);
	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static Site site = Site.me().setUserAgent(USER_AGENT).setRetryTimes(30).setSleepTime(100);

    public static final String ITEM_URL = "http://item.jd.com/%s.html";

    @Autowired
    private JdBookItemPipeline databasePipeline;

    @Autowired
    private CrawlBookCatalogService crawlBookCatalogService;

    @Autowired
    private BookCatalogRepository bookCatalogRepository;

    @Autowired
    private CrawlerRecordPipelineFactory crawlerRecordPipelineFactory;

	/**
	 *
	 */
    @Scheduled(initialDelay=5*1000, fixedDelay=24*3600*1000)
	public void doCrawl() {
        log.info("JdBookItemCrawler start");

		OOSpider ooSpider = OOSpider.create(site, databasePipeline, JdBookItem.class);
		ooSpider.setDownloader(new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe"));

        CrawlerRecordPipelineFactory.CrawlerRecordPipeline pipeline = crawlerRecordPipelineFactory.createRecordPipeline(
            new CrawlerRecord(CrawlerType.JDITEM, new Date()));
        ooSpider.addPipeline(pipeline);
        ooSpider.setUUID(""+pipeline.getCrawlerRecord().getId());


        List<BookCatalog> bookCatalogs = bookCatalogRepository.findByCatalogStatusAndSite(CatalogStatus.CATALOGED, CrawlerSource.jd.getType());

        for(BookCatalog book: bookCatalogs){
    		ooSpider.addUrl(String.format(ITEM_URL, book.getItemId()));
            break;
    	}

    	ooSpider.thread(8).run();
	}



}
