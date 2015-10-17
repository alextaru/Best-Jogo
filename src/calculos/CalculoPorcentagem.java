package calculos;

import java.util.ArrayList;

import organizador.Organiza;
import converter.ConverterVariavel;
import txtFuncion.Txt;

public class CalculoPorcentagem {
	Txt txt = new Txt();
	ConverterVariavel converte = new ConverterVariavel();
	Organiza organizar = new Organiza();
	
	ArrayList<String> numerosJogos = new ArrayList<String>();
	
	String numerosJuntos;
	
	
	public CalculoPorcentagem() {
		// TODO Auto-generated constructor stub
	}
	
	//calcula a porcentagem em que um numero sai em pereiodo
	public String CalculoPorcentagemNumero(String local){
	
		
		double quantidadeJogos,quantidadesNumeros,numerosIguais = 0;
		double porcentagem;
		int continua = 0,separador = 0;
		String arquivoPorcentagem = null;
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
	
	//compara a quantodade de minima de vezes que saiu 8 pares e 7 inpares
	public void Conta8par7inpar() {
		int par, inpar, quantidadeJogos, quantidadeNumeros;
		ArrayList<Integer> ficouSemSair = new ArrayList<Integer>();
		ArrayList<String> numerosSeparados = new ArrayList<String>();
		
		
		ficouSemSair.clear();
		numerosSeparados.clear();
		
		numerosJogos = txt.GravarTxt("arquivos/resutados.txt");
		
		quantidadeJogos = numerosJogos.size();
		
		for (int cont=0; cont < quantidadeJogos; cont++){
			numerosSeparados = organizar.SepararNumero(numerosJogos.get(cont));
		}
		
		
	}
}
