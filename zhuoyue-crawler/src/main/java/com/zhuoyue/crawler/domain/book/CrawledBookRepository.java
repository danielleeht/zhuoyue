package com.zhuoyue.crawler.domain.book;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface CrawledBookRepository extends PagingAndSortingRepository<CrawledBook, Long> {

}
