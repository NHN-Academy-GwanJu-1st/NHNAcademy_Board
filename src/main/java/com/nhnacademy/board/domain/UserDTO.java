package com.nhnacademy.board.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO {
    private final String id;
    private final String password;
    private final String name;
    private final String profile;

//    public UserDTO(String id, String password, String name, String profile) {
//        this.id = id;
//        this.password = password;
//        this.name = name;
//        this.profile = profile;
//    }
}
