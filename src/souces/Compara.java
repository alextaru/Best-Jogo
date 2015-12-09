package souces;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

public class Compara {
	CalculoPorcentagem porcentagem = new CalculoPorcentagem();
	Txt txt = new Txt();
	Organiza organiza = new Organiza();
	ConverterVariavel converte = new ConverterVariavel();
	
	ArrayList<String> numerosSeparados = new ArrayList<String>();
	ArrayList<Integer> numerosConvertidos = new ArrayList<Integer>();
	ArrayList<String> numerosJogo = new ArrayList<String>();
	
	int quantidadeJogos;
	
	public Compara() {
		numerosJogo = txt.GravarTxt("arquivos/resutadosLoto.txt");
		quantidadeJogos = numerosJogo.size();
	}
	
	//compara se o jogo ja foi sorteado
	public String ComparaJogos(ArrayList<Integer> jogo){
		
		String resultado = null;
		int tamanhoResultado,tamanhoJogo,acertos = 0;
		int onze = 0, doze = 0, treze = 0, quatorze = 0, quinze = 0;
		
		
		for(int cont = 0; cont < quantidadeJogos; cont++){
			numerosConvertidos = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont)));
			
			tamanhoJogo = jogo.size();
			tamanhoResultado = numerosConvertidos.size();
			
			for(int cont2 = 0;cont2 < tamanhoJogo; cont2++){
				for(int cont3 = 0; cont3 < tamanhoResultado; cont3++){
					if(jogo.get(cont2) == numerosConvertidos.get(cont3)){
						acertos++;
					}
				}
			}
			
			switch(acertos){
				case 11:
					onze++;
					acertos = 0;
					break;
				case 12:
					doze++;
					acertos = 0;
					break;
				case 13:
					treze++;
					acertos = 0;
					break;
				case 14:
					quatorze++;
					acertos = 0;
					break;
				case 15:
					quinze++;
					acertos = 0;
					break;
				default:
					acertos = 0;
					break;
			}
				
		}
		
		if(onze != 0){
			resultado = "11 acertos = " + onze +" vezes\n";
		}
		if(doze != 0){
			if(resultado == null)
				resultado = "12 acertos = " + doze +" vezes\n";
			else
				resultado =resultado + "12 acertos = " + doze +" vezes\n";
		}
		if(treze != 0){
			if(resultado == null)
				resultado = "13 acertos = " + treze +" vezes\n";
			else
				resultado =resultado + "13 acertos = " + treze +" vezes\n";
		}
		if(quatorze != 0){
			if(resultado == null)
				resultado = "14 acertos = " + quatorze +" vezes\n";
			else
				resultado =resultado + "14 acertos = " + quatorze +" vezes\n";
		}
		if(quinze != 0){
			if(resultado == null)
				resultado = "15 acertos = " + quinze +" vezes\n";
			else
				resultado =resultado + "15 acertos = " + quinze +" vezes\n";
		}
		if(resultado == null)
			resultado = "bilete nao premiado ainda";
		
		return resultado;
	}
	
	//compara a frequecia que em determinados numeros sai na loto
	public ArrayList<Integer> ComparaFrequeciaAcerto(ArrayList<Integer> jogo){
		
		ArrayList<Integer> conjuntoACertos = new ArrayList<Integer>();
		int tamanhoResultado,tamanhoJogo,acertos = 0;
		
		for(int cont = 0; cont < quantidadeJogos; cont++){
			numerosConvertidos = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont)));
			
			tamanhoJogo = jogo.size();
			tamanhoResultado = numerosConvertidos.size();
			
			for(int cont2 = 0;cont2 < tamanhoJogo; cont2++){
				for(int cont3 = 0; cont3 < tamanhoResultado; cont3++){
					if(jogo.get(cont2) == numerosConvertidos.get(cont3)){
						acertos++;
					}
				}
			}
			
			conjuntoACertos.add(acertos);
			acertos = 0;
			
		}
		
		return conjuntoACertos;
	}
	
	
	//conta quantidade de par
	public int ContaPar(ArrayList<Integer> jogo){
		int tamanho, par = 0, numero, resultado;
		
		tamanho = jogo.size();
		
		for(int cont = 0; cont < tamanho; cont++){
			numero = jogo.get(cont);
			resultado = numero % 2;
			
			if(resultado == 0)
				par++;
		}
		
		return par;
	}
	
	//conta quantidade de inpar
	public int ContaImpar(ArrayList<Integer> jogo){
		int tamanho, inpar = 0, numero, resultado;
		
		tamanho = jogo.size();
		
		for(int cont = 0; cont < tamanho; cont++){
			numero = jogo.get(cont);
			resultado = numero % 2;
			
			if(resultado != 0)
				inpar++;
		}
		
		return inpar;
	}
	
	//compara a quantodade de minima de vezes que saiu 8 pares e 7 inpares
	public ArrayList<Integer> Conta8par7inpar() {
		int par, impar, naoSaiu = 0;
		ArrayList<Integer> ficouSemSair = new ArrayList<Integer>();
		
		ficouSemSair.clear();
			
		for (int cont=0; cont < quantidadeJogos; cont++){
			numerosSeparados = organiza.SepararNumero(numerosJogo.get(cont));
			numerosConvertidos = converte.CoverteParaInteiro(numerosSeparados);	
			
			par = ContaPar(numerosConvertidos);
			impar = ContaImpar(numerosConvertidos);
			
			if(par == 8){
				if(impar == 7){
					if(cont == 0)
						naoSaiu = 0;
					else{
						ficouSemSair.add(naoSaiu);
						naoSaiu = 0;
					}
				}else
					naoSaiu++;
			}else
				naoSaiu++;
		}
			
		return ficouSemSair;	
	}
	
	//retorna a maxima quantidade de veses que um numero nao saiu
	public String QuantNumSemSair() {
		int naoSaiu = 0, tamanho,contNaoSaiu;
		boolean saiu;
		ArrayList<Integer> temporario = new ArrayList<Integer>();
		String numerosRepetidos = null;
		
		
		for (int numero = 1; numero < 26; numero++){
			
			temporario.clear();
			
			saiu = false;
			contNaoSaiu = 0;
			
			for (int cont=0; cont < quantidadeJogos; cont++){
				
				numerosSeparados = organiza.SepararNumero(numerosJogo.get(cont));
				numerosConvertidos = converte.CoverteParaInteiro(numerosSeparados);	
				
				tamanho = numerosConvertidos.size();
				
				for(int contResultado = 0; contResultado < tamanho; contResultado++){
					if(numero == numerosConvertidos.get(contResultado)){
					    saiu = true;
					    break;
					}
				}
				
				if(saiu == true){
					temporario.add(contNaoSaiu);
					contNaoSaiu = 0;
					saiu = false;
					
				}else
					contNaoSaiu++;
			}
			if(numero == 1)
				numerosRepetidos = numero + "\n";
			else
				numerosRepetidos = numerosRepetidos + numero + "\n";
			numerosRepetidos = numerosRepetidos + porcentagem.NumerosRepetidos(temporario);
			
		}
		
		return numerosRepetidos;
	}
	
	//conta a quantidade de acertos do concurso anterior
	public ArrayList<Integer> AcertosJogoAnterior(){
		ArrayList<Integer> conjuntoACertos = new ArrayList<Integer>();
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		
		int tamanhoResultado,acertos = 0;
		
		for(int cont = 0; cont < quantidadeJogos-1; cont++){
			numerosConvertidos = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont)));
			jogo = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont+1)));
			
			tamanhoResultado = numerosConvertidos.size();
			for(int cont1 = 0; cont1 < tamanhoResultado; cont1++){
				for(int cont2 = 0; cont2 < tamanhoResultado; cont2++){
					if(jogo.get(cont1) == numerosConvertidos.get(cont2)){
						acertos++;
					}
				}
			}
			
			conjuntoACertos.add(acertos);
			acertos = 0;
			
		}
		
		return conjuntoACertos;
	}
	
	//conta a quantidade de acertos em um determinado concurso
	public int AcertosJogoConcurso(ArrayList<Integer> jogo, int concurso){
		
		int acertos = 0;
		
		numerosConvertidos = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(concurso-1)));
		
		for(int cont = 0; cont < jogo.size(); cont++){
			for(int cont1 = 0; cont1 < numerosConvertidos.size(); cont1++){
				if(jogo.get(cont) == numerosConvertidos.get(cont1)){
					acertos++;
				}
			}
		}
		return acertos;
	}
	
    //conta a quantodade de inpar que acertou no jogo anterior
	public ArrayList<Integer> ContaInparAcertoAnterior(){
		ArrayList<Integer> conjuntoACertos = new ArrayList<Integer>();
		ArrayList<Integer> jogo = new ArrayList<Integer>();
		ArrayList<Integer> impar = new ArrayList<Integer>();
		
		
		int tamanhoResultado;
		
		for(int cont = 0; cont < quantidadeJogos-1; cont++){
			numerosConvertidos = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont)));
			jogo = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont+1)));
			
			tamanhoResultado = numerosConvertidos.size();
			for(int cont1 = 0; cont1 < tamanhoResultado; cont1++){
				for(int cont2 = 0; cont2 < tamanhoResultado; cont2++){
					if(jogo.get(cont1) == numerosConvertidos.get(cont2)){
						conjuntoACertos.add(jogo.get(cont1));
					}
				}
			}
			
			impar.add(ContaImpar(conjuntoACertos));
			conjuntoACertos.clear();
			
		}
		
		return impar;
	}
	
	//conta a quantodade de par que acertou no jogo anterior
		public ArrayList<Integer> ContaParAcertoAnterior(){
			ArrayList<Integer> conjuntoACertos = new ArrayList<Integer>();
			ArrayList<Integer> jogo = new ArrayList<Integer>();
			ArrayList<Integer> par = new ArrayList<Integer>();
			
			
			int tamanhoResultado;
			
			for(int cont = 0; cont < quantidadeJogos-1; cont++){
				numerosConvertidos = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont)));
				jogo = converte.CoverteParaInteiro(organiza.SepararNumero(numerosJogo.get(cont+1)));
				
				tamanhoResultado = numerosConvertidos.size();
				for(int cont1 = 0; cont1 < tamanhoResultado; cont1++){
					for(int cont2 = 0; cont2 < tamanhoResultado; cont2++){
						if(jogo.get(cont1) == numerosConvertidos.get(cont2)){
							conjuntoACertos.add(jogo.get(cont1));
						}
					}
				}
				
				par.add(ContaPar(conjuntoACertos));
				conjuntoACertos.clear();
				
			}
			
			return par;
		}
		
		//compara a quantidade maxima que 8 pares ficarao sem sair
		public String QuantParSemSair() {
			int quantidadePar,contNaoSaiu = 0;
			boolean saiu = false;
			ArrayList<Integer> temporario = new ArrayList<Integer>();
			String numerosRepetidos;
			
			temporario.clear();
				
			for (int cont=0; cont < quantidadeJogos; cont++){
					
				numerosSeparados = organiza.SepararNumero(numerosJogo.get(cont));
				numerosConvertidos = converte.CoverteParaInteiro(numerosSeparados);	
					
				quantidadePar = ContaPar(numerosConvertidos);
					
				if(quantidadePar == 8)
					saiu = true;
					
				if(saiu == true){
					temporario.add(contNaoSaiu);
					contNaoSaiu = 0;
					saiu = false;
						
				}else
					contNaoSaiu++;
			}
			
			numerosRepetidos = porcentagem.NumerosRepetidos(temporario);
			
			return numerosRepetidos;
		}
		
		//conta a quantodade de vezes que uns numeros fica sem acertar 2
		public String QuantNumSemAcertarDois(ArrayList<Integer> conjunto) {
			int acerto,contNaoSaiu = 0;
			boolean saiu = false;
			ArrayList<Integer> temporario = new ArrayList<Integer>();
			String numerosRepetidos;
			
			temporario.clear();
				
			for (int cont=1; cont < quantidadeJogos; cont++){
				
				acerto = AcertosJogoConcurso(conjunto, cont);
					
				if(acerto == 2)
					saiu = true;
					
				if(saiu == true){
					temporario.add(contNaoSaiu);
					contNaoSaiu = 0;
					saiu = false;
						
				}else
					contNaoSaiu++;
			}
			
			numerosRepetidos = porcentagem.NumerosRepetidos(temporario);
			
			return numerosRepetidos;
		}		
}
