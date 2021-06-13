package com.orangetalents.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orangetalents.zup.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT obj from Usuario obj WHERE obj.cpf =:cpf")
	Usuario findbyCPF(@Param("cpf") String cpf);

	@Query("SELECT obj from Usuario obj WHERE obj.email =:email")
	Usuario findByEmail(@Param("email") String email);

}
