package com.casadocodigo.shopapi.shopping;

import com.casadocodigo.shopapi.dto.ShopDTO;
import com.casadocodigo.shopapi.persistence.entity.Shop;
import com.casadocodigo.shopapi.persistence.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopProcessor {

    private final ShopRepository shopRepository;

    @Transactional
    public void processShop(ShopDTO shopDTO){
        log.info("Processing shop={}", shopDTO);
        Shop shop = shopRepository.findByIdentifier(shopDTO.getIdentifier())
                .orElseThrow(RuntimeException::new);

        shop.setStatus(ShopStatus.valueOf(shopDTO.getStatus()));
    }
}
