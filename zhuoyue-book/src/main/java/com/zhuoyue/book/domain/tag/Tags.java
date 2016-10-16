package com.zhuoyue.book.domain.tag;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
public class Tags extends BaseEntity {

    private String tag; //标签名称
    private String tagType; //定制标签归类，可编辑

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
