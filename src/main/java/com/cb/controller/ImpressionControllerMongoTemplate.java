package com.cb.controller;

import com.cb.model.Impression;
import com.cb.model.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mt/impression")
public class ImpressionControllerMongoTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/")
    public Impression create(@RequestBody Impression impression) {
        return mongoTemplate.save(impression);
    }


    @GetMapping("/{clientId}/{campaignId}")
    public Impression read(@PathVariable long clientId, long campaignId) {
        return mongoTemplate.findById(new Key(clientId, campaignId), Impression.class);
    }

    @PutMapping("/")
    public Impression update(@RequestBody Impression impression) {
        return mongoTemplate.save(impression);
    }
}
