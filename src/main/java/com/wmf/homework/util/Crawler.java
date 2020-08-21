package com.wmf.homework.util;

import com.wmf.homework.domain.HtmlType;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawler {
    public static String crawling(String url, HtmlType htmlType) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .method(Connection.Method.GET)
                .execute();

        Document document = response.parse();

        if (htmlType.isFullHtml()) {
            return document.html();
        }
        return document.text();
    }
}
