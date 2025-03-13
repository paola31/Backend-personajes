package com.example.databasepersonajes.service;

import com.example.databasepersonajes.model.Personaje;
import com.example.databasepersonajes.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> getAllPersonajes() {
        return personajeRepository.findAll();
    }

    public Personaje createPersonaje(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public Personaje getPersonajeById(Long id) {
        return personajeRepository.findById(id).orElse(null);
    }

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

    public void deletePersonaje(Long id) {
        personajeRepository.deleteById(id);
    }
}
