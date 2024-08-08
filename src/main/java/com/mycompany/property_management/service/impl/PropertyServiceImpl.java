package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.DTO.PropertyDTO;
import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperties(PropertyDTO propertyDTO) {

        PropertyEntity p1 = propertyConverter.convertDTOtoEntity(propertyDTO);

        p1 =propertyRepository.save(p1);

        propertyDTO = propertyConverter.convertEntitiytoDTO(p1);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyDTOList = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<PropertyDTO>();
        for(PropertyEntity pe: propertyDTOList){
            PropertyDTO dto = propertyConverter.convertEntitiytoDTO(pe);
            propList.add(dto);

        }

        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long id) {
       Optional<PropertyEntity> opt = propertyRepository.findById(id);
       PropertyDTO dto =null;
       if(opt.isPresent()) {
           PropertyEntity pe = opt.get();
           pe.setTitle(propertyDTO.getTitle());
           pe.setDescription(propertyDTO.getDescription());
           pe.setAddress(propertyDTO.getAddress());
           pe.setPrice(propertyDTO.getPrice());

           pe =propertyRepository.save(pe);
           dto = propertyConverter.convertEntitiytoDTO(pe);


       }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyprice(PropertyDTO propertyDTO, Long id) {
        Optional<PropertyEntity> opt = propertyRepository.findById(id);
        PropertyDTO dto =null;
        if(opt.isPresent()) {
            PropertyEntity pe = opt.get();

            pe.setPrice(propertyDTO.getPrice());

            pe =propertyRepository.save(pe);
            dto = propertyConverter.convertEntitiytoDTO(pe);


        }
        return dto;
    }

    @Override
    public void deleteProperty(Long ID) {
        propertyRepository.deleteById(ID);
    }


}
