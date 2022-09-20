package com.rockola.controladores;

import com.rockola.entidades.GeneroMusical;
import com.rockola.servicios.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * index.html                /
 * listageneros.html         /generos
 * formgeneros.html          /generos/form/{id}
 *
 */
@Controller
public class GenerosController {
    
    @Autowired
    private GeneroService generoService;

    @GetMapping("/")
    public String cargarIndex() {
        return "index";
    }
    
    @GetMapping("/generos")
    public String cargarListaGeneros(Model model, @RequestParam(value="criterio", required=false) String criterio) {
        if(criterio==null){
            model.addAttribute("generos", generoService.consultarGeneros());
        }
        else{
            model.addAttribute("generos", generoService.consultarGeneros(criterio));
            model.addAttribute("criterio", criterio);
        }
        return "listageneros";
    }
    
    @GetMapping("/generos/form")
    public String cargarFormGeneros(Model modelo) {
        modelo.addAttribute("genero", new GeneroMusical());
        return "formgeneros";
    }
    
    @GetMapping("/generos/form/{id}")
    public String cargarFormGeneros(Model modelo, @PathVariable int id) {
        GeneroMusical g = generoService.consultarGeneros(id);
        modelo.addAttribute("genero", g);
        return "formgeneros";
    }
    
    @PostMapping("/generos")
    public String guardarGenero(@ModelAttribute GeneroMusical g){
        generoService.crearNuevoGenero(g);
        return "redirect:/generos";
    }
    
    @GetMapping("/generos/eliminar/{id}")
    public String eliminarGenero(@PathVariable int id) {
        GeneroMusical g = generoService.consultarGeneros(id);
        generoService.eliminarGenero(g);
        return "redirect:/generos";
    }
}
