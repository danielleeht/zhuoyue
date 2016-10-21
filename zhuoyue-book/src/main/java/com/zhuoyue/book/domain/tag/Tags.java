package com.zhuoyue.book.domain.tag;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "Tag库及分类")
public class Tags extends BaseEntity {

    @ApiModelProperty(value="标签")
    private String tag;

    @ApiModelProperty(value="标签分类")
    private String tagType;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }
}
