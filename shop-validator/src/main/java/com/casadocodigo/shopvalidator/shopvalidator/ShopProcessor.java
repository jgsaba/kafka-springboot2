package com.casadocodigo.shopvalidator.shopvalidator;

import com.casadocodigo.shopvalidator.dto.ShopDTO;
import com.casadocodigo.shopvalidator.persistence.entity.Product;
import com.casadocodigo.shopvalidator.persistence.repository.ProductRepository;
import com.casadocodigo.shopvalidator.shopvalidator.kafka.ShopEventKafkaDispatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.casadocodigo.shopvalidator.shopvalidator.ShopStatus.ERROR;
import static com.casadocodigo.shopvalidator.shopvalidator.ShopStatus.SUCCESS;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopProcessor {

    private final ProductRepository productRepository;
    private final ShopEventKafkaDispatcher shopEventKafkaDispatcher;

    @Transactional
    public void processShop(ShopDTO shopDTO){
        shopDTO.getItems().forEach(shopItemDTO -> {

            Product product = productRepository.
                    findByProductIdentifier(shopItemDTO.getProductIdentifier())
                    .orElseThrow(RuntimeException::new);

            product.decreaseAmount(shopItemDTO.getAmount());
        });

        shopSuccess(shopDTO);
    }

    public void invalidateShop(ShopDTO shopDTO){
        log.error("Compra {} inválida.", shopDTO.getIdentifier());
        shopDTO.setStatus(ERROR.toString());
        shopEventKafkaDispatcher.sendEvent(shopDTO);
    }

    private void shopSuccess(ShopDTO shopDTO){
        log.info("Compra {} efetuada com sucesso.", shopDTO.getIdentifier());
        shopDTO.setStatus(SUCCESS.toString());
        shopEventKafkaDispatcher.sendEvent(shopDTO);
    }
}
