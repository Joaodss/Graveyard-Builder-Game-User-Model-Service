package com.ironhack.usermodelservice.dto;

import com.ironhack.usermodelservice.dao.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class UserDTO {

    private String username;
    private String email;
    private Long experience;
    private Long gold;
    private Integer partyLevel;


    // -------------------- Custom Constructor --------------------
    public UserDTO(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.experience = user.getExperience();
        this.gold = user.getGold();
        this.partyLevel = user.getPartyLevel();
        log.info("UserDTO created for returning details");
    }

}
