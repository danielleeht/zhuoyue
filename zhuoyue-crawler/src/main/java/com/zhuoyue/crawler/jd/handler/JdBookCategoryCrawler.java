/*

 */
package com.zhuoyue.crawler.jd.handler;

import com.zhuoyue.crawler.domain.category.CategoryType;
import com.zhuoyue.crawler.domain.category.CrawlBookCategory;
import com.zhuoyue.crawler.domain.category.CrawlBookCategoryRepository;
import com.zhuoyue.crawler.domain.task.CrawlerRecord;
import com.zhuoyue.crawler.jd.model.JdBookCategory;
import com.zhuoyue.crawler.jd.pipeline.JdBookCategoryPipeline;
import com.zhuoyue.crawler.pipeline.CrawlerRecordPipelineFactory;
import com.zhuoyue.crawler.utils.CrawlerSource;
import com.zhuoyue.crawler.utils.CrawlerType;
import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.selector.XpathSelector;

import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lihaitao
 *
 */
@Component
public class JdBookCategoryCrawler {
    private static final Logger log = LoggerFactory.getLogger(JdBookCategoryCrawler.class);
	//少儿图书首页
	private static final String URL_INDEX = "http://list.jd.com/list.html?cat=1713,3263";

    private static final String URL_CATG = "http://list.jd.com/list.html?cat=1713,3263,%s";

	private static final String URL_LIST = "http://list.jd.com/list.html?cat=1713,3263,%s&ev=%s&page=1&stock=0&sort=sort_totalsales15_desc";

	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static Site site = Site.me().setUserAgent(USER_AGENT).setRetryTimes(30).setSleepTime(100);

    @Autowired
    private CrawlerRecordPipelineFactory crawlerRecordPipelineFactory;

    @Autowired
    private JdBookCategoryPipeline databasePipeline;

    @Autowired
    private CrawlBookCategoryRepository crawlBookCategoryRepository;

	/**
	 *
	 */
	public void doCrawl() {
        log.info("开始执行图书目录爬虫程序");

        OOSpider ooSpider = OOSpider.create(site, databasePipeline, JdBookCategory.class);
        ooSpider.setDownloader(new HttpClientDownloader());

        CrawlerRecordPipelineFactory.CrawlerRecordPipeline pipeline = crawlerRecordPipelineFactory.createRecordPipeline(
            new CrawlerRecord(CrawlerType.JDCATEGORY, new Date()));
        ooSpider.addPipeline(pipeline);
        ooSpider.setUUID(""+pipeline.getCrawlerRecord().getId());

        List<CrawlBookCategory> bookCategories = this.findCrawlBookCategories();

        for(CrawlBookCategory bookCategory: bookCategories){
            List<CrawlBookCategory> normalCategories = this.findNormalBookCategories(bookCategory.getCategoryString());

            for(CrawlBookCategory normalCategory: normalCategories){
                ooSpider.addUrl(String.format(URL_LIST, bookCategory.getCategoryString(), normalCategory.getCategoryString() ));
            }
        }

    	ooSpider.thread(4).run();
	}

    List<CrawlBookCategory> findNormalBookCategories(String indexCategory) {

        List<CrawlBookCategory> bookCategories = crawlBookCategoryRepository
            .findBySiteAndCategoryTypeAndParentCategory(CrawlerSource.jd.getType(), CategoryType.NORMAL, indexCategory);
        log.info("找到{}条二级童书分类", bookCategories.size());
        if(CollectionUtils.isEmpty(bookCategories)){

            log.info("开始爬取二级童书分类");
            bookCategories = new ArrayList<>();

            Downloader downloader = new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe");
            Page indexCategoryPage = downloader.download(new Request(String.format(URL_CATG, indexCategory)), site.toTask());

            XpathSelector lineSelector = new XpathSelector("//div[@class=\"sl-wrap\"]");
            List<Element> lineElements = lineSelector.selectElements(indexCategoryPage.getHtml().getDocument());

            for(Element lineElement:lineElements){
                XpathSelector subTypeSelector = new XpathSelector("div/div[@class=\"sl-key\"]/span/text()");
                String subTypeName = subTypeSelector.select(lineElement).replaceAll("：", "");
                String subType = null;

                XpathSelector normalSelector = new XpathSelector("//ul[@class=\"J_valueList\"]/li");
                List<Element> normalElements = normalSelector.selectElements(lineElement);

                for(Element normalElement : normalElements){
                    XpathSelector normalCategorySelector = new XpathSelector("li/a/regex(@href,'.*&ev=([^&]+)&*', 1)");
                    String normalCategory = normalCategorySelector.select(normalElement);

                    XpathSelector normalNameSelector = new XpathSelector("li/a/text()");
                    String normalCategoryName = normalNameSelector.select(normalElement);

                    try {
                        normalCategory = URLDecoder.decode(normalCategory, Charset.defaultCharset().name());
                    } catch (Exception e) {
                        log.error("URL 转码错误", e);
                    }

                    if( subType == null){
                        subType = normalCategory.substring(0, normalCategory.indexOf("_"));
                    }

                    CrawlBookCategory crawlBookCategory = new CrawlBookCategory();
                    crawlBookCategory.setSite(CrawlerSource.jd.getType());
                    crawlBookCategory.setCategoryName(normalCategoryName);
                    crawlBookCategory.setCategoryString(normalCategory);
                    crawlBookCategory.setCategoryType(CategoryType.NORMAL);
                    crawlBookCategory.setParentCategory(subType);

                    crawlBookCategoryRepository.save(crawlBookCategory);

                    log.info("已添加童书子分类{}", crawlBookCategory);

                    bookCategories.add(crawlBookCategory);

                }

                CrawlBookCategory crawlBookCategory = new CrawlBookCategory();
                crawlBookCategory.setSite(CrawlerSource.jd.getType());
                crawlBookCategory.setCategoryName(subTypeName);
                crawlBookCategory.setCategoryString(subType);
                crawlBookCategory.setCategoryType(CategoryType.SUBTYPE);
                crawlBookCategory.setParentCategory(indexCategory);

                crawlBookCategoryRepository.save(crawlBookCategory);

                log.info("已添加二级童书类型{}", crawlBookCategory);
            }
        }
        return bookCategories;
    }

    List<CrawlBookCategory> findCrawlBookCategories() {

        List<CrawlBookCategory> bookCategories = crawlBookCategoryRepository
            .findBySiteAndCategoryType(CrawlerSource.jd.getType(), CategoryType.INDEX);

        log.info("找到{}条童书分类", bookCategories.size());
        if(CollectionUtils.isEmpty(bookCategories)){
            log.info("开始爬取童书分类");
            bookCategories = new ArrayList<>();

            Downloader downloader = new HttpClientDownloader();
            Page indexPage = downloader.download(new Request(URL_INDEX), site.toTask());

            XpathSelector selector = new XpathSelector("//div[@id=\"J_selectorCategory\"]//li");
            List<Element> elements = selector.selectElements(indexPage.getHtml().getDocument());

            for(Element element:elements){
                XpathSelector categorySelector = new XpathSelector("li/a/regex(@href,'http://list.jd.com/1713-3263-(\\d+).html', 1)");
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

                log.info("已添加童书分类{}", crawlBookCategory);
            }
        }
        return bookCategories;

    }


}
