package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.UserDTO;

public interface UserRepository {

    public void addUser(UserDTO user);

    public UserDTO getUser(String id);

}
