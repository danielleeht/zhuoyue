package com.zhuoyue.crawler.domain.book;

import com.zhuoyue.commons.BaseEntity;
import com.zhuoyue.crawler.domain.CatalogStatus;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/19.
 */
@Entity
@ApiModel(description = "图书爬虫目录信息")
public class BookCatalog extends BaseEntity {

    private String bookId;

    private String itemId;

    private String name;

    private String site;

    private String shopName;

    private Date crawledDate;

    @Enumerated(EnumType.STRING)
    private CatalogStatus catalogStatus;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Date getCrawledDate() {
        return crawledDate;
    }

    public void setCrawledDate(Date crawledDate) {
        this.crawledDate = crawledDate;
    }

    public CatalogStatus getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(CatalogStatus catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
