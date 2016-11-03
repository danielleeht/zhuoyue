package com.zhuoyue.crawler.domain.author;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lihaitao on 2016/10/30.
 */
public interface AuthorMappingRepository extends JpaRepository<AuthorMapping, Long> {

    @Cacheable(value="author_logic")
    public AuthorMapping findByNameAndCountryAndBookAuthorType(String name, String country, BookAuthorType bookAuthorType);
}
