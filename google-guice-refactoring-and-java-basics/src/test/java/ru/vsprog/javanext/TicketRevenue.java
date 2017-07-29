package ru.vsprog.javanext;

import java.math.BigDecimal;

/**
 * Created by vsa
 * Date: 22.07.14.
 */
public class TicketRevenue {
    private static final int TICKET_PRICE = 30;

    public BigDecimal estimatTotalRevenue(int numberOfTicketsSold) throws IllegalArgumentException {
        if (numberOfTicketsSold < 0 || numberOfTicketsSold > 100) {
            throw new IllegalArgumentException("# Tix sold must == 1..100");
        }

        return new BigDecimal(TICKET_PRICE * numberOfTicketsSold);
    }
}
