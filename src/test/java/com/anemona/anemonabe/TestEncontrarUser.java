package com.anemona.anemonabe;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.anemona.anemonabe.model.User;
import com.anemona.anemonabe.repository.UserRepository;
import com.anemona.anemonabe.service.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestEncontrarUser {

    //mockeamos un poquito
    @Mock
    private UserRepository userRepository;

    @InjectMocks UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUser() {
        //datos de prueba
        Long idUser = 1L;
        String username = "sans";
        String nombre = "nombre";
        String apellido = "apellido";
        String password = "contra";
        Boolean estado = true;

        User user = new User(idUser, username, nombre, apellido, password, null, estado);

        //configuramos el mock del repo
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        //a partir de aqui llamamos al metodo a probar y de paso verificamos
        User foundUser = userService.findByUsername(username);

        assertNotNull(foundUser);
        assertEquals(username, foundUser.getUsername());
        assertEquals(nombre ,foundUser.getNombre());
        assertEquals(apellido ,foundUser.getApellido());
        assertEquals(password ,foundUser.getPassword()); 
        assertEquals(estado ,foundUser.getEstado());
    }

}