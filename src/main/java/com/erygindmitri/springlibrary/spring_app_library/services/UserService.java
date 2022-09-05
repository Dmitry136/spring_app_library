package com.erygindmitri.springlibrary.spring_app_library.services;

import com.erygindmitri.springlibrary.spring_app_library.models.User;
import com.erygindmitri.springlibrary.spring_app_library.models.enums.Role;
import com.erygindmitri.springlibrary.spring_app_library.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(User user){
        String email = user.getEmail();
        if(userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_ADMIN);
        userRepository.save(user);
        return true;
    }

    public User getUserByPrincipal(Principal principal){
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
}
