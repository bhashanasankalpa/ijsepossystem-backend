package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.Sale;

@Service
public interface SaleService {
    List<Sale> getAllSale();
    Sale createSale(Sale sale);
}
