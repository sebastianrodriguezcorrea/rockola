package com.rockola.repositorios;

import com.rockola.entidades.Interprete;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInterpreteRepository extends JpaRepository<Interprete, Integer> {

    public List<Interprete> findByNombreContainingOrFechanacimientoContaining(String criterio, String criterio2);

}
