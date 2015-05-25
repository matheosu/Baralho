package controller;

import model.Jogador;
import model.Jogo;
import viewer.IViewerJogo;

public interface IControllerJogo extends IController{
	
	public static final int QTD_GANHADORES = 1;
	
	public abstract boolean comecar();
	public abstract void parar();
	public abstract void resumir();
	public abstract void recomecar();
	
	public abstract IViewerJogo getViewer();
	
	public abstract Jogo getJogo();
	
	public abstract void ganhador(Jogador j);
	
}
