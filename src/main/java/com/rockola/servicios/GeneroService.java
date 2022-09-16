package com.rockola.servicios;

import com.rockola.entidades.GeneroMusical;
import com.rockola.repositorios.IGeneroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    
    @Autowired
    private IGeneroRepository repo;
    
    public GeneroMusical crearNuevoGenero(GeneroMusical g) {
        GeneroMusical guardado = repo.save(g);
        return guardado;
    }
    
    public GeneroMusical actualizarGenero(GeneroMusical g) {
        GeneroMusical guardado = repo.save(g);
        return guardado;
    }
    
    public List<GeneroMusical> consultarGeneros() {
        List<GeneroMusical> lista = repo.findAll();
        return lista;
    }
    
    public List<GeneroMusical> consultarGenerosPorEstado() {
        List<GeneroMusical> lista = repo.findByEstadoTrue();
        return lista;
    }
    
    public GeneroMusical consultarGeneros(int id) {
        GeneroMusical g = repo.findById(id).orElse(null);
        return g;
    }
    
    public List<GeneroMusical> consultarGeneros(String criterio) {
        List<GeneroMusical> lista = repo.findByNombreContainingOrCarpetaContaining(criterio, criterio);
        return lista;
    }
    
    public void eliminarGenero(GeneroMusical g) {
        repo.delete(g);
    }
}
