package com.zhuoyue.crowler.book.domain;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by daniel_li on 2016/10/18.
 */
@Entity
@ApiModel(description = "图书附加信息")
public class BookExtra extends BaseEntity {

    @ApiModelProperty(value="附加信息内容")
    private String content;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value="附加信息类型")
    private BookExtraType extraType;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BookExtraType getExtraType() {
        return extraType;
    }

    public void setExtraType(BookExtraType extraType) {
        this.extraType = extraType;
    }
}
