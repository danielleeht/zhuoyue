package com.zhuoyue.book.domain.author;

import com.zhuoyue.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

/**
 * 作者信息
 * Created by lihaitao on 2016/9/24.
 */
@Entity
@ApiModel(description = "作家档案信息")
public class Author extends BaseEntity {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("外文名")
    private String foreignName;

    @ApiModelProperty("照片")
    private String photo;

    @ApiModelProperty("简介")
    private String introduction;

    @ApiModelProperty("成就")
    private String achievement;

    @ApiModelProperty("职业")
    private String profession;

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
