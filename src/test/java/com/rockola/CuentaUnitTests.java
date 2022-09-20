package com.rockola;

import com.rockola.entidades.Cliente;
import com.rockola.entidades.Cuenta;
import com.rockola.entidades.Rol;
import com.rockola.servicios.ClienteService;
import com.rockola.servicios.CuentaService;
import com.rockola.servicios.RolService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class CuentaUnitTests {

    @Autowired
    private CuentaService servicioCuenta;

    @Autowired
    private ClienteService servicioCliente;

    @Autowired
    private RolService servicioRol;

    @Test
    @Disabled("Se ha guardado una nueva cuenta")
    void verificarSiSeGuardaUnaCuentaNueva() {
        Cliente cliente = servicioCliente.consultarCliente(1);
        List<Rol> listaRol = servicioRol.consultarRolPorNombreODescripcion("normal");
        Cuenta c = new Cuenta(cliente.getCorreo(), "123", true, cliente, listaRol);
//            Cliente guardado = servicio.crearNuevoCliente(c);
//            Assertions.assertTrue(guardado != null, "Error. No se ha guardado un nuevo cliente");
        Assertions.assertDoesNotThrow(() -> {
            servicioCuenta.crearNuevaCuenta(c);
        }, "No se pudo guardar una nueva cuenta");
    }

    @Test
    @Disabled("No se ha guardado un registro de cliente invalido")
    void verificarSiNoSeGuardaUnaCuentaInvalida() {
        Cliente cliente = servicioCliente.consultarCliente(1);
        List<Rol> listaRol = servicioRol.consultarRolPorNombreODescripcion("normal");
        Cuenta c = new Cuenta(null, null, null, cliente, listaRol);
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            servicioCuenta.crearNuevaCuenta(c);
        }, "No se generó excepción desde la base de datos.");
    }

}
