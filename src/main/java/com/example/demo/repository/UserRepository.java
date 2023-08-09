package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Users;


public interface UserRepository extends JpaRepository<Users, Integer> {
  boolean existsByEmail(String email);
  Users getByEmail(String email);
  Users getByEmailAndPassword(String email,String password);
}
