package com.zhuoyue.crawler.jd.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl(value = "http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&page=\\d+&stock=0*", sourceRegion="//div[@id=\"J_bottomPage\"]")
@ExtractBy(value = "//div[@id=\"plist\"]//div[contains(@class,\"j-sku-item\")]", multi=true)
public class JDBookList {

	@ExtractBy(value="div/@data-sku", notNull=true)
    private String itemId;

    @ExtractBy(value="div/@data-i")
    private Integer dataId;

    @ExtractByUrl("http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&page=(\\d+)&stock=0*")
    private Integer pageNo;

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

    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
	public String toString() {
		return "JDBookItem [itemId=" + itemId  + "]";
	}

}
