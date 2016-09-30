package com.zhuoyue.book;

import javax.persistence.Embeddable;

/**
 * 图书适合年龄范围
 * Created by lihaitao on 2016/9/25.
 */
@Embeddable
public class AgeScope {

    private Integer ageFrom;
    private Integer ageTo;

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
