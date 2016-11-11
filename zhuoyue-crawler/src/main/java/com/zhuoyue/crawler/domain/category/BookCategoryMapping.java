package com.zhuoyue.crawler.domain.category;

import com.zhuoyue.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "图书类型对应关系")
public class BookCategoryMapping extends BaseEntity {

    @ApiModelProperty("商品编号")
    @NotNull
    private String itemId;

    @ApiModelProperty(value="直属归类")
    @NotNull
    private String category;

    @ApiModelProperty(value="维度分类")
    @NotNull
    private String normalCategory;

    @ApiModelProperty(value="网站")
    @NotNull
    private String site;

    @ApiModelProperty(value="状态")
    @NotNull
    @Enumerated(EnumType.STRING)
    private CrawlStatus crawlStatus;

    @ApiModelProperty(value="爬取日期")
    private Date crawlDate;

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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public CrawlStatus getCrawlStatus() {
        return crawlStatus;
    }

    public void setCrawlStatus(CrawlStatus crawlStatus) {
        this.crawlStatus = crawlStatus;
    }

    public Date getCrawlDate() {
        return crawlDate;
    }

    public void setCrawlDate(Date crawlDate) {
        this.crawlDate = crawlDate;
    }

    @Override
    public String toString() {
        return "BookCategoryMapping{" +
            "itemId='" + itemId + '\'' +
            ", category='" + category + '\'' +
            ", normalCategory='" + normalCategory + '\'' +
            ", site='" + site + '\'' +
            ", crawlStatus=" + crawlStatus +
            ", crawlDate=" + crawlDate +
            "} " + super.toString();
    }
}
