package com.cb.controller;

import com.cb.model.Utilisateur;
import com.cb.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/")
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @PostMapping(value = "/bulk", consumes = "application/json")
    public Iterable<Utilisateur> createBulk(@RequestBody List<Utilisateur> utilisateurList) {
        return utilisateurRepository.saveAll(utilisateurList);
    }


    @GetMapping("/{id}")
    public Utilisateur read(@PathVariable String id) {
        return utilisateurRepository.findById(Integer.valueOf(id)).orElseThrow(NoSuchElementException::new);
    }

    @PutMapping("/")
    public Utilisateur update(@RequestBody Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        utilisateurRepository.deleteById(Integer.valueOf(id));
    }
}
