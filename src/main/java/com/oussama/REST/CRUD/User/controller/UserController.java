package com.oussama.REST.CRUD.User.controller;

import com.oussama.REST.CRUD.User.model.User;
import com.oussama.REST.CRUD.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// class pour la liste des API REST


@RestController
// l'ensemble des API va commencer par api dans l'URL
@RequestMapping("/api")
public class UserController {


    @Autowired
    UserRepository userRepository;

    // Get All Users
    @GetMapping("/users")
    public List<User> getAllNotes() {
        return userRepository.findAll();
    }

    // Create a new user
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
        // return user;
    }

    // Get a Single user
    @GetMapping("/userss/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long Id) {
        User user = userRepository.findOne(Id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }


    // Delete a user
    @DeleteMapping("/userss/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long Id) {
        User u = userRepository.findOne(Id);
        if(u == null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete(u);
        return ResponseEntity.ok().build();
    }

    // Update a user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateNote(@PathVariable(value = "id") Long Id,
                                           @Valid @RequestBody User userDetails) {
        User u = userRepository.findOne(Id);
        if(u == null) {
            return ResponseEntity.notFound().build();
        }
        u.setNom(userDetails.getNom());
        u.setPrenom(userDetails.getPrenom());

        User updatedUser = userRepository.save(u);
        return ResponseEntity.ok(updatedUser);
    }


}
