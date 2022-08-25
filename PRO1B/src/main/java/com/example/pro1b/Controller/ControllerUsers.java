package com.example.pro1b.Controller;


import com.example.pro1b.Model.Users;
import com.example.pro1b.Service.ServiceUsers;
import com.example.pro1b.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Users")


public class ControllerUsers {
   private final ServiceUsers serviceUsers;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid Users users){
        serviceUsers.register(users);
        return ResponseEntity.status(201).body(new ApiResponse("Register is dome ",201));
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body(new ApiResponse("Welcome",200));
    }

}

