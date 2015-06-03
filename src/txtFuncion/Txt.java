package txtFuncion;

import imporHtml.HtmlFunc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Txt {
	private String resultados,linha,numj;
	int tamanho;
	private String[] numeros = new String[5];

	public Txt() {
		resultados = null;
		tamanho = 0;
		numj = null;
		
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
			BufferedReader file = null;
			int inicio,fim;
			
			try {
				file = new BufferedReader(new FileReader("arquivos/resutados.txt"));
			} catch (FileNotFoundException e) {
				System.err.println("Erro ao ler arquivo resutados.txt");
				e.printStackTrace();
			}
			
			try {
				for (int cont = 0;cont<1;cont++){
					while (file.ready()){
						linha = file.readLine();
					
						inicio = linha.indexOf("<");
						fim = linha.indexOf(">");
						
						numj = linha.substring(inicio + 1, fim);
						
						
						
					}
				}
			} catch (IOException e) {
				System.err.println("Erro ao gravar arquivo resutados.txt");
				e.printStackTrace();
			}
			
			
	}
	
	

}
