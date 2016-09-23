package com.zhuoyue.crowler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
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
}
