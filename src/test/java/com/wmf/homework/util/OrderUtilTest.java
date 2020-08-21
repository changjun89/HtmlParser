package com.wmf.homework.util;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderUtilTest {

    @Test
    public void alphabetAscendingSort() {
        String testParam = "aBcaDaA";
        String expected = "AaaaBcD";

        String result = OrderUtil.ascendingSort(testParam);

        assertEquals(expected,result);
    }

    @Test
    public void numberAscendingSort() {
        String testParam = "15342";
        String expected = "12345";

        String result = OrderUtil.ascendingSort(testParam);
        assertEquals(expected,result);
    }

}