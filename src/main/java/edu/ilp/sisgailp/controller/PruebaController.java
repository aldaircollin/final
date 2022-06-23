package edu.ilp.sisgailp.controller;

import edu.ilp.sisgailp.entity.Escuela;
import edu.ilp.sisgailp.service.IEscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("login")
public class PruebaController {

    @Autowired
    private IEscuelaService escuelaService;

    @GetMapping("/listaEscuelas")
    public List<Escuela> listaEscuelas(){
        return this.escuelaService.listarEscuelas();
    }

    @GetMapping("/buscarEscuelaByCodigo")
    public Escuela buscarEscuelaByCodigo(@RequestParam String codigo){
        return this.escuelaService.obtenerEscuelPorCodigo(codigo);
    }

    @GetMapping("/buscarEscuelaByIdAndDenominacion")
    public Escuela buscarEscuelaByIdAndDenominacion(@RequestParam Long idescuela,@RequestParam String nombre){
        return this.escuelaService.buscarEscuelaByIdAndDenominacion(idescuela,nombre);
    }

    @GetMapping("/saludo")
    public String saludo(){
        return "Hola amig@s desde Ayacucho - perú";
    }

    @GetMapping("/bienvenido")
    public String identificacion(@RequestParam String datos){
        return "Bienvenido a la Pontificia: " + datos;
    }
}
