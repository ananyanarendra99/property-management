package com.mycompany.property_management.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;

}
