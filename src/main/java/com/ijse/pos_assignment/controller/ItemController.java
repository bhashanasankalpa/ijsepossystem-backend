package com.ijse.pos_assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_assignment.dto.ItemRequestDto;
import com.ijse.pos_assignment.entity.Item;
import com.ijse.pos_assignment.entity.ItemCategory;
import com.ijse.pos_assignment.service.ItemCategoryService;
import com.ijse.pos_assignment.service.ItemService;

@CrossOrigin(origins = "*")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;
    
    @GetMapping("/items")
    public ResponseEntity<List<Item>>getAllItems(){

        List<Item> item = itemService.getAllItem();

        return ResponseEntity.status(200).body(item);
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDto itemRequestDto){
        Item item = new Item();

        item.setItemName(itemRequestDto.getItemName());
        item.setItemPrice(itemRequestDto.getItemPrice());
        item.setItemDescription(itemRequestDto.getItemDescription());
        
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemRequestDto.getItemCategoryId());

        item.setItemCategory(itemCategory);

        Item createdItem = itemService.creatItem(item);

        return ResponseEntity.status(201).body(createdItem);
    }

    @GetMapping("/items/{item_id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long item_id){
        Item item = itemService.getItemById(item_id);

        if (item == null) {
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(item);
        }
    }

    @PutMapping("/items/{item_id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long item_id,@RequestBody ItemRequestDto itemRequestDto){
       Item item =new Item();
       item.setItemName(itemRequestDto.getItemName());
       item.setItemPrice(itemRequestDto.getItemPrice());
       item.setItemDescription(itemRequestDto.getItemDescription());

       ItemCategory itemCategory = itemCategoryService.getItemCategoryById(itemRequestDto.getItemCategoryId());
       item.setItemCategory(itemCategory);
       
        Item updatedItem = itemService.updateItem(item_id, item);

        if (updatedItem == null) {
            return ResponseEntity.status(404).body(null);

        }else{
            return ResponseEntity.status(200).body(updatedItem);
        }
    }

    @DeleteMapping("/items/{item_id}")
    public void deleteItem(@PathVariable Long item_id){
        itemService.deleteItem(item_id);
    }
}
