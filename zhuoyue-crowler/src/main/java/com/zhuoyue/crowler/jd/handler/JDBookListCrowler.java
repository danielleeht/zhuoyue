/**
 *
 */
package com.zhuoyue.crowler.jd.handler;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zhuoyue.crowler.jd.model.JDBookList;
import com.zhuoyue.crowler.jd.pipeline.JDBookListPipeline;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.SpiderListener;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.model.OOSpider;

/**
 * @author lihaitao
 *
 */
@Component
public class JDBookListCrowler {
	//少儿图书首页
	private static final String URL_INDEX = "http://list.jd.com/list.html?cat=1713,3263";

	private static final String URL_CATG = "http://list.jd.com/1713-3263-(\\d{4}).html";

	private static final String URL_LIST = "http://list.jd.com/list.html?cat=1713,3263,%s&page=1&stock=0&sort=sort_publishtime_desc";

	private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static Site site = Site.me().setUserAgent(USER_AGENT).setRetryTimes(30).setSleepTime(100);

    @Autowired
    private JDBookListPipeline databasePipeline;

    @Autowired
    private SpiderListener spiderListener;
	/**
	 * @param args
	 */
	public void doCrowl() {
		Downloader downloader = new HttpClientDownloader();
		Page indexPage = downloader.download(new Request(URL_INDEX), site.toTask());

		OOSpider ooSpider = OOSpider.create(site, databasePipeline, JDBookList.class);

		//添加二级分类页面
    	List<String> secondCatgs = indexPage.getHtml().xpath("//div[@id=\"J_selector\"]").links().regex(URL_CATG).all();
    	ooSpider.setSpiderListeners(Arrays.asList(spiderListener));
    	for(String secondCatg: secondCatgs){
    		ooSpider.addUrl(String.format(URL_LIST, secondCatg));
    	}

    	ooSpider.thread(4).run();
	}

}
