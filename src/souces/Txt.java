package souces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Txt {
	
	ArrayList<String> linhas = new ArrayList<String>();
	BufferedReader file;
	int inicio,fim;
	String data;
	Organiza organiza = new Organiza();
	ConverterVariavel converter = new ConverterVariavel();
	
	
	
	

	public Txt() {
		linhas.clear();
		inicio = 0;
		fim = 0;
		file = null;
		data = null;
	}
	
	//retorna as linhas do arquivo txt em arrayList
	public ArrayList<String> GravarTxt(String arquivo){
		
		linhas.clear();
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
		
		return linhas;
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
		String arquivoIgual = null,data2, quinze = null, quatorze = null, treze = null,doze = null,onze = null;
		int tamanho,acertos = 0;
		
		linhas = GravarTxt("arquivos/resutadosLoto.txt");
		
		tamanho = linhas.size();
			
		for (int cont = 0;cont<tamanho;cont++){//comparar se tem resultados igual
			
			data = linhas.get(cont).substring(0,10);
			
			numeros = converter.CoverteParaInteiro(organiza.SepararNumero(linhas.get(cont)));
						
			numeros = organiza.OrdenaArray(numeros);

			for (int cont2 = cont+1;cont2 < tamanho;cont2++){
			
				data2 = linhas.get(cont2).substring(0,10);
				
				numeros2 = converter.CoverteParaInteiro(organiza.SepararNumero(linhas.get(cont2)));  
							
				numeros2 = organiza.OrdenaArray(numeros2);
				
				//compara se o numero resutado � igual
				if(numeros.get(0) == numeros2.get(0)){
					if(numeros.get(1) == numeros2.get(1)){
						if(numeros.get(2) == numeros2.get(2)){
							if(numeros.get(3) == numeros2.get(3)){
								if(numeros.get(4) == numeros2.get(4)){
									if(numeros.get(5) == numeros2.get(5)){
										if(numeros.get(6) == numeros2.get(6)){
											if(numeros.get(7) == numeros2.get(7)){
												if(numeros.get(8) == numeros2.get(8)){
													if(numeros.get(9) == numeros2.get(9)){
														if(numeros.get(10) == numeros2.get(10)){
															if(numeros.get(11) == numeros2.get(11)){
																if(numeros.get(12) == numeros2.get(12)){
																	if(numeros.get(13) == numeros2.get(13)){
																		if(numeros.get(14) == numeros2.get(14)){
																			if(quinze == null){
																				quinze = data + "-";
																			}else
																				quinze = quinze + data + "-";
																			for(int cont6 = 0;cont6 < 15;cont6++){
																				quinze = quinze + Integer.toString(numeros.get(cont6)) + " ";
																			}
																			quinze = quinze + "\n" + data2 + "-";
																			for(int cont7 = 0;cont7 < 15;cont7++){
																				quinze = quinze + Integer.toString(numeros2.get(cont7)) + " ";
																			}
																			quinze = quinze + "\n";
																		}else{
																			if(quatorze == null){
																				quatorze = data + "-";
																			}else
																				quatorze = quatorze + data + "-";
																			for(int cont6 = 0;cont6 < 14;cont6++){
																				quatorze = quatorze + Integer.toString(numeros.get(cont6)) + " ";
																			}
																			quatorze = quatorze + "\n" + data2 + "-";
																			for(int cont7 = 0;cont7 < 14;cont7++){
																				quatorze = quatorze + Integer.toString(numeros2.get(cont7)) + " ";
																			}
																			quatorze = quatorze + "\n";
																		}
																	}else{
																		if(treze == null){
																			treze = data + "-";
																		}else
																			treze = treze + data + "-";
																		for(int cont6 = 0;cont6 < 13;cont6++){
																			treze = treze + Integer.toString(numeros.get(cont6)) + " ";
																		}
																		doze = doze + "\n" + data2 + "-";
																		for(int cont7 = 0;cont7 < 13;cont7++){
																			treze = treze + Integer.toString(numeros2.get(cont7)) + " ";
																		}
																		treze = treze + "\n";
																	}
																}else{
																	if(doze == null){
																		doze = data + "-";
																	}else
																		doze = doze + data + "-";
																	for(int cont6 = 0;cont6 < 12;cont6++){
																		doze = doze + Integer.toString(numeros.get(cont6)) + " ";
																	}
																	doze = doze + "\n" + data2 + "-";
																	for(int cont7 = 0;cont7 < 12;cont7++){
																		doze = doze + Integer.toString(numeros2.get(cont7)) + " ";
																	}
																	doze = doze + "\n";
																}
															}else{
																if(onze == null){
																onze = data + "-";
																}else
																	onze = onze + data + "-";
																for(int cont8 = 0;cont8 < 11;cont8++){
																	onze = onze + Integer.toString(numeros.get(cont8)) + " ";
																}
																onze = onze + "\n" + data2 + "-";
															
																for(int cont9 = 0;cont9 < 11;cont9++){
																	onze = onze + Integer.toString(numeros2.get(cont9)) + " ";
																}
																onze = onze + "\n";
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if(onze == null){
			onze = "N�o a resultado identico!";
		}
		if(doze == null){
			doze = "N�o a resultado identico!";
		}
		if(treze == null){
			treze = "N�o a resultado identico!";
		}
		if(quatorze == null){
			quatorze = "N�o a resultado identico!";
		}
		if(quinze == null){
			quinze = "N�o a resultado identico!";
		}
		
		TxtGerador("arquivos/onze.txt",onze);
		
		TxtGerador("arquivos/doze.txt",doze);
		
		TxtGerador("arquivos/treze.txt",treze);
		
		TxtGerador("arquivos/quatorze.txt",quatorze);
		
		TxtGerador("arquivos/quinze.txt",quinze);
	}
}
			
 
	

