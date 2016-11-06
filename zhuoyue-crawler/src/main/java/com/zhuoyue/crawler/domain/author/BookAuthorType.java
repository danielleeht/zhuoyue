package com.zhuoyue.crawler.domain.author;

/**
 * Created by lihaitao on 2016/9/25.
 */
public enum BookAuthorType {
    AUTHOR, //作者
    EDITOR, //编者
    PROOFREADER,    //校
    CRITICS,    //评
    TRANSFER,   //译
    DRAWER;  //绘

    public static BookAuthorType transform(String authorTypeStr){
        if("著".equals(authorTypeStr)){
            return AUTHOR;
        }else
        if("作".equals(authorTypeStr)){
            return AUTHOR;
        }else
        if("编".equals(authorTypeStr)){
            return EDITOR;
        }else
        if("校".equals(authorTypeStr)){
            return PROOFREADER;
        }else
        if("评".equals(authorTypeStr)){
            return CRITICS;
        }else
        if("译".equals(authorTypeStr)){
            return TRANSFER;
        }else
        if("绘".equals(authorTypeStr)){
            return DRAWER;
        }
        return AUTHOR;
    }
}
