package com.zhuoyue.crawler.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface CrawledBookRepository extends JpaRepository<CrawledBook, Long> {

    public List<CrawledBook> findByCrawledBookStatus(CrawledBookStatus crawledBookStatus);
}
