package Grafico;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Principal {

	private JFrame frame;

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
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 22);
		frame.getContentPane().add(menuBar);
		frame.setLocationRelativeTo(null);
		
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem mntmResultadosIguais = new JMenuItem("Resultados iguais");
		menu.add(mntmResultadosIguais);
		
		JMenuItem mntmPorcentagemPorPeriodo = new JMenuItem("Porcentagem por periodo");
		menu.add(mntmPorcentagemPorPeriodo);
		
		JSeparator separator = new JSeparator();
		menu.add(separator);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		menu.add(mntmSair);
		
		final JPanel panelIguais = new JPanel();
		panelIguais.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelIguais);
		panelIguais.setLayout(null);
		panelIguais.setVisible(false);
		
		final JPanel panelPorcentagem = new JPanel();
		panelPorcentagem.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelPorcentagem);
		panelPorcentagem.setLayout(null);
		panelPorcentagem.setVisible(false);
		
		final JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 22, 800, 556);
		frame.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblSelecioneOPeriodo = new JLabel("Selecione o periodo para mostrar a porcentagem de cada numero por sorteio");
		lblSelecioneOPeriodo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSelecioneOPeriodo.setBounds(113, 49, 573, 21);
		panelPorcentagem.add(lblSelecioneOPeriodo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos resultados", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setBounds(205, 95, 165, 27);
		panelPorcentagem.add(comboBox);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.setBounds(382, 94, 117, 29);
		panelPorcentagem.add(btnAnalizar);
		
		JList listPorcentagem = new JList();
		listPorcentagem.setBounds(6, 155, 788, 327);
		panelPorcentagem.add(listPorcentagem);
		
		JButton btnVoltarPorcentagem = new JButton("Voltar");
		btnVoltarPorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPorcentagem.setVisible(false);
				panelPrincipal.setVisible(true);
			}
		});
		btnVoltarPorcentagem.setBounds(6, 6, 93, 29);
		panelPorcentagem.add(btnVoltarPorcentagem);
		
		JLabel lblSena = new JLabel("Sena");
		lblSena.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSena.setBounds(100, 76, 61, 16);
		panelIguais.add(lblSena);
		
		JList listSena = new JList();
		listSena.setBounds(22, 104, 210, 400);
		panelIguais.add(listSena);
		
		JList listQuina = new JList();
		listQuina.setBounds(263, 104, 210, 400);
		panelIguais.add(listQuina);
		
		JList listQuadra = new JList();
		listQuadra.setBounds(519, 104, 210, 400);
		panelIguais.add(listQuadra);
		
		JLabel lblQuina = new JLabel("Quina");
		lblQuina.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuina.setBounds(342, 76, 61, 16);
		panelIguais.add(lblQuina);
		
		JLabel lblQuadra = new JLabel("Quadra");
		lblQuadra.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuadra.setBounds(601, 76, 61, 16);
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
		
		
		
		JButton btnResultadosIguais = new JButton("Resultados iguais");
		btnResultadosIguais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelIguais.setVisible(true);
				panelPrincipal.setVisible(false);
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
