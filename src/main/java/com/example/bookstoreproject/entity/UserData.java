package com.example.bookstoreproject.entity;
import com.example.bookstoreproject.dto.UserRequestDTO;
import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name = "UserDetails")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private  String address;

   // @Column(name = "Login_Id", nullable = false)
    //private String loginId;

    private String password;

   // @Column(name = "is_admin", nullable = false)
   // private boolean isAdmin;

    public UserData(int userId, String firstName, String lastName, String email, String address, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public UserData(UserRequestDTO userRequestDTO) {

    }

    public UserData() {

    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
