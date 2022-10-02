package com.bcnc.brandprices.application.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PriceDataNotFoundException extends RuntimeException {
    public PriceDataNotFoundException() {
        super("There isn't any price list applying to the search criteria.");
    }
}