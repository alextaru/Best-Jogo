package txtFuncion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Txt {
	
	ArrayList<String> linhas = new ArrayList<String>();
	BufferedReader file;
	int inicio,fim;
	String data;
	int tamanho;
	
	

	public Txt() {
		linhas.clear();
		
		//adiciona as linhas ao arrayList
		try {
			file = new BufferedReader(new FileReader("arquivos/resutados.txt"));
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
		
		inicio = 0;
		fim = 0;
		file = null;
		data = null;
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
		System.out.println(mes1);
	}
	
	
	//acha resultados igual
	public void Igualdade(){
		int numeros[] = new int[6];
		int numeros2[] = new int[6];
		String temporario[] = new String[5];
		String arquivoIgual = null,numj,data2;
		int temp;
			
			
		for (int cont = 0;cont<tamanho;cont++){//comparar se tem resultados igual
			
			inicio = linhas.get(cont).indexOf("<");
			fim = linhas.get(cont).indexOf(">");
					
			numj = linhas.get(cont).substring(inicio + 1, fim);
			data = linhas.get(cont).substring(0,inicio);
						
			temporario = numj.split (Pattern.quote (";"));//pega todos os numros 
						
			for(int lin = 0;lin < 6;lin++){//para passar os numeros para inteiro
				numeros[lin] = Integer.parseInt(temporario[lin]);
			}
						
			for(int cont1 = 0;cont1<6;cont1++){//colocar numeros em ordem crescente 
				for(int cont3 = cont1+1;cont3<6;cont3++){
					if(numeros[cont1] > numeros[cont3]){
						temp = numeros[cont1];
						numeros[cont1] = numeros[cont3];
						numeros[cont3] = temp;
					}
				}
			}

			for (int cont2 = cont+1;cont2 < tamanho;cont2++){
			
				inicio = linhas.get(cont2).indexOf("<");
				fim = linhas.get(cont2).indexOf(">");
						
				numj = linhas.get(cont2).substring(inicio + 1, fim);
				data2 = linhas.get(cont2).substring(0,inicio);
							
				temporario = numj.split (Pattern.quote (";"));//pega todos os numros 
							
				for(int lin = 0;lin < 6;lin++){//para passar os numeros para inteiro
					numeros2[lin] = Integer.parseInt(temporario[lin]);
				}
							
				for(int cont1 = 0;cont1<6;cont1++){//colocar numeros em ordem crescente 
					for(int cont3 = cont1+1;cont3<6;cont3++){
						if(numeros2[cont1] > numeros2[cont3]){
							temp = numeros2[cont1];
							numeros2[cont1] = numeros2[cont3];
							numeros2[cont3] = temp;
						}
					}
				}
				
							
				//compara se o numero resutado Ž igual
				if(numeros[0] == numeros2[0]){
					if(numeros[1] == numeros2[1]){
						if(numeros[2] == numeros2[2]){
							if(numeros[3] == numeros2[3]){
								if(numeros[4] == numeros2[4]){
									if(numeros[5] == numeros2[5]){
										if(arquivoIgual == null){
											arquivoIgual = data + "-";
										}else
											arquivoIgual = arquivoIgual + data + "-";
										
										for(int cont4 = 0;cont4 < 6;cont4++){
											arquivoIgual = arquivoIgual + Integer.toString(numeros[cont4]) + " ";
										}
										arquivoIgual = arquivoIgual + "\n" + data2 + "-";
										for(int cont5 = 0;cont5 < 6;cont5++){
											arquivoIgual = arquivoIgual + Integer.toString(numeros2[cont5]) + " ";
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
}
			
 
	

