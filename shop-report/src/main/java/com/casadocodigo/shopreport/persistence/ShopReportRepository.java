package com.casadocodigo.shopreport.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopReportRepository extends JpaRepository<ShopReport, Long> {

    Optional<ShopReport> findByStatus(String status);

    @Modifying
    @Query(value = "update ShopReport set quantity = (quantity + 1) where status = :status")
    void incrementShopStatus(String status);
}
