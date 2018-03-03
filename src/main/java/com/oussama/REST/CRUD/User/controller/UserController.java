package com.oussama.REST.CRUD.User.controller;

import com.oussama.REST.CRUD.User.model.User;
import com.oussama.REST.CRUD.User.repository.UserRepository;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
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
    public String createUser(@Valid @RequestBody User user) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        user.setCreationDate(date);
        EmailValidator emailValidator = new EmailValidator();

        if(emailValidator.isValid( user.getEmail(),null)) {

    userRepository.save(user);
     return "User succesfully created with id = " + user.getId(); }


        else {return "add a correct email adress"; }
        // return user;
    }

    // Get a Single user
    @GetMapping("/users/{id}")
    public JSONObject getUserById(@PathVariable(value = "id") Long Id) {
        User user = userRepository.findOne(Id);
        if(user == null) {
            //return ResponseEntity.notFound().build();
            JSONObject json = new JSONObject();

            json.put("response","User not found");
            return json;
        }
        else {
            //return ResponseEntity.ok().body(user);
            JSONObject json = new JSONObject();

            json.put("nom",user.getNom());
            json.put("prenom",user.getPrenom());
            json.put("age",user.getAge());
            json.put("Date de création",user.getCreationDate());
            json.put("email", user.getEmail());
            return json;
        }
    }


       // Delete a user
    @DeleteMapping("/users/{id}")
    public JSONObject deleteUser(@PathVariable(value = "id") Long Id) {
        User u = userRepository.findOne(Id);

        if(u == null) {
            JSONObject json = new JSONObject();

            json.put("response","failed");
            return json;
            //return ResponseEntity.notFound().build();
            //return "user not found";
        }

        userRepository.delete(u);
        JSONObject json = new JSONObject();

        json.put("respnse", "success");
        return json;

        //return ResponseEntity.ok().build();
        //return "the user " + u.getNom() +" " + u.getPrenom()+" has been deleted";
    }

    // Update a user
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable(value = "id") Long Id,
                                           @Valid @RequestBody User userDetails) {
        User u = userRepository.findOne(Id);
        if(u == null) {
            //return ResponseEntity.notFound().build();
            return "User not Found";
        }
          // date de modification
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        userDetails.setModificationDate(date);

        u.setNom(userDetails.getNom());
        u.setPrenom(userDetails.getPrenom());
        u.setAge(userDetails.getAge());
        u.setModificationDate(userDetails.getModificationDate());

        User updatedUser = userRepository.save(u);
        //return ResponseEntity.ok(updatedUser);
        return "User updated";
    }


}
