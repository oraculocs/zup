package com.orangetalents.zup.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import com.orangetalents.zup.entities.Veiculo;

public class VerificarRodizio {
	
	public static boolean consultarRodizio(Veiculo veiculo) {
		//Formatando data do sistesma
		LocalDate data = LocalDate.now();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataAtual = formato.format(data);

		String rodizio = diaDaSemana(dataAtual);
		
		if(veiculo.getDataRodizio().toString().contains(rodizio)) {
			return true;
		}
		return false;
	}
	
	//Método para pegar o dia da Semana
	public static String diaDaSemana(String data) {
	    DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    DayOfWeek dow = DayOfWeek.from(parser.parse(data));
	    return dow.getDisplayName(TextStyle.SHORT, new Locale("pt", "BR")).toUpperCase();
	}

}
