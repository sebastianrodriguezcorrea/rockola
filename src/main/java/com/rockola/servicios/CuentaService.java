package com.rockola.servicios;

import com.rockola.entidades.Cuenta;
import com.rockola.repositorios.ICuentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    @Autowired
    private ICuentaRepository repo;

    public Cuenta crearNuevaCuenta(Cuenta c) {
        Cuenta guardado = repo.save(c);
        return guardado;
    }

    public Cuenta actualizarCuenta(Cuenta c) {
        Cuenta guardado = repo.save(c);
        return guardado;
    }

    public List<Cuenta> consultarCuenta() {
        List<Cuenta> lista = repo.findAll();
        return lista;
    }

    public Cuenta consultarCuenta(int id) {
        Cuenta c = repo.findById(id).orElse(null);
        return c;
    }

    public Cuenta consultarCuentaPorCorreo(String correo) {
        Cuenta c = repo.findByCorreo(correo);
        return c;
    }

    public Cuenta consultarCuentaPorPassword(String pass) {
        Cuenta c = repo.findByPassword(pass);
        return c;
    }

    public List<Cuenta> consultarCuentasPorEstado(String criterio) {
        List<Cuenta> lista = repo.findByEstadoContaining(criterio);
        return lista;
    }

    public void eliminarCuenta(Cuenta c) {
        repo.delete(c);
    }

}
