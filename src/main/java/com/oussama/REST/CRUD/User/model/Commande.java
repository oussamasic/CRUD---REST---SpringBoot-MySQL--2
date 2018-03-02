package com.oussama.REST.CRUD.User.model;

import javax.persistence.*;

@Entity
@Table(name = "commandes")
public class Commande {

    //table commande(id_commande,name, prix)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "prix")
    private String prix;
}
