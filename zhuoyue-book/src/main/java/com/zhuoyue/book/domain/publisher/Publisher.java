package com.zhuoyue.book.domain.publisher;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;

/**
 * 出版社信息
 * Created by lihaitao on 2016/9/24.
 */
@Entity
public class Publisher extends BaseEntity {

    private String name;    //出版社名称
    private String foreignName; //外文名称
    private String introduction;    //出版社简介
    private String location;    //位置
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
