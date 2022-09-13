package com.rockola;

import com.rockola.entidades.Cliente;
import com.rockola.servicios.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RockolaApplicationTests {

        @Autowired
        private ClienteService servicio;
    
	@Test
        @Disabled
	void verificarSiSeGuardaUnClienteNuevo() {
            Cliente c = new Cliente(1234523,"Cédula de ciudadanía","Juan","Correa",23,"juan@gmail.com");
            Cliente guardado = servicio.crearNuevoCliente(c);
            Assertions.assertTrue(guardado != null, "Error. No se ha guardado un nuevo cliente");
	}
        
        @Test
        @Disabled
	void verificarSiSeActualizaUnClienteNuevo() {
            Cliente c = new Cliente(12324522,"Cédula de ciudadanía","Juan","Rodriguez",23,"juan22@gmail.com");
            Cliente guardado = servicio.crearNuevoCliente(c);
            
            guardado.setNombre("Juan Sebastian");
            guardado.setApellido("Rodriguez Correa");
            Cliente actualizado = servicio.actualizarCliente(guardado);
            
            Assertions.assertTrue(actualizado.getNombre().equals("Juan Sebastian"), "Error. No se pudo actualizar el cliente");
            Assertions.assertTrue(actualizado.getApellido().equals("Rodriguez Correa"), "Error. No se pudo actualizar el cliente");
	}

}
