package com.rockola;

import com.rockola.entidades.Compositor;
import com.rockola.servicios.CompositorService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

@SpringBootTest
public class CompositorUnitTests {

    @Autowired
    private CompositorService servicio;

    @Test
    @Disabled("Se guardó el registro de un nuevo compositor")
    void verificarSiSeGuardaUnCompsitor() {
        Compositor comp = new Compositor("Juanito", "22-03-1987");
        Assertions.assertDoesNotThrow(() -> {
            servicio.crearNuevoCompositor(comp);
        }, "No se pudo guardar un nuevo compositor");
    }

    @Test
    @Disabled("Se ha actualizado el registro")
    void verificarSiSeActualizaUnCompositorNuevo() {
        Compositor comp = new Compositor("Pepito", "21-02-1988");
        Compositor guardado = servicio.crearNuevoCompositor(comp);

        guardado.setFechanacimiento("22-03-1234");
        Compositor actualizado = servicio.actualizarCompositor(guardado);

        Assertions.assertTrue(actualizado.getFechanacimiento().equals("22-03-1234"), "Error. No se pudo actualizar el compositor");
    }

    @Test
    @Disabled("No se guardó el registro invalido")
    void verificarSiNoSeGuardaUnCompositorInvalido() {
        Compositor comp = new Compositor(null, null);
        Assertions.assertThrows(JpaSystemException.class, () -> {
            servicio.crearNuevoCompositor(comp);
        }, "No se generó excepción desde la base de datos");
    }

    @Test
    @Disabled("Se cargaron los registros de los compositores")
    void verificarSiSeCarganTodosLosCompositores() {
        List<Compositor> lista = servicio.consultarCompositor();
        Assertions.assertTrue(lista.size() > 0, "No se cargaron los compositores");
    }

    @Test
    @Disabled("Se cargó el compositor existente con un nombre")
    void verificarSiSeCargaUnCompositorExistentePorNombre() {
        Compositor comp = servicio.consultarCompositor("Juanito");
        Assertions.assertNotNull(comp, "No se cargo el compositor existente");
    }

    @Test
    @Disabled("Se cargaron los registros de compositores existentes")
    void verificarSiSeCargaUnCompositorExistentePorCriterio() {
        List<Compositor> lista = servicio.consultarCompositorPorNombreOFecha("22-03-1234");
        Assertions.assertTrue(lista.size() > 0, "No se cargaron compositores existentes");
    }

    @Test
    @Disabled("No se cargó un compositor inexistente por nombre")
    void verificarSiNoSeCargaUnCompositorInexistentePorNombre() {
        Compositor comp = servicio.consultarCompositor("Lola");
        Assertions.assertNull(comp, "Se cargó compositor inexistente");
    }

    @Test
    @Disabled("Se eliminó un compositor existente")
    void verificarSiSeEliminaUnRegistroDeUnCompositorExistente() {
        Compositor comp = servicio.consultarCompositor("Pepito");
        servicio.eliminarCompositor(comp);
        Compositor eliminado = servicio.consultarCompositor("Pepito");
        Assertions.assertNull(eliminado, "No se eliminó el cliente existente");
    }

    @Test
    @Disabled("No se eliminó un compositor inexistente")
    void verificarSiNoSeEliminaUnRegistroDeUnCompositorInexistente() {
        Compositor comp = new Compositor("Fabricio", null);
        servicio.eliminarCompositor(comp);
        Compositor eliminado = servicio.consultarCompositor("Fabricio");
        Assertions.assertNull(eliminado, "Se eliminó un compositor inexistente");
    }
}
