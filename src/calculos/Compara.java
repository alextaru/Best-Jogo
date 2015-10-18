package calculos;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import converter.ConverterVariavel;
import organizador.Organiza;
import txtFuncion.Txt;

public class Compara {
	Txt txt = new Txt();
	Organiza organiza = new Organiza();
	ConverterVariavel converte = new ConverterVariavel();
	
	
	
	public Compara() {
		// TODO Auto-generated constructor stub
	}
	
	//compara se o jogo ja foi sorteado
	public int ComparaJogos(ArrayList<Integer> jogo,String local){
		
		ArrayList<String> todosResultados = new ArrayList<String>();
		ArrayList<Integer> numerosJogo = new ArrayList<Integer>();
		int tamanho, tamanhoResultado,tamanhoJogo,acertos = 0,resutado = 0;
		
		todosResultados = txt.GravarTxt(local);
		tamanho = todosResultados.size();
		
		for(int cont = 0; cont < tamanho; cont++){
			numerosJogo = converte.CoverteParaInteiro(organiza.SepararNumero(todosResultados.get(cont)));
			
			tamanhoJogo = jogo.size();
			tamanhoResultado = numerosJogo.size();
			
			for(int cont2 = 0;cont2 < tamanhoJogo; cont2++){
				for(int cont3 = 0; cont3 < tamanhoResultado; cont3++){
					if(jogo.get(cont2) == numerosJogo.get(cont3)){
						acertos++;
					}
				}
			}
			
			if(resutado < acertos){
				resutado = acertos;
				acertos = 0;
			}else
				acertos = 0;
		}
		
		return resutado;
	}
	
	//compara a frequecia que em determinados numeros sai na loto
	public ArrayList<Integer> ComparaFrequeciaAcerto(ArrayList<Integer> jogo, String local){
		
		ArrayList<Integer> conjuntoACertos = new ArrayList<Integer>();
		ArrayList<String> todosResultados = new ArrayList<String>();
		ArrayList<Integer> numerosJogo = new ArrayList<Integer>();
		int tamanho, tamanhoResultado,tamanhoJogo,acertos = 0;
		
		todosResultados = txt.GravarTxt(local);
		tamanho = todosResultados.size();
		
		for(int cont = 0; cont < tamanho; cont++){
			numerosJogo = converte.CoverteParaInteiro(organiza.SepararNumero(todosResultados.get(cont)));
			
			tamanhoJogo = jogo.size();
			tamanhoResultado = numerosJogo.size();
			
			for(int cont2 = 0;cont2 < tamanhoJogo; cont2++){
				for(int cont3 = 0; cont3 < tamanhoResultado; cont3++){
					if(jogo.get(cont2) == numerosJogo.get(cont3)){
						acertos++;
					}
				}
			}
			
			conjuntoACertos.add(acertos);
			
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
	public int ContaInpar(ArrayList<Integer> jogo){
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
			
			
		int par, inpar, quantidadeJogos, naoSaiu = 0;
		ArrayList<Integer> ficouSemSair = new ArrayList<Integer>();
		ArrayList<String> numerosSeparados = new ArrayList<String>();
		ArrayList<String> numerosJogos = new ArrayList<String>();
		ArrayList<Integer> numerosConvertidos = new ArrayList<Integer>();
			
		ficouSemSair.clear();
		numerosSeparados.clear();
			
		numerosJogos = txt.GravarTxt("arquivos/resutadosLoto.txt");
			
		quantidadeJogos = numerosJogos.size();
			
		for (int cont=0; cont < quantidadeJogos; cont++){
			numerosSeparados = organiza.SepararNumero(numerosJogos.get(cont));
			numerosConvertidos = converte.CoverteParaInteiro(numerosSeparados);	
			
			par = ContaPar(numerosConvertidos);
			inpar = ContaInpar(numerosConvertidos);
			
			if(par == 8){
				if(inpar == 7){
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
}
