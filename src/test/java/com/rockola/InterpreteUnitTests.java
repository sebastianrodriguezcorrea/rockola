package com.rockola;

import com.rockola.entidades.Interprete;
import com.rockola.servicios.InterpreteService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class InterpreteUnitTests {

    @Autowired
    private InterpreteService servicio;

    @Test
    @Disabled("Se guardó el registro de un nuevo interprete")
    void verificarSiSeGuardaUnInterprete() {
        Interprete inter = new Interprete("Pascal", "22-03-1987");
        Assertions.assertDoesNotThrow(() -> {
            servicio.crearNuevoInterprete(inter);
        }, "No se pudo guardar un nuevo interprete");
    }

    @Test
    @Disabled("Se ha actualizado el registro")
    void verificarSiSeActualizaUnInterpreteNuevo() {
        Interprete inter = new Interprete("Fabio", "21-02-1988");
        Interprete guardado = servicio.crearNuevoInterprete(inter);

        guardado.setFechanacimiento("22-03-2000");
        Interprete actualizado = servicio.actualizarInterprete(guardado);

        Assertions.assertTrue(actualizado.getFechanacimiento().equals("22-03-2000"), "Error. No se pudo actualizar el interprete");
    }

    @Test
    @Disabled("No se guarda un interprete invalido")
    void verificarSiNoSeGuardaUnInterpreteInvalido() {
        Interprete inter = new Interprete(null, null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevoInterprete(inter);
        }, "No se generó excepción desde la base de datos");
    }

    @Test
    @Disabled("Se cargaron los registros de los interpretes")
    void verificarSiSeCarganTodosLosInterpretes() {
        List<Interprete> lista = servicio.consultarInterprete();
        Assertions.assertTrue(lista.size() > 0, "No se cargaron los interpretes");
    }

    @Test
    @Disabled("Se cargó el interprete existente con un nombre")
    void verificarSiSeCargaUnInterpreteExistentePorId() {
        Interprete inter = servicio.consultarInterprete(1);
        Assertions.assertNotNull(inter, "No se cargo el interprete existente");
    }

    @Test
    @Disabled("Se cargaron los registros de interpretes existentes")
    void verificarSiSeCargaUnInterpreteExistentePorCriterio() {
        List<Interprete> lista = servicio.consultarInterpretePorNombreOFecha("22-03-2000");
        Assertions.assertTrue(lista.size() > 0, "No se cargaron interpretes existentes");
    }

    @Test
    @Disabled("No se cargó un interprete inexistente por id")
    void verificarSiNoSeCargaUnInterpreteInexistentePorId() {
        Interprete inter = servicio.consultarInterprete(12);
        Assertions.assertNull(inter, "Se cargó interprete inexistente");
    }

    @Test
    @Disabled("Se eliminó un interprete existente")
    void verificarSiSeEliminaUnRegistroDeInterpreteExistente() {
        Interprete inter = servicio.consultarInterprete(3);
        servicio.eliminarInterprete(inter);
        Interprete eliminado = servicio.consultarInterprete(3);
        Assertions.assertNull(eliminado, "No se eliminó el interprete existente");
    }

    @Test
    @Disabled("No se eliminó un interprete inexistente")
    void verificarSiNoSeEliminaUnRegistroDeUnIntepreteInexistente() {
        Interprete inter = new Interprete("Fabricio", null);
        servicio.eliminarInterprete(inter);
        List<Interprete> lista = servicio.consultarInterpretePorNombreOFecha("Fabricio");
        Assertions.assertTrue(lista.isEmpty(), "Se eliminó un interprete inexistente");
    }

}
