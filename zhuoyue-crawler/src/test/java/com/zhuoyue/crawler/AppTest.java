package com.zhuoyue.crawler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zhuoyue.crawler.domain.author.BookAuthorType;
import com.zhuoyue.crawler.domain.category.CategoryType;
import com.zhuoyue.crawler.domain.category.CrawlBookCategory;
import com.zhuoyue.crawler.utils.CrawlerSource;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.collections.CollectionUtils;
import org.jsoup.nodes.Element;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.downloader.selenium.SeleniumDownloader;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selector;
import us.codecraft.webmagic.selector.XpathSelector;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testRegex()
    {
    	assertTrue(Pattern.matches("\\w", "s"));
    	assertTrue(Pattern.matches("http://list.jd.com/1713-3263-\\d{4}.html", "http://list.jd.com/1713-3263-3094.html"));
    	assertTrue(Pattern.matches("(http://list\\.jd\\.com/list\\.html\\?cat=1713,3263,\\d{4}&page=\\d+&stock=0.*)",
    			"http://list.jd.com/list.html?cat=1713,3263,3394&page=1&stock=0&sort=sort_publishtime_desc"));

    }

    public void testLinkedHashMap(){
    	LinkedHashMap map = new LinkedHashMap();
    	map.put("a", "a");
    	map.put("a", "a");
    	map.put("a", "b");
    	map.put("a", "c");

    	System.out.println(map);
    }

    public void testDataId(){
        String html = "<div class=\"gl-i-wrap j-sku-item\" data-sku=\"11946232\" venderid=\"1000004558\" jdzy_shop_id=\"1000004558\" ts_venderid=\"\" data-sku_temp=\"11946232\" data-i=\"45\">\n" +
            "  <div class=\"p-img\">\n" +
            "    <a target=\"_blank\" href=\"//item.jd.com/11946232.html\">\n" +
            "                          <img width=\"200\" height=\"200\" data-img=\"1\" data-lazy-img=\"//img12.360buyimg.com/n7/jfs/t2767/95/1822638030/135265/1daadad8/574bd1eaNa706d72f.jpg\">\n" +
            "          </a>\n" +
            "          </div>\n" +
            "  <div class=\"p-price\">\n" +
            "    <strong class=\"J_price\"><em>¥</em><i>11.60</i></strong>\n" +
            "      </div>\n" +
            "  <div class=\"p-name\">\n" +
            "    <a target=\"_blank\" title=\"\" href=\"//item.jd.com/11946232.html\">\n" +
            "      <em>为什么不可以偷东西</em>\n" +
            "      <i class=\"promo-words\"></i>\n" +
            "    </a>\n" +
            "  </div>\n" +
            "      <div class=\"p-bookdetails\">\n" +
            "      <span class=\"p-bi-name\">\n" +
            "                  <span class=\"author_type_1\" style=\"display: ;\">\n" +
            "                                                       [韩]                <a title=\"李柔姃\" href=\"//book.jd.com/writer/李柔姃_1.html\" target=\"_blank\"> 李柔姃 </a>                                        著          </span>\n" +
            "                        </span>\n" +
            "      <em>|</em>      <span class=\"p-bi-store\">\n" +
            "                  <a title=\"河北少年儿童出版社\" href=\"//book.jd.com/publish/河北少年儿童出版社_1.html\" target=\"_blank\">河北少年儿童出版社</a>\n" +
            "              </span>\n" +
            "      <em>|</em>      <span class=\"p-bi-date\">\n" +
            "        2016-06      </span>\n" +
            "    </div>\n" +
            "        <div class=\"p-shop hide\" data-score=\"4\" data-reputation=\"0\" data-shopid=\"\" data-done=\"1\"></div>\n" +
            "        <div class=\"p-commit\"><strong>已有<a class=\"comment\" target=\"_blank\" href=\"//item.jd.com/11946232.html#comment\">2</a>人评价</strong></div>\n" +
            "        <div class=\"p-shopnum\">\n" +
            "      <span class=\"curr-shop\">京东自营</span>\n" +
            "    </div>\n" +
            "          <div class=\"p-icons J-pro-icons\">\n" +
            "              <i class=\"goods-icons-s1 J-picon-tips\" title=\"货到付款\" data-tips=\"<div class=&quot;picon-tips&quot;><i class=&quot;goods-icons-s1&quot;>货到付款</i><em>该商品支持货到付款</em></div>\">货到付款</i><i class=\"goods-icons J-picon-tips\" data-tips=\"<div class=&quot;picon-tips&quot;><i class=&quot;goods-icons&quot;>券</i><em>优惠券</em></div>\">券</i><i class=\"icons J-picon-tips\" data-tips=\"<div class=&quot;picon-tips&quot;><i class=&quot;goods-icons&quot;>满减</i></div><em>满减</em>\">满减</i></div>\n" +
            "        <div class=\"p-operate\">\n" +
            "      <a class=\"p-o-btn focus J_focus\" data-sku=\"11946232\" href=\"javascript:;\">\n" +
            "        <i></i>关注\n" +
            "      </a>\n" +
            "      <a class=\"p-o-btn addcart\" target=\"_blank\" href=\"//cart.jd.com/gate.action?pid=11946232&amp;pcount=1&amp;ptype=1\">\n" +
            "        <i></i>加入购物车\n" +
            "      </a>\n" +
            "    </div>\n" +
            "    <div class=\"p-stock\" data-isdeliveryable=\"5\" style=\"display: none\" data-stock_v=\"1\" data-stock_h=\"33\"></div>\n" +
            "    <div class=\"p-service\">由 京东 发货</div>\n" +
            "    <div class=\"p-summary\">\n" +
            "      <a href=\"//item.jd.com/11946232.html#recommend-editor\" target=\"_blank\">更多&gt;</a>\n" +
            "    </div>\n" +
            "    <div class=\"p-addtocart\">\n" +
            "      <a data-sku=\"11946232\" href=\"//cart.jd.com/gate.action?pid=11946232&amp;pcount=1&amp;ptype=1\"><i></i>加入购物车</a>\n" +
            "    </div>\n" +
            "  </div>";
        Selector selector = new XpathSelector("div/@data-i");
        String dataId = selector.select(html);
        System.out.println(dataId);

        //因为@src在没有的情况下返回空字符串，无法执行后半段，需要通过正则控制非空
        Selector coverSelector = new XpathSelector("div/div[@class=\"p-img\"]/a/img/regex(@src,'(//.*)', 1) | div/div[@class=\"p-img\"]/a/img/@data-lazy-img");
        String cover = coverSelector.select(html);
        System.out.println(cover);


    }

    public void testSelector(){
    	String html = "<ul id=\"parameter2\" class=\"p-parameter-list\">"+
"                              <li title=\"中央广播电视大学出版社\" clstag=\"shangpin|keycount|product|chubanshe_3\">出版社："+
"                    <a target=\"_blank\" title=\"中央广播电视大学出版社\" href=\"//book.jd.com/publish/中央广播电视大学出版社_1.html\">中央广播电视大学出版社</a>"+
"    </li>"+
"<li title=\"9787304074951\">ISBN：9787304074951</li>"+
"<li title=\"1\">版次：1</li>"+
"<li title=\"11781267\">商品编码：11781267</li>"+
"<li title=\"精装\">包装：精装</li>"+
"<li title=\"16开\">开本：16开</li>"+
"<li title=\"2015-10-01\">出版时间：2015-10-01</li>"+
"<li title=\"铜版纸\">用纸：铜版纸</li>"+
"<li title=\"48\">页数：48</li>"+
"                        </ul>";
    	Selector selector = new XpathSelector("//ul[@id=\"parameter2\"]/li[contains(@title, '2015')]/allText()");
    	List<String> suku = selector.selectList(html);
    	System.out.println(suku);

    	Selector cssselector = new XpathSelector("//ul[@id=\"parameter2\"]/li[last()]/allText()");
    	List<String> aa = cssselector.selectList(html);
    	System.out.println(aa);
    }

    String search(final String regex, final String text) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        String result = "";
        if (m.find()) result = m.group();
        return result;
    }

    public void testXPathSelector(){
    	String html = "<div id=\"root-nav\">"+
    "<div class=\"w\">"+
    "    <div class=\"breadcrumb\">"+
                "<strong><a href=\"//book.jd.com\" clstag=\"shangpin|keycount|product|mbNav-1\">图书</a></strong><span>&nbsp;&gt;&nbsp;<a href=\"//channel.jd.com/1713-3263.html\" clstag=\"shangpin|keycount|product|mbNav-2\">少儿</a>&nbsp;&gt;&nbsp;<a href=\"//list.jd.com/list.html?cat=1713,3263,4761\" clstag=\"shangpin|keycount|product|mbNav-3\">绘本</a>&nbsp;&gt;&nbsp;</span>"+
  "<span><a href=\"//item.jd.com/11887753.html\">猜猜我有多爱你 珍藏版</a></span>"+
   "     </div>"+
    "</div>"+
"</div>";
    	Selector selector = new XpathSelector("//div[@id=\"root-nav\"]/div/div/span[2]/a/text()");
    	String res = selector.select(html);
    	System.out.println(res);

    	String html1 = "<div class=\"p-author\" id=\"p-author\" clstag=\"shangpin|keycount|product|zuozhe_3\">                            [爱尔兰] <a target=\"_blank\" href=\"//book.jd.com/writer/山姆·麦克布雷尼_1.html\">山姆·麦克布雷尼</a> 著；[英] <a target=\"_blank\" href=\"//book.jd.com/writer/安妮塔·婕朗_1.html\">安妮塔·婕朗</a> 绘                        </div>";
    	Selector selector1 = new XpathSelector("//div/allText()");
    	String res1 = selector1.select(html1);
    	System.out.println(res1);

    	Selector selector2 = new XpathSelector("//div[@class=\"breadcrumb\"]//span[1]/a[2]/regex(@href,'//list.jd.com/list.html\\?cat=(1713,3263,\\d+)', 1)");
    	String res2 = selector2.select(html);
    	System.out.println(res2);


    	String href = "//item.jd.com/11887753.html";
    	Pattern pattern = Pattern.compile("//item.jd.com/(\\d+).html");
        Matcher matcher = pattern.matcher(href);
        while (matcher.find()) {
            System.out.println("matcher.group() :" + matcher.group() + " starting at index \"" + matcher.start() + "\" and ending at index \""
                     + matcher.end()+"\""
            );
            System.out.println("matcher.group(1) :" + matcher.group(1)
            );
            System.out.println(matcher.groupCount());

        }

    }

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
    private static Site site = Site.me().setUserAgent(USER_AGENT).setRetryTimes(30).setSleepTime(100);

    public void testBookItemCh(){
    	Downloader downloader = new SeleniumDownloader();
		Page indexPage = downloader.download(new Request("http://item.jd.com/10014239.html"), site.toTask());

		//添加二级分类页面
		Html html = indexPage.getHtml();
		Selector selector = new XpathSelector("//*[@id=\"jd-price\"]/allText()");
		String res = html.selectDocument(selector);
		System.out.println(res);
    }

    public void testCrawlBookCategories() {


        Downloader downloader = new HttpClientDownloader();
        Page indexPage = downloader.download(new Request("http://list.jd.com/list.html?cat=1713,3263"), site.toTask());

        XpathSelector selector = new XpathSelector("//div[@id=\"J_selectorCategory\"]//li");
        List<Element> elements = selector.selectElements(indexPage.getHtml().getDocument());

        for(Element element:elements){
            XpathSelector categorySelector = new XpathSelector("li/a/regex(@href,'http://list.jd.com/1713-3263-(\\d+).html', 1)");
            XpathSelector categorySelector1 = new XpathSelector("li/a/@href");
            String categoryString = categorySelector.select(element);
            String categoryString1 = categorySelector1.select(element);

            XpathSelector categoryNameSelector = new XpathSelector("li/a/@title");
            String categoryName = categoryNameSelector.select(element);

            System.out.println("categoryString=" + categoryString);
            System.out.println("categoryString1=" + categoryString1);
            System.out.println("categoryName=" + categoryName);


        }
    }

    public void testCrawlSubCategories(){
        Downloader downloader = new SeleniumDownloader("D:\\develop\\tools\\chromedriver.exe");
        Page indexCategoryPage = downloader.download(new Request("http://list.jd.com/list.html?cat=1713,3263,3394"), site.toTask());

        XpathSelector lineSelector = new XpathSelector("//div[@class=\"sl-wrap\"]");
        List<Element> lineElements = lineSelector.selectElements(indexCategoryPage.getHtml().getDocument());

        for(Element lineElement:lineElements){
            XpathSelector subTypeSelector = new XpathSelector("div/div[@class=\"sl-key\"]/span/text()");
            String subTypeName = subTypeSelector.select(lineElement).replaceAll("：", "");

            XpathSelector normalSelector = new XpathSelector("//ul[@class=\"J_valueList\"]/li");
            List<Element> normalElements = normalSelector.selectElements(lineElement);

            for(Element normalElement : normalElements){
                XpathSelector normalCategorySelector = new XpathSelector("li/a/regex(@href,'.*&ev=([^&]+)&*', 1)");
                String normalCategory = normalCategorySelector.select(normalElement);

                XpathSelector normalNameSelector = new XpathSelector("li/a/text()");
                String normalCategoryName = normalNameSelector.select(normalElement);

                try {
                    System.out.println("normalCategory=" + URLDecoder.decode(normalCategory, Charset.defaultCharset().name()));
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("normalCategory=" + normalCategory);
                }
                System.out.println("normalCategoryName=" + normalCategoryName);
            }

        }
    }

    public void testSelectAgeScope() {
        String html = "<font color=\"red\">适读人群 ：7-10岁</font>\n" +
            "<br> \n" +
            "<p>　　★窗边的小豆豆 精选集1-6</p>\n" +
            "<p>　　★含《窗边的小豆豆》《小时候就在想的事》《小豆豆与我》《丢三落四的小豆豆》《小豆豆频道》《小豆豆动物剧场》6种<br>　　★世纪有价值图书！<br>　　★为了孩子，你一定要读的书，每一位家长和老师！<br><strong>海报：</strong></p>\n" +
            "<p><strong><img data-lazyload=\"//img30.360buyimg.com/vc/jfs/t2806/35/1628878623/95937/52540eb3/57456a86N64f8df85.jpg\" title=\"窗边的小豆豆合集海报.jpg\" alt=\"\" style=\"\"></strong></p>";
        Selector selector = new XpathSelector("font/text()");
        String res = selector.select(html);

        System.out.println(res);
        Pattern p = Pattern.compile("适读人群 ：(\\d+)-(\\d+)岁");
        Matcher m = p.matcher(res);
        ArrayList<String> strs = new ArrayList<String>();
        while (m.find()) {
            System.out.println("pattern found: "+m.group(1));
            System.out.println("pattern found: "+m.group(2));
        }

    }

    public void testFindRegex(){
        Pattern pattern = Pattern.compile("href=\"(.+)\"");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        if(matcher.find())
            System.out.println(matcher.group(1));
    }

    public void testRegexSplit(){
        String target = "adfsad;dfas;fdsfds水电费；dsf；发生大女;十大sdf;dsf";
        System.out.println(target.substring(target.length()-2));

        for(String res:target.split("[;；]"))
        System.out.println(res);

        System.out.println("aaa".split("b").length);
    }

    public void testConvertAuthorType(){
        Pattern authorTypePattern = Pattern.compile("(.+) ([著作编校评译绘])");
        Matcher authorTypeMatcher = authorTypePattern.matcher("[丹] 安徒生，[法] 夏尔·佩罗，[德] 威廉·豪夫 著");
        if(authorTypeMatcher.find()){
            System.out.println(authorTypeMatcher.group(1));
            System.out.println(authorTypeMatcher.group(2));
            System.out.println(BookAuthorType.transform(authorTypeMatcher.group(2)));
        }
    }

}
