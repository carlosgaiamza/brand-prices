package com.bcnc.brandprices.jpa;

import com.bcnc.brandprices.domain.PriceList;
import com.bcnc.brandprices.domain.PriceListId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="price_list")
@Getter
@Setter
class PriceListJPA implements PriceList {

    @Id
    @GeneratedValue
    private PriceListId id;
}
