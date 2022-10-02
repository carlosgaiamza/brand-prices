package com.bcnc.brandprices.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@Embeddable
public class Price  {
    private BigDecimal amount;
    private Currency currency;

    public Price() { }

    public Price(@NonNull BigDecimal amount, @NonNull Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
}
