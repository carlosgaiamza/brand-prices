package com.bcnc.brandprices.jpa;

import com.bcnc.brandprices.domain.Brand;
import com.bcnc.brandprices.domain.BrandId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="brand")
class BrandJPA implements Brand {

    @Id
    @GeneratedValue
    private BrandId id;

    private String name;
}
