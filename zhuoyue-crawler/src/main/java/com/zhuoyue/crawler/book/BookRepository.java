package com.zhuoyue.crawler.book;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface BookRepository extends PagingAndSortingRepository<CrawledBook, Long> {

}
