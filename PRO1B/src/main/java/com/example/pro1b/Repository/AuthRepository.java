package com.example.pro1b.Repository;

import com.example.pro1b.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepository extends JpaRepository<Users,Integer> {
    Users findUsersByUsername(String username);



}
