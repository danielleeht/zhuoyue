package com.zhuoyue.crawler.domain.catalog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lihaitao on 2016/10/23.
 */
public interface BookCatalogRepository extends JpaRepository<BookCatalog, Long> {

    List<BookCatalog> findByCatalogStatusAndSite(CatalogStatus catalogStatus, String site);

    BookCatalog findByItemIdAndSite(String itemId, String site);

    Page<BookCatalog> findByIsbn(@Param("isbn") String isbn, Pageable pageable);

}
