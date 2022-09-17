package com.example.jpa.controller;

import com.example.jpa.entity.User;
import com.example.jpa.exception.DuplicateRecordException;
import com.example.jpa.exception.NotFoundException;
import com.example.jpa.model.dto.UserDto;
import com.example.jpa.model.mapper.UserMapper;
import com.example.jpa.model.request.CreateUserReq;
import com.example.jpa.model.request.UpdateUserReq;
import com.example.jpa.repository.UserRespository;
import com.example.jpa.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserService userService;
    @Autowired
    private UserRespository userRespository;
    @PostMapping("")
    public ResponseEntity<?> createListUser(@Valid @RequestBody CreateUserReq req){
        User re=userRespository.findByEmail(req.getEmail().trim().toString());
        if(re!=null){
            throw new DuplicateRecordException("Email exits");
        }
        User user=new User();
        user.setEmail(req.getEmail());
        user.setFullname(req.getFullName());
        user.setPhone(req.getPhone());
        user.setPassword(BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12)));
        userRespository.save(user);
        return ResponseEntity.ok(UserMapper.toUserDto(user));
    }
    @GetMapping("")
    public ResponseEntity<?> getListUser(){
        List<User> users=userRespository.findAll();
        List<UserDto> result= new ArrayList<UserDto>();
        for (User user:users) {
            result.add(UserMapper.toUserDto(user));
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(required = false,defaultValue = "") String keyword){
       List<User> users=new ArrayList<User>();
       return null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id){
        Optional<User> user=userRespository.findById(id);
        if(user.isEmpty()){
            throw new NotFoundException("On user found");
        }
        return ResponseEntity.ok(UserMapper.toUserDto(user.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UpdateUserReq req, @PathVariable int id){
        userRespository.updateProfile(req.getFullName(),req.getEmail(),req.getPhone(),id);
        return ResponseEntity.ok(userRespository.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteListUser(@PathVariable int id){
        userRespository.deleteById(id);
        return ResponseEntity.ok("Success");
    }
    @GetMapping("/test-transaction")
    public ResponseEntity<?> testTransaction() {
        userService.testTransaction();

        return ResponseEntity.status(HttpStatus.OK).body("Thành công");
    }
}

