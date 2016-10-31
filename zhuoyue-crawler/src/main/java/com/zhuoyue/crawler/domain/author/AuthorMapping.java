package com.zhuoyue.crawler.domain.author;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 作者信息
 * Created by lihaitao on 2016/9/24.
 */
@Entity
@ApiModel(description = "作家档案信息")
public class AuthorMapping extends BaseEntity {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("国籍")
    private String country;

    @ApiModelProperty("外文名")
    private String foreignName;

    @ApiModelProperty("简介")
    private String introduction;

    @ApiModelProperty("映射到作者")
    @ManyToOne(fetch = FetchType.EAGER)
    private Author mappingAuthor;

    @Enumerated(EnumType.STRING)
    private BookAuthorType bookAuthorType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public Author getMappingAuthor() {
        return mappingAuthor;
    }

    public void setMappingAuthor(Author mappingAuthor) {
        this.mappingAuthor = mappingAuthor;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public BookAuthorType getBookAuthorType() {
        return bookAuthorType;
    }

    public void setBookAuthorType(BookAuthorType bookAuthorType) {
        bookAuthorType = bookAuthorType;
    }
}
