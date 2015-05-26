package viewer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import model.Carta;
import model.Jogador;
import pilhaEncadeada.Pilha;
import controller.IController;
import controller.IControllerJogo;

public class JogoViewer extends JFrame implements IViewerJogo{

	private static final long serialVersionUID = -3376873223392399044L;
	
	/* Caminho Dos Arquivos */
	private static final String URL_RESOURCES = "resources/";
	private static final String PATH_META_INF = URL_RESOURCES + "META-INF/";
	private static final String PATH_IMG = PATH_META_INF + "img/";
	private static final String PATH_CARTAS = PATH_IMG + "cartas/";
	private static final String PATH_3 = PATH_CARTAS + "3/";
	private static final String PATH_9 = PATH_CARTAS + "9/";
	private static final String PATH_AS = PATH_CARTAS + "As/";
	private static final String PATH_K = PATH_CARTAS + "k/";
	
	
	/* Nome das imagens */
	private static final String TABLE_FILE_IMG = PATH_IMG + "table.png";
	private static final String PROFILE_FILE_IMG = PATH_IMG + "profile.png";
	private static final String VEZ_FILE_IMG = PATH_IMG + "vez.png";
	private static final String COPAS = "copas.png";
	private static final String ESPADAS = "espadas.png";
	private static final String OUROS = "ouros.png";
	private static final String PAUS = "paus.png";
	
	/* Imagens */
	private static final ImageIcon TABLE_IMG = new ImageIcon(TABLE_FILE_IMG);
	private static final ImageIcon PROFILE_IMG = new ImageIcon(PROFILE_FILE_IMG);
	private static final ImageIcon VEZ_IMG = new ImageIcon(VEZ_FILE_IMG);
	private static final ImageIcon[] cartas_As = {new ImageIcon(PATH_AS + "As" + COPAS),new ImageIcon(PATH_AS + "As" + ESPADAS),new ImageIcon(PATH_AS + "As" + OUROS),new ImageIcon(PATH_AS + "As" + PAUS)};
	private static final ImageIcon[] cartas_3 = {new ImageIcon(PATH_3 + "3" + COPAS),new ImageIcon(PATH_3 + "3" + ESPADAS),new ImageIcon(PATH_3 + "3" + OUROS),new ImageIcon(PATH_3 + "3" + PAUS)};
	private static final ImageIcon[] cartas_9 = {new ImageIcon(PATH_9 + "9" + COPAS),new ImageIcon(PATH_9 + "9" + ESPADAS),new ImageIcon(PATH_9 + "9" + OUROS),new ImageIcon(PATH_9 + "9" + PAUS)};
	private static final ImageIcon[] cartas_K = {new ImageIcon(PATH_K + "K" + COPAS),new ImageIcon(PATH_K + "K" + ESPADAS),new ImageIcon(PATH_K + "K" + OUROS),new ImageIcon(PATH_K + "K" + PAUS)};
	
	/* Panel e String do  Histórico do Jogo */
	private JTextPane txtpnjogo = new JTextPane();
	private StringBuilder historico = new StringBuilder("");
	/* Profile 1 */
	private JLabel profile1 = new JLabel("");
	private JLabel lblJogador1 = new JLabel("<Jogador 1>");
	
	/* Profile 2 */
	private JLabel profile2 = new JLabel("");
	private JLabel lblJogador2 = new JLabel("<Jogador 2>");
	
	/* Profile 3 */
	private JLabel profile3 = new JLabel("");
	private JLabel lblJogador3 = new JLabel("<Jogador 3>");
	
	/* Profile 4 */
	private JLabel profile4 = new JLabel("");
	private JLabel lblJogador4 = new JLabel("<Jogador 4>");
	
	/* Profile 5 */
	private JLabel profile5 = new JLabel("");
	private JLabel lblJogador5 = new JLabel("<Jogador 5>");
	
	/* Profile 6 */
	private JLabel profile6 = new JLabel("");
	private JLabel lblJogador6 = new JLabel("<Jogador 6>");
	
	/* Profile 7 */
	private JLabel profile7 = new JLabel("");
	private JLabel lblJogador7 = new JLabel("<Jogador 7>");
	
	/* Profile 8 */
	private JLabel profile8 = new JLabel("");
	private JLabel lblJogador8 = new JLabel("<Jogador 8>");
	
	/* Profile 9 */
	private JLabel profile9 = new JLabel("");
	private JLabel lblJogador9 = new JLabel("<Jogador 9>");
	
	/* Profile 10 */
	private JLabel profile10 = new JLabel("");
	private JLabel lblJogador10 = new JLabel("<Jogador 10>");
	
