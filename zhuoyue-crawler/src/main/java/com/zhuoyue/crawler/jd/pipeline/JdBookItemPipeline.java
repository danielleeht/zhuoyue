package com.zhuoyue.crawler.jd.pipeline;

import com.zhuoyue.crawler.domain.book.*;
import com.zhuoyue.crawler.event.BookItemSavedEvent;
import com.zhuoyue.crawler.jd.model.JdBookItem;
import com.zhuoyue.crawler.jd.model.JdBookProperty;
import com.zhuoyue.crawler.service.CrawlBookItemService;
import com.zhuoyue.crawler.utils.CrawlerSource;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;
import us.codecraft.webmagic.selector.Selector;
import us.codecraft.webmagic.selector.XpathSelector;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class JdBookItemPipeline implements PageModelPipeline<JdBookItem> {

    private static final Logger log = LoggerFactory.getLogger(JdBookItemPipeline.class);

    @Autowired
    private CrawledBookRepository crawledBookRepository;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void process(JdBookItem jdBookItem, Task task) {
        log.info("UUID={}, Site={}", task.getUUID(), task.getSite());

        log.info("resultItem = {}", jdBookItem);

        CrawledBook crawledBook = convertCrawledBook(jdBookItem);

        log.info("获得图书信息：{}", crawledBook);

        crawledBook = crawledBookRepository.save(crawledBook);

        applicationContext.publishEvent(new BookItemSavedEvent(crawledBook));

    }

    /**
     * 将爬虫模型转换为图书实体模型
     * @param jdBookItem
     * @return
     */
    private CrawledBook convertCrawledBook(JdBookItem jdBookItem) {

        CrawledBook crawledBook = new CrawledBook();

        crawledBook.setName(jdBookItem.getName());
        crawledBook.setSite(CrawlerSource.jd.getType());
        crawledBook.setAuthorText(jdBookItem.getAuthorText());
        crawledBook.setCoverPictures(jdBookItem.getCoverPictures());
        crawledBook.setCrawledBookStatus(CrawledBookStatus.CRAWLED);
        crawledBook.setItemId(jdBookItem.getItemId());
        crawledBook.setInset(jdBookItem.getInset());

        String priceString = jdBookItem.getPrice();

        try{
            BigDecimal price = new BigDecimal(priceString.replaceAll("[^0-9.]", ""));
            crawledBook.setPrice(price);
        }catch (Exception e){
            log.warn("Price parse error, priceString: {}", priceString);
        }

        List<JdBookProperty> jdBookPropertyList = jdBookItem.getProperties();
        for(JdBookProperty jdBookProperty : jdBookPropertyList){
            convertProperty(crawledBook, jdBookProperty);
        }

        Set<CrawledBookExtra> crawledBookExtras = convertBookExtras(jdBookItem, crawledBook);
        crawledBook.setCrawledBookExtras(crawledBookExtras);

        return crawledBook;
    }

    /**
     * 转换属性信息
     * @param crawledBook
     * @param jdBookProperty
     */
    private void convertProperty(CrawledBook crawledBook, JdBookProperty jdBookProperty) {
        try{
            if("ISBN".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setIsbn(jdBookProperty.getPropertyValue().trim());
            }else
            if("外文名称".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setForeignName(jdBookProperty.getPropertyValue().trim());
            }else
            if("丛书名".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setSeries(jdBookProperty.getPropertyValue().trim());
            }else
            if("出版时间".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                String publishTimeString = jdBookProperty.getPropertyValue().trim();
                Date publishTime = DateUtils.parseDate(publishTimeString, "YYYY-MM-DD");
                crawledBook.setPublishTime(publishTime);
            }else
            if("出版社".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setPublisherText(jdBookProperty.getPropertyValue().trim());
            }else
            if("包装".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setPackaging(jdBookProperty.getPropertyValue().trim());
            }else
            if("套装数量".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setSuit(Boolean.TRUE);
                crawledBook.setSuitCount(Integer.parseInt(jdBookProperty.getPropertyValue().trim()));
            }else
            if("字数".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setWordCount(Integer.parseInt(jdBookProperty.getPropertyValue().trim()));
            }else
            if("开本".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setFormat(jdBookProperty.getPropertyValue().trim());
            }else
            if("正文语种".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setLanguage(jdBookProperty.getPropertyValue().trim());
            }else
            if("版次".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setPublishNo(Integer.parseInt(jdBookProperty.getPropertyValue().trim()));
            }else
            if("用纸".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setPager(jdBookProperty.getPropertyValue().trim());
            }else
            if("页数".equalsIgnoreCase(jdBookProperty.getPropertyName().trim())){
                crawledBook.setPages(Integer.parseInt(jdBookProperty.getPropertyValue().trim()));
            }
        }catch(Exception e){
            log.warn("值解析出错，异常信息", e);
        }
    }

    /**
     * 转换图书附加信息
     * @param jdBookItem
     * @param crawledBook
     * @return
     */
    private Set<CrawledBookExtra> convertBookExtras(JdBookItem jdBookItem, CrawledBook crawledBook) {
        Set<CrawledBookExtra> crawledBookExtras = new HashSet<CrawledBookExtra>();


        if(StringUtils.isNoneEmpty(jdBookItem.getAuthorIntro())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getAuthorIntro(), CrawledBookExtraType.AUTHORINTRO));
        }
        if(StringUtils.isNoneEmpty(jdBookItem.getBookReview())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getBookReview(), CrawledBookExtraType.REVIEW));
        }
        if(StringUtils.isNoneEmpty(jdBookItem.getCharacteristic())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getCharacteristic(), CrawledBookExtraType.CHARACTERISTIC));
        }
        if(StringUtils.isNoneEmpty(jdBookItem.getExcerpt())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getExcerpt(), CrawledBookExtraType.EXCERPT));
        }
        if(StringUtils.isNoneEmpty(jdBookItem.getPreface())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getPreface(), CrawledBookExtraType.PREFACE));
        }
        if(StringUtils.isNoneEmpty(jdBookItem.getRecommend())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getRecommend(), CrawledBookExtraType.RECOMMEND));
            Selector selector = new XpathSelector("font/text()");
            String ageScopeText = selector.select(jdBookItem.getRecommend());

            if(StringUtils.isNotEmpty(ageScopeText)){
                Pattern p = Pattern.compile("适读人群 ：(\\d+)-(\\d+)岁");
                Matcher m = p.matcher(ageScopeText);
                while (m.find()) {
                    AgeScope ageScope = new AgeScope(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
                    crawledBook.setAgeScope(ageScope);
                }
            }


        }
        if(StringUtils.isNoneEmpty(jdBookItem.getIntroduction())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getIntroduction(), CrawledBookExtraType.INTRODUCTION));
        }
        if(StringUtils.isNoneEmpty(jdBookItem.getToc())){
            crawledBookExtras.add(new CrawledBookExtra(jdBookItem.getToc(), CrawledBookExtraType.TOC));
        }
        return crawledBookExtras;
    }
}
