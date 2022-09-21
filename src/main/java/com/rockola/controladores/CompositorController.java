package com.rockola.controladores;

import com.rockola.entidades.Compositor;
import com.rockola.servicios.CompositorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CompositorController {

    @Autowired
    private CompositorService compositorService;

    @GetMapping("/compositores")
    public String cargarCompositoresPorCriterio(Model model, @RequestParam(name = "criterio", required = false) String criterio) {
        List<Compositor> compositores;
        if (criterio == null) {
            compositores = compositorService.consultarCompositor();
        } else {
            compositores = compositorService.consultarCompositorPorNombreOFecha(criterio);
        }
        model.addAttribute("compositores", compositores);
        return "listacompositores";
    }

}
