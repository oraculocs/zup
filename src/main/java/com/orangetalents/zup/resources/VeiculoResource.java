package com.orangetalents.zup.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.orangetalents.zup.dto.VeiculoDTO;
import com.orangetalents.zup.services.UsuarioService;
import com.orangetalents.zup.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<VeiculoDTO>> findAll() {
		List<VeiculoDTO> lista = service.findAll();

		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id) {
		VeiculoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<?> insert(@Valid @RequestBody VeiculoDTO dto) {
		try {

			dto = service.insert(dto);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
			return ResponseEntity.created(uri).body(dto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao Cadastrar veículo, verifique os campos!");
			
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @RequestBody VeiculoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("vincular/{userId}/{veiculoId}")
    public ResponseEntity<?> vincularVeiculo(@PathVariable("userId") Long userId,
                                             @PathVariable("veiculoId") Long veiculoId){
        try {
            usuarioService.vincular(userId, veiculoId);
            return ResponseEntity.status(HttpStatus.OK).body("Veiculo vinculado ao usuário com sucesso!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.OK).body("Erro ao tentar vincular o veiculo a um usuário");
        }
    }
}
