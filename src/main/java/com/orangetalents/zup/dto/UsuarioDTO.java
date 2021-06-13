package com.orangetalents.zup.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.orangetalents.zup.entities.Usuario;
import com.orangetalents.zup.entities.Veiculo;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Instant dataNascimento;
	
	private List<VeiculoDTO> veiculos = new ArrayList<>();
	
	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email, String cpf, Instant dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	//Construtor personalizado recebendo a entidade
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.dataNascimento = entity.getDataNascimento();
	}
	
	public UsuarioDTO(Usuario entity, List<Veiculo> veiculos) {
		this(entity);
		veiculos.forEach(x -> this.veiculos.add(new VeiculoDTO(x)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<VeiculoDTO> getVeiculos() {
		return veiculos;
	}

}
