package imporHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HtmlFunc {
	private String arquivo, condicao1,erro;// string arquivo Ž onde Ž gravado o arquivo organizado
	private int clear,tamanho;

	public HtmlFunc() {
		arquivo = null;
		condicao1 = "td rowspan=\"1\"";
		clear = 0;
		erro = null;
		tamanho = 0;
	}
	

	// funcao para ler o arquivo html e organizar apenas as datas e resutador em
	// uma unica string
	public String HtmlRead() {
		try {
			String linha, palavra;
			int inicio, fim, cont = 0;

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			
			BufferedReader file = new BufferedReader(new FileReader("//Users//alexandre//Documents//workspace//Best Jogo//arquivos//D_MEGA.html"));

			// faz a leitura de todas as linha do arquivo html
			while (file.ready()) {
				linha = file.readLine();
				
				// procura na linha a palavra que esta entre os caracteres < e >
				inicio = linha.indexOf("<");
				fim = linha.indexOf(">");

				if (inicio != -1) {// correcao do erro quando nao acha os caracteres < e > retorna -1
					palavra = linha.substring(inicio + 1, fim);

					/* compara a palavra achada se esta igual a condicao que
					 aparece antes da data no arquivo html*/
					if (palavra.equals(condicao1)) {
						
						inicio = fim;
						fim = linha.lastIndexOf("<");
						palavra = linha.substring(inicio + 1, fim);// pega a proxima palavra em os caracteres < e >
						if (cont == 0) {// cont para separar data de numeros dos jogos
							try {

								// testa se a palavra achada entre os caracteres Ž uma data
								java.util.Date dataJogo = null;
								dataJogo = (java.util.Date) formato.parse(palavra);
								tamanho++;
								if (clear == 0) {
									arquivo = palavra + "<";
									clear++;
								} else
									arquivo = arquivo + palavra +"<";

								cont++;

							} catch (ParseException e) {
								erro = "data nao encontrada!";
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
			return arquivo;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			erro = "erro ao ler o arquivo!";
			return "erro";
		}

	}
	
	//retorna a quantidade de linhas do arquivo
	public int TamLinhas(){
		tamanho++;
		return tamanho;
	}

}
