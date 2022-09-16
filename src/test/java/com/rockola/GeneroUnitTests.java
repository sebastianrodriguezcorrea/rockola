package com.rockola;

import com.rockola.entidades.GeneroMusical;
import com.rockola.servicios.GeneroService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class GeneroUnitTests {
    
    @Autowired
    private GeneroService servicio;
    
    @Test
    @Disabled
    void verificarSiSeGuardaUnGeneroNuevo() {
        GeneroMusical g = new GeneroMusical("Rock en español", "rock", true);
        Assertions.assertDoesNotThrow(() -> {
            servicio.crearNuevoGenero(g);
        }, "No se pudo crear un nuevo género musical");
    }
    
    @Test
    @Disabled
    void verificarSiNoSeGuardaUnGeneroRepetido() {
        GeneroMusical g = new GeneroMusical("Rock en español", "rock", true);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevoGenero(g);
        }, "No se generó excepción desde la base de datos.");
    }
    
    @Test
    @Disabled
    void verificarSiNoSeGuardaGeneroInvalido() {
        GeneroMusical g = new GeneroMusical(null, null, false);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevoGenero(g);
        }, "No se generó excepción desde la base de datos.");
    }
    
    @Test
    @Disabled
    void verificarSiSeCarganTodosLosGeneros() {
        List<GeneroMusical> lista = servicio.consultarGeneros();
        Assertions.assertTrue(lista.size() > 0, "No se cargaron los géneros musicales");
    }
    
    @Test
    @Disabled
    void verificarSiSeCargaUnGeneroExistentePorId() {
        GeneroMusical g = servicio.consultarGeneros(1);
        Assertions.assertNotNull(g, "No se cargó género existente");
    }
    
    @Test
    @Disabled
    void verificarSiSeCargaUnGeneroExistentePorCriterio() {
        List<GeneroMusical> lista = servicio.consultarGeneros("rock");
        Assertions.assertTrue(lista.size() > 0, "No se cargaron géneros existentes");
    }
    
    @Test
    @Disabled
    void verificarSiNoSeCargaUnGeneroNoExistentePorId() {
        GeneroMusical g = servicio.consultarGeneros(10000000);
        Assertions.assertNull(g, "Se cargó género inexistente");
    }
    
    @Test
    @Disabled
    void verificarSiSeEliminaUnGenero() {
        GeneroMusical g = new GeneroMusical("AAAAA", "AAAAA", true);
        GeneroMusical guardado = servicio.crearNuevoGenero(g);
        Assertions.assertTrue(guardado.getId() > 0, "No se pudo crear genero para borrar");
        servicio.eliminarGenero(guardado);
        GeneroMusical eliminado = servicio.consultarGeneros(guardado.getId());
        Assertions.assertNull(eliminado, "No se eliminó el genero creado");
    }
    
    @Test
    @Disabled
    void verificarSiSeEliminaUnRegistroDeUnGeneroExistente() {
        GeneroMusical g = servicio.consultarGeneros(2);
        servicio.eliminarGenero(g);
        GeneroMusical eliminado = servicio.consultarGeneros(2);
        Assertions.assertNull(eliminado, "No se eliminó el genero existente");
    }

}
