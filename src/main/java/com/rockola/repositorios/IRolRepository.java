package com.rockola.repositorios;

import com.rockola.entidades.Rol;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

    public List<Rol> findByNombreContainingOrDescripcionContaining(String criterio, String criterio2);

}
