package com.ironhack.usermodelservice.controller;

import com.ironhack.usermodelservice.dto.NewPasswordDTO;
import com.ironhack.usermodelservice.dto.RegisterUserDTO;
import com.ironhack.usermodelservice.dto.UserDTO;

import java.util.List;

public interface UserController {

    // -------------------- GET REQUESTS --------------------
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO getUserByUsername(String username);

    UserDTO getUserByEmail(String email);

    List<Long> getAllUsersIdsByPartyLevelBetween(Integer min, Integer max);


    // -------------------- POST REQUESTS --------------------
    UserDTO registerUser(RegisterUserDTO registerUserDTO);


    // -------------------- PUT REQUESTS --------------------
    UserDTO updateUser(String username, UserDTO user);

    void changePassword(String username, NewPasswordDTO password);


    // -------------------- DELETE REQUESTS --------------------
    void deleteUser(String username);

}
