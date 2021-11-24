package com.ironhack.usermodelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class RegisterValidationDTO {

    private List<String> existingFields = new ArrayList<>();


    // -------------------- Custom Constructor --------------------
    public RegisterValidationDTO(boolean usernameFound, boolean emailFound) {
        if (usernameFound) existingFields.add("username");
        if (emailFound) existingFields.add("email");
        log.info("RegisterValidationDTO created");
        log.info("Existing fields: " + existingFields);
    }

}
