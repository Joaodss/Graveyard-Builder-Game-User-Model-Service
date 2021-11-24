package com.ironhack.usermodelservice.service;

import com.ironhack.usermodelservice.dao.User;
import com.ironhack.usermodelservice.dto.UserDTO;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface UserService {

    // -------------------- Get methods --------------------
    List<UserDTO> getAllUsers(String username);

    UserDTO getUserByUsername(String username);

    UserDTO getUserById(long id);

    UserDTO getUserByEmail(String email);

    List<Long> getAllUsersIdsByPartyLevelBetween(int min, int max);

    // -------------------- Update methods --------------------
    UserDTO updateUser(UserDTO user);

    void changePassword(String password);

    // -------------------- Delete methods --------------------
    void deleteUser(User user);

}
