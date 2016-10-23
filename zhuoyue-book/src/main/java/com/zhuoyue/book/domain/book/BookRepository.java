package com.zhuoyue.book.domain.book;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

}
