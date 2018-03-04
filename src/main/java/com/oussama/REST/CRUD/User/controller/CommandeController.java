package com.oussama.REST.CRUD.User.controller;


import com.oussama.REST.CRUD.User.model.Commande;
import com.oussama.REST.CRUD.User.model.User;
import com.oussama.REST.CRUD.User.repository.CommandeRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
// l'ensemble des API va commencer par api dans l'URL
@RequestMapping("/api")
public class CommandeController {

    @Autowired
    CommandeRepository commandeRepository;

    // Get All Commandes
    @GetMapping("/commandes")
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    // Create a new commande
    @PostMapping("/commandes")
    public String createCommande(@Valid @RequestBody Commande commande) {

      commandeRepository.save(commande);
      return "Commande created";

    }

    // Get a Single Commande
    @GetMapping("/commandes/{id}")
    public JSONObject getCommandeById(@PathVariable(value = "id") Long Id) {
      Commande commande = commandeRepository.findOne(Id);
      if (commande == null) {

          JSONObject json = new JSONObject();
          json.put("resultat","Failed");
          return json;
      }
      else {

          JSONObject json = new JSONObject();
          json.put("name", commande.getName());
          json.put("prix", commande.getPrix());
          return json;
      }

    }

    // Delete a commande
    @DeleteMapping("/commandess/{id}")
    public JSONObject deleteCommande(@PathVariable(value = "id") Long Id) {
        Commande commande = commandeRepository.findOne(Id);
        if (commande == null) {

            JSONObject j = new JSONObject();
            j.put("resultat", "failed");
            return j;
        } else {

            commandeRepository.delete(Id);
            JSONObject j = new JSONObject();
            j.put("resultat", "Commande deleted");
            return j;
        }
    }
// Update a commande
        @PutMapping("/commandes/{id}")
        public JSONObject updateCommande(@PathVariable(value = "id") Long Id,
                @Valid @RequestBody Commande commandeDetails) {
            Commande c = commandeRepository.findOne(Id);
            if (c==null) {
                JSONObject j = new JSONObject();
                j.put("resultat","Failed");
                return j;

            }
            else {
                c.setName(commandeDetails.getName());
                c.setPrix(commandeDetails.getPrix());
                commandeRepository.save(c);

                JSONObject j = new JSONObject();
                j.put("resultat","Success");
                return j;
            }
        }

    }



