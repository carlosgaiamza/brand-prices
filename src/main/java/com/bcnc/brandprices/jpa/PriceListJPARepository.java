package com.bcnc.brandprices.jpa;

import com.bcnc.brandprices.domain.BrandId;
import com.bcnc.brandprices.domain.PriceListItem;
import com.bcnc.brandprices.domain.PriceListItemId;
import com.bcnc.brandprices.domain.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface PriceListJPARepository extends JpaRepository<PriceListItemJPA, PriceListItemId> {

    @Query(value = "SELECT pli FROM PriceListItemJPA pli " +
            "WHERE productId = :productId " +
            "AND brand.id = :brandId " +
            "AND :applicationDate BETWEEN startDate AND endDate"
    )
    List<PriceListItem> findByProductIdAndBrandId(LocalDateTime applicationDate, ProductId productId, BrandId brandId);
}
