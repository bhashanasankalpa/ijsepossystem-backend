package com.ijse.pos_assignment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequestDto {
    
    private String itemName;
    private double itemPrice;
    private String itemDescription;
    private Long itemCategoryId;

}
