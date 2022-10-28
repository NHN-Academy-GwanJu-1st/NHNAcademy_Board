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
    public UserDTO findUser(String id) {
        return userMap.get(id);
    }

    @Override
    public UserDTO findUserByName(String name) {

        UserDTO findUser = null;

        for (String key : userMap.keySet()) {
            if (userMap.get(key).getName().equals(name)) {
                findUser = userMap.get(key);
                break;
            }
        }

        return findUser;
    }

    @Override
    public Map<String, UserDTO> findAll() {
        return userMap;
    }

    @Override
    public boolean deleteUser(String id) {

        boolean deleteCheck = false;

        if (userMap.containsKey(id)) {
            userMap.remove(id);
            deleteCheck = true;
        }

        return deleteCheck;
    }

    @Override
    public void modifyUser(UserDTO user) {
        userMap.put(user.getId(), user);
    }
}
