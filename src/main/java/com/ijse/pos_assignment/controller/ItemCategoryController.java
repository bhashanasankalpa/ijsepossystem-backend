package com.ijse.pos_assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos_assignment.entity.ItemCategory;
import com.ijse.pos_assignment.service.ItemCategoryService;

@RestController
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<ItemCategory>> getAllItemCategories(){
        List<ItemCategory> itemCategories =itemCategoryService.getAllItemCategories();

        return ResponseEntity.status(200).body(itemCategories);
    }

    @PostMapping("/categories")
    public ResponseEntity<ItemCategory> createItemCategory(@RequestBody ItemCategory itemCategory){
        ItemCategory createdItemCategory = itemCategoryService.createItemCategory(itemCategory);

        return ResponseEntity.status(201).body(createdItemCategory);
    }

    @GetMapping("/categories/{category_id}")
    public ResponseEntity<ItemCategory> getItemCategoryById(@PathVariable Long category_id){
        ItemCategory itemCategory = itemCategoryService.getItemCategoryById(category_id);

        if (itemCategory == null) {
                return ResponseEntity.status(404).body(null);
        }else{
                return ResponseEntity.status(200).body(itemCategory);
        }
    }

    @PutMapping("/categories/{category_id}")
    public ResponseEntity<ItemCategory> updateItemCategory(@PathVariable Long category_id,@RequestBody ItemCategory itemCategory){
        ItemCategory updatedItemCategory = itemCategoryService.updateItemCategory(category_id, itemCategory);

        if (updatedItemCategory == null) {
            return ResponseEntity.status(404).body(null);
        }else{
            return ResponseEntity.status(200).body(updatedItemCategory);
        }
    }

    @DeleteMapping("/categories/{category_id}")
    public void deleteItemCategory(@PathVariable Long category_id){
        itemCategoryService.deleteItemCategory(category_id);
    }
    
}
