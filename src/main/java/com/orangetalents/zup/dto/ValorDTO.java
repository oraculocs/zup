package com.orangetalents.zup.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ValorDTO {
	
	@JsonAlias("Valor")
	private String valor;
	@JsonAlias("Marca")
	private String marca;
	@JsonAlias("Modelo")
	private String modelo;
	@JsonAlias("AnoModelo")
	private String anoModelo;
	@JsonAlias("Combustivel")
	private String combustivel;
	@JsonAlias("CodigoFipe")
	private String codigoFipe;
	@JsonAlias("MesReferencia")
	private String mesReferencia;
	@JsonAlias("TipoVeiculo")
	private String tipoVeiculo;
	@JsonAlias("SiglaCombustivel")
	private String siglaCombustivel;

	public ValorDTO() {
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
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

	public String getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCodigoFipe() {
		return codigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		this.codigoFipe = codigoFipe;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getSiglaCombustivel() {
		return siglaCombustivel;
	}

	public void setSiglaCombustivel(String siglaCombustivel) {
		this.siglaCombustivel = siglaCombustivel;
	}

	
}
