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
		tamanho = html.TamLinhas();
		try {
			FileWriter txt = new FileWriter("arquivos/resutados.txt");//cria o arquivo txt
			PrintWriter gravarTxt = new PrintWriter(txt);
			gravarTxt.printf(tamanho+"\n"+resultados);//grava os resultados no arquivo
			txt.close();
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//acha resultados igual
	public void Igualdade(){
		String temporario[] = new String[5];
		int numeros[] = new int[5];
		int numeros2[] = new int[5];
		String linha,numj,data1 = null,data2,arquivoIgual = null;
		int nlinha = 0,temp;//linha que esta comparando
		
		BufferedReader file = null;
		int inicio,fim;
			
		try {
			file = new BufferedReader(new FileReader("arquivos/resutados.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao ler arquivo resutados.txt");
			e.printStackTrace();
		}
	
		try {
			for (int cont = 0;cont<tamanho;cont++){//comparar linha por linha
				while (file.ready()){
					if(cont == 0){//pega o numeros de linhas do arquivo
						linha = file.readLine();
						tamanho = Integer.parseInt(linha);
						cont++;
						nlinha++;
					}else{
						
						if(cont == nlinha){//quarda a linha para comparar com as outras
							
							linha = file.readLine();
					
							inicio = linha.indexOf("<");
							fim = linha.indexOf(">");
						
							numj = linha.substring(inicio + 1, fim);
							data1 = linha.substring(0,inicio);
							
							temporario = numj.split (Pattern.quote (";"));//pega todos os numros 
							
							for(int lin = 0;lin < 5;lin++){//para passar os numeros para inteiro
								numeros[lin] = Integer.parseInt(temporario[lin]);
							}
							
							for(int cont1 = 0;cont1<5;cont1++){//colocar numeros em ordem crescente 
								for(int cont2 = cont1+1;cont2<5;cont2++){
									if(numeros[cont1] > numeros[cont2]){
										temp = numeros[cont1];
										numeros[cont1] = numeros[cont2];
										numeros[cont2] = temp;
									}
								}
							}
							nlinha++;
								
						}else if(cont < nlinha){//pega proxima linha para comparar
							linha = file.readLine();
							
							inicio = linha.indexOf("<");
							fim = linha.indexOf(">");
						
							numj = linha.substring(inicio + 1, fim);
							data2 = linha.substring(0,inicio);
							
							temporario = numj.split (Pattern.quote (";"));
							
							for(int lin = 0;lin < 5;lin++){//para passar os numeros para inteiro
								numeros2[lin] = Integer.parseInt(temporario[lin]);
							}
							
							for(int cont1 = 0;cont1<5;cont1++){//colocar numeros em ordem crescente 
								for(int cont2 = cont1+1;cont2<5;cont2++){
									if(numeros2[cont1] > numeros2[cont2]){
										temp = numeros2[cont1];
										numeros2[cont1] = numeros2[cont2];
										numeros2[cont2] = temp;
									}
								}
							}
							
							//compara se o numero resutado Ž igual
							if(numeros[0] == numeros2[0]){
								if(numeros[1] == numeros2[1]){
									if(numeros[2] == numeros2[2]){
										if(numeros[3] == numeros2[3]){
											if(numeros[4] == numeros2[4]){
												arquivoIgual = arquivoIgual + data1 + "-";
												for(cont = 0;cont < 5;cont++){
													arquivoIgual = arquivoIgual + Integer.toString(numeros[cont]) + " ";
												}
												arquivoIgual = arquivoIgual + "\n" + data2 + "-";
												for(cont = 0;cont < 5;cont++){
													arquivoIgual = arquivoIgual + Integer.toString(numeros2[cont]) + " ";
												}
											}
										}
									}
								}
							}
							nlinha++;
						}else{//nao faz nada apenas passa para proxima linha
							if(cont>nlinha)
								nlinha = 0;
							else
								nlinha++;
						}
					}
				}
			}
			
		} catch (IOException e) {
			System.err.println("Erro ao gravar arquivo resutados.txt");
			e.printStackTrace();
		}	
	}
}
