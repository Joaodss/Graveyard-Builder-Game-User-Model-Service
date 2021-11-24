package com.ironhack.usermodelservice.service;

import com.ironhack.usermodelservice.dto.RegisterUserDTO;
import com.ironhack.usermodelservice.dto.RegisterValidationDTO;
import com.ironhack.usermodelservice.dto.UserDTO;

public interface SignInService {

    // -------------------- Register methods --------------------
    UserDTO register(RegisterUserDTO registerUserDTO);

    void addRoleToUser(String username, String roleName);

    RegisterValidationDTO validateRegistration(String username, String email);

}
