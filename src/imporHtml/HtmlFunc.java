package imporHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HtmlFunc {
	private String arquivo,condicao1;
	private int clear;
	
	public HtmlFunc() {
		arquivo = null;
		condicao1 = "td rowspan=\"1\"";
		clear = 0;
	}
	
	public void HtmlRead(){
		try{
			String linha,palavra;
			int inicio,fim,cont=0;
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			 
			BufferedReader file = new BufferedReader(new FileReader("//Users//alexandre//Documents//workspace//Best Jogo//arquivos//D_MEGA.html"));
			
			while(file.ready()){  
				   linha = file.readLine();
				   
				   inicio = linha.indexOf("<");
				   fim = linha.indexOf(">");
				   
				   if(inicio != -1){
					   palavra = linha.substring(inicio+1, fim);
					   
					   if ( palavra.equals(condicao1)){
						   inicio = fim;
						   fim = linha.lastIndexOf("<");
						   palavra = linha.substring(inicio+1, fim);
						   if (cont == 0){
							   try {
								  
								   java.util.Date dataJogo = null;
								   dataJogo = (java.util.Date)formato.parse(palavra);
								   if(clear == 0){
									   arquivo = palavra+" - ";
									   clear++;
								   }else
									   arquivo = arquivo+palavra+" - ";
								   
								   cont++;
								  
							   } catch(ParseException e) {
							
							   }
						   }else{
							   if(cont == 6){
								   arquivo = arquivo+palavra+"\n";
								   cont = 0;
							   }else{
								   arquivo = arquivo+palavra+" ";
								   cont++;
							   }
						   }
					   }
				   }
				}  
				file.close();
				System.out.println(arquivo);
		} catch (IOException ioe){
			ioe.printStackTrace();
		}

	}
	
	public void teste(){
		
	}
	
	public static void main (String[]args) {
		
		HtmlFunc html = new HtmlFunc(); 
		
		html.HtmlRead();
		
		
		
	}

}
