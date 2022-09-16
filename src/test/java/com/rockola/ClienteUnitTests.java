package com.rockola;

import com.rockola.entidades.Cliente;
import com.rockola.servicios.ClienteService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class ClienteUnitTests {

    @Autowired
    private ClienteService servicio;

    @Test
    @Disabled("Registro ya creado")
    void verificarSiSeGuardaUnClienteNuevo() {
        Cliente c = new Cliente(32342, "Cédula de ciudadanía", "Fabian", "Correa", 34, "fabian@gmail.com");
//            Cliente guardado = servicio.crearNuevoCliente(c);
//            Assertions.assertTrue(guardado != null, "Error. No se ha guardado un nuevo cliente");
        Assertions.assertDoesNotThrow(() -> {
            servicio.crearNuevoCliente(c);
        }, "No se pudo guardar un nuevo cliente");
    }

    @Test
    @Disabled("Registro actualizado")
    void verificarSiSeActualizaUnClienteNuevo() {
        Cliente c = new Cliente(12324522, "Cédula de ciudadanía", "Juan", "Rodriguez", 23, "juan22@gmail.com");
        Cliente guardado = servicio.crearNuevoCliente(c);

        guardado.setNombre("Juan Sebastian");
        guardado.setApellido("Rodriguez Correa");
        Cliente actualizado = servicio.actualizarCliente(guardado);

        Assertions.assertTrue(actualizado.getNombre().equals("Juan Sebastian"), "Error. No se pudo actualizar el cliente");
        Assertions.assertTrue(actualizado.getApellido().equals("Rodriguez Correa"), "Error. No se pudo actualizar el cliente");
    }

    @Test
    @Disabled("No se guarda el registro invalido")
    void verificarSiNoSeGuardaUnClienteInvalido() {
        Cliente c = new Cliente(3232342, null, null, null, 23, null);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicio.crearNuevoCliente(c);
        }, "No se generó excepción desde la base de datos");
    }

    @Test
    @Disabled("Se cargaron los registros de los clientes")
    void verificarSiSeCarganTodosLosClientes() {
        List<Cliente> lista = servicio.consultarCliente();
        Assertions.assertTrue(lista.size() > 0, "No se cargaron los clientes");
    }

    @Test
    @Disabled("Se cargó el cliente existente con un num de documento")
    void VerificarSiSeCargaUnClienteExistentePorId() {
        Cliente c = servicio.consultarCliente(1);
        Assertions.assertNotNull(c, "No se cargó el cliente existente");
    }

    @Test
    @Disabled("Se cargaron los registros de clientes existentes")
    void verificarSiSeCargaUnClienteExistentePorCriterio() {
        List<Cliente> lista = servicio.consultarCliente("Fabian");
        Assertions.assertTrue(lista.size() > 0, "No se cargaron clientes existentes");
    }

    @Test
    @Disabled("No se cargó un cliente inexistente por num de documento")
    void verificarSiNoSeCargaUnClienteInexistentePorId() {
        Cliente c = servicio.consultarCliente(4444444);
        Assertions.assertNull(c, "Se cargó cliente inexistente");
    }

    @Test
    @Disabled("Se eliminó un cliente existente")
    void verificarSiSeEliminaUnRegistroDeUnClienteExistente() {
        Cliente c = servicio.consultarCliente(3);
        servicio.eliminarCliente(c);
        Cliente eliminado = servicio.consultarCliente(3);
        Assertions.assertNull(eliminado, "No se eliminó el cliente existente");
    }

    @Test
    @Disabled("No se eliminó un cliente inexistente")
    void verificarSiNoSeEliminaUnRegistroDeUnClienteInexistente() {
        Cliente c = new Cliente(3232342, null, null, null, 23, null);
        servicio.eliminarCliente(c);
        Cliente eliminado = servicio.consultarCliente(3232342);
        Assertions.assertNull(eliminado, "Se eliminó un cliente inexistente");
    }
    
    @Test
    @Disabled("Se cargó el registro del cliente existente por num de documento")
    void verificarSiSeCargaUnClienteExistentePorNumDocumento(){
        Cliente c = servicio.consultarClientePorNumDocumento(32342);
        Assertions.assertNotNull(c, "No se cargó el cliente existente");
    }
    
    @Test
    @Disabled("No se cargó un registro de un cliente inexistente por num de documento")
    void verificarSiNoSeCargaUnClienteInexistentePorNumDocumento(){
        Cliente c = servicio.consultarCliente(1232232);
        Assertions.assertNull(c, "Se cargó un cliente inexistente por num de documento");
    }
}
