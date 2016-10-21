package com.zhuoyue.crawler.jd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zhuoyue.crawler.jd.model.JDBookList;

/**
 * Created by arvinaboque on 6/21/16.
 */

public interface JDBookListRepository extends MongoRepository<JDBookList, String> {
}
