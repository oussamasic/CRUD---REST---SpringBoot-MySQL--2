package com.oussama.REST.CRUD.User.model;


import org.hibernate.validator.constraints.Email;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")


public class User implements Serializable {

// user(id, nom, prenom, email, age, creation(createdAt), date modification)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private Collection<Commande> commandes;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;


    @Column(name = "prenom")
    private String prenom;

    @Column(name = "age")
    private Long age;

    @Column( updatable = false, name = "Date_Creation")
    @Temporal(TemporalType.TIMESTAMP)

    private Date creationDate;

    @Column( updatable = true, name = "Date_Modification")
    @Temporal(TemporalType.TIMESTAMP)

    private Date modificationDate;

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Collection<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Collection<Commande> commandes) {
        this.commandes = commandes;
    }
}