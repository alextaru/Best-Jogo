package organizador;

import java.util.ArrayList;

public class OrganizaVariavel {

	public OrganizaVariavel() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> OrdenaArray(ArrayList<Integer> NumerosArray){
		
		int temp,tamanho;
		
		tamanho = NumerosArray.size();
		
		for(int cont = 0;cont<6;cont++){//colocar numeros em ordem crescente 
			for(int cont2 = cont+1;cont2 < tamanho;cont2++){
				if(NumerosArray.get(cont) > NumerosArray.get(cont2)){
					NumerosArray.add(cont, NumerosArray.get(cont2));
					NumerosArray.remove(cont2+1);
				}
			}
		}
		
		return NumerosArray;
	}

}
