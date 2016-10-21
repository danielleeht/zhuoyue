/**
 *
 */
package com.zhuoyue.crowler.jd.handler;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhuoyue.crowler.jd.model.JDBookComment;
import com.zhuoyue.crowler.jd.model.JDBookItem;
import com.zhuoyue.crowler.jd.model.JDBookList;
import com.zhuoyue.crowler.jd.pipeline.JDBookItemPipeline;
import com.zhuoyue.crowler.jd.repository.JDBookListRepository;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.model.OOSpider;

/**
 * @author lihaitao
 *
 */
@Component
public class JDBookItemCrowler implements InitializingBean {

	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static Site site = Site.me().setUserAgent(USER_AGENT).setRetryTimes(30).setSleepTime(100);

    public static final String ITEM_URL = "http://item.jd.com/%s.html";
    public static final String COMMENT_URL = "http://sclub.jd.com/productpage/p-%s-s-0-t-3-p-0.html";

    @Autowired
    private JDBookItemPipeline databasePipeline;

    @Autowired
    private JDBookListRepository bookListRepository;

    private OOSpider ooSpider;


	/**
	 *
	 */
	public void doCrowl() {
		if(ooSpider.getStatus().equals(Spider.Status.Running)){
			return;
		}
		List<JDBookList> bookList = bookListRepository.findAll();

//		OOSpider ooSpider = OOSpider.create(site, databasePipeline, JDBookItem.class, JDBookComment.class);
//		ooSpider.setDownloader(new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe"));

    	for(JDBookList book: bookList){
    		ooSpider.addUrl(String.format(ITEM_URL, book.getItemId()));
    		ooSpider.addUrl(String.format(COMMENT_URL, book.getItemId()));
    	}

    	ooSpider.thread(8).run();
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		ooSpider = OOSpider.create(site, databasePipeline, JDBookItem.class, JDBookComment.class);
		ooSpider.setDownloader(new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe"));
	}


	public OOSpider getOoSpider() {
		return ooSpider;
	}

	public void addCrowlerUrls(String... urls){
		ooSpider.addUrl(urls);
		if(!ooSpider.getStatus().equals(Spider.Status.Running)){
			ooSpider.setExitWhenComplete(false);
			ooSpider.thread(12).run();
		}
	}



}
