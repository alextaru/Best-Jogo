package txtFuncion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

import organizador.Organiza;


public class Txt {
	
	ArrayList<String> linhas = new ArrayList<String>();
	BufferedReader file;
	int inicio,fim;
	String data;
	int tamanho;
	Organiza organiza = new Organiza();
	
	
	
	

	public Txt() {
		linhas.clear();
		inicio = 0;
		fim = 0;
		file = null;
		data = null;
		tamanho = 0;
	}
	
	//retorna as linhas do arquivo txt em arrayList
	public ArrayList<String> GravarTxt(String arquivo){
		ArrayList<String> linhasArquivo = new ArrayList<String>();
		
		try {
			file = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao ler arquivo resutados.txt");
			e.printStackTrace();
		}
			
		try {
			while (file.ready()){//adiciona as linhas do arquivo em uma array
				linhasArquivo.add(file.readLine());
			}
		}catch (IOException e) {
			System.err.println("Erro ao gravar arquivo resutados.txt no array");
			e.printStackTrace();
		}
		
		return linhasArquivo;
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
			
 
	

