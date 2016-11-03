package com.zhuoyue.crawler.domain.publisher;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lihaitao on 2016/10/15.
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    @Cacheable(value = "publisher")
    public Publisher findByName(String name);
}
