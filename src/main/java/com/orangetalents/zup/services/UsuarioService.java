package com.orangetalents.zup.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangetalents.zup.dto.UsuarioDTO;
import com.orangetalents.zup.entities.Usuario;
import com.orangetalents.zup.repositories.UsuarioRepository;
import com.orangetalents.zup.services.exceptions.DatabaseException;
import com.orangetalents.zup.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll(){
		List<Usuario> lista = repository.findAll();
		
		List<UsuarioDTO> listaDto = lista.stream().map(x -> new UsuarioDTO(x, x.getVeiculos())).collect(Collectors.toList());
		
		return listaDto;
	}

	@Transactional(readOnly = true)
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não localizado!"));
		return new UsuarioDTO(entity, entity.getVeiculos());
		
	}

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		if(findByCPF(dto) != null) {
			throw new com.orangetalents.zup.services.exceptions.DataIntegrityViolationException("CPF já cadastrado na base de dados!");
		}
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
		
		try {
			Usuario entity = repository.getOne(id);
			
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setCpf(dto.getCpf());
			entity.setDataNascimento(dto.getDataNascimento());
			
			entity = repository.save(entity);
			
			return new UsuarioDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado: " + id);
		}
		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
			
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado: " + id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integridade violada");
		}
	}
	
	private Usuario findByCPF(UsuarioDTO objDto) {
		Usuario obj = repository.findbyCPF(objDto.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}
}
