package com.example.bookstoreproject.repository;

import com.example.bookstoreproject.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserData,Integer> {
}
