package Grafico;

import imporHtml.HtmlFunc;

import java.util.ArrayList;

import organizador.Organiza;
import txtFuncion.Txt;
import calculos.CalculoPorcentagem;
import calculos.Compara;

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
		
		
		
		/*ArrayList<Integer> jogo = new ArrayList<Integer>();
		jogo.clear();
		
		jogo.add(2);
		jogo.add(3);
		jogo.add(4);
		jogo.add(6);
		jogo.add(9);
		jogo.add(10);
		jogo.add(11);
		jogo.add(13);
		jogo.add(15);
		jogo.add(16);
		jogo.add(18);
		jogo.add(19);
		jogo.add(20);
		jogo.add(23);
		jogo.add(24);
		
		System.out.println(compara.ComparaJogos(jogo));*/
		
		//System.out.println(porcentagem.NumerosRepetidos(compara.ContaParAcertoAnterior()));
		
		txt.Igualdade();
	}

}
