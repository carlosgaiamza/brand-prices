package com.bcnc.brandprices;

import com.bcnc.brandprices.BrandPricesApplication;
import com.bcnc.brandprices.application.data.ProductPriceResponse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = BrandPricesApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BrandPricesApplicationIntegrationTests {

    @LocalServerPort
    private int port;

    @Test
    @Order(1)
    void determinePriceTest1() {
        RestTemplate restTemplate = new RestTemplate();
        var url = getUrl("2020-06-14T10:00:00", 35455L, 1L);
        var result = restTemplate.getForEntity(url, ProductPriceResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo( HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getData()).isNotNull();
        assertThat(result.getBody().getData().getPriceListId()).isEqualTo(1);
        assertThat(result.getBody().getData().getAmount()).isEqualByComparingTo(BigDecimal.valueOf(35.5));
    }

    @Test
    @Order(2)
    void determinePriceTest2() {
        RestTemplate restTemplate = new RestTemplate();
        var url = getUrl("2020-06-14T16:00:00", 35455L, 1L);
        var result = restTemplate.getForEntity(url, ProductPriceResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo( HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getData()).isNotNull();
        assertThat(result.getBody().getData().getPriceListId()).isEqualTo(2);
        assertThat(result.getBody().getData().getAmount()).isEqualByComparingTo(BigDecimal.valueOf(25.45));
    }

    @Test
    @Order(3)
    void determinePriceTest3() {
        RestTemplate restTemplate = new RestTemplate();
        var url = getUrl("2020-06-14T21:00:00", 35455L, 1L);
        var result = restTemplate.getForEntity(url, ProductPriceResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo( HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getData()).isNotNull();
        assertThat(result.getBody().getData().getPriceListId()).isEqualTo(1);
        assertThat(result.getBody().getData().getAmount()).isEqualByComparingTo(BigDecimal.valueOf(35.5));
    }

    @Test
    @Order(4)
    void determinePriceTest4() {
        RestTemplate restTemplate = new RestTemplate();
        var url = getUrl("2020-06-15T10:00:00", 35455L, 1L);
        var result = restTemplate.getForEntity(url, ProductPriceResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo( HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getData()).isNotNull();
        assertThat(result.getBody().getData().getPriceListId()).isEqualTo(3);
        assertThat(result.getBody().getData().getAmount()).isEqualByComparingTo(BigDecimal.valueOf(30.5));
    }

    @Test
    @Order(5)
    void determinePriceTest5() {
        RestTemplate restTemplate = new RestTemplate();
        var url = getUrl("2020-06-15T21:00:00", 35455L, 1L);
        var result = restTemplate.getForEntity(url, ProductPriceResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo( HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getData()).isNotNull();
        assertThat(result.getBody().getData().getPriceListId()).isEqualTo(4);
        assertThat(result.getBody().getData().getAmount()).isEqualByComparingTo(BigDecimal.valueOf(38.95));
    }

    @Test
    @Order(6)
    void determinePriceTestNotFound() {
        RestTemplate restTemplate = new RestTemplate();
        var url = getUrl("2019-06-15T21:00:00", 35455L, 1L);
        var result = restTemplate.getForEntity(url, ProductPriceResponse.class);
        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo( HttpStatus.NO_CONTENT);
        assertThat(result.getBody()).isNull();
    }
    private String getUrl(String date, long productId, long brandId) {
        return "http://localhost:"+port+"/prices/determinePrice?applicationDate="+date+"&productId="+productId+"&brandId="+brandId;
    }
}