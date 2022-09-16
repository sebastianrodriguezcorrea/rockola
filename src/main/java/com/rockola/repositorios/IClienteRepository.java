package com.rockola.repositorios;

import com.rockola.entidades.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
    
    public List<Cliente> findByNombreContainingOrApellidoContaining(String criterio, String criterio2);
    public Cliente findByNumdocumento(Integer criterio);
    
}
