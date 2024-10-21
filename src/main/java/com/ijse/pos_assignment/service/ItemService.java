package com.ijse.pos_assignment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos_assignment.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItem();
    Item creatItem(Item item);
    Item getItemById(Long id);
    Item updateItem(Long id,Item item);
    void deleteItem(Long id);
}
