package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.Sale;
import com.ijse.pos_assignment.repository.SaleRepository;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> getAllSale() {
        return saleRepository.findAll();
    }

    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);    
    }
    
}
