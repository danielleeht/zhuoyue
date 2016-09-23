package com.zhuoyue.crowler.jd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.zhuoyue.crowler.jd.model.JDBookList;

/**
 * Created by arvinaboque on 6/21/16.
 */

public interface JDBookListRepository extends MongoRepository<JDBookList, String> {
}
