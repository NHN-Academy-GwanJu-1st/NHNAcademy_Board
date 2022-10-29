package com.nhnacademy.board.domain;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String password;
    private String name;
    
    private String profile;

    public UserDTO(String id, String password, String name, String profile) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.profile = profile;
    }
}
