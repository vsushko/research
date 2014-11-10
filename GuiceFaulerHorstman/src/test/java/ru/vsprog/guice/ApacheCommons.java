package ru.vsprog.guice;

import org.junit.Test;

import java.util.Date;

/**
 * User: vsa
 * Date: 05.03.14
 * Time: 15:21
 */
public class ApacheCommons {

    @Test
    public void test() {
        /*String sample1 = "172.31.96.122/172.31.96.132/";
        String sample2 = "172.31.96.1//172.31.96.132";
        String sample3 = "/172.31.96.122/172.31.96.132";
        String sample4 = "//172.31.96.132";
        String sample5 = "/172.31.96.122/";
        String sample6 = "172.31.96.1//";

        String sample7 = "";
        String sample8 = null;
        String sample9 = "//";

        *//*System.out.println("1: " + !isAnyIpExists(sample1));
        System.out.println("2: " + !isAnyIpExists(sample2));
        System.out.println("3: " + !isAnyIpExists(sample3));
        System.out.println("4: " + !isAnyIpExists(sample4));
        System.out.println("5: " + !isAnyIpExists(sample5));
        System.out.println("6: " + !isAnyIpExists(sample6));*//*

        System.out.println("7: " + !isAnyIpExists(sample7));
        System.out.println("8: " + !isAnyIpExists(sample8));
        System.out.println("9: " + !isAnyIpExists(sample9));
    }

    public boolean isAnyIpExists(String userIps) {
        if (userIps == null)
            return false;
        else if (userIps.isEmpty() || userIps.equals("//"))
            return false;

        *//*String[] mass = userIps.split("/");
        for (String s : mass)
            try {
                return !s.isEmpty();
            } catch (ArrayIndexOutOfBoundsException ignore) {
                System.out.println("YO");
            }
*//*
        return false;*/
    }

    @Test
    public void test2() {
        Date date = new Date();
        System.out.println(date);
    }
}
