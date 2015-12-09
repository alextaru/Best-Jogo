package souces;

import java.util.ArrayList;

public class ConverterVariavel {

	public ConverterVariavel() {
		// TODO Auto-generated constructor stub
	}
	
	//funcao para converter String para inteiro
	public ArrayList<Integer> CoverteParaInteiro(ArrayList<String> numerosCoverter){
		int tamanhoArray;
		ArrayList<Integer> numerosConvertidos = new ArrayList<Integer>();
		
		tamanhoArray = numerosCoverter.size();
		
		for(int cont=0; cont < tamanhoArray; cont++){
			numerosConvertidos.add(Integer.parseInt(numerosCoverter.get(cont)));
		}
		
		return numerosConvertidos;
	}

}
