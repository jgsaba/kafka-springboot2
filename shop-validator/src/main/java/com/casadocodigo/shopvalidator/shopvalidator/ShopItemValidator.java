package com.casadocodigo.shopvalidator.shopvalidator;

import com.casadocodigo.shopvalidator.dto.ShopItemDTO;
import com.casadocodigo.shopvalidator.persistence.entity.Product;
import com.casadocodigo.shopvalidator.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class ShopItemValidator implements Predicate<ShopItemDTO> {

    private final ProductRepository productRepository;
    
    @Override
    public boolean test(ShopItemDTO shopItemDTO) {
        Optional<Product> product = productRepository.findByProductIdentifier(shopItemDTO.getProductIdentifier());
        return product.isPresent() && product.get().getAmount() >= shopItemDTO.getAmount();
    }
}
