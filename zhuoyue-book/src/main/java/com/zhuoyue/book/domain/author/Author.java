package com.zhuoyue.book.domain.author;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;

/**
 * 作者信息
 * Created by lihaitao on 2016/9/24.
 */
@Entity
public class Author extends BaseEntity {

    private String name;    //姓名
    private String foreignName; //外文名
    private String photo;   //照片
    private String introduction;    //简介
    private String achievement; //成就
    private String profession;  //职业

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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
