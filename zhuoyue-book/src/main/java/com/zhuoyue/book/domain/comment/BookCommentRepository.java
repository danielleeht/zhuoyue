package com.zhuoyue.book.domain.comment;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface BookCommentRepository extends JpaRepository<BookComment, Long> {

}
