package calculos;

import java.util.ArrayList;

import converter.ConverterVariavel;
import txtFuncion.Txt;

public class CalculoPorcentagem {

	public CalculoPorcentagem() {
		// TODO Auto-generated constructor stub
	}
	
	//calcula a porcentagem em que um numero sai em pereiodo
	public void CalculoPorcentagemNumero(String local){
		ArrayList<Integer> numerosJogos = new ArrayList<Integer>();
		int tamanhoArray;
		
		Txt txt = new Txt();
		ConverterVariavel converte = new ConverterVariavel();
		
		numerosJogos = converte.CoverteParaInteiro(txt.GravarTxt(local));
		
		
	}

}
