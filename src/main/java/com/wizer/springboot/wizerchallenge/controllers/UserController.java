package com.wizer.springboot.wizerchallenge.controllers;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.wizer.springboot.wizerchallenge.models.Cheque;
import com.wizer.springboot.wizerchallenge.models.RoleType;
import com.wizer.springboot.wizerchallenge.models.Users;
import com.wizer.springboot.wizerchallenge.repositories.ChequeRepository;
import com.wizer.springboot.wizerchallenge.repositories.UsersRepository;


@RestController
@RequestMapping("/user")
public class UserController {
   private final AtomicLong counter = new AtomicLong();

   private final AtomicLong chequeCounter = new AtomicLong();

   

   @Autowired
   private UsersRepository userRepository;

   @Autowired
   private ChequeRepository chequeRepository; 
   
   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;





   
   
   @RequestMapping(value="/register", method= RequestMethod.POST)
   public ResponseEntity<Object> user(@Valid @RequestBody Users payload) {
      Users newUser = new Users(counter.incrementAndGet(), payload.getUsername(), payload.getPassword(), payload.getBranch(), payload.getRole());
      newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
      userRepository.save(newUser); 
      return new ResponseEntity<Object>("User Created Successfully" , HttpStatus.CREATED);
   }

   @RequestMapping(method = RequestMethod.GET)
   public ResponseEntity<Object> getUsers(){
       return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
   }

   @RequestMapping(value= "/{id}", method = RequestMethod.GET)
   public ResponseEntity<Object> getUserById(@PathVariable("id") Long id){      
       return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
   }
   @RequestMapping(value= "/assign-cheque/{id}", method = RequestMethod.POST)
   public ResponseEntity<Object> assignUserCheque(@PathVariable("id") Long id, @RequestBody Cheque cheque){ 
        Optional<Users> optional = userRepository.findById(id);
        String  message;
        Users user = optional.get();
        if ( user.getRole().toString() == "BRANCHMANAGER") {
            Cheque newCheque = new Cheque(cheque.getBankName(), cheque.getStartNumber(), cheque.getEndNumber());
            chequeRepository.save(newCheque);
            user.addCheque(newCheque);
            return new ResponseEntity<>("Cheque assigned to user", HttpStatus.OK);
        }
        
        

        return new ResponseEntity<>("Cheque cannot be assigned to user", HttpStatus.FORBIDDEN);
    }

}
