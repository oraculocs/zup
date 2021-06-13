package com.orangetalents.zup.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orangetalents.zup.dto.ModelosDTO;
import com.orangetalents.zup.dto.ValorDTO;

@Service
public class FipeService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ModelosDTO getModelosV1(Long marcaId) {
		
		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas/{marcaId}/modelos";
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("marcaId", marcaId.toString());
		
		ResponseEntity<ModelosDTO> result = restTemplate.getForEntity(path, ModelosDTO.class, uriVariables);
		return result.getBody();
	}
	
	public ValorDTO getValor(Long marcaId, String codigoFipe, Integer ano) {

		String path = "https://parallelum.com.br/fipe/api/v1/carros/marcas/{marcaId}/modelos/{codigoFipe}/anos/{ano}-3";
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("marcaId", marcaId.toString());
		uriVariables.put("codigoFipe", codigoFipe.toString());
		uriVariables.put("ano", ano.toString());
		
		ResponseEntity<ValorDTO> result = restTemplate.getForEntity(path, ValorDTO.class, uriVariables);
		return result.getBody();
	}

}
