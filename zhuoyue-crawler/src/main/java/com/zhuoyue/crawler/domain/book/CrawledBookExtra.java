package com.zhuoyue.crawler.domain.book;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by daniel_li on 2016/10/18.
 */
@Entity
@ApiModel(description = "图书附加信息")
public class CrawledBookExtra extends BaseEntity {

    @ApiModelProperty(value="附加信息内容")
    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value="附加信息类型")
    private CrawledBookExtraType extraType;

    public CrawledBookExtra() {
    }

    public CrawledBookExtra(String content, CrawledBookExtraType extraType) {
        this.content = content;
        this.extraType = extraType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CrawledBookExtraType getExtraType() {
        return extraType;
    }

    public void setExtraType(CrawledBookExtraType extraType) {
        this.extraType = extraType;
    }
}
