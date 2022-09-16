package com.rockola.repositorios;

import com.rockola.entidades.GeneroMusical;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends JpaRepository<GeneroMusical, Integer>{
    public List<GeneroMusical> findByNombreContainingOrCarpetaContaining(String criterio1, String criterio2);
    public List<GeneroMusical> findByEstadoTrue();
}
