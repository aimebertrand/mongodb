package com.cb.controllerTest;

import com.cb.controller.UtilisateurController;
import com.cb.model.Utilisateur;
import com.cb.repository.UtilisateurRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UtilisateurControllerTest {

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private UtilisateurController utilisateurController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void cleanup() {
        reset(utilisateurRepository);
    }

    @Test
    public void testCreateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur(/* remplir avec les attributs de Utilisateur */);
        when(utilisateurRepository.save(any(Utilisateur.class))).thenReturn(utilisateur);

        Utilisateur createdUtilisateur = utilisateurController.create(utilisateur);

        verify(utilisateurRepository, times(1)).save(any(Utilisateur.class));
        assertEquals(utilisateur, createdUtilisateur);
    }

    @Test
    public void testReadUtilisateur() {
        Utilisateur utilisateur = new Utilisateur(/* remplir avec les attributs de Utilisateur */);
        when(utilisateurRepository.findById(any())).thenReturn(Optional.of(utilisateur));

        Utilisateur retrievedUtilisateur = utilisateurController.read("1");

        verify(utilisateurRepository, times(1)).findById(any());
        assertEquals(utilisateur, retrievedUtilisateur);
    }

    @Test
    public void testReadUtilisateurNotFound() {
        when(utilisateurRepository.findById(any())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> utilisateurController.read("1"));

        verify(utilisateurRepository, times(1)).findById(any());
    }

    @Test
    public void testUpdateUtilisateur() {
        Utilisateur utilisateur = new Utilisateur(/* remplir avec les attributs de Utilisateur */);
        when(utilisateurRepository.save(any(Utilisateur.class))).thenReturn(utilisateur);

        Utilisateur updatedUtilisateur = utilisateurController.update(utilisateur);

        verify(utilisateurRepository, times(1)).save(any(Utilisateur.class));
        assertEquals(utilisateur, updatedUtilisateur);
    }

    @Test
    public void testDeleteUtilisateur() {
        doNothing().when(utilisateurRepository).deleteById(any());

        utilisateurController.delete("1");

        verify(utilisateurRepository, times(1)).deleteById(any());
    }
}

