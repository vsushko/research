package com.sva.adapter.iternum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: vsa
 * @date: 11.10.16
 */
public class IteratorEnumerationTestDrive {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList(args));
        Enumeration<?> enumeration = new IteratorEnumeration(list.iterator());

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
