package com.example.jpa.repository;

import com.example.jpa.JpaApplication;
import com.example.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;

public interface UserRespository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
    @Modifying
    @Transactional
    @Query(value = "UPDATE user SET fullname = ?1, email = ?2, phone = ?3 WHERE id = ?4", nativeQuery = true)
    public void updateProfile(String name, String email, String phone, int id);
}
