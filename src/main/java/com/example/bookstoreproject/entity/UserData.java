package com.example.bookstoreproject.entity;
import com.example.bookstoreproject.dto.UserRegisterRequestDTO;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "UserData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String email;
    private  String address;

    @Column(unique = true, nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isAdmin;


    public UserData(UserRegisterRequestDTO userRegisterRequestDTO) {
        this.firstName=userRegisterRequestDTO.getFirstName();
        this.lastName=userRegisterRequestDTO.getLastName();
        this.address=userRegisterRequestDTO.getAddress();
        this.email=userRegisterRequestDTO.getEmail();
        this.loginId=userRegisterRequestDTO.getLoginId();
        this.password=userRegisterRequestDTO.getPassword();
        this.isAdmin=userRegisterRequestDTO.isAdmin();
    }

    public UserData() {

    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
