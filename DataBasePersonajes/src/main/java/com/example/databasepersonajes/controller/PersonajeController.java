package com.example.databasepersonajes.controller;

import com.example.databasepersonajes.model.Personaje;
import com.example.databasepersonajes.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
@CrossOrigin("*") // Permite que React pueda hacer peticiones sin problemas
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    // Obtener todos los personajes
    @GetMapping
    public List<Personaje> getAllPersonajes() {
        return personajeService.getAllPersonajes();
    }

    // Crear un nuevo personaje
    @PostMapping
    public Personaje createPersonaje(@RequestBody Personaje personaje) {
        return personajeService.createPersonaje(personaje);
    }

    // Obtener un personaje por ID
    @GetMapping("/{id}")
    public Personaje getPersonajeById(@PathVariable Long id) {
        return personajeService.getPersonajeById(id);
    }

    // Actualizar un personaje
    @PutMapping("/{id}")
    public Personaje updatePersonaje(@PathVariable Long id, @RequestBody Personaje personaje) {
        return personajeService.updatePersonaje(id, personaje);
    }

    // Eliminar un personaje
    @DeleteMapping("/{id}")
    public void deletePersonaje(@PathVariable Long id) {
        personajeService.deletePersonaje(id);
    }
}
