package com.bcnc.brandprices.infrastructure;

import com.bcnc.brandprices.application.data.ProductPriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@RequestMapping("prices")
public interface PricesApi {

    @Operation(summary = "Determine a the price for a given brand and product id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Price found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductPriceResponse.class)) }),
            @ApiResponse(responseCode = "204", description = "The price for the given values cannot be determined",
                    content = @Content)})
    @GetMapping(value = "determinePrice", produces = { "application/json" })
    ProductPriceResponse determinePrice(
            @NotBlank
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime applicationDate,
            @Min(0)
            long productId,
            @Min(0)
            long brandId);
}
