package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.Stock;

@Service
public interface StockService {
    public List<Stock>getAllStock();
    public Stock createStock(Stock stock);
    public Stock getStockById(Long id);
    public Stock updateStock(Long id,Stock stock);

    public Stock getStockByIdnew(Long id);
   
}
