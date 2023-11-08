package com.springboot.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.onetoone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
