package com.rockola.controladores;

import com.rockola.entidades.GeneroMusical;
import com.rockola.servicios.GeneroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenerosWebController {
    
    @Autowired
    private GeneroService generoService;
    
    @GetMapping("/api/generos")
    public ResponseEntity<List<GeneroMusical>> consultarGeneros(){
        List<GeneroMusical> lista = generoService.consultarGeneros();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
}
