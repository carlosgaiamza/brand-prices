package com.bcnc.brandprices.infrastructure;

import com.bcnc.brandprices.application.PriceListService;
import com.bcnc.brandprices.application.data.PriceDataNotFoundException;
import com.bcnc.brandprices.application.data.ProductPriceResponse;
import com.bcnc.brandprices.domain.BrandId;
import com.bcnc.brandprices.domain.ProductId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
class PricesController implements PricesApi {

    private final PriceListService priceListService;

    @Override
    public ProductPriceResponse determinePrice(LocalDateTime applicationDate, long productId, long brandId) {
        log.info("Request for determining price for {} and {} on: {} has been received.", productId, brandId, applicationDate);
        return priceListService.determinePrice(applicationDate, ProductId.of(productId), BrandId.of(brandId));
    }

    @ExceptionHandler(PriceDataNotFoundException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @Nullable ResponseEntity<ProductPriceResponse> handleNotFound(PriceDataNotFoundException ex) {
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

 }
