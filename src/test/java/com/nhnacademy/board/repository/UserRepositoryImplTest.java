//package com.nhnacademy.board.repository;
//
//import com.nhnacademy.board.domain.UserDTO;
//import junit.framework.TestCase;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.Map;
//
//public class UserRepositoryImplTest extends TestCase {
//
//    UserRepository userRepository = new UserRepositoryImpl();
//    UserDTO testUser = new UserDTO("test", "123", "testName", "");
//    public void testAddUser() {
//    }
//
//    public void testFindUser() {
//
//        String test = "name=test";
//        System.out.println(test.split("=")[1]);
//    }
//
//    public void testFindAll() {
//    }
//
//    @Test
//    public void testDeleteUser() {
//
//        String findId = "test";
//
//        userRepository.addUser(testUser);
//        Map<String, UserDTO> all = userRepository.findAll();
//
//        boolean deleteCheck = false;
//
//        if (all.containsKey(findId)) {
//            all.remove(findId);
//            deleteCheck = true;
//        }
//
//
//        Assert.assertTrue(deleteCheck);
//    }
//
//    @Test
//    public void testModifyUser() {
//
//        userRepository.addUser(testUser);
//
//        boolean modifyCheck = false;
//
//        String id = "test";
//        UserDTO test = new UserDTO("test", "asdf", "asdf", "asdf");
//
//        Map<String, UserDTO> all = userRepository.findAll();
//
//        for (String key : all.keySet()) {
//            if (key.equals(id)) {
//                all.put(key, test);
//                modifyCheck = true;
//                break;
//            }
//        }
//        Assert.assertTrue(modifyCheck);
//    }
//}