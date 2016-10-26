/**
 *
 */
package com.zhuoyue.crawler.jd.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.zhuoyue.crawler.domain.category.CategoryType;
import com.zhuoyue.crawler.domain.category.CrawlBookCategory;
import com.zhuoyue.crawler.domain.category.CrawlBookCategoryRepository;
import com.zhuoyue.crawler.pipeline.CrawlerRecordPipelineFactory;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.service.CrawlBookCatalogService;
import com.zhuoyue.crawler.utils.CrawlerSource;
import com.zhuoyue.crawler.utils.CrawlerType;
import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zhuoyue.crawler.jd.model.JdBookCatalog;
import com.zhuoyue.crawler.jd.pipeline.JdBookCatalogPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.selector.XpathSelector;

/**
 * @author lihaitao
 *
 */
@Component
public class JdBookCatalogCrawler {
	//少儿图书首页
	private static final String URL_INDEX = "http://list.jd.com/list.html?cat=1713,3263";

	private static final String URL_CATG = "http://list.jd.com/1713-3263-(\\d{4}).html";

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
    private CrawlBookCatalogService crawlBookCatalogService;

    @Autowired
    private CrawlBookCategoryRepository crawlBookCategoryRepository;

	/**
	 * @param
	 */
	@Scheduled(initialDelay=20*1000, fixedDelay=24*3600*1000)
	public void doCrawl() {
        crawlBookCatalogService.deleteDailyCatalog(CrawlerSource.jd.getType());

		Downloader downloader = new HttpClientDownloader();
		Page indexPage = downloader.download(new Request(URL_INDEX), site.toTask());

        List<CrawlBookCategory> bookCategories = this.findCrawlBookCategories();

		OOSpider ooSpider = OOSpider.create(site, databasePipeline, JdBookCatalog.class);
        ooSpider.setDownloader(new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe"));

        CrawlerRecordPipelineFactory.CrawlerRecordPipeline pipeline = crawlerRecordPipelineFactory.createRecordPipeline(
            new CrawlerRecord(CrawlerType.JDCATALOG, new Date()));
        ooSpider.addPipeline(pipeline);
        ooSpider.setUUID(""+pipeline.getCrawlerRecord().getId());


    	ooSpider.setSpiderListeners(Arrays.asList(spiderListener));
    	for(CrawlBookCategory bookCategory: bookCategories){
    		ooSpider.addUrl(String.format(URL_LIST, bookCategory.getCategoryString()));
            break;
    	}

    	ooSpider.thread(4).run();
	}

    private List<CrawlBookCategory> findCrawlBookCategories() {

        List<CrawlBookCategory> bookCategories = crawlBookCategoryRepository
            .findBySiteAndCategoryType(CrawlerSource.jd.getType(), CategoryType.INDEX);
        if(CollectionUtils.isEmpty(bookCategories)){
            bookCategories = new ArrayList<CrawlBookCategory>();

            Downloader downloader = new HttpClientDownloader();
            Page indexPage = downloader.download(new Request(URL_INDEX), site.toTask());

            XpathSelector selector = new XpathSelector("//div[@id=\"J_selectorCategory\"]//li");
            List<Element> elements = selector.selectElements(indexPage.getHtml().getDocument());

            for(Element element:elements){
                XpathSelector categorySelector = new XpathSelector("li/a/regex(@href,'/1713,3263,(\\d+).html', 1)");
                String categoryString = categorySelector.select(element);

                XpathSelector categoryNameSelector = new XpathSelector("li/a/@title");
                String categoryName = categoryNameSelector.select(element);

                CrawlBookCategory crawlBookCategory = new CrawlBookCategory();
                crawlBookCategory.setSite(CrawlerSource.jd.getType());
                crawlBookCategory.setCategoryName(categoryName);
                crawlBookCategory.setCategoryString(categoryString);
                crawlBookCategory.setCategoryType(CategoryType.INDEX);

                bookCategories.add(crawlBookCategory);
                crawlBookCategoryRepository.save(crawlBookCategory);
            }
        }
        return bookCategories;

    }

}
