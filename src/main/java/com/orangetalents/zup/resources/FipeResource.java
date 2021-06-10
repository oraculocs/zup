package com.orangetalents.zup.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.zup.dto.ModelosDTO;
import com.orangetalents.zup.dto.ValorDTO;
import com.orangetalents.zup.services.FipeService;

@RestController
@RequestMapping(value = "/marcas")
public class FipeResource {

	@Autowired
	private FipeService service;
	
	@GetMapping(value = "/{marcaId}/modelos")
	public ResponseEntity<ModelosDTO> getModelos(@PathVariable Long marcaId) {
		ModelosDTO list = service.getModelosV1(marcaId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{marcaId}/modelos/{codigoFipe}/anos/{ano}-3")
	public ResponseEntity<ValorDTO> getValor(@PathVariable Long marcaId, 
												@PathVariable String codigoFipe,
												@PathVariable Integer ano){
		ValorDTO dto = service.getValor(marcaId, codigoFipe, ano);
		return ResponseEntity.ok().body(dto);
	}
}
