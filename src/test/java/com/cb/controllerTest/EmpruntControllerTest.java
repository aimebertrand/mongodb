package com.cb.controllerTest;

import com.cb.controller.EmpruntController;
import com.cb.model.Emprunt;
import com.cb.repository.EmpruntRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmpruntControllerTest {

    @Mock
    private EmpruntRepository empruntRepository;

    @InjectMocks
    private EmpruntController empruntController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void cleanup() {
        reset(empruntRepository);
    }

    @Test
    public void testCreateEmprunt() {
        Emprunt emprunt = new Emprunt(/* remplir avec les attributs de Emprunt */);
        when(empruntRepository.save(any(Emprunt.class))).thenReturn(emprunt);

        Emprunt createdEmprunt = empruntController.create(emprunt);

        verify(empruntRepository, times(1)).save(any(Emprunt.class));
        assertEquals(emprunt, createdEmprunt);
    }

    @Test
    public void testReadEmprunt() {
        Emprunt emprunt = new Emprunt(/* remplir avec les attributs de Emprunt */);
        when(empruntRepository.findById(any())).thenReturn(Optional.of(emprunt));

        Emprunt retrievedEmprunt = empruntController.read("1");

        verify(empruntRepository, times(1)).findById(any());
        assertEquals(emprunt, retrievedEmprunt);
    }

    @Test
    public void testReadEmpruntNotFound() {
        when(empruntRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> empruntController.read("1"));

        verify(empruntRepository, times(1)).findById(any());
    }

    @Test
    public void testUpdateEmprunt() {
        Emprunt emprunt = new Emprunt(/* remplir avec les attributs de Emprunt */);
        when(empruntRepository.save(any(Emprunt.class))).thenReturn(emprunt);

        Emprunt updatedEmprunt = empruntController.update(emprunt);

        verify(empruntRepository, times(1)).save(any(Emprunt.class));
        assertEquals(emprunt, updatedEmprunt);
    }

    @Test
    public void testDeleteEmprunt() {
        doNothing().when(empruntRepository).deleteById(any());

        empruntController.delete("1");

        verify(empruntRepository, times(1)).deleteById(any());
    }
}
