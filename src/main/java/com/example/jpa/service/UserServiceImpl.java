package com.example.jpa.service;

import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRespository userRespository;

    @Override
    public List<User> getListUser() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> searchUser(String keyword) {
        return null;
    }

    @Override
    public User createUser(User req) {
        return null;
    }

    @Override
    public void testTransaction() {
        // User hợp lệ
        User user1 = new User();
        user1.setEmail("mongmo@gmail.com");
        user1.setFullname("Nguyễn Thị Mộng Mơ");
        user1.setPassword("123456789");
        user1.setPhone("0916125984");
        user1.setRole("USER");

        // User không hợp lệ
        User user2 = new User();
        user2.setEmail("lunglinh@gmail.com");
        user2.setFullname("Phan Thị Lung Linh");
        user2.setPassword("abc123");
        user2.setPhone("0987654321000000000");
        user2.setRole("USER");

        userRespository.save(user1);
        userRespository.save(user2);
    }


}
