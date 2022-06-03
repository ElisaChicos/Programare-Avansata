package com.company;

import org.junit.Test;

import java.util.Locale;

public class Tested {
    public int a;
    private int b;

    private String ex1(String s)
    {
        return s.toLowerCase(Locale.ROOT);
    }

    protected Integer ex2(Integer a, Integer b)
    {
        return a+b;
    }

    @Test
    public static void m1() {
    }

    public static void m2() {
    }

    @Test
    public static void m3() {
        throw new RuntimeException("Boom");
    }

    public static void m4() {
    }

    @Test
    public static void m5() {
    }

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

    public static void m8() {
    }

    @Test
    public void m9(int a)
    {
        System.out.println(a);
    }

}
