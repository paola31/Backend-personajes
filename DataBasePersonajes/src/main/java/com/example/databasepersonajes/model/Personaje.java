package com.example.databasepersonajes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "personajes")
@Data  // Lombok genera automáticamente getters, setters, toString, equals y hashCode
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String identificacion;
    private String imagen;
    private String rol;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
