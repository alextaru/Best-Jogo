package Grafico;

import imporHtml.HtmlFunc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;

import txtFuncion.Txt;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Txt txt = new Txt();
		//HtmlFunc html = new HtmlFunc();
		
		//html.HtmlRead();
		
		//txt.Igualdade();
		
		txt.MesSeparetor();
		
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

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 28);
		frame.getContentPane().add(menuBar);
		
		JMenu analizar = new JMenu("Analizar Jogo");
		menuBar.add(analizar);
		
		JMenuItem mntmResultadosIgual = new JMenuItem("resultados Igual");
		
		analizar.add(mntmResultadosIgual);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);
		
		
		final JLayeredPane IgualdadePane = new JLayeredPane();
		IgualdadePane.setBounds(0, 28, 800,550);
		frame.getContentPane().add(IgualdadePane);
		
		final JRadioButton rdbtnTodosOsResultados = new JRadioButton("todos os resultados");
		rdbtnTodosOsResultados.setBounds(35, 62, 157, 23);
		IgualdadePane.add(rdbtnTodosOsResultados);
		
		JLabel lblMarqueAbaixoO = new JLabel("Marque abaixo o periodo que voce deseja fazer a comparacao.");
		lblMarqueAbaixoO.setBounds(177, 17, 435, 16);
		IgualdadePane.add(lblMarqueAbaixoO);
		
		final JTextArea textAreaResult = new JTextArea();
		textAreaResult.setBounds(0, 112, 800, 438);
		IgualdadePane.add(textAreaResult);
		IgualdadePane.setVisible(false);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnTodosOsResultados.isSelected()){
					BufferedReader file = null;
					
					try {
						file = new BufferedReader(new FileReader("arquivos/resulIgual.txt"));
					} catch (FileNotFoundException e1) {
						System.err.println("Erro ao ler arquivo resulIgual.txt");
						e1.printStackTrace();
					}
					
					try {
						while (file.ready()){//adiciona as linhas do arquivo em uma array
							textAreaResult.append(file.readLine());
							textAreaResult.append("\n");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnBuscar.setBounds(215, 61, 117, 29);
		IgualdadePane.add(btnBuscar);
		
		mntmResultadosIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IgualdadePane.setVisible(true);
			}
		});
		
	}
}
