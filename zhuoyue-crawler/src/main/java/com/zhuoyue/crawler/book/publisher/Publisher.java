package com.zhuoyue.crawler.book.publisher;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

/**
 * 出版社信息
 * Created by lihaitao on 2016/9/24.
 */
@Entity
@ApiModel(description = "出版社")
public class Publisher extends BaseEntity {

    @ApiModelProperty(value="出版社名称")
    private String name;    //出版社名称

    @ApiModelProperty(value="外文名称")
    private String foreignName; //外文名称

    @ApiModelProperty(value="出版社简介")
    private String introduction;    //出版社简介

    @ApiModelProperty(value="位置")
    private String location;    //位置

    @ApiModelProperty(value="成立日期")
    private String foundDate;   //成立日期

    private String logo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
