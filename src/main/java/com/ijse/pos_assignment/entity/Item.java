package com.ijse.pos_assignment.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private double itemPrice;

    @Column(nullable = false)
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "itemCategoryId")
    private ItemCategory itemCategory;

    @JsonIgnore
    @ManyToMany(mappedBy ="saleItems")
    private List<Sale> sales;

}
