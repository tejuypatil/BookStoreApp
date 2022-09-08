package com.example.bookstoreproject.entity;
import com.example.bookstoreproject.dto.UserRequestDTO;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "UserData")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private  String address;

    @Column(name = "Login_id", nullable = false)
    private String loginId;

    private String password;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;


    public UserData(UserRequestDTO userRequestDTO) {
        this.firstName=userRequestDTO.getFirstName();
        this.lastName=userRequestDTO.getLastName();
        this.address=userRequestDTO.getAddress();
        this.loginId=userRequestDTO.getLoginId();
        this.isAdmin=userRequestDTO.isAdmin();
    }

    public UserData() {

    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
