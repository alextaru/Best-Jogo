package souces;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HtmlFunc {
	private String arquivo, condicao1;// string arquivo � onde � gravado o arquivo organizado
	private int clear;

	public HtmlFunc() {
		arquivo = null;
		condicao1 = "td rowspan";
		clear = 0;
	}
	

	// criar um arquivo txt da mega com os resultados
	public void HtmlReadMega() {
		try {
			String linha, palavra;
			int inicio, fim, cont = 0;

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			
			BufferedReader file = new BufferedReader(new FileReader("src//htm//D_MEGA.htm"));

			// faz a leitura de todas as linha do arquivo html
			while (file.ready()) {
				linha = file.readLine();
				
				// procura na linha a palavra que esta entre os caracteres < e >
				inicio = linha.indexOf("<");
				fim = linha.indexOf(">");

				if (inicio != -1) {// correcao do erro quando nao acha os caracteres < e > retorna -1
					palavra = linha.substring(inicio + 1, fim);
					
					try {
						palavra = palavra.substring(0, 10);
					} catch (Exception e) {
					    palavra = "null";
					}

					/* compara a palavra achada se esta igual a condicao que
					 aparece antes da data no arquivo html*/
					if (palavra.equals(condicao1)) {
						
						inicio = fim;
						fim = linha.lastIndexOf("<");
						palavra = linha.substring(inicio + 1, fim);// pega a proxima palavra em os caracteres < e >
						if (cont == 0) {// cont para separar data de numeros dos jogos
							try {

								// testa se a palavra achada entre os caracteres � uma data
								java.util.Date dataJogo = null;
								dataJogo = (java.util.Date) formato.parse(palavra);
								if (clear == 0) {
									arquivo = palavra + "<";
									clear++;
								} else
									arquivo = arquivo + palavra +"<";

								cont++;

							} catch (ParseException e) {
							}
						} else {
							if (cont == 6) {
								arquivo = arquivo + palavra + ">\n";
								cont = 0;
							} else {
								arquivo = arquivo + palavra + ";";
								cont++;
							}
						}
					}
				}
			}
			file.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Txt gerartxt = new Txt();
		
		gerartxt.TxtGerador("src/txt/resutadosMega.txt", arquivo);

	}
	
	// criar um arquivo txt da lotofacil com os resultados
	public void HtmlReadLoto() {
		try {
			String linha, palavra;
			int inicio, fim, cont = 0;

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			
			BufferedReader file = new BufferedReader(new FileReader("src//htm//D_LOTFAC.HTM"));

			// faz a leitura de todas as linha do arquivo html
			while (file.ready()) {
				linha = file.readLine();
				
				// procura na linha a palavra que esta entre os caracteres < e >
				inicio = linha.indexOf("<");
				fim = linha.indexOf(">");

				if (inicio != -1) {// correcao do erro quando nao acha os caracteres < e > retorna -1
					palavra = linha.substring(inicio + 1, fim);
					
					try {
						palavra = palavra.substring(0, 10);
					} catch (Exception e) {
					    palavra = "null";
					}

					/* compara a palavra achada se esta igual a condicao que
					 aparece antes da data no arquivo html*/
					if (palavra.equals(condicao1)) {
						
						inicio = fim;
						fim = linha.lastIndexOf("<");
						palavra = linha.substring(inicio + 1, fim);// pega a proxima palavra em os caracteres < e >
						if (cont == 0) {// cont para separar data de numeros dos jogos
							try {

								// testa se a palavra achada entre os caracteres � uma data
								java.util.Date dataJogo = null;
								dataJogo = (java.util.Date) formato.parse(palavra);
								if (clear == 0) {
									arquivo = palavra + "<";
									clear++;
								} else
									arquivo = arquivo + palavra +"<";

								cont++;

							} catch (ParseException e) {
							}
						} else {
							if (cont == 15) {
								arquivo = arquivo + palavra + ">\n";
								cont = 0;
							} else {
								arquivo = arquivo + palavra + ";";
								cont++;
							}
						}
					}
				}
			}
			file.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		Txt gerartxt = new Txt();
		
		gerartxt.TxtGerador("src/txt/resutadosLoto.txt", arquivo);

	}


}
