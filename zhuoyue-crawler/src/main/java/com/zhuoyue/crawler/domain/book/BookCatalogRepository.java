package com.zhuoyue.crawler.domain.book;

import com.zhuoyue.crawler.domain.CatalogStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by lihaitao on 2016/10/23.
 */
public interface BookCatalogRepository extends PagingAndSortingRepository<BookCatalog, Long> {

    List<BookCatalog> findByCatalogStatusAndSite(CatalogStatus catalogStatus, String site);

}
