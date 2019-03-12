package com.github.jingshouyan.poetry;

/**
 * @author jingshouyan
 * #date 2019/3/1 14:04
 */

public class TestByte {


    public static void main(String[] args) {
        String a = "00000001";
        String b = "01000001";
        String c = "10000001";
        String d = "11000001";
        String e = "11100001";

        System.out.println(Integer.parseInt(a,2));
        System.out.println(Integer.parseInt(b,2));
        System.out.println(Integer.parseInt(c,2));
        System.out.println(Integer.parseInt(d,2));
        System.out.println(Integer.parseInt(e,2));
    }
}
