package com.ironhack.usermodelservice.controller;

import com.ironhack.usermodelservice.dto.NewPasswordDTO;
import com.ironhack.usermodelservice.dto.RegisterUserDTO;
import com.ironhack.usermodelservice.dto.UserDTO;
import com.ironhack.usermodelservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final UserService userService;


    // -------------------- GET REQUESTS --------------------
    @GetMapping("/all")
    @ResponseStatus(OK)
    public List<UserDTO> getAllUsers() {
        log.info("Getting all users");
        return userService.getAllUsers();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(OK)
    public UserDTO getUserById(@PathVariable Long id) {
        log.info("Getting user by id {}", id);
        var user = userService.getUserById(id);
        if (user == null) throw new ResponseStatusException(NOT_FOUND, "User not found");
        return user;
    }

    @GetMapping("/username/{username}")
    @ResponseStatus(OK)
    public UserDTO getUserByUsername(@PathVariable String username) {
        log.info("Getting user by username {}", username);
        var user = userService.getUserByUsername(username);
        if (user == null) throw new ResponseStatusException(NOT_FOUND, "User not found");
        return user;
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(OK)
    public UserDTO getUserByEmail(@PathVariable String email) {
        log.info("Getting user by email {}", email);
        var user = userService.getUserByEmail(email);
        if (user == null) throw new ResponseStatusException(NOT_FOUND, "User not found");
        return user;
    }

    @GetMapping("/partyLevel")
    @ResponseStatus(OK)
    public List<Long> getAllUsersIdsByPartyLevelBetween(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max
    ) {
        int minValue = min == null ? 0 : min;
        int maxValue = max == null ? Integer.MAX_VALUE : max;
        log.info("Getting all users by party level between {} and {}", minValue, maxValue);
        if (minValue > maxValue)
            throw new ResponseStatusException(BAD_REQUEST, "Min party level must be less than max party level");
        if (maxValue < 0 || minValue < 0)
            throw new ResponseStatusException(BAD_REQUEST, "Party level must be positive");
        return userService.getAllUsersIdsByPartyLevelBetween(minValue, maxValue);
    }

    // -------------------- POST REQUESTS --------------------
    @PostMapping("/register")
    @ResponseStatus(CREATED)
    public UserDTO registerUser(@RequestBody @Valid RegisterUserDTO registerUserDTO) {
        log.info("Registering user {}", registerUserDTO.getUsername());
        try {
            return userService.registerUser(registerUserDTO);
        } catch (IllegalArgumentException e1) {
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e1.getMessage());
        }
    }

    // -------------------- PUT REQUESTS --------------------
    @PutMapping("/update/{username}")
    @ResponseStatus(OK)
    public UserDTO updateUser(@PathVariable String username, @RequestBody UserDTO user) {
        log.info("Updating user {}", username);
        try {
            return userService.updateUser(username, user);
        } catch (IllegalArgumentException e1) {
            if (e1.getMessage().equals("User not found"))
                throw new ResponseStatusException(BAD_REQUEST, "User not found");
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e1.getMessage());
        }
    }

    @PutMapping("/update/{username}/password")
    @ResponseStatus(OK)
    public void changePassword(@PathVariable String username, @RequestBody @Valid NewPasswordDTO passwordDTO) {
        log.info("Changing password for user {}", username);
        try {
            userService.changePassword(username, passwordDTO.getNewPassword());
        } catch (IllegalArgumentException e1) {
            if (e1.getMessage().equals("User not found"))
                throw new ResponseStatusException(BAD_REQUEST, "User not found");
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e1.getMessage());
        }
    }

    // -------------------- DELETE REQUESTS --------------------
    @DeleteMapping("/delete/{username}")
    @ResponseStatus(OK)
    public void deleteUser(@PathVariable String username) {
        log.info("Deleting user {}", username);
        try {
            userService.deleteUser(username);
        } catch (IllegalArgumentException e1) {
            if (e1.getMessage().equals("User not found"))
                throw new ResponseStatusException(BAD_REQUEST, "User not found");
            throw new ResponseStatusException(INTERNAL_SERVER_ERROR, e1.getMessage());
        }
    }

}
