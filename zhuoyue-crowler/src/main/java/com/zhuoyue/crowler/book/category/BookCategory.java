package com.zhuoyue.crowler.book.category;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "图书类型")
public class BookCategory extends BaseEntity {

    @ApiModelProperty(value="分类名称")
    private String categoryName;

    @ApiModelProperty(value="分类名称")
    private Integer pid;     //上级分类ID

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value="分类类型")
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

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}
