package com.sva.adapter.iternum;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author: vsa
 * @date: 11.10.16
 */
public class EI {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>(Arrays.asList(args));
        Enumeration<String> enumeration = vector.elements();

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
