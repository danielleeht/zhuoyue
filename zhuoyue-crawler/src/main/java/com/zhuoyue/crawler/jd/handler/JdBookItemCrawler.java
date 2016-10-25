/**
 *
 */
package com.zhuoyue.crawler.jd.handler;

import java.util.List;

import com.zhuoyue.crawler.domain.CatalogStatus;
import com.zhuoyue.crawler.domain.book.BookCatalog;
import com.zhuoyue.crawler.domain.book.BookCatalogRepository;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.jd.model.JdBookItem;
import com.zhuoyue.crawler.pipeline.CrawlEndEvent;
import com.zhuoyue.crawler.service.CrawlBookCatalogService;
import com.zhuoyue.crawler.utils.CrawlerSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.zhuoyue.crawler.jd.model.JdBookCatalog;
import com.zhuoyue.crawler.jd.pipeline.JdBookItemPipeline;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
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
    public static final String COMMENT_URL = "http://sclub.jd.com/productpage/p-%s-s-0-t-3-p-0.html";

    @Autowired
    private JdBookItemPipeline databasePipeline;

    @Autowired
    private CrawlBookCatalogService crawlBookCatalogService;

    @Autowired
    private BookCatalogRepository bookCatalogRepository;


	/**
	 *
	 */
    @EventListener(condition="#crawlEndEvent.crawlerType.equals(T(com.zhuoyue.crawler.utils.CrawlerType).JDCATALOG)")
	public void doCrawl(CrawlEndEvent crawlEndEvent) {
        CrawlerRecord record = (CrawlerRecord)crawlEndEvent.getSource();
        String taskId = record.getId()+"";

        crawlBookCatalogService.addBookCatalog(taskId);

        log.info("JdBookItemCrawler start");

		List<BookCatalog> bookCatalogs = bookCatalogRepository.findByCatalogStatusAndSite(CatalogStatus.CATALOGED, CrawlerSource.jd.getType());

		OOSpider ooSpider = OOSpider.create(site, databasePipeline, JdBookItem.class);
		ooSpider.setDownloader(new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe"));

    	for(BookCatalog book: bookCatalogs){
    		ooSpider.addUrl(String.format(ITEM_URL, book.getItemId()));
    	}

    	ooSpider.thread(8).run();
	}



}
