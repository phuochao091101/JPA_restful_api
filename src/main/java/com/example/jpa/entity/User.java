package com.example.jpa.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="phone", length = 11)
    private String phone;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullname;

    @Column(name="avatar")
    private String avatar;

    @Column(name="birthday")
    private Date birthday;

    @Column(name = "role", nullable = true, columnDefinition = "varchar(255) default 'USER'")
    private String role;
    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbacks;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
