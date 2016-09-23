package com.zhuoyue.crowler.jd.formatter;

import com.zhuoyue.crowler.jd.model.JDAuthor;

import us.codecraft.webmagic.model.formatter.ObjectFormatter;

public class JDAuthorFormatter implements ObjectFormatter<JDAuthor> {


    @Override
    public JDAuthor format(String raw) {
        return null;
    }

    @Override
    public Class<JDAuthor> clazz() {
        return JDAuthor.class;
    }

    @Override
    public void initParam(String[] extra) {
    }
}
