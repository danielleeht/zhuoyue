package com.zhuoyue.crawler;

/**
 *
 * @author lihaitao
 *
 */
public enum CrawlerSource {
    amazon("amazon", "亚马逊"),
    jd("jd", "京东"),
    dangdang("dd", "当当"),
    douban("douban", "豆瓣");

    private String type;

    private String name;

    CrawlerSource(String type, String name) {
        this.type = type;
        this.name = name;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
