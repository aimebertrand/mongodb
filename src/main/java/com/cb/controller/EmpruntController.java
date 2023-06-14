package com.cb.controller;

import com.cb.model.Emprunt;
import com.cb.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/emprunt")
public class EmpruntController {

    @Autowired
    private EmpruntRepository empruntRepository;

    @PostMapping("/")
    public Emprunt create(@RequestBody Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    @PostMapping(value = "/bulk", consumes = "application/json")
    public Iterable<Emprunt> createBulk(@RequestBody List<Emprunt> empruntList) {
        return empruntRepository.saveAll(empruntList);
    }

    @GetMapping("/{id}")
    public Emprunt read(@PathVariable String id) {
        return empruntRepository.findById(Integer.valueOf(id)).orElseThrow(NoSuchElementException::new);
    }

    @PutMapping("/")
    public Emprunt update(@RequestBody Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        empruntRepository.deleteById(Integer.valueOf(id));
    }
}

