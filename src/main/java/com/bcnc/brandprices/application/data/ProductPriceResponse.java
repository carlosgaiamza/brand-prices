package com.bcnc.brandprices.application.data;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPriceResponse {

    private ProductPriceData data;
    private LocalDateTime applicationDate;
}
