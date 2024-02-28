package com.example.springBootProject.service;

import com.example.springBootProject.models.User;
import com.example.springBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user=userRepository.findByEmail(username);
      if(user==null){
          throw new UsernameNotFoundException("Invalid Email");
      }
      List<GrantedAuthority> list=new ArrayList<>();
    return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),list);


    }
}
