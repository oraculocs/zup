package com.orangetalents.zup.dto;

public class ValorDTO {
	
	private Double Valor;
	private String Marca;
	private String Modelo;
	private Integer AnoModelo;
	private String Combustivel;
	private String CodigoFipe;
	private String MesReferencia;
	private Integer TipoVeiculo;
	private String SiglaCombustivel;
	
	public ValorDTO() {
	}

	public ValorDTO(Double valor, String marca, String modelo, Integer anoModelo, String combustivel, String codigoFipe,
			String mesReferencia, Integer tipoVeiculo, String siglaCombustivel) {
		super();
		Valor = valor;
		Marca = marca;
		Modelo = modelo;
		AnoModelo = anoModelo;
		Combustivel = combustivel;
		CodigoFipe = codigoFipe;
		MesReferencia = mesReferencia;
		TipoVeiculo = tipoVeiculo;
		SiglaCombustivel = siglaCombustivel;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double valor) {
		Valor = valor;
	}

	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getModelo() {
		return Modelo;
	}

	public void setModelo(String modelo) {
		Modelo = modelo;
	}

	public Integer getAnoModelo() {
		return AnoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		AnoModelo = anoModelo;
	}

	public String getCombustivel() {
		return Combustivel;
	}

	public void setCombustivel(String combustivel) {
		Combustivel = combustivel;
	}

	public String getCodigoFipe() {
		return CodigoFipe;
	}

	public void setCodigoFipe(String codigoFipe) {
		CodigoFipe = codigoFipe;
	}

	public String getMesReferencia() {
		return MesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		MesReferencia = mesReferencia;
	}

	public Integer getTipoVeiculo() {
		return TipoVeiculo;
	}

	public void setTipoVeiculo(Integer tipoVeiculo) {
		TipoVeiculo = tipoVeiculo;
	}

	public String getSiglaCombustivel() {
		return SiglaCombustivel;
	}

	public void setSiglaCombustivel(String siglaCombustivel) {
		SiglaCombustivel = siglaCombustivel;
	}
	
	

}
