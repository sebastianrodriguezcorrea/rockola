package com.rockola.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class PlayList {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 100, nullable = false, unique = false)
    private String nombre;

    @Column(name = "fechacreacion", length = 45, nullable = false, unique = false)
    private String fechacreacion;

    @Column(name = "numcanciones", columnDefinition = "BIGINT", length = 20, nullable = false, unique = false)
    private String numcanciones;

    @ManyToOne
    @JoinColumn(name = "cuenta")
    private Cuenta cuenta;

    @ManyToMany
    @JoinTable(name = "playlisthascancion", joinColumns = @JoinColumn(name = "playlistid"), inverseJoinColumns = @JoinColumn(name = "cancionid"))
    private List<Cancion> canciones;

    public PlayList() {
    }

    public PlayList(int id, String nombre, String fechacreacion, String numcanciones, Cuenta cuenta, List<Cancion> canciones) {
        this.id = id;
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.numcanciones = numcanciones;
        this.cuenta = cuenta;
        this.canciones = canciones;
    }

    public PlayList(String nombre, String fechacreacion, String numcanciones, Cuenta cuenta, List<Cancion> canciones) {
        this.nombre = nombre;
        this.fechacreacion = fechacreacion;
        this.numcanciones = numcanciones;
        this.cuenta = cuenta;
        this.canciones = canciones;
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

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getNumcanciones() {
        return numcanciones;
    }

    public void setNumcanciones(String numcanciones) {
        this.numcanciones = numcanciones;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

}
