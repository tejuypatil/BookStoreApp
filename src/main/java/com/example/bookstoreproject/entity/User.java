package com.example.bookstoreproject.entity;
import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private  String address;

    @Column(name = "Login_Id", nullable = false)
    private String loginId;

    private String password;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;


}
