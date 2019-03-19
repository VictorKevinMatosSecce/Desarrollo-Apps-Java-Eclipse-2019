package com.arquitecturajava.Repository;

import org.springframework.data.repository.CrudRepository;
import com.arquitecturajava.Entity.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {

}
