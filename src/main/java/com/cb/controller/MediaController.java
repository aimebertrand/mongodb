package com.cb.controller;

import com.cb.model.Media;
import com.cb.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @PostMapping("/")
    public Media create(@RequestBody Media media) {
        return mediaRepository.save(media);
    }

    @PostMapping(value = "/bulk", consumes = "application/json")
    public Iterable<Media> createBulk(@RequestBody List<Media> mediaList) {
        return mediaRepository.saveAll(mediaList);
    }

    @GetMapping("/")
    public Iterable<Media> readAll() {
        return mediaRepository.findAll();
    }

        @GetMapping("/{id}")
        public Media read(@PathVariable String id) {
            return mediaRepository.findById(id).orElseThrow(NoSuchElementException::new);
        }

    @PutMapping("/")
    public Media update(@RequestBody Media media) {
        return mediaRepository.save(media);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        mediaRepository.deleteById(id);
    }
}
