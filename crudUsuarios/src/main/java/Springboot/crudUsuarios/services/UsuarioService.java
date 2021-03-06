package Springboot.crudUsuarios.services;

import java.util.ArrayList;
import java.util.Optional;

import Springboot.crudUsuarios.models.UsuarioModel;
import Springboot.crudUsuarios.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> obtenerUsuario(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }

    public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad){
        return usuarioRepository.findByPrioridad(prioridad);
    }

    public ArrayList<UsuarioModel> obtenerPorNombre(String nombre){
        return usuarioRepository.findByNombre(nombre);
    }

    public ArrayList<UsuarioModel> obtenerPorEdad(Integer edad){
        return usuarioRepository.findByEdad(edad);
    }

    public ArrayList<UsuarioModel> obtenerOrdenadosPorEdad(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public boolean eliminarUsuario(Long id){
        try{
            usuarioRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean eliminarTodo(){
        try{
            usuarioRepository.deleteAll();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
