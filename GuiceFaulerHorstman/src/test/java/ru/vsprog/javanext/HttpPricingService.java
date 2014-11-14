package ru.vsprog.javanext;

import java.math.BigDecimal;

/**
 * Created by: vsa
 * Date: 24.07.14
 */
public class HttpPricingService {
    private static BigDecimal initialPrice;

    public static BigDecimal getInitialPrice() {
        return initialPrice;
    }
}
