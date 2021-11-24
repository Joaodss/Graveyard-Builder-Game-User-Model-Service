package com.ironhack.usermodelservice.service;

import com.ironhack.usermodelservice.dao.User;
import com.ironhack.usermodelservice.dto.RegisterUserDTO;
import com.ironhack.usermodelservice.dto.RegisterValidationDTO;
import com.ironhack.usermodelservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    // -------------------- Register / Login methods --------------------
    UserDTO register(RegisterUserDTO registerUserDTO);

    void addRoleToUser(String username, String roleName);

    RegisterValidationDTO validateRegistration(String username, String email);


    // -------------------- Get methods --------------------
    List<UserDTO> getAllUsers(String username);

    UserDTO getUserByUsername(String username);

    UserDTO getUserById(Long id);

    UserDTO getUserByEmail(String email);

    UserDTO updateUser(User user);

    void changePassword(User user);

    void deleteUser(User user);

}
