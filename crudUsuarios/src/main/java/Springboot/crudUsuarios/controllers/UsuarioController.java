package Springboot.crudUsuarios.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import Springboot.crudUsuarios.models.UsuarioModel;
import Springboot.crudUsuarios.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuario(){
        return usuarioService.obtenerUsuario();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping("/queryPrioridad")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @GetMapping("/queryNombre")
    public ArrayList<UsuarioModel> obtenerUsuarioPorNombre(@RequestParam("nombre") String nombre){
        return this.usuarioService.obtenerPorNombre(nombre);
    }

    @GetMapping("/queryEdad")
    public ArrayList<UsuarioModel> obtenerUsuarioPorEdad(@RequestParam("edad") Integer edad){
        return this.usuarioService.obtenerPorEdad(edad);
    }

    @GetMapping("/ordenPorEdad")
    public ArrayList<UsuarioModel> obtenerUsuariosOrdenadosPorEdad(){
        ArrayList<UsuarioModel> lista = this.usuarioService.obtenerOrdenadosPorEdad();
        Collections.sort(lista, new Comparator<UsuarioModel>() {
            @Override
            public int compare(UsuarioModel u1, UsuarioModel u2) {
                return u1.getEdad().compareTo(u2.getEdad());
            }
        });
        return lista;
    }

    @DeleteMapping(path="/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok)
            return "Se eliminó correctamente el usuario con id "+id+".";
        return "No pudo eliminarse el usuario con id "+id+".";
    }

    @DeleteMapping(path="/all")
    public String eliminarTodo(){
        boolean ok = this.usuarioService.eliminarTodo();
        if(ok)
            return "Se eliminaron todos los usuarios correctamente.";
        return "No se pudieron eliminar los usuarios.";
    }

}
