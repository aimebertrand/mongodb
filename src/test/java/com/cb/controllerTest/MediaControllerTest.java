package com.cb.controllerTest;

import com.cb.controller.MediaController;
import com.cb.model.Media;
import com.cb.repository.MediaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


public class MediaControllerTest {



        @Mock
        private MediaRepository mediaRepository;

        @InjectMocks
        private MediaController mediaController;

        @BeforeEach
        public void setup() {
            MockitoAnnotations.openMocks(this);
        }

        @AfterEach
        public void cleanup() {
            reset(mediaRepository);
        }

        @Test
        public void testCreateMedia() {
            Media media = new Media("1", "book", "The Lord of the Rings", "J.R.R. Tolkien", true);
            when(mediaRepository.save(any(Media.class))).thenReturn(media);

            Media createdMedia = mediaController.create(media);

            verify(mediaRepository, times(1)).save(any(Media.class));
            assertEquals(media, createdMedia);
        }

        @Test
        public void testCreateBulkMedia() {
            Media media1 = new Media("1", "book", "The Lord of the Rings", "J.R.R. Tolkien", true);
            Media media2 = new Media("2", "movie", "The Matrix", "Wachowskis", true);
            List<Media> mediaList = Arrays.asList(media1, media2);

            when(mediaRepository.saveAll(any(Iterable.class))).thenReturn(mediaList);

            Iterable<Media> createdMediaList = mediaController.createBulk(mediaList);

            verify(mediaRepository, times(1)).saveAll(any(Iterable.class));
            assertIterableEquals(mediaList, createdMediaList);
        }

        @Test
        public void testReadMedia() {
            Media media = new Media("1", "book", "The Lord of the Rings", "J.R.R. Tolkien", true);
            when(mediaRepository.findById(any())).thenReturn(Optional.of(media));

            Media retrievedMedia = mediaController.read("1");

            verify(mediaRepository, times(1)).findById(any());
            assertEquals(media, retrievedMedia);
        }

        @Test
        public void testReadMediaNotFound() {
            when(mediaRepository.findById(any())).thenReturn(Optional.empty());

            assertThrows(NoSuchElementException.class, () -> mediaController.read("1"));

            verify(mediaRepository, times(1)).findById(any());
        }

        @Test
        public void testUpdateMedia() {
            Media media = new Media("1", "book", "The Lord of the Rings", "J.R.R. Tolkien", true);
            when(mediaRepository.save(any(Media.class))).thenReturn(media);

            Media updatedMedia = mediaController.update(media);

            verify(mediaRepository, times(1)).save(any(Media.class));
            assertEquals(media, updatedMedia);
        }

        @Test
        public void testDeleteMedia() {
            doNothing().when(mediaRepository).deleteById(any());

            mediaController.delete("1");

            verify(mediaRepository, times(1)).deleteById(any());
        }


}
