package com.casadocodigo.shopapi.persistence.repository;

import com.casadocodigo.shopapi.persistence.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
}
