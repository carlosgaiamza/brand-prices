package com.bcnc.brandprices.application.data;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
public class ProductPriceData {

    private long productId;
    private long brandId;
    private String brandName;
    private long priceListId;
    private BigDecimal amount;
    private Currency currency;
}
