package com.sva.composite.menuiterator;

import java.util.Iterator;

/**
 * @author: vsa
 * @date: 18.10.16
 */
public class NullIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
