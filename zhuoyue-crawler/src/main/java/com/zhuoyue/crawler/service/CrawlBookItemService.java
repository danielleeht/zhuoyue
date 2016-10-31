package com.zhuoyue.crawler.service;

import com.zhuoyue.crawler.domain.author.*;
import com.zhuoyue.crawler.domain.book.CrawledBook;
import com.zhuoyue.crawler.domain.book.CrawledBookRepository;
import com.zhuoyue.crawler.domain.publisher.Publisher;
import com.zhuoyue.crawler.domain.publisher.PublisherRepository;
import com.zhuoyue.crawler.event.BookItemSavedEvent;
import com.zhuoyue.crawler.jd.pipeline.JdBookCatalogPipeline;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lihaitao on 2016/10/30.
 */
@Service
public class CrawlBookItemService {

    private static final Logger log = LoggerFactory.getLogger(JdBookCatalogPipeline.class);

    @Autowired
    private AuthorMappingRepository authorMappingRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publishRepository;

    @Autowired
    private CrawledBookRepository crawledBookRepository;

    @EventListener
    public void processBookItem(BookItemSavedEvent bookItemSavedEvent){
        CrawledBook crawledBook = (CrawledBook)bookItemSavedEvent.getSource();
        log.info("Begin process book item {}-{}-{}-{}", crawledBook.getId(), crawledBook.getName(), crawledBook.getSite(), crawledBook.getItemId());

        Set<BookAuthor> authors = new HashSet<BookAuthor>();
        crawledBook.setAuthors(authors);

        String authorText = crawledBook.getAuthorText();
        if(StringUtils.isNotEmpty(authorText)){
            convertAuthor(authorText, authors);
        }

        String publisherText = crawledBook.getPublisherText();
        Set<Publisher> publishers = new HashSet<Publisher>();

        if(StringUtils.isNotEmpty(publisherText)){
            String[] names = publisherText.split("[,，]");
            for(String name : names){
                Publisher publisher = publishRepository.findByName(name);
                if(publisher == null){
                    publisher = new Publisher();
                    publisher.setName(name);
                    publisher = publishRepository.save(publisher);
                }
                publishers.add(publisher);
            }
        }
        crawledBook.setPublishers(publishers);

        crawledBookRepository.save(crawledBook);
    }

    /**
     * 将字符串格式的作者信息转化为作者关联实体信息
     * @param authorText
     * @param authors
     */
    private void convertAuthor(String authorText, Set<BookAuthor> authors) {
        String[] authorStrs = authorText.split("[；;]");

        for(String authorStr : authorStrs){
            //截取末尾作者类型
            BookAuthorType bookAuthorType = null;
            String authorMain = authorStr;

            Pattern authorTypePattern = Pattern.compile("(.+) ([著作编校评译绘])");
            Matcher authorTypeMatcher = authorTypePattern.matcher(authorStr);
            if(authorTypeMatcher.find()){
                authorMain = authorTypeMatcher.group(1);
                bookAuthorType = BookAuthorType.transform(authorTypeMatcher.group(2));
            }
            authorMain = authorMain.trim();

            //是否带等
            if(authorMain.endsWith("等")){
                BookAuthor etcBookAuthor = new BookAuthor();
                etcBookAuthor.setName("等");
                etcBookAuthor.setBookAuthorType(bookAuthorType);
                etcBookAuthor.setNumber(99);
                authors.add(etcBookAuthor);
            }

            //截取头部国籍信息，例如：[美]
            String defaultCountry = null;
            Pattern countryPattern = Pattern.compile("[\\[\\(【（]([\\u4E00-\\u9FA5]+)[\\]\\)】）] (.+)");
            Matcher defaultCountryMatcher = countryPattern.matcher(authorMain);
            if(defaultCountryMatcher.find()){
                defaultCountry = defaultCountryMatcher.group(1);
            }
            //某一类作者有多个
            String[] singleAuthorStrs = authorMain.split("[，,]");
            int number = 0;
            for(String singleAuthorStr: singleAuthorStrs){
                number++;

                String country = defaultCountry;
                String namePart = singleAuthorStr;
                Matcher countryMatcher = countryPattern.matcher(singleAuthorStr);
                if(countryMatcher.find()){
                    country = countryMatcher.group(1);
                    namePart = countryMatcher.group(2);
                }

                String name = namePart;
                String foreignName = null;

                Pattern foreignNamePattern = Pattern.compile("(.+)[\\(（](.+)[\\)）] (.*)");
                Matcher foreignNameMatcher = foreignNamePattern.matcher(namePart);
                if(foreignNameMatcher.find()){
                    String temp = foreignNameMatcher.group(1);
                    if(temp.substring(0, 1).matches("[\\u4E00-\\u9FA5]")){
                        name = temp;
                        foreignName = foreignNameMatcher.group(2);
                    }else{
                        name = foreignNameMatcher.group(2);
                        foreignName = temp;
                    }
                }

                AuthorMapping authorMapping = authorMappingRepository.findByNameAndCountryAndBookAuthorType(name, country, bookAuthorType);

                Author author = null;
                if(authorMapping == null){
                    author = new Author();
                    author.setBookAuthorType(bookAuthorType);
                    author.setName(name);
                    author.setCountry(country);
                    author.setForeignName(foreignName);

                    author = authorRepository.save(author);

                    authorMapping = new AuthorMapping();
                    authorMapping.setBookAuthorType(bookAuthorType);
                    authorMapping.setName(name);
                    authorMapping.setCountry(country);
                    authorMapping.setForeignName(foreignName);
                    authorMapping.setMappingAuthor(author);

                    authorMappingRepository.save(authorMapping);
                }else{
                    author = authorMapping.getMappingAuthor();
                }

                BookAuthor bookAuthor = new BookAuthor();
                bookAuthor.setName(name);
                bookAuthor.setBookAuthorType(bookAuthorType);
                bookAuthor.setNumber(number);
                bookAuthor.setAuthor(author);
                authors.add(bookAuthor);
            }
        }
    }
}
