package com.anemona.anemonabe.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_product;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    //formateo para consumir mediante la api en formato json
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDateTime fecha_adicion;

    @Column(columnDefinition = "CLOB", nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private Long precio;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<TipoProd> tipo;

    @Column(nullable = false)
    private Long stock;

    @Column(name = "img_ruta")
    private String img_ruta;
     //init fecha
    @PrePersist
    protected void onCreate() {
        this.fecha_adicion = LocalDateTime.now();
    }

}
