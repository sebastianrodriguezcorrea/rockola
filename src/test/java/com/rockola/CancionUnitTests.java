package com.rockola;

import com.rockola.entidades.Cancion;
import com.rockola.entidades.Compositor;
import com.rockola.entidades.GeneroMusical;
import com.rockola.entidades.Interprete;
import com.rockola.servicios.CancionService;
import com.rockola.servicios.CompositorService;
import com.rockola.servicios.GeneroService;
import com.rockola.servicios.InterpreteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Interprete inter = new Interprete("Rafael Orozco", "24-03-1954");
        Interprete guardado2 = interpreteService.crearNuevoInterprete(inter);
        Assertions.assertTrue(guardado2.getId() > 0, "No se pudo crear interprete");
        Compositor comp = new Compositor("Ivan Ovalle", "16-01-1963");
        Compositor guardado3 = compositorService.crearNuevoCompositor(comp);
        Assertions.assertTrue(guardado3.getId() > 0, "No se pudo crear compositor");
        Cancion c = new Cancion("La muralla verde", 1986, "2:40", g, inter, comp);
        cancionService.guardarCancion(c);
        Assertions.assertDoesNotThrow(() -> {
            cancionService.guardarCancion(c);
        }, "Error al guardar la cancion");
    }
}