package com.rockola;

import com.rockola.entidades.Cancion;
import com.rockola.entidades.Compositor;
import com.rockola.entidades.GeneroMusical;
import com.rockola.entidades.Interprete;
import com.rockola.servicios.CancionService;
import com.rockola.servicios.CompositorService;
import com.rockola.servicios.GeneroService;
import com.rockola.servicios.InterpreteService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class CancionUnitTests {
    
    @Autowired
    private CancionService cancionService;
    
    @Autowired 
    private GeneroService generoService;
    
    @Autowired
    private InterpreteService interpreteService;
    
    @Autowired
    private CompositorService compositorService;
    
    @Test
    @Disabled
    public void verificarSiSeGuardaCancionNueva(){
        GeneroMusical g = generoService.consultarGeneros(4);
        Interprete inter = interpreteService.consultarInterprete(3);
        Compositor comp = compositorService.consultarCompositor(1);
        Cancion c = new Cancion("La muralla verde", 1986, "2:40", g, inter, comp);
        cancionService.guardarCancion(c);
        Assertions.assertDoesNotThrow(() -> {
            cancionService.guardarCancion(c);
        }, "Error al guardar la cancion");
        
    }
    
    @Test
    @Disabled
    void verificarSiSeGuardaUnaCancionNueva() {
        GeneroMusical g = new GeneroMusical("Vallenato", "vallenato", true);
        GeneroMusical guardado1 = generoService.crearNuevoGenero(g);
        Assertions.assertTrue(guardado1.getId() > 0, "No se pudo crear genero");
        Interprete inter = new Interprete("Binomio de oro de America", "1976");
        Interprete guardado2 = interpreteService.crearNuevoInterprete(inter);
        Assertions.assertTrue(guardado2.getId() > 0, "No se pudo crear interprete");
        Compositor comp = new Compositor("Ivan Ovalle", "16-01-1963");
        Compositor guardado3 = compositorService.crearNuevoCompositor(comp);
        Assertions.assertTrue(guardado3.getId() > 0, "No se pudo crear compositor");
        Cancion c = new Cancion("El amor es mas grande que yo", 1989, "4:20", g, inter, comp);
        cancionService.guardarCancion(c);
        Assertions.assertDoesNotThrow(() -> {
            cancionService.guardarCancion(c);
        }, "Error al guardar la cancion");
    }
    
    @Test
    @Disabled
    void verificarSiNoSeGuardaCancionInvalida() {
        Cancion c = new Cancion(null, 4, null, null, null, null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            cancionService.guardarCancion(c);
        }, "No se generó excepción desde la base de datos.");
    }
    
    @Test
    @Disabled
    void verificarSiSeCarganTodasLasCanciones() {
        List<Cancion> lista = cancionService.cargarCanciones();
        Assertions.assertTrue(lista.size() > 0, "No se cargaron las canciones");
    }
    
    @Test
    @Disabled
    void verificarSiSeCargaUnaCancionExistentePorId() {
        Cancion c = cancionService.cargarCancion(1);
        Assertions.assertNotNull(c, "No se cargó la canción");
    }
    
    @Test
    @Disabled
    void verificarSiSeCargaCancionesPorCriterio() {
        List<Cancion> cancionesPorNombre = cancionService.cargarCancionesPorCriterio("amor");
        Assertions.assertTrue(cancionesPorNombre.size() > 0, "Error al cargar canciones por nombre");
    }
    
    @Test
    @Disabled
    void verificarSiNoSeCargaUnaCancionNoExistentePorId() {
        Cancion c = cancionService.cargarCancion(10000000);
        Assertions.assertNull(c, "Se cargó género inexistente");
    }
    
    @Test
    @Disabled
    void verificarSiSeEliminaUnaCancionExistente() {
        cancionService.eliminarCancion(2);
        Cancion eliminado = cancionService.cargarCancion(2);
        Assertions.assertNull(eliminado, "No se eliminó el interprete existente");
    }
}