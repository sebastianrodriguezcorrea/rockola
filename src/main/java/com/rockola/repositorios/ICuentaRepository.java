package com.rockola.repositorios;

import com.rockola.entidades.Cuenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Integer> {

    public List<Cuenta> findByEstadoContaining(String criterio);
    public Cuenta findByCorreo(String correo);
    public Cuenta findByPassword(String password);

}
