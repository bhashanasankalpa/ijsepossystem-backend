package com.ijse.pos_assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.ijse.pos_assignment.entity.Stock;
import com.ijse.pos_assignment.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class StockController {
    
    @Autowired
    private StockService stockService;


    @GetMapping("/stocks")
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> stocks = stockService.getAllStock();

        return ResponseEntity.status(200).body(stocks);
    }

    @PostMapping("/stocks")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {


        Stock createdstock = stockService.createStock(stock);

        return ResponseEntity.status(201).body(createdstock);
    }
    
    @GetMapping("/stocks/{stock_id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long stock_id ){
        Stock stock = stockService.getStockById(stock_id);

        if (stock==null) {
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(stock);
        }
    }

    @PutMapping("/stocks/{stock_id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long stock_id,@RequestBody Stock stock){
        Stock existingStock = stockService.getStockById(stock_id);

        existingStock.setQuantity(stock.getQuantity());
        existingStock.setItemId(stock.getItemId());

        Stock updatedStock = stockService.updateStock(stock_id, existingStock);

        if (updatedStock == null) {
            return ResponseEntity.status(404).body(null);

        }else{
            return ResponseEntity.status(200).body(updatedStock);
        }

    }
    
    
}
