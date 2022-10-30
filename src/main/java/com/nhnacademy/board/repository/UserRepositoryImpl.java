package com.nhnacademy.board.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhnacademy.board.domain.UserDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserRepositoryImpl implements UserRepository {

    private Map<String, UserDTO> userMap = new HashMap<>();

    private List<UserDTO> list = new ArrayList<>();


    @Override
    public void addUser(File file, UserDTO user) {
        list.add(user);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userMap.put(user.getId(), user);
    }

    @Override
    public UserDTO findUser(String id) {
        return userMap.get(id);
    }

    @Override
    public Map<String, UserDTO> findAll() {
        return userMap;
    }

    @Override
    public boolean deleteUser(File file, String id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean deleteCheck = false;

        if (userMap.containsKey(id)) {
            userMap.remove(id);
            deleteCheck = true;
        }

        return deleteCheck;
    }

    @Override
    public void modifyUser(File file, UserDTO user) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(user.getId())) {
                list.set(i, user);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        userMap.put(user.getId(), user);
    }
}
