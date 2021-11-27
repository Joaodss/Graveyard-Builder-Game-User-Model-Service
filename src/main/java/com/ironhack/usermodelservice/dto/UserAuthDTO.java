package com.ironhack.usermodelservice.dto;

import com.ironhack.usermodelservice.dao.Role;
import com.ironhack.usermodelservice.dao.User;
import lombok.*;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserAuthDTO {

    private String username;
    private String password;
    private Set<String> roles;

    public UserAuthDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.toSet());
    }

}
