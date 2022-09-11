package com.example.bookstoreproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Order {
    @Id
    private int orderId;
    private LocalDate localDate;
    private int price;
    private int quantity;
    private  String address;
    private  String user;
    private String book;
    private boolean cancel;
}
