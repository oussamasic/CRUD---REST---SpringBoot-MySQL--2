package com.oussama.REST.CRUD.User.model;

import org.hibernate.validator.constraints.NotBlank;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "modificationDate"},
        allowGetters = true)

public class User implements Serializable {

// user(id, nom, prenom, creation(createdAt), date de modification updatedAt)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom")
    private String nom;


    @Column(name = "prenom")
    private String prenom;

    @Column( updatable = false, name = "Date_Creation")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationDate;

    @Column( name ="Date_Modification")
    @Temporal(TemporalType.TIMESTAMP)
    // le champ sera utilisé par le JPA
    @LastModifiedDate
    private Date modificationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

}