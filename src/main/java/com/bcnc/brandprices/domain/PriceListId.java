package com.bcnc.brandprices.domain;

import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public final class PriceListId implements Serializable {

    private static final long serialVersionUID = 8715746956644607285L;

    private Long id;

    public PriceListId() {}

    public PriceListId(@NonNull Long id) {
        this.id = id;
    }

    public static PriceListId of(@NonNull Long priceListId) {
        return new PriceListId(priceListId);
    }

    public Long value() {
        return id;
    }

    public boolean equals(final Object o) {
        if (!(o instanceof PriceListId)) {
            return false;
        }
        return id.equals(((PriceListId) o).id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return "PriceListId(id=" + this.id + ")";
    }
}
