package com.orangetalents.zup;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangetalents.zup.dto.UsuarioDTO;
import com.orangetalents.zup.entities.Usuario;
import com.orangetalents.zup.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll(){
		List<Usuario> lista = repository.findAll();
		
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x)).collect(Collectors.toList());
		
		return listaDto;
	}

	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario entity = obj.get();
		return new UsuarioDTO(entity);
		
	}
}
