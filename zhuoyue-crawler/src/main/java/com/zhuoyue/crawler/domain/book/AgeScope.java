package com.zhuoyue.crawler.domain.book;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;

/**
 * 图书适合年龄范围
 * Created by lihaitao on 2016/9/25.
 */
@Embeddable
@ApiModel(description = "图书适合年龄范围")
public class AgeScope {

    @ApiModelProperty("年龄从")
    private Integer ageFrom;

    @ApiModelProperty("年龄到")
    private Integer ageTo;

    public AgeScope() {
    }

    public AgeScope(Integer ageFrom, Integer ageTo) {
        this.ageFrom = ageFrom;
        this.ageTo = ageTo;
    }

    public Integer getAgeFrom() {
        return ageFrom;
    }

    public void setAgeFrom(Integer ageFrom) {
        this.ageFrom = ageFrom;
    }

    public Integer getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(Integer ageTo) {
        this.ageTo = ageTo;
    }

}
