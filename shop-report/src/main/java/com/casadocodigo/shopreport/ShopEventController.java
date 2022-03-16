package com.casadocodigo.shopreport;

import com.casadocodigo.shopreport.persistence.ShopReport;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop_report")
@RequiredArgsConstructor
public class ShopEventController {

    private final ShopEventService shopEventService;

    @GetMapping
    public List<ShopReport> getShopReport() {
        return shopEventService.findAll();
    }
}

