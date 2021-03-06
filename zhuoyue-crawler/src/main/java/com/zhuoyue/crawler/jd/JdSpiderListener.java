package com.zhuoyue.crawler.jd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.SpiderListener;

/**
 * Created by dongqi on 15/9/7.
 * 暂时没用
 */
@Component
public class JdSpiderListener implements SpiderListener {

    private static final Logger log = LoggerFactory.getLogger(JdSpiderListener.class);

    @Override
    public void onSuccess(Request request) {
        log.info("{}", request);
    }

    @Override
    public void onError(Request request) {
        log.info("{}", request);
    }
}
