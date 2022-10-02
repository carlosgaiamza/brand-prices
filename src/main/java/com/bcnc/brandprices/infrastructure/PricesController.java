package com.bcnc.brandprices.infrastructure;

import com.bcnc.brandprices.application.PriceListService;
import com.bcnc.brandprices.application.data.ProductPriceData;
import com.bcnc.brandprices.application.data.ProductPriceResponse;
import com.bcnc.brandprices.domain.BrandId;
import com.bcnc.brandprices.domain.ProductId;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class PricesController implements PricesApi {

    private final PriceListService priceListService;

    @Override
    public ProductPriceResponse determinePrice(LocalDateTime applicationDate, long productId, long brandId) {
        //TODO add validations
        return priceListService.determinePrice(applicationDate, ProductId.of(productId), BrandId.of(brandId));
    }
}
