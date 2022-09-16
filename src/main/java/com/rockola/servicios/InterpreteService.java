package com.rockola.servicios;

import com.rockola.entidades.Interprete;
import com.rockola.repositorios.IInterpreteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterpreteService {
    
    @Autowired
    private IInterpreteRepository repo;
    
    public Interprete crearNuevoInterprete(Interprete inter) {
        Interprete guardado = repo.save(inter);
        return guardado;
    }
    
    public Interprete actualizarInterprete(Interprete inter) {
        Interprete guardado = repo.save(inter);
        return guardado;
    }
    
    public List<Interprete> consultarInterprete() {
        List<Interprete> lista = repo.findAll();
        return lista;
    }
    
    public Interprete consultarInterprete(int id) {
        Interprete inter = repo.findById(id).orElse(null);
        return inter;
    }
    
    public List<Interprete> consultarInterpretePorNombreOFecha(String criterio) {
        List<Interprete> lista = repo.findByNombreContainingOrFechanacimientoContaining(criterio, criterio);
        return lista;
    }
    
    public void eliminarInterprete(Interprete inter) {
        repo.delete(inter);
    }
    
}
