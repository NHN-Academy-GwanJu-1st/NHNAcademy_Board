package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.UserDTO;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class UserRepositoryImplTest extends TestCase {

    UserRepository userRepository = new UserRepositoryImpl();
    UserDTO testUser = new UserDTO("test", "123", "testName", "");
    public void testAddUser() {
    }

    public void testFindUser() {
    }

    @Test
    public void testFindUserByName() {
        String findName = "testName";

        UserDTO findUser = null;

        userRepository.addUser(testUser);

        Map<String, UserDTO> all = userRepository.findAll();

        for (String key : all.keySet()) {
            if (all.get(key).getName().equals(findName)) {
                findUser = all.get(key);
                break;
            }
        }

        Assert.assertNotNull(findUser);

    }

    public void testFindAll() {
    }
}