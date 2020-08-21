package com.wmf.homework.util;

import java.util.Arrays;

public class OrderUtil {
    public static String ascendingSort(String text) {
        String[] stringArray = text.split("");

        // 오름차순 정렬 후 대소문자 구분하지 않고 재정렬
        Arrays.sort(stringArray);
        Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);
        return String.join("", stringArray);
    }
}
