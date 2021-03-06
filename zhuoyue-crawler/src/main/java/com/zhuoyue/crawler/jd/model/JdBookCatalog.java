package com.zhuoyue.crawler.jd.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl(value = "http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&page=\\d+&stock=0*", sourceRegion="//div[@id=\"J_bottomPage====\"]")
@ExtractBy(value = "//div[@id=\"plist\"]//div[contains(@class,\"j-sku-item\")]", multi=true)
public class JdBookCatalog {

	@ExtractBy(value="div/@data-sku", notNull=true)
    private String itemId;

    @ExtractBy(value="div/@data-i")
    private String dataId;

    @ExtractByUrl("http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&page=(\\d+)&stock=0*")
    private String pageNo;

    @ExtractByUrl("http://list.jd.com/list.html\\?cat=1713,3263,(\\d{4})&page=\\d+&stock=0*")
    private String category;

	@ExtractBy("div/div[@class=\"p-img\"]/a/img/regex(@src,'(//.*)', 1) | div/div[@class=\"p-img\"]/a/img/@data-lazy-img")
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

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "JDBookCatalog{" +
            "itemId='" + itemId + '\'' +
            ", dataId='" + dataId + '\'' +
            ", pageNo='" + pageNo + '\'' +
            ", category='" + category + '\'' +
            ", cover='" + cover + '\'' +
            ", name='" + name + '\'' +
            ", shopName='" + shopName + '\'' +
            '}';
    }
}
