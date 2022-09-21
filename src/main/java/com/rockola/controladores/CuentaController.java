package com.rockola.controladores;

import com.rockola.entidades.Cuenta;
import com.rockola.servicios.CuentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * index.html
 *
 */
@Controller
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/")
    public String cargarIndex(Model model) {
        List<Cuenta> cuentas = cuentaService.consultarCuenta();
        model.addAttribute("cuentas", cuentas);
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

    @PostMapping("/inicio")
    public String cargarFormInicio(Model model, @RequestParam(name = "criterio", required = false) String criterio,
            @RequestParam(name = "criterio2", required = false) String criterio2, RedirectAttributes redirectAttributes) {
        List<Cuenta> cuentas = cuentaService.consultarCuenta();
        model.addAttribute("cuentas", cuentas);
        String res = "";
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getCorreo().equals(criterio) && cuenta.getPassword().equals(criterio2)) {
                res = "inicio";
                redirectAttributes.addFlashAttribute("successMessage", "Se ha iniciado sesión");
                break;
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Credenciales no validas");
                res = "index";
            }
        }
        return res;
    }
}
