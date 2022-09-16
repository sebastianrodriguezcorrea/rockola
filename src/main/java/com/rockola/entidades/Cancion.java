package com.rockola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "cancion")
public class Cancion {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 100, nullable = false, unique = false)
    private String nombre;

    @Column(name = "aniopublicacion", nullable = false, unique = false)
    private int anioPublicacion;

    @Column(name = "duracion", length = 45, nullable = false, unique = false)
    private String duracion;

    @ManyToOne
    @JoinColumn(name = "genero")
    private GeneroMusical genero;

    @ManyToOne
    @JoinColumn(name = "interprete")
    private Interprete interprete;

    @ManyToOne
    @JoinColumn(name = "compositor")
    private Compositor compositor;

    public Cancion() {
    }

    public Cancion(String nombre, int anioPublicacion, String duracion, GeneroMusical genero, Interprete interprete, Compositor compositor) {
        this.nombre = nombre;
        this.anioPublicacion = anioPublicacion;
        this.duracion = duracion;
        this.genero = genero;
        this.interprete = interprete;
        this.compositor = compositor;
    }

    public Cancion(int id, String nombre, int anioPublicacion, String duracion, GeneroMusical genero, Interprete interprete, Compositor compositor) {
        this.id = id;
        this.nombre = nombre;
        this.anioPublicacion = anioPublicacion;
        this.duracion = duracion;
        this.genero = genero;
        this.interprete = interprete;
        this.compositor = compositor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public Interprete getInterprete() {
        return interprete;
    }

    public Compositor getCompositor() {
        return compositor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

    public void setInterprete(Interprete interprete) {
        this.interprete = interprete;
    }

    public void setCompositor(Compositor compositor) {
        this.compositor = compositor;
    }

}
