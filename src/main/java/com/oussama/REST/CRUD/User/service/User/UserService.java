package com.oussama.REST.CRUD.User.service.User;

import com.oussama.REST.CRUD.User.model.User;

import java.util.List;

public interface UserService {

    List <User> AllUsers();
    void addUser(User user);
    void updateUserById(Long id, User user);
    void deleteUserById(Long id);
    User GetUserById(long id);
    User GetUserByEmail(String email);

}
