package com.ijse.pos_assignment.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saleId;

    private LocalDateTime saleDateTime;

    private Double totalPrice;

    @PrePersist
    protected void onCreate(){
        if (this.saleDateTime==null) {
            this.saleDateTime = LocalDateTime.now();
        }
    }

    @ManyToMany
    @JoinTable(
        name = "sale_item",
        joinColumns =  @JoinColumn(name = "saleId"),
        inverseJoinColumns = @JoinColumn(name="itemId")
    )
    private List<Item> saleItems;


}
