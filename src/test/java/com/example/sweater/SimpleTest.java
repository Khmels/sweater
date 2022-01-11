package com.example.sweater;

import org.junit.Assert;
import org.junit.Test;

public class SimpleTest {
    @Test
    public void test() {
        int x=2;
        int y=23;

        Assert.assertEquals(46,x * y);
        Assert.assertEquals(25,x + y);
    }

    // forewarned is forearmed
    @Test(expected = ArithmeticException.class)
    public void testForException() {
        int a = 0;
        int iL = 1 / a;
    }

    // java.lang.AssertionError: Expected exception: java.lang.ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void testForExceptionFailTest() {
        int a = 1;
        int iL = 1 / a;
    }
}
