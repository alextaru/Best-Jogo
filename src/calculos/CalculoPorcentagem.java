package calculos;

import java.util.ArrayList;

import organizador.Organiza;

import converter.ConverterVariavel;
import txtFuncion.Txt;

public class CalculoPorcentagem {

	public CalculoPorcentagem() {
		// TODO Auto-generated constructor stub
	}
	
	//calcula a porcentagem em que um numero sai em pereiodo
	public void CalculoPorcentagemNumero(String local){
		ArrayList<String> numerosJogos = new ArrayList<String>();
		ArrayList<Integer> numerosConvertidos = new ArrayList<Integer>();
		int tamanhoArray;
		String numerosJuntos;
		
		Txt txt = new Txt();
		ConverterVariavel converte = new ConverterVariavel();
		Organiza organizar = new Organiza();
		
		numerosJogos = txt.GravarTxt(local);
		tamanhoArray = numerosJogos.size();
		
		for (int cont=0; cont < tamanhoArray; cont++){
			numerosJuntos = numerosJogos.get(cont);
			numerosConvertidos.addAll(converte.CoverteParaInteiro(organizar.SepararNumero(numerosJuntos)));
			
		}
			
		
		tamanhoArray = numerosJogos.size();
		
		
		
	}

}
