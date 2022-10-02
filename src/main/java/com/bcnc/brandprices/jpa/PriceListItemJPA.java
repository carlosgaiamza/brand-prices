package com.bcnc.brandprices.jpa;

import com.bcnc.brandprices.domain.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="price_list_item")
@Getter
@Setter
class PriceListItemJPA implements PriceListItem {

    @Id
    @GeneratedValue
    private PriceListItemId id;

    @Embedded
    @AttributeOverride( name = "id", column = @Column(name = "product_id"))
    private ProductId productId;

    @Embedded
    private Price price;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int priority;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private BrandJPA brand;

    @OneToOne(fetch = FetchType.LAZY)
    private PriceListJPA priceList;
}

