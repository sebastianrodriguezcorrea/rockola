package com.rockola.repositorios;

import com.rockola.entidades.Cancion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICancionRepository extends JpaRepository<Cancion, Integer>{
    public List<Cancion>findByNombreContaining(String criterio);
}
