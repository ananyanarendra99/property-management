package com.mycompany.property_management.converter;

import com.mycompany.property_management.DTO.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public UserEntity convertDTOtoEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(userDTO.getOwnerName());
        userEntity.setOwnerEmail(userDTO.getOwnerEmail());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setPhone(userDTO.getPhone());
        return userEntity;
    }
    public UserDTO convertEntitytoDTO(UserEntity userEntity){
        UserDTO userdto = new UserDTO();
        userdto.setOwnerName(userEntity.getOwnerName());
        userdto.setOwnerEmail(userEntity.getOwnerEmail());
        userdto.setID(userEntity.getId());
        userdto.setPhone(userEntity.getPhone());
        return userdto;
    }

}
