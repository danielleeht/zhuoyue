package com.zhuoyue.crawler.event;

import com.zhuoyue.crawler.domain.book.CrawledBook;

import java.util.EventObject;

/**
 * Created by lihaitao on 2016/10/30.
 */
public class BookItemSavedEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public BookItemSavedEvent(CrawledBook source) {
        super(source);
    }
}
