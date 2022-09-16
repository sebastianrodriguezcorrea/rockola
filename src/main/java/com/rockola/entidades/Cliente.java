package com.rockola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numdocumento", length = 11, nullable = false, unique = true)
    private int numdocumento;

    @Column(name = "tipodocumento", length = 45, nullable = false, unique = false)
    private String tipodocumento;

    @Column(name = "nombre", length = 45, nullable = false, unique = false)
    private String nombre;

    @Column(name = "apellido", length = 45, nullable = false, unique = false)
    private String apellido;

    @Column(name = "edad", length = 2, nullable = false, unique = false)
    private int edad;

    @Column(name = "correo", length = 45, nullable = false, unique = false)
    private String correo;

    public Cliente() {
    }

    public Cliente(int id, int numdocumento, String tipodocumento, String nombre, String apellido, int edad, String correo) {
        this.id = id;
        this.numdocumento = numdocumento;
        this.tipodocumento = tipodocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
    }

    public Cliente(int numdocumento, String tipodocumento, String nombre, String apellido, int edad, String correo) {
        this.numdocumento = numdocumento;
        this.tipodocumento = tipodocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
