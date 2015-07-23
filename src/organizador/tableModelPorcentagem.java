package organizador;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class tableModelPorcentagem  extends AbstractTableModel{

	private ArrayList<Integer> numeros = new ArrayList<Integer>();
	private ArrayList<String> porcentagem = new ArrayList<String>();
	private String[] colunas = {"numeros","porcentagem"};
	
	public tableModelPorcentagem(){
		numeros.clear();
		porcentagem.clear();
	}
	
	public void AdicionaTabela(ArrayList<Integer> numero,ArrayList<String> porcent){
		numeros = numero;
		porcentagem = porcent;
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return this.numeros.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return null;
	}

}
