package com.zhuoyue.crawler.domain.catalog;

import com.zhuoyue.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/19.
 */
@Entity
@ApiModel(description = "图书爬虫目录信息")
public class BookCatalog extends BaseEntity {

    @ApiModelProperty(value="爬虫图书明细")
    private Long crawledBookId;

    @ApiModelProperty(value="商品编号")
    @NotNull
    private String itemId;

    @ApiModelProperty(value="图书名称")
    private String name;

    @ApiModelProperty("ISBN")
    private String isbn;

    @ApiModelProperty(value="封面图片URL")
    private String cover;

    @ApiModelProperty(value="图书分类")
    private String category;

    @ApiModelProperty(value="爬虫网站")
    @NotNull
    private String site;

    @ApiModelProperty(value="销量排行")
    private Integer rank;

    @ApiModelProperty(value="商户名称")
    private String shopName;

    @ApiModelProperty(value="爬虫日期")
    private Date crawledDate;

    @ApiModelProperty(value="状态")
    @Enumerated(EnumType.STRING)
    @NotNull
    private CatalogStatus catalogStatus;

    public Long getCrawledBookId() {
        return crawledBookId;
    }

    public void setCrawledBookId(Long crawledBookId) {
        this.crawledBookId = crawledBookId;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public CatalogStatus getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(CatalogStatus catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}
