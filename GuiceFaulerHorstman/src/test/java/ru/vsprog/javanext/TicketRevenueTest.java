package ru.vsprog.javanext;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by vsa
 * Date: 22.07.14.
 */
public class TicketRevenueTest {
    private TicketRevenue venueRevenue;
    private BigDecimal expectedRevenue;

    @Before
    public void setUp() {
        venueRevenue = new TicketRevenue();
    }

    @Test
    public void oneTicketSoldIsThirtyInRevenue() {
        expectedRevenue = new BigDecimal("30");
        assertEquals(expectedRevenue, venueRevenue.estimatTotalRevenue(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failIfLessThanZeroTicketsAreSold() {
        venueRevenue.estimatTotalRevenue(-1);
    }

    @Test
    public void zeroSalesEqualsZeroRevenue() {
        assertEquals(BigDecimal.ZERO, venueRevenue.estimatTotalRevenue(0));
    }

    @Test
    public void tenTicketsSoldIsThreeHundredInRevenue() {
        expectedRevenue = new BigDecimal("300");
        assertEquals(expectedRevenue, venueRevenue.estimatTotalRevenue(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failIfMoreThanOneHundredTicketsAreSold() {
        venueRevenue.estimatTotalRevenue(101);
    }

}
