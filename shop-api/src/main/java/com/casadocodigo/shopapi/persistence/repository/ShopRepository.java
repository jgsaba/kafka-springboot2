package com.casadocodigo.shopapi.persistence.repository;

import com.casadocodigo.shopapi.persistence.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findByIdentifier(String shopIdentifier);
}
