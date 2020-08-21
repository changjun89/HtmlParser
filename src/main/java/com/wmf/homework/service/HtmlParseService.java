package com.wmf.homework.service;

import com.wmf.homework.domain.HtmlType;
import com.wmf.homework.domain.ParsingResult;
import com.wmf.homework.util.Crawler;
import com.wmf.homework.util.OrderUtil;
import com.wmf.homework.util.TextParser;
import org.springframework.stereotype.Service;

@Service
public class HtmlParseService {
    public ParsingResult parse(String url, HtmlType type, Integer unitCount) throws Exception {
        String crawlingResult = Crawler.crawling(url, type);

        String sortedNumbers = OrderUtil.ascendingSort(TextParser.extractNumber(crawlingResult));
        String sortedAlphabet = OrderUtil.ascendingSort(TextParser.extractAlphabet(crawlingResult));

        return new ParsingResult(sortedAlphabet, sortedNumbers).divideCharacter(unitCount);
    }
}
