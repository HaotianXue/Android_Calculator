package com.example.haotian.skycalculator;

import com.example.haotian.skycalculator.Parser.Expression;
import com.example.haotian.skycalculator.Parser.MySimpleTokenizer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 * Author:Haotian Xue & SiYu Zheng
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_calculaotr() throws Exception{
        String teststr1 = "1+2";
        String teststr2 = "1+2*3";
        String teststr3 = "2 + 3*4/5*(10*4)";
        String teststr4 = "10-(-4/(1+1))*2+0.1";
        String teststr5 = "15+(-5*3)";
        MySimpleTokenizer test1 = new MySimpleTokenizer(teststr1);
        MySimpleTokenizer test2 = new MySimpleTokenizer(teststr2);
        MySimpleTokenizer test3 = new MySimpleTokenizer(teststr3);
        MySimpleTokenizer test4 = new MySimpleTokenizer(teststr4);
        MySimpleTokenizer test5 = new MySimpleTokenizer(teststr5);
        Expression t1 = Expression.parse(test1);
        Expression t2 = Expression.parse(test2);
        Expression t3 = Expression.parse(test3);
        Expression t4 = Expression.parse(test4);
        Expression t5 = Expression.parse(test5);
        assertTrue(t1.evaluate()==3);
        assertTrue(t2.evaluate()==7);
        assertTrue(t3.evaluate()==98);
        assertTrue(t4.evaluate()==14.1f);
        assertTrue(t5.evaluate()==0);
    }
}