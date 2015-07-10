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
import txtFuncion.Txt;

public class Principal {

	private JFrame frame;
	Txt txt = new Txt();
	ArrayList<String> sena = new ArrayList<String>();
	CalculoPorcentagem porcentagem = new CalculoPorcentagem();

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
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
		
		JLabel lblSelecioneOPeriodo = new JLabel("Selecione o periodo para mostrar a porcentagem de cada numero por sorteio");
		lblSelecioneOPeriodo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSelecioneOPeriodo.setBounds(113, 49, 573, 21);
		panelPorcentagem.add(lblSelecioneOPeriodo);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos resultados", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setBounds(205, 95, 165, 27);
		panelPorcentagem.add(comboBox);
		
		final JTextArea textAreaPorcentagem = new JTextArea();
		textAreaPorcentagem.setBounds(33, 155, 728, 305);
		panelPorcentagem.add(textAreaPorcentagem);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(comboBox.getSelectedIndex()){
					case 0:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/resultados.txt"));
						break;
					case 1:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes1.txt"));
						break;
					case 2:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes2.txt"));
						break;
					case 3:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes3.txt"));
						break;
					case 4:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes4.txt"));
						break;
					case 5:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes5.txt"));
						break;
					case 6:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes6.txt"));
						break;
					case 7:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes7.txt"));
						break;
					case 8:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes8.txt"));
						break;
					case 9:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes9.txt"));
						break;
					case 10:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes10.txt"));
						break;
					case 11:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes11.txt"));
						break;
					case 12:
						textAreaPorcentagem.setText(porcentagem.CalculoPorcentagemNumero("arquivos/mes12.txt"));
						break;
				}
			}
		});
		btnAnalizar.setBounds(382, 94, 117, 29);
		panelPorcentagem.add(btnAnalizar);
		
		final JPanel panelIguais = new JPanel();
		panelIguais.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelIguais);
		panelIguais.setLayout(null);
		panelIguais.setVisible(false);
		
		final JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
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
		
		final JTextArea textAreaSena = new JTextArea();
		textAreaSena.setBounds(17, 104, 235, 440);
		panelIguais.add(textAreaSena);
		
		JTextArea textAreaQuina = new JTextArea();
		textAreaQuina.setBounds(276, 104, 235, 440);
		panelIguais.add(textAreaQuina);
		
		JTextArea textAreaQuadra = new JTextArea();
		textAreaQuadra.setBounds(539, 104, 235, 440);
		panelIguais.add(textAreaQuadra);
		
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
				panelIguais.setVisible(true);
				panelPrincipal.setVisible(false);
				panelPorcentagem.setVisible(false);
				sena = txt.GravarTxt("arquivos/resulIgual.txt");
				textAreaSena.setText(sena.get(0));
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
		
		JButton btnResultadosIguais = new JButton("Resultados iguais");
		btnResultadosIguais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelIguais.setVisible(true);
				panelPrincipal.setVisible(false);
				sena = txt.GravarTxt("arquivos/resulIgual.txt");
				textAreaSena.setText(sena.get(0));
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
		
	}
}
