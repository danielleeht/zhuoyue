package com.zhuoyue.book.domain;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by daniel_li on 2016/10/18.
 */
public class BookExtra extends BaseEntity {
    @ApiModelProperty(value="附加信息内容")
    private String content;

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
