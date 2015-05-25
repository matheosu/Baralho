package controller;

import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import listaDuplamenteEncadeadaCircular.ListaDuplamenteCircular;
import model.Jogador;
import model.Jogo;
import pilhaEncadeada.Pilha;
import util.ReadUtil;
import viewer.IViewerJogo;
import viewer.JogoViewer;
import controller.threads.ThreadGame;

public class JogoController implements IControllerJogo {
	
	private static final String PATH_RESOURCES = "resources/";
	private static final String PATH_META_INF = PATH_RESOURCES + "META-INF/";
	private static final String NAME_FILE = PATH_META_INF  + "nomes.txt";
	
	
	private IControllerInicio ctrl;
	private IViewerJogo vw;
	
	private Jogador jogador;
	private Jogo jogo;
	
	private Thread t;
	
	public JogoController(IControllerInicio c){
		this.ctrl = c;
	}
	
	@Override
	public IViewerJogo getViewer() {
		return vw;
	}

	@Override
	public boolean iniciar() {
		String nome = null;
		
		while(nome == null || nome.isEmpty() || nome.trim().isEmpty()){
			nome = JOptionPane.showInputDialog(null, "Informe o seu Nome", "Digite o seu nome", JOptionPane.QUESTION_MESSAGE);
		}
		
		this.jogador = new Jogador(nome);
		Pilha<Jogador> jogadores = this.gerarJogadores(jogador);
		this.vw = new JogoViewer(this);
		jogo = new Jogo(this.jogadoresEmRoda(jogadores));
		this.vw.setJogadores(jogadores);
		
		return comecar();
		
	}
	

	@Override
	public boolean terminar() {
//		t.destroy();
		visibleViewer(false);
		return this.ctrl.terminarJogo();
	}

	@Override
	public void visibleViewer(boolean flag) {
		this.vw.setVisible(flag);
	}


	/**
	 * Gera uma lista duplamente encadeada circular com os jogadores como se fosse uma roda;
	 * @param jogadores
	 * @return
	 */
	private ListaDuplamenteCircular<Jogador> jogadoresEmRoda(Pilha<Jogador> jogadores){
		if(jogadores == null)
			throw new IllegalArgumentException("Jogadores nulo");
		
		ListaDuplamenteCircular<Jogador> jogadoresEmRoda = new ListaDuplamenteCircular<Jogador>();
		Pilha<Jogador> pilhaJogador = new Pilha<Jogador>();
		while(!jogadores.isEmpty()){
			Jogador j = jogadores.pop();
			pilhaJogador.push(j);
			jogadoresEmRoda.add(j);
		}
		
		while(!pilhaJogador.isEmpty()){
			jogadores.push(pilhaJogador.pop());
		}
		
		return jogadoresEmRoda;
	}
	
	
	/**
	 * Gera uma pilha de jogadores aleatórios sendo o topo da pilha o jogador passado por parametro
	 * @author matheuscastro
	 * @param j
	 * @return
	 */
	private Pilha<Jogador> gerarJogadores(Jogador j){
		if(j== null)
			throw new NullPointerException("Jogador nulo");
		
		List<Jogador> listaJogadores = ReadUtil.lerJogadores(NAME_FILE);
		
		Collections.shuffle(listaJogadores);
		
		Pilha<Jogador> jogadores = new Pilha<Jogador>();
		jogadores.push(j);

		int max = 9;
		
		for(Jogador jogador: listaJogadores){
			if(max == 0)
				break;
			
			jogadores.push(jogador);
			--max;
		}
		
		return jogadores;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void parar() {
		t.stop();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void resumir() {
		t.resume();
	}

	@Override
	public boolean comecar() {
		ThreadGame tg = new ThreadGame(this);
		t = new Thread(tg);
		t.start();
		return true;
	}

	@Override
	public Jogo getJogo() {
		return this.jogo;
	}

	@Override
	public void ganhador(Jogador j) {
		if(j.equals(jogador)){
			this.vw.messageGanhador("Parabéns "+j.getNome()+"!! Você é o Ganhador!!!");
		}else{
			this.vw.messageGanhador("Infelizmente você não teve sorte :( - O ganhador foi: " + j.getNome());
		}
		this.vw.enableButtons(true);
	}
	
	@Override
	public void recomecar(){
		this.vw.setVisible(false);
		Pilha<Jogador> jogadores = this.gerarJogadores(jogador);
		this.vw = new JogoViewer(this);
		jogo = new Jogo(this.jogadoresEmRoda(jogadores));
		this.vw.setJogadores(jogadores);
		parar();
		comecar();
	}
}
