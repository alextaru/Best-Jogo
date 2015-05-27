package txtFuncion;

import imporHtml.HtmlFunc;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Txt {
	String resultados;

	public Txt() {
		resultados = null;
	}
	
		
	public void TxtGerador(){
		HtmlFunc html = new HtmlFunc();
		
		resultados = html.HtmlRead();
		try {
			FileWriter txt = new FileWriter("arquivos/resutados.txt");
			PrintWriter gravarTxt = new PrintWriter(txt);
			gravarTxt.printf(resultados);
			txt.close();
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
