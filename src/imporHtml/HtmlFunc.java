package imporHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class HtmlFunc {

	public HtmlFunc() {
		// TODO Auto-generated constructor stub
	}
	
	public void HtmlRead(){
		try{
			String linha,palavra,condicao1;
			int inicio,fim,cont=0;
			
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			formato.setLenient(false);
			 
			condicao1 = "td rowspan=\"1\"";

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
								
								   System.out.println(palavra);
								   
								   cont++;
								  
							   } catch(ParseException e) {
							
							   }
						   }else{
							   System.out.println(palavra);
							   if(cont == 6)
								   cont = 0;
							   else
								   cont++;
						   }
					   }
				   }
				}  
				file.close(); 
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
