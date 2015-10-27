package Grafico;

import imporHtml.HtmlFunc;

import java.util.ArrayList;

import organizador.Organiza;

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
		
		
		//String local = "arquivos/resutadosLoto.txt";
		
		//html.HtmlReadLoto();
		
		
		
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		jogo.clear();
		
		jogo.add(2);
		jogo.add(3);
		jogo.add(5);
		jogo.add(7);
		jogo.add(11);
		jogo.add(13);
		jogo.add(17);
		jogo.add(19);
		jogo.add(23);
		//jogo.add(8);
		//jogo.add(23);
		//jogo.add(3);
		//jogo.add(10);
		//jogo.add(6);
		//jogo.add(15);
		
		//System.out.println(porcentagem.NumerosRepetidos(compara.ComparaFrequeciaAcerto(jogo)));
		
		System.out.println(porcentagem.NumerosRepetidos(compara.ContaInparAcertoAnterior()));
	}

}
