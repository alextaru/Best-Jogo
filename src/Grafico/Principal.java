package Grafico;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import calculos.CalculoPorcentagem;
import calculos.Compara;
import txtFuncion.Txt;

import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Principal {
	Txt txt = new Txt();
	private JFrame frame;
	
	ArrayList<String> sena = new ArrayList<String>();
	ArrayList<String> quina = new ArrayList<String>();
	ArrayList<String> quadra = new ArrayList<String>();
	CalculoPorcentagem porcentagem = new CalculoPorcentagem();
	int tamanho;
	String senaTexto, quinaTexto, quadraTexto;
	private JTable tablePorcentagem;

	public static void main(String[] args) {
		Compara comparacao = new Compara();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(34);
		numeros.add(36);
		numeros.add(47);
		numeros.add(51);
		numeros.add(54);
		numeros.add(56);
		
		int teste = comparacao.ComparaJogos(numeros);
		System.out.println(teste);
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		
	}

	public Principal() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel panelPorcentagem = new JPanel();
		panelPorcentagem.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelPorcentagem);
		panelPorcentagem.setLayout(null);
		panelPorcentagem.setVisible(false);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos resultados", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setBounds(205, 95, 165, 27);
		panelPorcentagem.add(comboBox);
		
		JLabel lblSelecioneOPeriodo = new JLabel("Selecione o periodo para mostrar a porcentagem de cada numero por sorteio");
		lblSelecioneOPeriodo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSelecioneOPeriodo.setBounds(113, 49, 573, 21);
		panelPorcentagem.add(lblSelecioneOPeriodo);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(comboBox.getSelectedIndex()){
					case 0:
						break;
					case 1:
						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						break;
					case 7:
						break;
					case 8:
						break;
					case 9:
						break;
					case 10:
						break;
					case 11:
						break;
					case 12:
						break;
				}
			}
		});
		btnAnalizar.setBounds(382, 94, 117, 29);
		panelPorcentagem.add(btnAnalizar);
		
		tablePorcentagem = new JTable();
		tablePorcentagem.setBounds(27, 536, 734, -390);
		panelPorcentagem.add(tablePorcentagem);
		
		final JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		final JPanel panelIguais = new JPanel();
		panelIguais.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelIguais);
		panelIguais.setLayout(null);
		panelIguais.setVisible(false);
		
		final JLabel lblSena = new JLabel("Sena");
		lblSena.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSena.setBounds(110, 76, 41, 16);
		panelIguais.add(lblSena);
		
		JButton btnVoltarPorcentagem = new JButton("Voltar");
		btnVoltarPorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPorcentagem.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});
		btnVoltarPorcentagem.setBounds(6, 6, 93, 29);
		panelPorcentagem.add(btnVoltarPorcentagem);
		
		
		final JTextArea textAreaSena = new JTextArea();
		textAreaSena.setBounds(17, 104, 235, 440);
		panelIguais.add(textAreaSena);
		
		final JTextArea textAreaQuina = new JTextArea();
		textAreaQuina.setBounds(276, 104, 235, 440);
		panelIguais.add(textAreaQuina);
		
		final JTextArea textAreaQuadra = new JTextArea();
		textAreaQuadra.setBounds(539, 104, 235, 440);
		panelIguais.add(textAreaQuadra);
		
		JButton btnResultadosIguais = new JButton("Resultados iguais");
		btnResultadosIguais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quadraTexto = null;
				
				panelIguais.setVisible(true);
				panelPrincipal.setVisible(false);
				
				sena = txt.GravarTxt("arquivos/resulIgual.txt");
				tamanho = sena.size();
				for(int cont = 0; cont < tamanho; cont++){
					textAreaSena.setText(sena.get(cont));
				}
				
				quina = txt.GravarTxt("arquivos/quina.txt");
				tamanho = quina.size();
				for(int cont = 0; cont < tamanho; cont++){
					textAreaQuina.setText(quina.get(cont));
				}
				
				quadra = txt.GravarTxt("arquivos/quadra.txt");
				tamanho = quadra.size();
				for(int cont = 0; cont < tamanho; cont++){
					if(quadraTexto == null)
						quadraTexto = quadra.get(cont);
					else
						quadraTexto = quadraTexto + "\n" + quadra.get(cont);
				}
				textAreaQuadra.setText(quadraTexto);
			}
		});
		btnResultadosIguais.setBounds(124, 106, 228, 53);
		panelPrincipal.add(btnResultadosIguais);
		
		JButton btnPorcentagemDeNumeros = new JButton("Porcentagem por perido");
		btnPorcentagemDeNumeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPorcentagem.setVisible(true);
				panelPrincipal.setVisible(false);
			}
		});
		btnPorcentagemDeNumeros.setBounds(429, 106, 228, 53);
		panelPrincipal.add(btnPorcentagemDeNumeros);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/alexandre/Documents/workspace/Best Jogo/arquivos/principal.jpg"));
		lblNewLabel.setBounds(0, 0, 800, 556);
		panelPrincipal.add(lblNewLabel);
		
		JLabel lblQuina = new JLabel("Quina");
		lblQuina.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuina.setBounds(368, 76, 44, 16);
		panelIguais.add(lblQuina);
		
		JLabel lblQuadra = new JLabel("Quadra");
		lblQuadra.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuadra.setBounds(631, 76, 53, 16);
		panelIguais.add(lblQuadra);
		
		JLabel lblResultadosSemelhantesComparando = new JLabel("Resultados semelhantes comparando todos os jogos j\u00E1 realizados ");
		lblResultadosSemelhantesComparando.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblResultadosSemelhantesComparando.setBounds(92, 30, 594, 22);
		panelIguais.add(lblResultadosSemelhantesComparando);
		
		JButton btnVoltarIguais = new JButton("Voltar");
		btnVoltarIguais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelIguais.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});
		btnVoltarIguais.setBounds(6, 6, 81, 29);
		panelIguais.add(btnVoltarIguais);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 22);
		frame.getContentPane().add(menuBar);
		frame.setLocationRelativeTo(null);
		
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem mntmPorcentagemPorPeriodo = new JMenuItem("Porcentagem por periodo");
		mntmPorcentagemPorPeriodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelIguais.setVisible(false);
				panelPorcentagem.setVisible(true);
				panelPrincipal.setVisible(false);
			}
		});
		menu.add(mntmPorcentagemPorPeriodo);
		
		JMenuItem mntmResultadosIguais = new JMenuItem("Resultados iguais");
		mntmResultadosIguais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quadraTexto = null;
				
				panelIguais.setVisible(true);
				panelPrincipal.setVisible(false);
				panelPorcentagem.setVisible(false);
				
				sena = txt.GravarTxt("arquivos/resulIgual.txt");
				tamanho = sena.size();
				for(int cont = 0; cont < tamanho; cont++){
					textAreaSena.setText(sena.get(cont));
				}
				
				quina = txt.GravarTxt("arquivos/quina.txt");
				tamanho = quina.size();
				for(int cont = 0; cont < tamanho; cont++){
					textAreaQuina.setText(quina.get(cont));
				}
				
				quadra = txt.GravarTxt("arquivos/quadra.txt");
				tamanho = quadra.size();
				for(int cont = 0; cont < tamanho; cont++){
					if(quadraTexto == null)
						quadraTexto = quadra.get(cont);
					else
						quadraTexto = quadraTexto + "\n" + quadra.get(cont);
				}
				textAreaQuadra.setText(quadraTexto);
			}
		});
		menu.add(mntmResultadosIguais);
		
		JSeparator separator = new JSeparator();
		menu.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(mntmSair);
		
	}
}
