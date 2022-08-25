package com.example.pro1b.Service;

import com.example.pro1b.Model.Users;
import com.example.pro1b.Repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUsersDetailsService implements UserDetailsService {

    private final AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=authRepository.findUsersByUsername(username);
        if(users==null){

            throw new UsernameNotFoundException("Invalid username or password");
        }
        return users;
    }
}
