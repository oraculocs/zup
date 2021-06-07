package com.orangetalents.zup;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orangetalents.zup.entities.Usuario;
import com.orangetalents.zup.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional
	public List<Usuario> findAll(){
		return repository.findAll();
	}
}
