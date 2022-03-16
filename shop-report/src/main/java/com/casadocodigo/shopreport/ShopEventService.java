package com.casadocodigo.shopreport;

import com.casadocodigo.shopreport.persistence.ShopReport;
import com.casadocodigo.shopreport.persistence.ShopReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopEventService {

    private final ShopReportRepository repository;

    public List<ShopReport> findAll(){
        return repository.findAll();
    }

    public Integer getReportFor(String status){
        return findReport(status).getQuantity();
    }

    public void increaseReport(String status){
        repository.incrementShopStatus(status);
    }

    private ShopReport findReport(String status){
        return repository.findByStatus(status)
                .orElseThrow(RuntimeException::new);
    }
}
