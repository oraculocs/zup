package com.orangetalents.zup.dto;

import java.io.Serializable;

import com.orangetalents.zup.entities.Veiculo;
import com.orangetalents.zup.entities.enums.DataRodizio;

public class VeiculoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String marca;
	private String modelo;
	private Integer ano;
	private String dataRodizio;
	private boolean rodizioAtivo;

	public VeiculoDTO() {
	}
	
	public VeiculoDTO(Long id, String marca, String modelo, Integer ano, String dataRodizio,
			boolean rodizioAtivo) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.dataRodizio = dataRodizio;
		this.rodizioAtivo = rodizioAtivo;
	}


	public VeiculoDTO(Veiculo entity) {
		this.id = entity.getId();
		this.marca = entity.getMarca();
		this.modelo = entity.getModelo();
		this.ano = entity.getAno();
		this.dataRodizio = entity.getDataRodizio();
		this.rodizioAtivo = entity.isRodizioAtivo();
		
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

}
