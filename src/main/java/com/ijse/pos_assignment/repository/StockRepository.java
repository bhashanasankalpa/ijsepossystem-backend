package com.ijse.pos_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.pos_assignment.entity.Stock;



@Repository
public interface StockRepository extends JpaRepository<Stock,Long>{

    Stock findByItemId(Long itemId);
}
