package com.dreamshopbackend.demo.repository;

import com.dreamshopbackend.demo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
