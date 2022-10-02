package com.bcnc.brandprices.application;

import com.bcnc.brandprices.application.data.ProductPriceResponse;
import com.bcnc.brandprices.domain.BrandId;
import com.bcnc.brandprices.domain.ProductId;

import java.time.LocalDateTime;

public interface PriceListService {
    ProductPriceResponse determinePrice(LocalDateTime applicationDate, ProductId productId, BrandId brandId);

}
