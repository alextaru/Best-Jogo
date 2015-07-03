package txtFuncion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import converter.ConverterVariavel;
import organizador.Organiza;


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
		String arquivoIgual = null,data2;
		int tamanho;
		
		
		
		linhas = GravarTxt("arquivos/resutados.txt");
		
		tamanho = linhas.size();
			
		for (int cont = 0;cont<tamanho;cont++){//comparar se tem resultados igual
			
			data = linhas.get(cont).substring(0,10);
			
			numeros = converter.CoverteParaInteiro(organiza.SepararNumero(linhas.get(cont)));
						
			numeros = organiza.OrdenaArray(numeros);

			for (int cont2 = cont+1;cont2 < tamanho;cont2++){
			
				data2 = linhas.get(cont2).substring(0,10);
				
				numeros2 = converter.CoverteParaInteiro(organiza.SepararNumero(linhas.get(cont2)));  
							
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
}
			
 
	

