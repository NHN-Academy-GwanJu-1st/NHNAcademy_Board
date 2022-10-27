package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.UserDTO;

import java.util.Map;

public interface UserRepository {

    public void addUser(UserDTO user);

    public UserDTO findUser(String id);

    public Map<String, UserDTO> findAll();

}
