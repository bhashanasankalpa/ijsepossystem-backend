package com.ijse.pos_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.pos_assignment.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long>{
    
}
