package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.DTO.UserDTO;
import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> opt = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if(opt.isPresent()){
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ALREADY_EXISTS");
            errorModel.setMessage("The user email with which you are trying to register already exists");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        UserEntity userEntity = userConverter.convertDTOtoEntity(userDTO);
        userEntity =userRepository.save(userEntity);

        userDTO= userConverter.convertEntitytoDTO(userEntity);

        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        UserDTO userDTO = null;
        Optional<UserEntity> optUT = userRepository.findByOwnerEmailAndPassword(email, password);
        if(optUT.isPresent()){
            userDTO = userConverter.convertEntitytoDTO(optUT.get());

        }else{
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }

        return userDTO;
    }
}
