package com.zhuoyue.book.domain.category;

import com.zhuoyue.commons.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
public class BookCategory extends BaseEntity {

    private String categoryName;    //分类名称
    private Integer pid;     //上级分类ID
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
