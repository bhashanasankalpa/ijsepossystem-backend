package com.ijse.pos_assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_assignment.dto.SaleDto;
import com.ijse.pos_assignment.entity.Item;
import com.ijse.pos_assignment.entity.Sale;
import com.ijse.pos_assignment.entity.Stock;
import com.ijse.pos_assignment.service.ItemService;
import com.ijse.pos_assignment.service.SaleService;
import com.ijse.pos_assignment.service.StockService;

@CrossOrigin(origins = "*")
@RestController
public class SaleController {

    @Autowired
    private SaleService saleService; 

    @Autowired 
    private ItemService itemService;

    @Autowired
    private StockService stockService;
    
    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getAllSales(){
        List<Sale> sales = saleService.getAllSale();

        return ResponseEntity.status(200).body(sales);
    }

    @PostMapping("/sales")
    public ResponseEntity<Sale> createSale(@RequestBody SaleDto saleDto){
        Sale sale =new Sale();

        sale.setTotalPrice(0.0);

        List<Long> itemIds = saleDto.getItemIds();
        List<Item> soldItem =new ArrayList<>();
        itemIds.forEach(item ->{
            Item myitem = itemService.getItemById(item);
            Stock stock = stockService.getStockByIdnew(item);
            if (myitem!=null) {
                soldItem.add(myitem);
                sale.setTotalPrice(sale.getTotalPrice()+myitem.getItemPrice());
                stock.setQuantity(stock.getQuantity()-1);
                stockService.updateStock(item, stock);
            }
        });
        sale.setSaleItems(soldItem);
        saleService.createSale(sale);
        return ResponseEntity.status(201).body(sale);


    }
}
