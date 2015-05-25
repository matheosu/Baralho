package controller;

import viewer.IViewer;

public interface IController {
	
	public abstract boolean iniciar();
	public abstract boolean terminar();
	
	public abstract void visibleViewer(boolean flag);
	public abstract IViewer getViewer();

}
