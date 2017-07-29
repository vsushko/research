package ru.vsprog.javanext;

import java.math.BigDecimal;

/**
 * Created by: vsa
 * Date: 24.07.14
 */
public class HttpPrice implements Price {

    @Override
    public BigDecimal getInitialPrice() {
        return HttpPricingService.getInitialPrice();
    }

}
