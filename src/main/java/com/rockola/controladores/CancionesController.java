package com.rockola.controladores;

import com.rockola.entidades.Cancion;
import com.rockola.servicios.CancionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CancionesController {
    
    @Autowired
    private CancionService cancionService;
    
    @GetMapping("/canciones")
    public String cargarListaCancionesPorCriterio(Model model, @RequestParam(name="criterio", required=false)String criterio){
        List<Cancion> canciones;
        if(criterio == null){
            canciones = cancionService.cargarCanciones();
        }
        else{
            canciones = cancionService.cargarCancionesPorCriterio(criterio);
        }
        model.addAttribute("canciones", canciones);
        return "listacanciones";
    }
    
    @GetMapping("/canciones/form")
    public String cargarFormCanciones(Model modelo) {
        modelo.addAttribute("cancion", new Cancion());
        return "formcanciones";
    }
    
    @GetMapping("/canciones/form/{id}")
    public String cargarFormCanciones(Model modelo, @PathVariable int id) {
        Cancion g = cancionService.cargarCancion(id);
        modelo.addAttribute("cancion", g);
        return "formcanciones";
    }
    
    @PostMapping("/canciones")
    public String guardarCancion(@ModelAttribute Cancion g){
        cancionService.guardarCancion(g);
        return "redirect:/cancion";
    }
    
    @GetMapping("/canciones/eliminar/{id}")
    public String eliminarCancion(@PathVariable int id) {
        Cancion g = cancionService.cargarCancion(id);
        cancionService.eliminarCancion(g);
        return "redirect:/generos";
    }
}
