package com.zhuoyue.crawler.jd.formatter;

import com.zhuoyue.crawler.jd.model.JDBookProperty;

import us.codecraft.webmagic.model.formatter.ObjectFormatter;

public class JDBookPropertyFormatter implements ObjectFormatter<JDBookProperty> {

    @Override
    public JDBookProperty format(String raw) {
    	String[] substrs = raw.split("：");
    	JDBookProperty property = new JDBookProperty();
    	property.setPropertyName(substrs[0]);
    	property.setPropertyValue(substrs[1]);
        return property;
    }

    @Override
    public Class<JDBookProperty> clazz() {
        return JDBookProperty.class;
    }

    @Override
    public void initParam(String[] extra) {
    }
}
