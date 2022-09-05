package com.erygindmitri.springlibrary.spring_app_library.repositories;

import com.erygindmitri.springlibrary.spring_app_library.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
