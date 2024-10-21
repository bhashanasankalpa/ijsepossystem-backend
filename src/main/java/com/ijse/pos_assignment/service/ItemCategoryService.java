package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.ItemCategory;

@Service
public interface ItemCategoryService {
    List<ItemCategory> getAllItemCategories();
    ItemCategory createItemCategory(ItemCategory itemCategory);
    ItemCategory getItemCategoryById(Long id);
    ItemCategory updateItemCategory(Long id,ItemCategory itemCategory);
    void deleteItemCategory(Long id);
}
