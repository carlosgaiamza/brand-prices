package com.bcnc.brandprices.application.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductPriceResponse {

    private ProductPriceData data;
    private LocalDateTime applicationDate;
}
