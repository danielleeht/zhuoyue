package com.zhuoyue.crawler.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface CrawlBookCategoryRepository extends JpaRepository<CrawlBookCategory, Long> {

    public List<CrawlBookCategory> findBySiteAndCategoryType(String site, CategoryType categoryType );
}
