package com.zhuoyue.crowler.jd.model;

import us.codecraft.webmagic.model.annotation.ExtractBy;

@ExtractBy(value = "/allText()")
public class JDCommentTag {

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.id")
	private String id;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.name")
	private String name;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.count")
	private Integer count;

	@ExtractBy(type = ExtractBy.Type.JsonPath, value = "$.rid")
	private String rid;

}
