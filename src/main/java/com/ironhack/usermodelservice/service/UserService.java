package com.ironhack.usermodelservice.service;

import com.ironhack.usermodelservice.dao.User;
import com.ironhack.usermodelservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    // -------------------- Get methods --------------------
    List<UserDTO> getAllUsers(String username);

    UserDTO getUserByUsername(String username);

    UserDTO getUserById(Long id);

    UserDTO getUserByEmail(String email);

    // -------------------- Update methods --------------------
    UserDTO updateUser(User user);

    void changePassword(User user);

    // -------------------- Delete methods --------------------
    void deleteUser(User user);

}
