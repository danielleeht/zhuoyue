package com.zhuoyue.crawler.domain.category;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * Created by lihaitao on 2016/10/9.
 */
@Entity
@ApiModel(description = "图书类型")
public class CrawlBookCategory extends BaseEntity {

    @ApiModelProperty(value="分类编号")
    @NotNull
    private String categoryString;

    @ApiModelProperty(value="分类名称")
    @NotNull
    private String categoryName;

    @ApiModelProperty(value="上级分类")
    private String parentCategory;     //上级分类ID

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value="分类类型")
    @NotNull
    private CategoryType categoryType;

    @ApiModelProperty(value="网站")
    @NotNull
    private String site;

    public String getCategoryString() {
        return categoryString;
    }

    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "CrawlBookCategory{" +
            "categoryString='" + categoryString + '\'' +
            ", categoryName='" + categoryName + '\'' +
            ", parentCategory=" + parentCategory +
            ", categoryType=" + categoryType +
            ", site='" + site + '\'' +
            '}';
    }
}
