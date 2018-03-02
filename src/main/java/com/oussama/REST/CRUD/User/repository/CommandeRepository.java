package com.oussama.REST.CRUD.User.repository;

import com.oussama.REST.CRUD.User.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
