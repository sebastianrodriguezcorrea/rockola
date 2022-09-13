package com.rockola.servicios;

import com.rockola.entidades.Cliente;
import com.rockola.repositorios.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private IClienteRepository repo;
    
    public Cliente crearNuevoCliente(Cliente c){
        Cliente guardado = repo.save(c);
        return guardado;
    }
    
    public void actualizarCliente(){
        
    }
    
    public void consultarCliente(){
        
    }
    
    public void eliminarCliente(){
        
    }
}
