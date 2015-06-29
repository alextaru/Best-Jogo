package txtFuncion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import organizador.OrganizaVariavel;


public class Txt {
	
	ArrayList<String> linhas = new ArrayList<String>();
	BufferedReader file;
	int inicio,fim;
	String data;
	int tamanho;
	OrganizaVariavel organiza = new OrganizaVariavel();
	
	
	
	

	public Txt() {
		linhas.clear();
		inicio = 0;
		fim = 0;
		file = null;
		data = null;
		tamanho = 0;
	}
	
	//adiciona as linhas do arquivo txt ao arrayList
	public void GravarTxt(String arquivo){
		
		try {
			file = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao ler arquivo resutados.txt");
			e.printStackTrace();
		}
			
		try {
			while (file.ready()){//adiciona as linhas do arquivo em uma array
				linhas.add(file.readLine());
			}
		}catch (IOException e) {
			System.err.println("Erro ao gravar arquivo resutados.txt no array");
			e.printStackTrace();
		}
		
		tamanho = linhas.size();
	}
	
	//gerar um txt com os jogos do arquivo html	
	public void TxtGerador(String local, String conteudo){
		try {
			FileWriter txt = new FileWriter(local);//cria o arquivo txt
			PrintWriter gravarTxt = new PrintWriter(txt);
			gravarTxt.printf(conteudo);//grava os resultados no arquivo
			txt.close();
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//separa todos os resultados por mes
	public void MesSeparetor(){
		String mes1 = null,mes2 = null,mes3 = null,mes4 = null,mes5 = null,mes6 = null,mes7 = null,mes8 = null,mes9 = null,mes10 = null,mes11 = null,mes12 = null;
		String temp;
		int primeira,ultima,mes;
		
		GravarTxt("arquivos/resutados.txt");
		
		for (int cont = 0;cont<tamanho;cont++){
			inicio = linhas.get(cont).indexOf("<");
			fim = linhas.get(cont).indexOf(">");
			data = linhas.get(cont).substring(0,inicio);
			
			primeira = data.indexOf("/");
			ultima = data.lastIndexOf("/");
			
			temp = data.substring(primeira+1,ultima);
			
			mes = Integer.parseInt(temp);
			
			switch(mes){//adicionar cada resultado em seu mes
				case 1:
					if(mes1 == null) 
						mes1 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else	
						mes1 = mes1 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 2:
					if(mes2 == null)
						mes2 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes2 = mes2 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 3:
					if(mes3 == null)
						mes3 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes3 = mes3 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 4:
					if(mes4 == null)
						mes4 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes4 = mes4 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 5:
					if(mes5 == null)
						mes5 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes5 = mes5 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 6:
					if(mes6 == null)
						mes6 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes6 = mes6 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 7:
					if(mes7 == null)
						mes7 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes7 = mes7 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 8:
					if(mes8 == null)
						mes8 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes8 = mes8 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 9:
					if(mes9 == null)
						mes9 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes9 = mes9 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 10:
					if(mes10 == null)
						mes10 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes10 = mes10 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 11:
					if(mes11 == null)
						mes11 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes11 = mes11 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;
				case 12:
					if(mes12 == null)
						mes12 = linhas.get(cont).substring(inicio+1,fim) + "\n";
					else
						mes12 = mes12 + linhas.get(cont).substring(inicio+1,fim) + "\n";
					break;

			}
			
		}
		
		//criando os arquivos com o conteudo do mes
		TxtGerador("arquivos/mes1.txt",mes1);
		TxtGerador("arquivos/mes2.txt",mes2);
		TxtGerador("arquivos/mes3.txt",mes3);
		TxtGerador("arquivos/mes4.txt",mes4);
		TxtGerador("arquivos/mes5.txt",mes5);
		TxtGerador("arquivos/mes6.txt",mes6);
		TxtGerador("arquivos/mes7.txt",mes7);
		TxtGerador("arquivos/mes8.txt",mes8);
		TxtGerador("arquivos/mes9.txt",mes9);
		TxtGerador("arquivos/mes10.txt",mes10);
		TxtGerador("arquivos/mes11.txt",mes12);
		TxtGerador("arquivos/mes12.txt",mes12);
	}
	
	
	//acha resultados igual
	public void Igualdade(){
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		ArrayList<Integer> numeros2 = new ArrayList<Integer>();
		String temporario[] = new String[5];
		String arquivoIgual = null,numj,data2;
		int temp;
		
		GravarTxt("arquivos/resutados.txt");	
			
		for (int cont = 0;cont<tamanho;cont++){//comparar se tem resultados igual
			
			inicio = linhas.get(cont).indexOf("<");
			fim = linhas.get(cont).indexOf(">");
					
			numj = linhas.get(cont).substring(inicio + 1, fim);
			data = linhas.get(cont).substring(0,inicio);
						
			temporario = numj.split (Pattern.quote (";"));//pega todos os numros 
						
			for(int lin = 0;lin < 6;lin++){//para passar os numeros para inteiro
				numeros.add(Integer.parseInt(temporario[lin]));
			}
						
			numeros = organiza.OrdenaArray(numeros);

			for (int cont2 = cont+1;cont2 < tamanho;cont2++){
			
				inicio = linhas.get(cont2).indexOf("<");
				fim = linhas.get(cont2).indexOf(">");
						
				numj = linhas.get(cont2).substring(inicio + 1, fim);
				data2 = linhas.get(cont2).substring(0,inicio);
							
				temporario = numj.split (Pattern.quote (";"));//pega todos os numros 
							
				for(int lin = 0;lin < 6;lin++){//para passar os numeros para inteiro
					numeros2.add(Integer.parseInt(temporario[lin]));
				}
							
				numeros2 = organiza.OrdenaArray(numeros2);
				
							
				//compara se o numero resutado Ž igual
				if(numeros.get(0) == numeros2.get(0)){
					if(numeros.get(1) == numeros2.get(1)){
						if(numeros.get(2) == numeros2.get(2)){
							if(numeros.get(3) == numeros2.get(3)){
								if(numeros.get(4) == numeros2.get(4)){
									if(numeros.get(5) == numeros2.get(5)){
										if(arquivoIgual == null){
											arquivoIgual = data + "-";
										}else
											arquivoIgual = arquivoIgual + data + "-";
										
										for(int cont4 = 0;cont4 < 6;cont4++){
											arquivoIgual = arquivoIgual + Integer.toString(numeros.get(cont4)) + " ";
										}
										arquivoIgual = arquivoIgual + "\n" + data2 + "-";
										for(int cont5 = 0;cont5 < 6;cont5++){
											arquivoIgual = arquivoIgual + Integer.toString(numeros2.get(cont5)) + " ";
										}
										arquivoIgual = arquivoIgual + "\n";
									}
								}
							}
						}
					}
				}
			}
		}
		if(arquivoIgual == null){
			arquivoIgual = "N‹o a resultado identico!";
		}
		
		TxtGerador("arquivos/resulIgual.txt",arquivoIgual);
	}
	
	public void CalculoPorcentagem(/*String local*/){
		
		ArrayList<Integer> numeroMes = new ArrayList<Integer>();
		ArrayList<Integer> numerMes = new ArrayList<Integer>();
		
		numeroMes.add(1);
		
		numerMes = numeroMes;
		numeroMes.add(2);
		
		
		//GravarTxt(local);//gravar os resultados no arrayList
		
		
	}
}
			
 
	

