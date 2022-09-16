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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "correo", length = 45, nullable = false, unique = false)
    private String correo;

    @Column(name = "password", length = 100, nullable = false, unique = false)
    private String password;

    @Column(name = "estado", columnDefinition = "TINYINT", nullable = false)
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "cuentahasrol", joinColumns = @JoinColumn(name = "cuentaid"), inverseJoinColumns = @JoinColumn(name = "rolid"))
    private List<Rol> roles;

    public Cuenta() {
    }

    public Cuenta(int id, String correo, String password, Boolean estado, Cliente cliente, List<Rol> roles) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.cliente = cliente;
        this.roles = roles;
    }

    public Cuenta(String correo, String password, Boolean estado, Cliente cliente, List<Rol> roles) {
        this.correo = correo;
        this.password = password;
        this.estado = estado;
        this.cliente = cliente;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

}
