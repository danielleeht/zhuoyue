package com.zhuoyue.crawler.domain.category;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lihaitao on 2016/11/5.
 */
public interface BookCategoryMappingRepository extends JpaRepository<BookCategoryMapping, Long> {

    BookCategoryMapping findByItemIdAndCategoryAndNormalCategoryAndSite
        (String itemId, String category, String normalCategory, String site);
}
