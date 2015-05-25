package viewer;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.IController;
import controller.IControllerRegras;

public class RegrasViewer extends JFrame implements IViewerRegras{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1430420376804327095L;
	private JPanel contentPane;
	private IControllerRegras ctrl;
	
	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegrasViewer frame = new RegrasViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 * Create the frame.
	 */
	public RegrasViewer(IControllerRegras c) {
		this.ctrl = c;
		setTitle("Jogo de Baralho - Regras do Jogo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblRegrasDoJogo = new JLabel("Regras do Jogo");
		lblRegrasDoJogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegrasDoJogo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblRegrasDoJogo.setBounds(284, 6, 131, 22);
		contentPane.add(lblRegrasDoJogo);
		
		JTextPane txtpnOJogoComeca = new JTextPane();
		txtpnOJogoComeca.setEditable(false);
		txtpnOJogoComeca.setText("O jogo começa com você e mais 9 jogadores aleatórios sentados numa roda, e um baralho no meio da roda contendo apenas as cartas 1, 3, 9 e 13(Dama).  As cartas são ilimitadas. \n\nA princípio o jogo segue no sentido horário, e escolhe uma carta aleatóriamente para o primeiro jogador. \n\nCada carta tem um significado, explicado abaixo:\n1 – Pula o próximo jogador.\r3 – Elimina o terceiro jogador contado a partir do jogador atual.\r9 – Elimina o jogador anterior na roda.\r13 – Inverte o sentido do jogo.\n\rDepois que é executado o que a carta tirada pede, passa a vez para o próximo jogador, no sentido em que estiver o jogo.\r\rO jogo termina quando só restar apenas 1 jogador.");
		txtpnOJogoComeca.setBounds(19, 40, 656, 384);
		contentPane.add(txtpnOJogoComeca);
		
		this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e){
				ctrl.terminar();
			 }
			 });
		
		setVisible(true);
	}

	@Override
	public IController getController() {
		return this.ctrl;
	}

}
