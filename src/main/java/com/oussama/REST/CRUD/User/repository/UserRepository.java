package com.oussama.REST.CRUD.User.repository;

import com.oussama.REST.CRUD.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     User findByEmail(String email);

    // les méthodes save(), findOne(), findAll(), count(), delete() sont generées automatiquement par le JPA

}