package com.zhuoyue.crawler.jd.formatter;

import com.zhuoyue.crawler.jd.model.JdBookProperty;

import us.codecraft.webmagic.model.formatter.ObjectFormatter;

public class JdBookPropertyFormatter implements ObjectFormatter<JdBookProperty> {

    @Override
    public JdBookProperty format(String raw) {
    	String[] substrs = raw.split("：");
    	JdBookProperty property = new JdBookProperty();
    	property.setPropertyName(substrs[0]);
    	property.setPropertyValue(substrs[1]);
        return property;
    }

    @Override
    public Class<JdBookProperty> clazz() {
        return JdBookProperty.class;
    }

    @Override
    public void initParam(String[] extra) {
    }
}
