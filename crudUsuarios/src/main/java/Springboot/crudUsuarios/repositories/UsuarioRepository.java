package Springboot.crudUsuarios.repositories;

import java.util.ArrayList;

import Springboot.crudUsuarios.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
    public abstract ArrayList<UsuarioModel> findByNombre(String nombre);
    public abstract ArrayList<UsuarioModel> findByEmail(String email);
    public abstract ArrayList<UsuarioModel> findByEdad(Integer edad);
}
