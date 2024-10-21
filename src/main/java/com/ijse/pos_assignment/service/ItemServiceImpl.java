package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.Item;
import com.ijse.pos_assignment.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

    @Override
    public Item creatItem(Item item) {
        return itemRepository.save(item);    
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            return null;
        }else{
            existingItem.setItemName(item.getItemName());
            existingItem.setItemPrice(item.getItemPrice());
            existingItem.setItemDescription(item.getItemDescription());
            existingItem.setItemCategory(item.getItemCategory());

            return itemRepository.save(existingItem);
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);    
    }
    
}
