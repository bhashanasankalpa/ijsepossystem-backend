package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.ItemCategory;
import com.ijse.pos_assignment.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllItemCategories() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);    
    }

    @Override
    public ItemCategory getItemCategoryById(Long id) {
        return itemCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public ItemCategory updateItemCategory(Long id, ItemCategory itemCategory) {
        ItemCategory existingItemCategory = itemCategoryRepository.findById(id).orElse(null);

        if (existingItemCategory == null) {
            return null;
        }else{
            existingItemCategory.setItemCategoryName(itemCategory.getItemCategoryName());

            return itemCategoryRepository.save(existingItemCategory);
        }
    }

    @Override
    public void deleteItemCategory(Long id) {
       itemCategoryRepository.deleteById(id);
    }
    
}
