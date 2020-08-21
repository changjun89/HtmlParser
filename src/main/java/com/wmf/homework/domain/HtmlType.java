package com.wmf.homework.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum HtmlType {
    FULL_HTML,
    NO_TAG_HTML;

    @JsonCreator
    public static HtmlType create(String requestValue) {
        return Stream.of(values())
                .filter(v -> v.toString().equalsIgnoreCase(requestValue))
                .findFirst()
                .orElse(null);
    }

    public boolean isFullHtml() {
        return this == FULL_HTML;
    }
}
