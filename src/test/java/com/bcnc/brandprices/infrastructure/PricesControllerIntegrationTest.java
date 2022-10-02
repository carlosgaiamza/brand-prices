package com.bcnc.brandprices.infrastructure;

import com.bcnc.brandprices.BrandPricesApplication;
import com.bcnc.brandprices.application.data.PriceListItemDataMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = BrandPricesApplication.class)
public class PricesControllerIntegrationTest {

    @Test
    @Order(1)
    void determinePriceTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        var url = "http://localhost:8081/prices/determinePrice?applicationDate=2020-06-15T00%3A00%3A00&productId=35455&brandId=1";
        var result = restTemplate.getForEntity(url, String.class);

        assertThat(result.getStatusCode().value()).isEqualTo("200");
    }
}