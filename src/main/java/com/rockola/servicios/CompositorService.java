package com.rockola.servicios;

import com.rockola.entidades.Compositor;
import com.rockola.repositorios.ICompositorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompositorService {

    @Autowired
    private ICompositorRepository repo;

    public Compositor crearNuevoCompositor(Compositor comp) {
        Compositor guardado = repo.save(comp);
        return guardado;
    }

    public Compositor actualizarCompositor(Compositor comp) {
        Compositor guardado = repo.save(comp);
        return guardado;
    }

    public List<Compositor> consultarCompositor() {
        List<Compositor> lista = repo.findAll();
        return lista;
    }

    public Compositor consultarCompositor(String nombre) {
        Compositor comp = repo.findById(nombre).orElse(null);
        return comp;
    }

    public List<Compositor> consultarCompositorPorNombreOFecha(String criterio) {
        List<Compositor> lista = repo.findByNombreContainingOrFechanacimientoContaining(criterio, criterio);
        return lista;
    }
    
    public void eliminarCompositor(Compositor comp){
        repo.delete(comp);
    }
}
