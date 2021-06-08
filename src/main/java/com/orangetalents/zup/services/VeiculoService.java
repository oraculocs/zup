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

import com.orangetalents.zup.dto.VeiculoDTO;
import com.orangetalents.zup.entities.Veiculo;
import com.orangetalents.zup.repositories.VeiculoRepository;
import com.orangetalents.zup.services.exceptions.DatabaseException;
import com.orangetalents.zup.services.exceptions.ResourceNotFoundException;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repository;
	
	@Transactional(readOnly = true)
	public List<VeiculoDTO> findAll(){
		List<Veiculo> lista = repository.findAll();
		
		List<VeiculoDTO> listaDto = lista.stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
		
		return listaDto;
	}

	@Transactional(readOnly = true)
	public VeiculoDTO findById(Long id) {
		Optional<Veiculo> obj = repository.findById(id);
		Veiculo entity = obj.orElseThrow(() -> new ResourceNotFoundException("Id não localizado!"));
		return new VeiculoDTO(entity);
		
	}

	@Transactional
	public VeiculoDTO insert(VeiculoDTO dto) {
		
		Veiculo entity = new Veiculo();
		entity.setMarca(dto.getMarca());
		entity.setModelo(dto.getModelo());
		entity.setAno(dto.getAno());
		
		entity = repository.save(entity);
		
		return new VeiculoDTO(entity);
	}

	@Transactional
	public VeiculoDTO update(Long id, VeiculoDTO dto) {
		
		try {
			Veiculo entity = repository.getOne(id);
			
			entity.setMarca(dto.getMarca());
			entity.setModelo(dto.getModelo());
			entity.setAno(dto.getAno());
			
			entity = repository.save(entity);
			
			return new VeiculoDTO(entity);
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
	
	
}
