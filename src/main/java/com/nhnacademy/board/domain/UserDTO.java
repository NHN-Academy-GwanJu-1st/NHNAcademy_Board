package com.nhnacademy.board.domain;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String password;
    private String name;
    
    /* TODO## 이미지 업로드 받고, 그걸 어느 디렉토리에 저장 후 그 경로를 저장하고 img태그로 불러오기 */
    private String profile;

    public UserDTO(String id, String password, String name, String profile) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.profile = profile;
    }
}
