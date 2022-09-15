package com.rockola.repositorios;

import com.rockola.entidades.Compositor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompositorRepository extends JpaRepository<Compositor, String>{
    
    public List<Compositor> findByNombreContainingOrFechanacimientoContaining(String criterio, String criterio2);
    
}
