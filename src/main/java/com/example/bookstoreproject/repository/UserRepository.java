package com.example.bookstoreproject.repository;

import com.example.bookstoreproject.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <UserData,Integer> {
    Optional<UserData> findByLoginId(String loginId);
}
