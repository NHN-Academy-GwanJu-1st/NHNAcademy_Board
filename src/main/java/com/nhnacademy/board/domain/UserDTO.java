package com.nhnacademy.board.domain;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String password;
    private String name;
    private String profile;

    public UserDTO(String id, String password) {
        this.id = id;
        this.password = password;

        if (id.equals("admin")) {
            this.name = "관리자";
        } else {
            this.name = id + "Name";

        }
        this.profile = "";
    }
}
