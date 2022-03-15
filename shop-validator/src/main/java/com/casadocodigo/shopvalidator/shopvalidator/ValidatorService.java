package com.casadocodigo.shopvalidator.shopvalidator;

import com.casadocodigo.shopvalidator.dto.ShopDTO;
import com.casadocodigo.shopvalidator.dto.ShopItemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidatorService {

    private final ShopProcessor shopProcessor;
    private final ShopItemValidator shopItemValidator;

    public void validateShop(ShopDTO shopDTO){

        try {
            if (validate(shopDTO.getItems())) shopProcessor.processShop(shopDTO);
            else shopProcessor.invalidateShop(shopDTO);
        } catch (Exception exception){
            log.error("Erro no processamento da compra {}. Ex: {}", shopDTO.getIdentifier(), exception.getMessage());
            shopProcessor.invalidateShop(shopDTO);
        }
    }

    private boolean validate(List<ShopItemDTO> shopItems){
        return shopItems.stream().allMatch(shopItemValidator);
    }
}
