package ru.vsprog.javanext;

import java.math.BigDecimal;

/**
 * Created by: vsa
 * Date: 24.07.14
 */
public class Ticket {
    public static final int BASIC_TICKET_PRICE = 30;
    private long ticketId;
    private final Price priceSource;
    private BigDecimal faceValue = null;
    private BigDecimal discountRate;

    public Ticket(Price priceSource) {
        this.priceSource = priceSource;
    }

    public Ticket(Price price, BigDecimal bigDecimal) {
        priceSource = price;
        discountRate = bigDecimal;
    }

    public Ticket() {
        priceSource = null;
    }

    private final class FixedPrice implements Price {
        @Override
        public BigDecimal getInitialPrice() {
            return new BigDecimal((BASIC_TICKET_PRICE));
        }
    }

    public Ticket(long id) {
        ticketId = id;
        priceSource = new FixedPrice();
        discountRate = new BigDecimal("1.0");
    }

    public BigDecimal getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(BigDecimal faceValue) {
        this.faceValue = faceValue;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getDiscountPrice() {
        if (faceValue == null) {
            faceValue = priceSource.getInitialPrice();
        }
        return faceValue.multiply(discountRate);
    }
}
