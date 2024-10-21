package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.Stock;
import com.ijse.pos_assignment.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll() ;   
    }

    @Override
    public Stock createStock(Stock stock) {
       return stockRepository.save(stock);
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);   
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        Stock existingStock = stockRepository.findById(id).orElse(null);
        
        if (existingStock == null) {
            return null;
        }else{
            existingStock.setQuantity(stock.getQuantity());
            existingStock.setItemId(stock.getItemId());

            return stockRepository.save(existingStock);
        }
    }
    
}
