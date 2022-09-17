package com.example.jpa.service;

import com.example.jpa.entity.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    public List<User> getListUser();
    public User getUserById(int id);
    public List<User> searchUser(String keyword);
    public User createUser(User req);
    @Transactional
    public void testTransaction();
}
