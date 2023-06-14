package com.cb.controller;

import com.cb.model.Impression;
import com.cb.model.Key;
import com.cb.repository.ImpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("impression")
public class ImpressionController {
    @Autowired
    private ImpressionRepository impressionRepository;

    @PostMapping("/")
    public Impression create(@RequestBody Impression impression) {
        return impressionRepository.save(impression);
    }


    @GetMapping("/{clientId}/{campaignId}")
    public Impression read(@PathVariable long clientId, long campaignId) {
        return impressionRepository.findById(new Key(clientId, campaignId)).orElseThrow(
                () -> new NoSuchElementException());
    }

    @PutMapping("/")
    public Impression update(@RequestBody Impression impression) {
        return impressionRepository.save(impression);
    }

    @DeleteMapping("/{clientId}/{campaignId}")
    public void delete(@PathVariable long clientId, @PathVariable long campaignId) {
        impressionRepository.delete(new Impression(new Key(clientId, campaignId)));
    }

    @GetMapping("/site/{siteId}")
    public Impression delete(@PathVariable long siteId) {
        return impressionRepository.getImpressionBySiteId(siteId).orElseThrow(() -> new NoSuchElementException());
    }
}
