package com.orangetalents.zup.entities.enums;

public enum DataRodizio {
	
	SEGUNDA_FEIRA("segunda-feira") ,
	TERCA_FEIRA("terca-feira"),
	QUARTA_FEITA("quarta-feira"),
	QUINTA_FEIRA("quinta-feira"),
	SEXTA_FEIRA("sexta-feira");
	
	private final String dataRodizio;
	
	DataRodizio(String s){
		this.dataRodizio = s;
	}

	public String getDataRodizio() {
		return dataRodizio;
	}

	public static DataRodizio verDia(String ano) {
		int ultimoDigito = Integer.parseInt(ano.substring(ano.length() - 1));
		
		switch (ultimoDigito) {
		case 0:
		case 1:
			return SEGUNDA_FEIRA;
		case 2:
		case 3:
			return TERCA_FEIRA;
		case 4:
		case 5:
			return QUARTA_FEITA;
		case 6:
		case 7:
			return QUINTA_FEIRA;
		case 8:
		case 9:
			return SEXTA_FEIRA;
		default:
			break;
		}
		return null;
	}

}
