package com.bcnc.brandprices.application;

import com.bcnc.brandprices.application.data.ProductPriceData;
import com.bcnc.brandprices.application.data.PriceListItemDataMapper;
import com.bcnc.brandprices.application.data.ProductPriceResponse;
import com.bcnc.brandprices.domain.BrandId;
import com.bcnc.brandprices.domain.PriceListItem;
import com.bcnc.brandprices.domain.ProductId;
import com.bcnc.brandprices.jpa.PriceListJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class PriceListServiceImpl implements PriceListService {

    private final PriceListJPARepository priceListJPARepository;
    private final PriceListItemDataMapper priceListItemDataMapper;
    public ProductPriceResponse determinePrice(LocalDateTime applicationDate, ProductId productId, BrandId brandId) {
        log.info("Determining price for {}) and {})", productId, brandId);
        List<PriceListItem> priceListItems = priceListJPARepository.findByProductIdAndBrandId(applicationDate, productId, brandId);

        if(priceListItems.isEmpty()) {
            throw new RuntimeException("Not Found");
        }

        var priceListItem = Collections.max(priceListItems, Comparator.comparing(PriceListItem::getPriority));
        var data = priceListItemDataMapper.map(priceListItem);
        return ProductPriceResponse
                .builder()
                .data(data)
                .applicationDate(applicationDate)
                .build();
    }
}
