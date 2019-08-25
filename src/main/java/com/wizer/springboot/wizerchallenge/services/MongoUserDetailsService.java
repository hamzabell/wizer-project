package com.wizer.springboot.wizerchallenge.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

import com.wizer.springboot.wizerchallenge.models.Users;
import com.wizer.springboot.wizerchallenge.repositories.UsersRepository;

@Component
public class MongoUserDetailsService implements UserDetailsService{
  @Autowired
  private UsersRepository repository;
  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Users user = repository.findByUsername(username);
    System.out.print(user);
    if(user == null) {
      throw new UsernameNotFoundException("User not Found");
    }
    List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("User"));
    return new User(user.getUsername(), user.getPassword(), authorities);
  }
}