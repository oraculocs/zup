package com.orangetalents.zup.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.orangetalents.zup.entities.enums.DataRodizio;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo marca é obrigatório")
	private String marca;
	@NotEmpty(message = "Campo modelo é obrigatório")
	private String modelo;
	@NotNull(message = "Campo ano é obrigatório")
	private Integer ano;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	//@Enumerated(value = EnumType.STRING)
	private String dataRodizio;
	
	private boolean rodizioAtivo;
	
	public Veiculo() {
	}

	public Veiculo(Long id, @NotEmpty(message = "Campo marca é obrigatório") String marca,
			@NotEmpty(message = "Campo modelo é obrigatório") String modelo,
			@NotNull(message = "Campo ano é obrigatório") Integer ano, String dataRodizio, boolean rodizioAtivo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.dataRodizio = dataRodizio;
		this.rodizioAtivo = rodizioAtivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDataRodizio() {
		return dataRodizio;
	}

	public void setDataRodizio(String dataRodizio) {
		this.dataRodizio = dataRodizio;
	}

	public boolean isRodizioAtivo() {
		return rodizioAtivo;
	}

	public void setRodizioAtivo(boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
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
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo: id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano;
	}

}
