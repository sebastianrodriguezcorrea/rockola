package com.rockola.servicios;

import com.rockola.entidades.Cancion;
import com.rockola.repositorios.ICancionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionService {
    
    @Autowired
    private ICancionRepository cancionRepo;
    
    public List<Cancion> cargarCanciones(){
        return cancionRepo.findAll();
    }
    
    public List<Cancion> cargarCancionesPorCriterio(String criterio){
        return cancionRepo.findByNombreContaining(criterio);
    }
    
    public Cancion cargarCancion(int id){
        return cancionRepo.findById(id).orElse(null);
    }
    
    public Cancion guardarCancion(Cancion c){
        return cancionRepo.save(c);
    }
    
    public boolean eliminarCancion(int id){
        Cancion c = cancionRepo.findById(id).orElse(null);
        if(c == null){
            return false;
        }
        else{
            cancionRepo.delete(c);
            return true;
        }
    }
}
