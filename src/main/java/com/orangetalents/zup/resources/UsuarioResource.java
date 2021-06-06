package com.orangetalents.zup.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.zup.entities.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lista = new ArrayList<>();
		
		lista.add(new Usuario(1L, "Vitor Alvim", "vitor@gmail.com", "12345678901", Instant.now()));
		lista.add(new Usuario(2L, "Vitoria Sousa", "vitoria@gmail.com", "12345123901", Instant.now()));
		lista.add(new Usuario(3L, "Alberto Brum", "alberto@gmail.com", "12345678101", Instant.now()));
		
		return ResponseEntity.ok().body(lista);
		
	}

}
