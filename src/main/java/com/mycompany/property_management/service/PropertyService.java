package com.mycompany.property_management.service;

import com.mycompany.property_management.DTO.PropertyDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperties(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id);
    PropertyDTO updatePropertyprice( PropertyDTO propertyDTO,  Long propertyID);
    void deleteProperty(Long ID);

}