	/* Imagem que representa a vez do Jogaodr */
	private JLabel vez = new JLabel("Vez");
	
	
	/* Carta */
	private JLabel carta = new JLabel("");
	
	/* Button Recomeçar */
	private JButton recomecar = new JButton("Recomeçar");
	
	private JLabel[] profiles = {profile1,profile2,profile3,profile4,profile5,profile6,profile7,profile8,profile9,profile10};
	private JLabel[] lbljogadores = {lblJogador1,lblJogador2,lblJogador3,lblJogador4,lblJogador5,lblJogador6,lblJogador7,lblJogador8,lblJogador9,lblJogador10};
	
	private JPanel contentPane;
	private IControllerJogo ctrl; 
	
	
	public JogoViewer(IControllerJogo c) {
		this.ctrl = c;
		setTitle("Jogo de Baralho");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		vez.setBounds(0,0, 16, 16);
		vez.setIcon(VEZ_IMG);
		vez.setVisible(false);
		contentPane.add(vez);
		
		JLabel lblHistricoDoJogo = new JLabel("Histórico do Jogo");
		lblHistricoDoJogo.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblHistricoDoJogo.setBounds(6, 384, 114, 16);
		contentPane.add(lblHistricoDoJogo);
		
		txtpnjogo.setEditable(false);
		txtpnjogo.setText(historico.toString());
		txtpnjogo.setBounds(6, 412, 448, 160);
		txtpnjogo.setVisible(true);
		JScrollPane scroll = new JScrollPane(txtpnjogo);
		scroll.setBounds(6, 412, 448, 160);
		scroll.setVisible(true);
		contentPane.add(scroll);
		
		
		recomecar.setBounds(550, 520, 100, 20);
		recomecar.setVisible(false);
		recomecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.recomecar();
			}
		});
		contentPane.add(recomecar);
		
		profile1.setIcon(PROFILE_IMG);
		profile1.setBounds(447, 275, 48, 48);
		contentPane.add(profile1);
		
		
		lblJogador1.setBounds(435, 324, 100, 16);
		contentPane.add(lblJogador1);
		
		
		profile2.setIcon(PROFILE_IMG);
		profile2.setBounds(334, 275, 48, 48);
		contentPane.add(profile2);
		
		carta.setBounds(350,180,80,80);
		carta.setVisible(false);
		contentPane.add(carta);
		
		lblJogador2.setBounds(320, 324, 100, 16);
		contentPane.add(lblJogador2);
		
		
		profile3.setIcon(PROFILE_IMG);
		profile3.setBounds(228, 263, 48, 48);
		contentPane.add(profile3);
		
		
		lblJogador3.setBounds(214, 311, 100, 16);
		contentPane.add(lblJogador3);
		
		
		profile4.setIcon(PROFILE_IMG);
		profile4.setBounds(189, 192, 48, 48);
		contentPane.add(profile4);
		
		
		lblJogador4.setBounds(106, 210, 100, 16);
		contentPane.add(lblJogador4);
		
		
		profile5.setIcon(PROFILE_IMG);
		profile5.setBounds(228, 104, 48, 48);
		contentPane.add(profile5);
		
		
		lblJogador5.setBounds(210, 86, 100, 16);
		contentPane.add(lblJogador5);
		
		
		profile6.setIcon(PROFILE_IMG);
		profile6.setBounds(334, 90, 48, 48);
		contentPane.add(profile6);
		
		
		lblJogador6.setBounds(319, 72, 100, 16);
		contentPane.add(lblJogador6);
		
		
		profile7.setIcon(PROFILE_IMG);
		profile7.setBounds(447, 90, 48, 48);
		contentPane.add(profile7);
		
		
		lblJogador7.setBounds(435, 70, 100, 16);
		contentPane.add(lblJogador7);
		
		
		profile8.setIcon(PROFILE_IMG);
		profile8.setBounds(553, 104, 48, 48);
		contentPane.add(profile8);
		
		
		profile9.setIcon(PROFILE_IMG);
		profile9.setBounds(596, 192, 48, 48);
		contentPane.add(profile9);
		
		
		profile10.setIcon(PROFILE_IMG);
		profile10.setBounds(553, 263, 48, 48);
		contentPane.add(profile10);
		
		lblJogador10.setBounds(538, 311, 100, 16);
		contentPane.add(lblJogador10);
		
		JLabel table = new JLabel("");
		table.setIcon(TABLE_IMG);
		table.setBounds(15, 104, 610, 219);
		contentPane.add(table);
		
		
		lblJogador8.setBounds(538, 87, 100, 16);
		contentPane.add(lblJogador8);
		
		lblJogador9.setBounds(653, 210, 100, 16);
		contentPane.add(lblJogador9);
		
		this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e){
				 ctrl.parar();
				 int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente encerrar o Jogo?", "Encerrar Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION);
				 if(opcao == JOptionPane.YES_OPTION)
					 ctrl.terminar();
				 else if(opcao == JOptionPane.NO_OPTION)
					 ctrl.resumir();
			 }
			 });
		
		setVisible(true);
	}
	
	@Override
	public void setVez(Jogador jogador){
		if(jogador == null)
			throw new NullPointerException("Jogador Nulo");
		
		this.setVez(getProfile(jogador.getNome()));
	}

	private void setVez(JLabel profile){
		int xP = profile.getBounds().x;
		int yP = profile.getBounds().y;
		int hP = profile.getBounds().height;
		int wP = profile.getBounds().width;
		int x = xP;
		int y = yP;
		
		if (yP == 275) { // profile 1 and 2
			y -= (hP - 30);
		} else if (yP == 263) { // profile 3 and 10
			y -= 16;
			x +=10;
		} else if (yP == 192) { // profile 4 and 9
			y += 16;
			if(xP == 596){
				x-=20;
			}else{
				x+=wP+5;
			}
		} else if (yP == 104) { // profile 5 and 8
			y += hP;
			x +=14;
		} else if (yP == 90) { // profile 6 and 7
			y += (hP);
		}
		
		vez.setBounds(x, y, vez.getBounds().width, vez.getBounds().height);
		vez.setVisible(true);
	}
	
	@Override
	public IController getController() {
		return this.ctrl;
	}
	
	@Override
	public void removeJogador(String nome){
		if(nome == null)
			throw new NullPointerException("Nome nulo");
		
		getLblJogador(nome).setVisible(false);
		getProfile(nome).setVisible(false);
	}

	@Override
	public void setJogadores(Pilha<Jogador> jogadores) {
		if(jogadores == null)
			throw new IllegalArgumentException("Jogadores nulo!");
		
		String jogador1 = jogadores.pop().toString();
		historico.append("[Mesa] : Bem Vindo ao Jogo de Baralho " + jogador1 + "\n");
		lblJogador1.setText(jogador1);
		lblJogador2.setText(jogadores.pop().toString());
		lblJogador3.setText(jogadores.pop().toString());
		lblJogador4.setText(jogadores.pop().toString());
		lblJogador5.setText(jogadores.pop().toString());
		lblJogador6.setText(jogadores.pop().toString());
		lblJogador7.setText(jogadores.pop().toString());
		lblJogador8.setText(jogadores.pop().toString());
		lblJogador9.setText(jogadores.pop().toString());
		lblJogador10.setText(jogadores.pop().toString());
		
		atualizarHistorico();
	}
	
	@Override
	public void setHistorico(String s){
		historico.append("[Mesa] : "+s+"\n");
		this.atualizarHistorico();
	}

	private void atualizarHistorico(){
		txtpnjogo.setText(historico.toString());
		txtpnjogo.setCaretPosition(txtpnjogo.getDocument().getLength());
	}
	
	private JLabel getProfile(String nome){
		return profiles[getIndexLblJogador(nome)];
	}
	
	private int getIndexLblJogador(String nome){
		for(int i=0;i<lbljogadores.length;i++){
			if(lbljogadores[i].getText().equals(nome))
				return i;
		}
		return -1;
	}
	
	private JLabel getLblJogador(String nome){
		for(JLabel lblJogador : lbljogadores){
			if(lblJogador.getText().equals(nome))
				return lblJogador;
		}
		
		return null;
	}

	@Override
	public void enableButtons(boolean flag) {
		recomecar.setVisible(flag);
	}

	@Override
	public void messageGanhador(String s) {
		JOptionPane.showMessageDialog(null, s, "Ganhador do Jogo do Baralho", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void setCarta(Carta c) {
		this.carta.setIcon(getRandomCarta(c.getNumero()));
		this.carta.setVisible(true);
	}
	
	
	private ImageIcon getRandomCarta(int n){
		Random r = new Random();
		int i = -1;
		switch(n){
			case 1:
				i = (r.nextInt(cartas_As.length));
				return cartas_As[i];
			
			case 3:
				i = (r.nextInt(cartas_3.length));
				return cartas_3[i];		
				
			case 9:
				i = (r.nextInt(cartas_9.length));
				return cartas_9[i];
				
			case 13:
				i = (r.nextInt(cartas_K.length));
				return cartas_K[i];		
				
			default:
				i=-1;
		}
		return null;
	}
}
