package Grafico;

import imporHtml.HtmlFunc;

import java.util.ArrayList;

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
		
		/*html.HtmlReadLoto();
		
		
		
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		jogo.clear();
		
		jogo.add(1);
		jogo.add(1);
		jogo.add(1);
		jogo.add(2);
		jogo.add(2);
		jogo.add(13);
		jogo.add(13);
		jogo.add(13);
		
		
		System.out.println(compara.ContaPar(jogo));
		jogo.add(16);
		jogo.add(18);
		jogo.add(19);
		jogo.add(20);
		jogo.add(22);
		jogo.add(23);
		jogo.add(24);*/
		
		
		
		System.out.println(compara.QuantNumSemSair());
	}

}
