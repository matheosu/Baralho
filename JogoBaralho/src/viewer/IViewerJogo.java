package viewer;

import model.Jogador;
import pilhaEncadeada.Pilha;


public interface IViewerJogo extends IViewer{
	
	public abstract void setVez(Jogador j);
	public abstract void setHistorico(String s);
	public abstract void setJogadores(Pilha<Jogador> jogadores);
	public abstract void removeJogador(String nome);
	
	public abstract void enableButtons(boolean flag);
	public abstract void messageGanhador(String s);
}
