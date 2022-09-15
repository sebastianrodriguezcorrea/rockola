package com.rockola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="compositor")
public class Compositor {
    
    @Id
    @Column(name="nombre", length=100, nullable=false, unique=true)
    private String nombre;
    
    @Column(name="fechanacimiento", length=45, nullable=false, unique=false)
    private String fechanacimiento;

    public Compositor() {
    }

    public Compositor(String nombre, String fechanacimiento) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
    }

    public Compositor(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
}
