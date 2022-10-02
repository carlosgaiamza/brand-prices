package com.bcnc.brandprices.infrastructure;

import com.bcnc.brandprices.application.data.ProductPriceData;
import com.bcnc.brandprices.application.data.ProductPriceResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@RequestMapping("prices")
public interface PricesApi {

    @GetMapping(value = "determinePrice", produces = { "application/json" })
    ProductPriceResponse determinePrice(
            @RequestParam("applicationDate")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime applicationDate, long productId, long brandId);
}
