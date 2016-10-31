package com.zhuoyue.crawler.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface CrawledBookRepository extends JpaRepository<CrawledBook, Long> {

}
