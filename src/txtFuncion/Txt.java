package txtFuncion;

import imporHtml.HtmlFunc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Txt {
	private String resultados;
	private int tamanho;
	
	

	public Txt() {
		resultados = null;
		tamanho = 1;//numeros de linhas do arquivo
	}
	
	//gerar um txt com os jogos do arquivo html	
	public void TxtGerador(){
		HtmlFunc html = new HtmlFunc();
		
		resultados = html.HtmlRead();
		try {
			FileWriter txt = new FileWriter("arquivos/resutados.txt");//cria o arquivo txt
			PrintWriter gravarTxt = new PrintWriter(txt);
			gravarTxt.printf(resultados);//grava os resultados no arquivo
			txt.close();
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//acha resultados igual
	public void Igualdade(){
		int numeros[] = new int[6];
		int numeros2[] = new int[6];
		String temporario[] = new String[5];
		String arquivoIgual = null,numj,data1,data2;
		ArrayList<String> linhas = new ArrayList<String>();
		int temp;
		
		
		BufferedReader file = null;
		int inicio,fim;
			
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
		
		tamanho = linhas.size();
			
			
		for (int cont = 0;cont<tamanho;cont++){//comparar se tem resultados igual
			
			inicio = linhas.get(cont).indexOf("<");
			fim = linhas.get(cont).indexOf(">");
					
			numj = linhas.get(cont).substring(inicio + 1, fim);
			data1 = linhas.get(cont).substring(0,inicio);
						
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
										arquivoIgual = arquivoIgual + data1 + "-";
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
		System.out.println(arquivoIgual);
	}
}
			
 
	

