package com.bcnc.brandprices.domain;

import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public final class PriceListItemId implements Serializable {

    private static final long serialVersionUID = 8715746956644607285L;

    private Long id;

    public PriceListItemId(){ }
    public PriceListItemId(@NonNull Long id) {
        this.id = id;
    }

    public static PriceListItemId of(@NonNull Long priceListItemId) {
        return new PriceListItemId(priceListItemId);
    }

    public Long value() {
        return id;
    }

    public boolean equals(final Object o) {
        if (!(o instanceof PriceListItemId)) {
            return false;
        }
        return id.equals(((PriceListItemId) o).id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return "PriceListItemId(id=" + this.id + ")";
    }
}
