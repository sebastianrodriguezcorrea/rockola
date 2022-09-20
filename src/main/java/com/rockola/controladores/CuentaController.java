package com.rockola.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * index.html
 *
 */
@Controller
public class CuentaController {

    @GetMapping("/")
    public String cargarIndex() {
        return "index";
    }

    @GetMapping("/cuentas")
    public String cargarListaDeCuentas() {
        return "listacuentas";
    }

    @GetMapping("/formcuentas")
    public String cargarFormCuentas() {
        return "formcuentas";
    }
}
