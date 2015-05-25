package controller.threads;

import model.Acao;
import model.Carta;
import model.Jogador;
import model.Jogo;
import viewer.IViewerJogo;
import controller.IControllerJogo;

public class ThreadGame implements Runnable{
	
	private static final int TEMPO_PARADA = 1 * 1000; 
	private static IViewerJogo vw;
	private IControllerJogo ctrl; 
	private Jogo jogo;
	
	@Override
	public void run() {
		while(jogo.getJogadores().size() != IControllerJogo.QTD_GANHADORES){
			vw.setVez(jogo.getVez());
			vw.setHistorico("Vez do Jogador: " + jogo.getVez());
			try {
				Thread.sleep(TEMPO_PARADA);
				Carta carta = jogo.getRandomCarta();
				vw.setHistorico("Carta escolida: " + carta);
				Thread.sleep(TEMPO_PARADA);
				jogo = realizarAcao(jogo, carta.getAcao());
				Thread.sleep(TEMPO_PARADA);
				jogo.proximo();
			} catch (InterruptedException e) {
				System.err.println("Deu ruim " + e);
				e.printStackTrace();
			}
		}
		
		this.ctrl.ganhador(jogo.getJogadores().getFirstNode().getInfo());
	}
	
	public ThreadGame(IControllerJogo ctrl){
		if(ctrl== null)
			throw new IllegalArgumentException("Controlador nulo");
		this.ctrl = ctrl;
		this.jogo = ctrl.getJogo();
		vw = ctrl.getViewer();
	}
	
	
	private static Jogo realizarAcao(Jogo jogo, Acao acao){
		switch(acao){
			case PULA_PROXIMO_PASSA_VEZ:
				jogo.proximo();
				break;
			
			case ELIMINA_3_JOGADOR:
				Jogador anteriorPrimeiro = jogo.getVez();
				jogo.proximo();
				jogo.proximo();
				Jogador atual = jogo.getVez();
				jogo.getJogadores().remove(atual);
				vw.removeJogador(atual.getNome());
				jogo.setVez(anteriorPrimeiro);
				break;
				
			case ELIMINA_JOGADOR_ANTERIOR:
				Jogador anterior = jogo.getJogadores().getNodeByInfo(jogo.getVez()).getBack().getInfo();
				jogo.getJogadores().remove(anterior);
				vw.removeJogador(anterior.getNome());
				break;
				
			case INVERTER_JOGO:
				jogo.inverteJogo();
				break;
		}
		
		return jogo;
	}
	
	
}
