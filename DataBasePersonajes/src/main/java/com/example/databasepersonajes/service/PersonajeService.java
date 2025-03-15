package com.example.databasepersonajes.service;

import com.example.databasepersonajes.model.Personaje;
import com.example.databasepersonajes.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    @Cacheable(value="personajes")
    public List<Personaje> getAllPersonajes() {
        return personajeRepository.findAll();
    }

    @CacheEvict(value="personajes", allEntries = true)
    public Personaje createPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    @Cacheable(value="personaje", key="#id")
    public Personaje getPersonajeById(Long id) {
        return personajeRepository.findById(id).orElse(null);
    }

    @CachePut(value="personaje", key="#id")
    public Personaje updatePersonaje(Long id, Personaje personaje) {
        Optional<Personaje> existingPersonaje = personajeRepository.findById(id);
        if (existingPersonaje.isPresent()) {
            Personaje updatedPersonaje = existingPersonaje.get();
            updatedPersonaje.setNombre(personaje.getNombre());
            updatedPersonaje.setIdentificacion(personaje.getIdentificacion());
            updatedPersonaje.setImagen(personaje.getImagen());
            updatedPersonaje.setRol(personaje.getRol());
            updatedPersonaje.setDescripcion(personaje.getDescripcion());
            return personajeRepository.save(updatedPersonaje);
        } else {
            return null;
        }
    }

    @CacheEvict(value = {"personaje", "personajes"}, key = "#id", allEntries = true)
    public void deletePersonaje(Long id) {
        System.out.println("Eliminando personaje con ID: " + id + " y limpiando caché...");
        personajeRepository.deleteById(id);
    }
}


