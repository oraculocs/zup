package com.orangetalents.zup.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.br.CPF;


@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo nome é obrigatório!")
	@Column(length = 50, nullable = false)
	private String nome;
	
	@NotEmpty(message = "Campo email é obrigatório!")
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	
	
	//@Column(unique = true, nullable = false)
	@NotEmpty(message = "Campo CPF é requerido!")
	@CPF
	private String cpf;
	
	@NotNull
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataNascimento;
	
	@OneToMany(mappedBy = "usuario", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String cpf, Instant dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
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
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}
	
	public void addVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario: id=" + id + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento;
	}
	
}
