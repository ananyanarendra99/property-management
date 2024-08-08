package com.mycompany.property_management.controller;

import com.mycompany.property_management.DTO.PropertyDTO;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Value("${pms.dummy:}")
    public String dummy;
    @Value("${spring.h2.console.path}")
    public String path;

    @Autowired
    public PropertyService propertyService;

    @Autowired
    public PropertyRepository propertyRepository;

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){

        propertyDTO = propertyService.saveProperties(propertyDTO);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);

    }

    @GetMapping("/save")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){

        List<PropertyDTO> propertyDTOList = propertyService.getAllProperties();
        return new ResponseEntity<>(propertyDTOList,HttpStatus.OK);

    }

    @PutMapping("/save/{propertyID}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyID){
        propertyDTO = propertyService.updateProperty(propertyDTO,propertyID);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);


    }
    @PatchMapping("/save/update-price/{propertyID}")
    public ResponseEntity<PropertyDTO> updatePropertyprice(@RequestBody PropertyDTO propertyDTO,@PathVariable Long propertyID){
        propertyDTO = propertyService.updatePropertyprice(propertyDTO,propertyID);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);


    }
    @DeleteMapping("/save/{propertyID}")
    public ResponseEntity deleteProperty(@PathVariable Long propertyID){
        propertyService.deleteProperty(propertyID);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);

    }
}
