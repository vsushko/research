package ru.vsprog.javanext;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by: vsa
 * Date: 24.07.14
 */
public class TicketTest {

    @Test
    public void tenPercentDiscount() {

        /*Price price = new StubPrice();
        Ticket ticket = new Ticket(price);
        assertEquals("9.0", ticket.getDiscountPrice().doubleValue(), 0.0001);*/

        Price price = mock(Price.class);
        when(price.getInitialPrice()).thenReturn(new BigDecimal("10"));

        Ticket ticket = new Ticket(price, new BigDecimal("0.9"));
        assertEquals(9.0, ticket.getDiscountPrice().doubleValue(), 0.00001);
        verify(price).getInitialPrice();


    }

}
