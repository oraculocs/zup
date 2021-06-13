package com.orangetalents.zup.dto;

import java.util.ArrayList;
import java.util.List;

public class ModelosDTO {

	private List<ItemDTO> modelos = new ArrayList<>();
	
	private List<AnoDTO> anos = new ArrayList<>();
	
	private ValorDTO valor;
	
	public ModelosDTO() {
	}

	public List<ItemDTO> getModelos() {
		return modelos;
	}

	public void setModelos(List<ItemDTO> modelos) {
		this.modelos = modelos;
	}

	public List<AnoDTO> getAnos() {
		return anos;
	}

	public void setAnos(List<AnoDTO> anos) {
		this.anos = anos;
	}

	public ValorDTO getValor() {
		return valor;
	}

	public void setValor(ValorDTO valor) {
		this.valor = valor;
	}
		
}
