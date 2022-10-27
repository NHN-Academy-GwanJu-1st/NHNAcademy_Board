package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.UserDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private Map<String, UserDTO> userMap = new HashMap<>();

    @Override
    public void addUser(UserDTO user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public UserDTO getUser(String id) {
        return userMap.get(id);
    }
}
