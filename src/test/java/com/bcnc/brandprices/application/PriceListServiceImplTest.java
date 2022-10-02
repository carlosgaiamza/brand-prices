package com.bcnc.brandprices.application;

import com.bcnc.brandprices.application.data.PriceListItemDataMapper;
import com.bcnc.brandprices.application.data.ProductPriceData;
import com.bcnc.brandprices.domain.BrandId;
import com.bcnc.brandprices.domain.PriceListItem;
import com.bcnc.brandprices.domain.ProductId;
import com.bcnc.brandprices.jpa.PriceListJPARepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PriceListServiceImplTest {

    @Mock
    private PriceListJPARepository priceListJPARepository;
    @Mock
    private PriceListItemDataMapper priceListItemDataMapper;

    @InjectMocks
    private PriceListServiceImpl priceListService;

    @Test
    void determinePrice() {
        var applicationDate = LocalDateTime.now();
        var productId = ProductId.of(1L);
        var brandId = BrandId.of(2L);
        var priceListItem1 = mock(PriceListItem.class);
        var priceListItems = List.of(priceListItem1);

        when(priceListJPARepository.findByProductIdAndBrandId(applicationDate, productId, brandId)).thenReturn(priceListItems);

        var data = new ProductPriceData();

        when(priceListItemDataMapper.map(priceListItem1)).thenReturn(data);

        var result = priceListService.determinePrice(applicationDate, productId, brandId);

        assertThat(result.getApplicationDate()).isSameAs(applicationDate);
        assertThat(result.getData()).isSameAs(data);

        verify(priceListJPARepository).findByProductIdAndBrandId(applicationDate, productId, brandId);
        verify(priceListItemDataMapper).map(priceListItem1);

        verifyNoMoreInteractions(priceListJPARepository, priceListItemDataMapper);
    }
}