package souces;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Organiza {

	public Organiza() {
		// TODO Auto-generated constructor stub
	}
	
	//organiza o ArrayList em ordem creceste
	public ArrayList<Integer> OrdenaArray(ArrayList<Integer> NumerosArray){
			
		int tamanho;
			
		tamanho = NumerosArray.size();
			
		for(int cont = 0;cont < tamanho;cont++){//colocar numeros em ordem crescente 
			for(int cont2 = cont+1;cont2 < tamanho;cont2++){
				if(NumerosArray.get(cont) > NumerosArray.get(cont2)){
					NumerosArray.add(cont, NumerosArray.get(cont2));
					NumerosArray.remove(cont2+1);
				}
			}
		}
				
		return NumerosArray;
	}
		
		
	//separa todos os resultados por mes
	public void MesSeparetor(){
		String mes1 = null,mes2 = null,mes3 = null,mes4 = null,mes5 = null,mes6 = null,mes7 = null,mes8 = null,mes9 = null,mes10 = null,mes11 = null,mes12 = null;
		String temp,data;
		ArrayList <String> linhasTemporario = new ArrayList<String>();
		int primeira,ultima,mes,tamanho,inicio,fim;
		Txt txt = new Txt();
			
		linhasTemporario = txt.GravarTxt("arquivos/resutados.txt");
		
		tamanho = linhasTemporario.size();
		
		for (int cont = 0;cont<tamanho;cont++){
			inicio = linhasTemporario.get(cont).indexOf("<");
			fim = linhasTemporario.get(cont).indexOf(">");
			data = linhasTemporario.get(cont).substring(0,inicio);
					
			primeira = data.indexOf("/");
			ultima = data.lastIndexOf("/");
					
			temp = data.substring(primeira+1,ultima);
					
			mes = Integer.parseInt(temp);
					
			switch(mes){//adicionar cada resultado em seu mes
				case 1:
					if(mes1 == null) 
						mes1 ="<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else	
						mes1 = mes1 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 2:
					if(mes2 == null)
						mes2 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes2 = mes2 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 3:
					if(mes3 == null)
						mes3 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) +  ">" + "\n";
					else
						mes3 = mes3 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 4:
					if(mes4 == null)
						mes4 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes4 = mes4 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 5:
					if(mes5 == null)
						mes5 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes5 = mes5 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 6:
					if(mes6 == null)
						mes6 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes6 = mes6 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 7:
					if(mes7 == null)
						mes7 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes7 = mes7 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 8:
					if(mes8 == null)
						mes8 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes8 = mes8 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 9:
					if(mes9 == null)
						mes9 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes9 = mes9 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 10:
					if(mes10 == null)
						mes10 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes10 = mes10 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 11:
					if(mes11 == null)
						mes11 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes11 = mes11 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
				case 12:
					if(mes12 == null)
						mes12 = "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					else
						mes12 = mes12 + "<" + linhasTemporario.get(cont).substring(inicio+1,fim) + ">" + "\n";
					break;
			}
				
		}
				
		//criando os arquivos com o conteudo do mes
		txt.TxtGerador("arquivos/mes1.txt",mes1);
		txt.TxtGerador("arquivos/mes2.txt",mes2);
		txt.TxtGerador("arquivos/mes3.txt",mes3);
		txt.TxtGerador("arquivos/mes4.txt",mes4);
		txt.TxtGerador("arquivos/mes5.txt",mes5);
		txt.TxtGerador("arquivos/mes6.txt",mes6);
		txt.TxtGerador("arquivos/mes7.txt",mes7);
		txt.TxtGerador("arquivos/mes8.txt",mes8);
		txt.TxtGerador("arquivos/mes9.txt",mes9);
		txt.TxtGerador("arquivos/mes10.txt",mes10);
		txt.TxtGerador("arquivos/mes11.txt",mes12);
		txt.TxtGerador("arquivos/mes12.txt",mes12);
	}
	
	//separa os numeros fornecendo a linha do arquivo
	public ArrayList<String> SepararNumero(String linha){
		int inicio,fim,tamanho;
		String numerosJuntos;
		String[] numerosSeparados;
		ArrayList<String> numeros = new ArrayList<String>();
		
		inicio = linha.indexOf("<");
		fim = linha.indexOf(">");
				
		numerosJuntos = linha.substring(inicio + 1, fim);
					
		numerosSeparados = numerosJuntos.split (Pattern.quote (";"));//pega todos os numros 
					
		tamanho = numerosSeparados.length;
		
		for(int lin = 0;lin < tamanho;lin++){//para passar os numeros para inteiro
			numeros.add(numerosSeparados[lin]);
		}
		
		return numeros;
	}
}
