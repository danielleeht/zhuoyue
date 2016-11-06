package com.zhuoyue.crawler.domain.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by lihaitao on 2016/10/23.
 */
public interface BookCatalogRepository extends JpaRepository<BookCatalog, Long> {

    List<BookCatalog> findByCatalogStatusAndSite(CatalogStatus catalogStatus, String site);

    BookCatalog findByItemIdAndSite(String itemId, String site);

}
