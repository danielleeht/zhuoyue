package com.zhuoyue.crowler.jd.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.zhuoyue.crowler.CrawlerSource;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@Document(collection = "jd_book_list")
@TargetUrl(value = "http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&page=\\d+&stock=0*", sourceRegion="//div[@id=\"J_bottomPage\"]")
@ExtractBy(value = "//div[@id=\"plist\"]//div[contains(@class,\"j-sku-item\")]", multi=true)
public class JDBookList {

	@ExtractBy(value="div/@data-sku", notNull=true)
    private String itemId;

	@ExtractBy("div/div[@class=\"p-img\"]/a/img/@src")
	private String cover;

	@ExtractBy("div/div[@class=\"p-name\"]/a/em/text()")
	private String name;

	@ExtractBy("div/div[@class=\"p-shopnum\"]/allText()")
	private String shopName;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "JDBookItem [itemId=" + itemId  + "]";
	}

}
