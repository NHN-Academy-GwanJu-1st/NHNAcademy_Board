package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.UserDTO;

import java.io.File;
import java.util.Map;

public interface UserRepository {

    public void addUser(File file, UserDTO user);

    public UserDTO findUser(String id);

    public Map<String, UserDTO> findAll();

    public boolean deleteUser(File file,String name);

    public void modifyUser(File file, UserDTO user);

}
