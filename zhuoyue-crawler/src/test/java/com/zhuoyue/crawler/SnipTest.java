package com.zhuoyue.crawler;

import com.zhuoyue.crawler.domain.author.BookAuthorType;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Unit test for simple App.
 */
public class SnipTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SnipTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SnipTest.class );
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

    public void testStringBytes() throws UnsupportedEncodingException {
    	String lockKey = "author_果麦_null_AUTHOR";
        byte[] bytes = lockKey.getBytes();

        for(byte b:bytes){
            System.out.println(b);
        }
        String str1 = new String(bytes, "ISO-8859-1");
        System.out.println("length of string:"+lockKey.length());
        System.out.println("length of bytes:"+bytes.length);
        System.out.println("length of str1:"+str1.length());
    }



}
