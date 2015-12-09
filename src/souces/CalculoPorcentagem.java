package souces;

import java.util.ArrayList;

public class CalculoPorcentagem {
	
	Organiza organizar = new Organiza();
	
	public CalculoPorcentagem() {
		// TODO Auto-generated constructor stub
	}
	
	//calcula a porcentagem em que um numero sai em pereiodo
	public String CalculoPorcentagemNumero(String local){
		Txt txt = new Txt();
		ConverterVariavel converte = new ConverterVariavel();
		
		ArrayList<String> numerosJogos = new ArrayList<String>();
		double quantidadeJogos,quantidadesNumeros,numerosIguais = 0, porcentagem;
		int continua = 0,separador = 0;
		String arquivoPorcentagem = null, numerosJuntos;
		ArrayList<Integer> numerosConvertidos = new ArrayList<Integer>();
		
		numerosJogos = txt.GravarTxt(local);
		quantidadeJogos = numerosJogos.size();
		
		for (int cont=0; cont < quantidadeJogos; cont++){
			numerosJuntos = numerosJogos.get(cont);
			numerosConvertidos.addAll(converte.CoverteParaInteiro(organizar.SepararNumero(numerosJuntos)));
			
		}
		
		numerosConvertidos = organizar.OrdenaArray(numerosConvertidos);
			
		quantidadesNumeros = numerosConvertidos.size();
		
		for(int cont = 1;cont < 61; cont++){
			for (int cont2 = continua;cont2 < (int)quantidadesNumeros; cont2++){
				if(cont == numerosConvertidos.get(cont2)){
					numerosIguais++;
					if(cont2 == (int)quantidadesNumeros-1){
						porcentagem = 100 * (numerosIguais / quantidadeJogos);
						arquivoPorcentagem = arquivoPorcentagem + "\t\t" + cont + "=" + (int) porcentagem + "% - " + numerosIguais;
					}
				}else{
					porcentagem = 100 * (numerosIguais / quantidadeJogos);
					if(arquivoPorcentagem == null){
						arquivoPorcentagem = "Quantidades de jogos " + (int) quantidadeJogos;
						arquivoPorcentagem = arquivoPorcentagem + "\n" + cont + "= " + (int) porcentagem + "% - " + numerosIguais;
						continua = cont2;
						numerosIguais = 0;
						break;
					}else{
						if(separador == 3){
							arquivoPorcentagem = arquivoPorcentagem + "\n" + cont + "= " + (int) porcentagem + "% - " + numerosIguais;
							numerosIguais = 0;
							continua = cont2;
							separador = 0;
						}else{
							arquivoPorcentagem = arquivoPorcentagem + "\t\t" + cont + "= " + (int) porcentagem + "% - " + numerosIguais;
							numerosIguais = 0;
							continua = cont2;
							separador++;
						}
						break;
					}
				}
			}
		}
		return arquivoPorcentagem;
	}
	
	
	//conta a quantidade de numeros repetidos de uma array
	public String NumerosRepetidos(ArrayList<Integer> numeros){
		String numContado = null;
		int numerosComparado, tamanho, quantidadeNumero = 0;
		
		numeros = organizar.OrdenaArray(numeros);
		tamanho = numeros.size();
		
		numerosComparado = numeros.get(0);
		for(int cont = 0; cont < tamanho; cont++){
			if(numerosComparado == numeros.get(cont)){
				quantidadeNumero++;
				if(cont == tamanho-1){
					numContado = numContado + numerosComparado + " = " + quantidadeNumero + "\n";
				}
			}else{
				if(numContado == null)
					numContado = numerosComparado + " = " + quantidadeNumero + "\n";
				else
					numContado = numContado + numerosComparado + " = " + quantidadeNumero + "\n";
				
				quantidadeNumero = 1;
				numerosComparado = numeros.get(cont);
			}
		}
		
		return numContado;
	}

}
