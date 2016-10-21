package com.zhuoyue.crawler;

import us.codecraft.webmagic.model.SubEntityExtractor;
import us.codecraft.webmagic.model.formatter.ObjectFormatter;

public class SubEntityFormatter implements ObjectFormatter {

	private Class clazz;

	@Override
    public Object format(String raw) {
		SubEntityExtractor extractor = SubEntityExtractor.create(clazz);
		return extractor.process(raw);
    }

    @Override
    public Class clazz() {
        return Object.class;
    }

    @Override
    public void initParam(String[] extra) {
    	try {
			clazz = Class.forName(extra[0]);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
