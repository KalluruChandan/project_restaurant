package com.project.resto.app.repository;

import com.project.resto.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRegistrationRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}