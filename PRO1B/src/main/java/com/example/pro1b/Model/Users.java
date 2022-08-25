package com.example.pro1b.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Users implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "username empty")
    @Column(columnDefinition = "varchar(20)unique not null")
    private String fristname;


    @NotEmpty(message = "username empty")
    @Column(columnDefinition = "varchar(20)unique not null")
    private String listname;

    @NotEmpty(message = "username empty")
   @Column(columnDefinition = "varchar(20)unique not null")
    private String username;



//    @NotEmpty(message = "Password mpty ,(9-0)(A-Z)(a-z)")
//    @Pattern(regexp = "(    ([0-9]) ([A-Z]) ([a-z])   )"   )
   private String password;
  //private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.singleton(new SimpleGrantedAuthority("user"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
