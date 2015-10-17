package Grafico;

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
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		jogo.clear();
		
		jogo.add(1);
		jogo.add(2);
		jogo.add(5);
		jogo.add(6);
		jogo.add(9);
		jogo.add(12);
		jogo.add(13);
		jogo.add(15);
		jogo.add(16);
		jogo.add(18);
		jogo.add(19);
		jogo.add(20);
		jogo.add(22);
		jogo.add(23);
		jogo.add(24);
		
		
		//porcentagem.Conta8par7inpar();
		System.out.println(compara.ComparaJogos(jogo));
	}

}
