package com.sva.iterator.dinermergecafe;

import java.util.Iterator;

/**
 * @author: vsa
 * @date: 17.10.16
 */
public interface Menu {

    Iterator<MenuItem> createIterator();
}
