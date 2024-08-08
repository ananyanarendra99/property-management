package com.mycompany.property_management.converter;

import com.mycompany.property_management.DTO.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO){
        PropertyEntity pe = new PropertyEntity();
        pe.setId(propertyDTO.getId());
        pe.setTitle(propertyDTO.getTitle());
        pe.setDescription(propertyDTO.getDescription());
        pe.setAddress(propertyDTO.getAddress());
        pe.setPrice(propertyDTO.getPrice());


        return pe;
    }

    public PropertyDTO convertEntitiytoDTO(PropertyEntity propertyEntity){
        PropertyDTO pe = new PropertyDTO();
        pe.setId(propertyEntity.getId());
        pe.setTitle(propertyEntity.getTitle());
        pe.setDescription(propertyEntity.getDescription());
        pe.setAddress(propertyEntity.getAddress());
        pe.setPrice(propertyEntity.getPrice());

        return pe;
    }
}
