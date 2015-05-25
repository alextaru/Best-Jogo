package imporHtml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlFunc {

	public HtmlFunc() {
		// TODO Auto-generated constructor stub
	}
	
	public void HtmlRead(){
		try{
			BufferedReader file = new BufferedReader(new FileReader("//Users//alexandre//Documents//workspace//Best Jogo//arquivos//D_MEGA.html"));
			while(file.ready()){  
				   String linha = file.readLine();  
				   System.out.println(linha);  
				}  
				file.close(); 
		} catch (IOException ioe){
			ioe.printStackTrace();
		}

	}
	
	public static void main (String[]args){
		HtmlFunc html = new HtmlFunc(); 
		
		html.HtmlRead();
	}

}
