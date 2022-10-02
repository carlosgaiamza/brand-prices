package com.bcnc.brandprices.application.data;

import com.bcnc.brandprices.domain.PriceListItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PriceListItemDataMapper {

    @Mapping(expression = "java(priceListItem.getProductId().value())", target = "productId")
    @Mapping(expression = "java(priceListItem.getBrand().getId().value())", target = "brandId")
    @Mapping(expression = "java(priceListItem.getBrand().getName())", target = "brandName")
    @Mapping(expression = "java(priceListItem.getPriceList().getId().value())", target = "priceListId")
    @Mapping(expression = "java(priceListItem.getPrice().getAmount())", target = "amount")
    @Mapping(expression = "java(priceListItem.getPrice().getCurrency())", target = "currency")
    ProductPriceData map(PriceListItem priceListItem);
}
