package com.zhuoyue.crawler.jd.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl(value = "http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&ev=[^&]+&page=\\d+&stock=0*", sourceRegion="//div[@id=\"J_bottomPage\"]")
@ExtractBy(value = "//div[@id=\"plist\"]//div[contains(@class,\"j-sku-item\")]", multi=true)
public class JdBookCategory {

	@ExtractBy(value="div/@data-sku", notNull=true)
    private String itemId;

    @ExtractByUrl("http://list.jd.com/list.html\\?cat=1713,3263,(\\d{4})&ev=[^&]+&page=\\d+&stock=0*")
    private String category;

    @ExtractByUrl("http://list.jd.com/list.html\\?cat=1713,3263,\\d{4}&ev=([^&]+)&page=\\d+&stock=0*")
	private String normalCategory;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNormalCategory() {
        return normalCategory;
    }

    public void setNormalCategory(String normalCategory) {
        this.normalCategory = normalCategory;
    }

    @Override
    public String toString() {
        return "JdBookCategory{" +
            "itemId='" + itemId + '\'' +
            ", category='" + category + '\'' +
            ", normalCategory='" + normalCategory + '\'' +
            '}';
    }
}
