package com.bcnc.brandprices.domain;

import lombok.NonNull;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public final class ProductId implements Serializable {

    private static final long serialVersionUID = 2739000459808548226L;

    private Long id;

    public ProductId() { }

    @NonNull
    public ProductId(@NonNull Long id) {
        this.id = id;
    }

    public static ProductId of(@NonNull Long productId) {
        return new ProductId(productId);
    }

    public Long value() {
        return id;
    }

    public boolean equals(final Object o) {
        if (!(o instanceof ProductId)) {
            return false;
        }
        return id.equals(((ProductId) o).id);
    }

    public int hashCode() {
        return id.hashCode();
    }

    public String toString() {
        return "ProductId(id=" + this.id + ")";
    }
}
