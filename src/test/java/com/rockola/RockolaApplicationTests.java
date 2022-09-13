package com.rockola;

import com.rockola.entidades.Cliente;
import com.rockola.servicios.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RockolaApplicationTests {

        @Autowired
        private ClienteService servicio;
    
	@Test
	void verificarSiSeGuardaUnClienteNuevo() {
            Cliente c = new Cliente(1234523,"Cédula de ciudadanía","Juan","Correa",23,"juan@gmail.com");
            Cliente guardado = servicio.crearNuevoCliente(c);
            Assertions.assertEquals(1234523, guardado.getNumdocumento(), "Error. No se ha guardado un nuevo cliente");
	}

}
