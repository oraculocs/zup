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

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entity = new Usuario();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setDataNascimento(dto.getDataNascimento());
		
		entity = repository.save(entity);
		
		return new UsuarioDTO(entity);
	}

	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		Usuario entity = repository.getOne(id);
		
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setDataNascimento(dto.getDataNascimento());
		
		entity = repository.save(entity);
		
		return new UsuarioDTO(entity);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
