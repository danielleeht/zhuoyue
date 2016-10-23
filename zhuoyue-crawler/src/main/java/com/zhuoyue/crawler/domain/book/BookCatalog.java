package com.zhuoyue.crawler.domain.book;

import com.zhuoyue.commons.BaseEntity;
import com.zhuoyue.crawler.domain.RecordStatus;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by lihaitao on 2016/10/19.
 */
@Entity
@ApiModel(description = "图书爬虫目录信息")
public class BookCatalog extends BaseEntity {

    private String taskId;

    private String bookId;

    private String itemId;

    private String cover;

    private String name;

    private String site;

    private String shopName;

    private Date crawledDate;

    private RecordStatus recordStatus;

    private Integer rank;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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

    public RecordStatus getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(RecordStatus recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
