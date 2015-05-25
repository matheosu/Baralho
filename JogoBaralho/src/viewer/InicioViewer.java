package viewer;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.IController;
import controller.IControllerInicio;

public class InicioViewer extends JFrame implements IViewer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1977904968373613291L;
	private JPanel contentPane;
	private IControllerInicio ctrl;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioViewer frame = new InicioViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 * Create the frame.
	 */
	public InicioViewer(IControllerInicio c) {
		this.ctrl = c;
		setAlwaysOnTop(true);
		setTitle("Jogo de Baralho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblJogoDeBaralho = new JLabel("Jogo de Baralho");
		lblJogoDeBaralho.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblJogoDeBaralho.setHorizontalAlignment(SwingConstants.CENTER);
		lblJogoDeBaralho.setBounds(172, 21, 144, 22);
		contentPane.add(lblJogoDeBaralho);
		
		JButton btnIniciarJogo = new JButton("Iniciar Jogo");
		btnIniciarJogo.setBounds(192, 130, 117, 29);
		contentPane.add(btnIniciarJogo);
		
		JButton btnRegrasDoJogo = new JButton("Regras do Jogo");
		btnRegrasDoJogo.setBounds(184, 175, 132, 29);
		contentPane.add(btnRegrasDoJogo);
		
		JLabel lblCriadoPorMatheus = new JLabel("Criado por Matheus Castro");
		lblCriadoPorMatheus.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblCriadoPorMatheus.setBounds(354, 246, 122, 16);
		contentPane.add(lblCriadoPorMatheus);
		
		JTextPane txtpnEsseJogoFoi = new JTextPane();
		txtpnEsseJogoFoi.setEditable(false);
		txtpnEsseJogoFoi.setBackground(SystemColor.window);
		txtpnEsseJogoFoi.setText("Esse Jogo foi construído com a Estrutura de Dados Lista Duplamente Encadeada Circular.");
		txtpnEsseJogoFoi.setBounds(84, 55, 328, 38);
		contentPane.add(txtpnEsseJogoFoi);
		
		
		btnRegrasDoJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarRegras();
			}
		});
		
		btnIniciarJogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarJogo();
			}
		});
		
		setVisible(true);
	}

	@Override
	public IController getController() {
		return this.ctrl;
	}
}
