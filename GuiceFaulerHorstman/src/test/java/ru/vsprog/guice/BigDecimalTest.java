package ru.vsprog.guice;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by vsa
 * Date: 23.07.14.
 */
public class BigDecimalTest {
    private BigDecimal x;

    @Before
    public void setUp() {
        x = new BigDecimal(1.5);
    }

    @After
    public void tearDown() {
        x = null;
    }

    @Test
    public void addingTwoBigDecimals() {
        assertEquals(new BigDecimal("3.0"), x.add(x));
    }

    @Test(expected = NumberFormatException.class)
    public void numberFormatExceptionIfNotANumber() {
        x = new BigDecimal("Not a number");
    }

}
