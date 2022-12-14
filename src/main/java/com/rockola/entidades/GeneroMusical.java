package com.rockola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "generomusical")
public class GeneroMusical {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 45, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nombre;

    @Column(name = "carpeta", length = 45, nullable = false, unique = true)
    private String carpeta;

    @Column(name = "estado", columnDefinition = "TINYINT", nullable = false)
    private Boolean estado;

    public GeneroMusical() {
    }

    public GeneroMusical(int id, String nombre, String carpeta, Boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.carpeta = carpeta;
        this.estado = estado;
    }

    public GeneroMusical(String nombre, String carpeta, Boolean estado) {
        this.nombre = nombre;
        this.carpeta = carpeta;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
