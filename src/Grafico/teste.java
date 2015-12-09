package Grafico;

import java.util.ArrayList;

import souces.CalculoPorcentagem;
import souces.Compara;
import souces.HtmlFunc;
import souces.Organiza;
import souces.Txt;

public class teste {

	public teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		CalculoPorcentagem porcentagem = new CalculoPorcentagem();
		Compara compara = new Compara();
		HtmlFunc html = new HtmlFunc();
		Txt txt =  new Txt();
		
		
		//String local = "arquivos/resutadosLoto.txt";
		
		//html.HtmlReadLoto();
		
		
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		jogo.clear();
		
		jogo.add(6);
		jogo.add(7);
		jogo.add(8);
		jogo.add(9);
		jogo.add(10);
		//jogo.add(11);
		//jogo.add(24);
		//jogo.add(14);
		//jogo.add(06);
		//jogo.add(2);
		//jogo.add(13);
		//jogo.add(9);
		//jogo.add(5);
		//jogo.add(16);
		//jogo.add(3);
		//jogo.add(25);
		
		System.out.println(compara.QuantNumSemAcertarDois(jogo));
		
		//System.out.println(porcentagem.NumerosRepetidos(compara.ComparaFrequeciaAcerto(jogo)));
		
		//txt.Igualdade();
	}

}
