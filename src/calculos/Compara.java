package calculos;

import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import converter.ConverterVariavel;
import organizador.Organiza;
import txtFuncion.Txt;

public class Compara {

	public Compara() {
		// TODO Auto-generated constructor stub
	}
	
	public int ComparaJogos(ArrayList<Integer> jogo){
		Txt txt = new Txt();
		Organiza separar = new Organiza();
		ConverterVariavel converte = new ConverterVariavel();
		
		ArrayList<String> todosResultados = new ArrayList<String>();
		ArrayList<Integer> numerosJogo = new ArrayList<Integer>();
		int tamanho,tamanhoJogo,acertos = 0,resutado = 0;
		
		todosResultados = txt.GravarTxt("arquivos/resutados.txt");
		tamanho = todosResultados.size();
		
		for(int cont = 0; cont < tamanho; cont++){
			numerosJogo = converte.CoverteParaInteiro(separar.SepararNumero(todosResultados.get(cont)));
			
			tamanhoJogo = jogo.size();
			
			for(int cont2 = 0;cont2 < tamanhoJogo; cont2++){
				for(int cont3 = 0; cont3 < 6; cont3++){
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

}
