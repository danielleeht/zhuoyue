package com.zhuoyue.book.domain.comment;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface BookCommentRepository extends PagingAndSortingRepository<BookComment, Long> {

}
