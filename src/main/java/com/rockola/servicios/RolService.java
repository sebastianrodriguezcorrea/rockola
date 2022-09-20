package com.rockola.servicios;

import com.rockola.entidades.Rol;
import com.rockola.repositorios.IRolRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

    @Autowired
    private IRolRepository repo;

    public Rol crearNuevoRol(Rol rol) {
        Rol guardado = repo.save(rol);
        return guardado;
    }

    public Rol actualizarRol(Rol rol) {
        Rol guardado = repo.save(rol);
        return guardado;
    }

    public List<Rol> consultarRol() {
        List<Rol> lista = repo.findAll();
        return lista;
    }

    public Rol consultarRol(int id) {
        Rol rol = repo.findById(id).orElse(null);
        return rol;
    }

    public List<Rol> consultarRolPorNombreODescripcion(String criterio) {
        List<Rol> lista = repo.findByNombreContainingOrDescripcionContaining(criterio, criterio);
        return lista;
    }

    public void eliminarRol(Rol rol) {
        repo.delete(rol);
    }

}
