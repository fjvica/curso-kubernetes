package com.springcluod.msvc.usuarios.msvc.usuarios.repositories;

import com.springcluod.msvc.usuarios.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
