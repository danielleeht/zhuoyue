package com.zhuoyue.crawler.domain.category;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface CrawlBookCategoryRepository extends PagingAndSortingRepository<CrawlBookCategory, Long> {

    public List<CrawlBookCategory> findBySiteAndCategoryType(String site, CategoryType categoryType );
}
