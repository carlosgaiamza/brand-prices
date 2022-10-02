package com.bcnc.brandprices.domain;

import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BrandId implements Serializable {

    private static final long serialVersionUID = -4328628963459485599L;

    private Long id;

    public BrandId() {
    }

    public BrandId(@NonNull Long id) {
        this.id = id;
    }

    public static BrandId of(@NonNull Long brandId) {
        return new BrandId(brandId);
    }

    public Long value() {
        return id;
    }

    public boolean equals(final Object o) {
        if (!(o instanceof BrandId)) {
            return false;
        }
        return id.equals(((BrandId) o).id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return "BrandId(id=" + this.id + ")";
    }
}
