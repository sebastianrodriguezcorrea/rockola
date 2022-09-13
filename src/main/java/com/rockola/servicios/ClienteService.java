package com.rockola.servicios;

import com.rockola.entidades.Cliente;
import com.rockola.repositorios.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private IClienteRepository repo;

    public Cliente crearNuevoCliente(Cliente c) {
        Cliente guardado = repo.save(c);
        return guardado;
    }

    public Cliente actualizarCliente(Cliente c) {
        Cliente guardado = repo.save(c);
        return guardado;
    }

    public List<Cliente> consultarCliente() {
        List<Cliente> lista = repo.findAll();
        return lista;
    }

    public Cliente consultarCliente(int documento) {
        Cliente c = repo.findById(documento).get();
        return c;
    }

    public List<Cliente> consultarCliente(String criterio) {
        List<Cliente> lista = repo.findByNombreContainingOrApellidoContaining(criterio, criterio);
        return lista;
    }

    public void eliminarCliente(Cliente c) {
        repo.delete(c);
    }
}
