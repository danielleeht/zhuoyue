package com.zhuoyue.crawler.domain.publisher;

import com.zhuoyue.commons.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;

/**
 * 出版社信息
 * Created by lihaitao on 2016/9/24.
 */
@Entity
@ApiModel(description = "出版社")
public class Publisher extends BaseEntity {

    @ApiModelProperty(value="出版社名称")
    private String name;    //出版社名称

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
