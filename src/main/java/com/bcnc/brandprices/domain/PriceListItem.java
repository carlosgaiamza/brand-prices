package com.bcnc.brandprices.domain;

import java.time.LocalDateTime;

public interface PriceListItem {

    PriceListItemId getId();

    ProductId getProductId();

    int getPriority();

    Brand getBrand();

    PriceList getPriceList();

    Price getPrice();

    LocalDateTime getStartDate();

    LocalDateTime getEndDate();
}
