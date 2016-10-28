package com.zhuoyue.crawler.jd.model;

import java.util.Date;
import java.util.List;

import com.zhuoyue.crawler.utils.CrawlerSource;
import com.zhuoyue.crawler.jd.formatter.JdBookPropertyFormatter;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.Formatter;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl(value = "http://item.jd.com/\\d+.html*", sourceRegion="no")
public class JdBookItem {

    @ExtractByUrl("http://item.jd.com/(\\d+).html*")
    private String itemId;	//商品编号

//	@ExtractBy(value="//div[@class=\"breadcrumb\"]//span[1]/a[2]/regex(@href,'//list.jd.com/list.html\\?cat=(1713,3263,\\d+)', 1)")
//	private String category;	//商品分类

	@ExtractBy(value="//*[@id=\"spec-list\"]/div/ul/li/img/@src")
	private List<String> coverPictures;	//封面图片

	@ExtractBy(value="//*[@id=\"name\"]/h1/text()")
	private String name;	//书名

	@Formatter(subClazz=JdBookProperty.class, formatter=JdBookPropertyFormatter.class)
	@ExtractBy("//ul[@id=\"parameter2\"]/li/allText()")
	private List<JdBookProperty> properties;

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

//	@ExtractBy(value="//div[@id=\"summary-order\"]/div[2]/font/text()")
//	private String saleRank;	//销售排行
//
//	@ExtractBy(value="//div[@id=\"comments-list\"]/div[1]/div/ul/li[contains(@clstag,'haoping')]/a/em/text()")
//	private String good;	//好评数
//
//	@ExtractBy(value="//div[@id=\"comments-list\"]/div[1]/div/ul/li[contains(@clstag,'zhongping')]/a/em/text()")
//	private String middle;	//中评数
//
//	@ExtractBy(value="//div[@id=\"comments-list\"]/div[1]/div/ul/li[contains(@clstag,'chaping')]/a/em/text()")
//	private String bad;	//差评数

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAuthorText() {
		return authorText;
	}

	public void setAuthorText(String authorText) {
		this.authorText = authorText;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public List<String> getCoverPictures() {
        return coverPictures;
    }

    public void setCoverPictures(List<String> coverPictures) {
        this.coverPictures = coverPictures;
    }

    public List<JdBookProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<JdBookProperty> properties) {
        this.properties = properties;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getBookReview() {
        return bookReview;
    }

    public void setBookReview(String bookReview) {
        this.bookReview = bookReview;
    }

    public String getToc() {
        return toc;
    }

    public void setToc(String toc) {
        this.toc = toc;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public List<String> getInset() {
        return inset;
    }

    public void setInset(List<String> inset) {
        this.inset = inset;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "JdBookItem{" +
            "itemId='" + itemId + '\'' +
            ", coverPictures=" + coverPictures +
            ", name='" + name + '\'' +
            ", properties=" + properties +
            ", authorText='" + authorText + '\'' +
            ", characteristic='" + characteristic + '\'' +
            ", recommend='" + recommend + '\'' +
            ", introduction='" + introduction + '\'' +
            ", authorIntro='" + authorIntro + '\'' +
            ", bookReview='" + bookReview + '\'' +
            ", toc='" + toc + '\'' +
            ", excerpt='" + excerpt + '\'' +
            ", preface='" + preface + '\'' +
            ", inset=" + inset +
            ", price='" + price + '\'' +
            '}';
    }
}
