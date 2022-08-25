package com.example.pro1b.Service;


import com.example.pro1b.Model.MobileMaintenance;
import com.example.pro1b.Model.Users;
import com.example.pro1b.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceUsers {

    private final AuthRepository authRepository;
    public void register(Users user) {
        String hashedPassword=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        authRepository.save(user);
    }
}
