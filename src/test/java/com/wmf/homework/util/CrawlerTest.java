package com.wmf.homework.util;

import com.wmf.homework.domain.HtmlType;
import org.junit.Test;

import java.io.IOException;
import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CrawlerTest {

    @Test
    public void crawlingTest() throws IOException {
        String result = Crawler.crawling("http://wemakeprice.co.kr", HtmlType.FULL_HTML);

        assertNotEquals(result, null);
        assertNotEquals(result, "");
    }

    @Test
    public void itShouldThrowIllegalArgumentExceptionWhenInvalidURLFromat() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            Crawler.crawling("invalidURL", HtmlType.FULL_HTML);
        });
    }

    @Test
    public void itShouldThrowUnknownHostExceptionWhenInvalidUrl() throws IOException {
        assertThrows(UnknownHostException.class, () -> {
            Crawler.crawling("https://www.nddddd.com", HtmlType.FULL_HTML);
        });
    }
}