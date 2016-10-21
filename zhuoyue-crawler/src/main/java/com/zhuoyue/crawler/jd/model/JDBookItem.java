package com.zhuoyue.crawler.jd.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.zhuoyue.crawler.CrawlerSource;
import com.zhuoyue.crawler.jd.formatter.JDBookPropertyFormatter;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.Formatter;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl(value = "http://item.jd.com/\\d+.html*", sourceRegion="no")
public class JDBookItem {

	@Id
	private String id;

	@ExtractBy(value="//*[@id=\"short-share\"]/div/span[2]/text()", notNull=true)
	private String itemId;	//商品编号

	@ExtractBy(value="//div[@class=\"breadcrumb\"]//span[1]/a[2]/regex(@href,'//list.jd.com/list.html\\?cat=(1713,3263,\\d+)', 1)")
	private String category;	//商品分类

	@ExtractBy(value="//*[@id=\"spec-list\"]/div/ul/li/img/@src")
	private List<String> coverPictures;	//封面图片

	@ExtractBy(value="//*[@id=\"name\"]/h1/text()")
	private String name;	//书名

	@Formatter(subClazz=JDBookProperty.class, formatter=JDBookPropertyFormatter.class)
	@ExtractBy("//ul[@id=\"parameter2\"]/li/allText()")
	private List<JDBookProperty> properties;

	@ExtractBy(value="//div[@id=\"p-author\"]/allText()")
	private String authorText;	//作者

	@ExtractBy(value="//div[@id=\"detail-tag-id-1\"]/div[2]/div/html()")
	private String characteristic;	//特色

	@ExtractBy(value="//div[@id=\"detail-tag-id-2\"]/div[2]/div/html()")
	private String recommend;	//编辑推荐

	@ExtractBy(value="//div[@id=\"detail-tag-id-3\"]/div[2]/div/html()")
	private String introduction;	//内容简介

	@ExtractBy(value="//div[@id=\"detail-tag-id-4\"]/div[2]/div/html()")
	private String authorIntro;	//作者简介

	@ExtractBy(value="//div[@id=\"detail-tag-id-5\"]/div[2]/div/html()")
	private String bookReview;	//专家评论

	@ExtractBy(value="//div[@id=\"detail-tag-id-6\"]/div[2]/div/html()")
	private String toc;	//目录

	@ExtractBy(value="//div[@id=\"detail-tag-id-7\"]/div[2]/div/html()")
	private String excerpt;	//精彩书摘

	@ExtractBy(value="//div[@id=\"detail-tag-id-8\"]/div[2]/div/html()")
	private String preface;	//前言/序言

	@ExtractBy(value="//div[@id=\"detail-tag-id-9\"]/div[2]/div/ul/li/a/img/@src")
	private List<String> inset;	//书摘与插画

	@ExtractBy(value="//*[@id=\"jd-price\"]/allText()")
	private String price;	//价格

	@ExtractBy(value="//div[@id=\"summary-order\"]/div[2]/font/text()")
	private String saleRank;	//销售排行

	@ExtractBy(value="//div[@id=\"comments-list\"]/div[1]/div/ul/li[contains(@clstag,'haoping')]/a/em/text()")
	private String good;	//好评数

	@ExtractBy(value="//div[@id=\"comments-list\"]/div[1]/div/ul/li[contains(@clstag,'zhongping')]/a/em/text()")
	private String middle;	//中评数

	@ExtractBy(value="//div[@id=\"comments-list\"]/div[1]/div/ul/li[contains(@clstag,'chaping')]/a/em/text()")
	private String bad;	//差评数


	private String site = CrawlerSource.jd.getType();

	private Date updateTime = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.id = "JD"+itemId;
		this.itemId = itemId;
	}

	public String getAuthorText() {
		return authorText;
	}

	public void setAuthorText(String authorText) {
		this.authorText = authorText;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "JDBookItem [id=" + id + ", itemId=" + itemId + ", category=" + category + ", coverPictures="
				+ coverPictures + ", name=" + name + ", properties=" + properties + ", authorText=" + authorText
				+ ", characteristic=" + characteristic + ", recommend=" + recommend + ", introduction=" + introduction
				+ ", authorIntro=" + authorIntro + ", bookReview=" + bookReview + ", toc=" + toc + ", excerpt="
				+ excerpt + ", preface=" + preface + ", inset=" + inset + ", price=" + price + ", saleRank=" + saleRank
				+ ", good=" + good + ", middle=" + middle + ", bad=" + bad + ", site=" + site + ", updateTime="
				+ updateTime + "]";
	}


}
