package controller;

public interface IControllerInicio extends IController{
	
	public abstract boolean iniciarJogo();
	public abstract boolean terminarJogo();
	
	public abstract boolean iniciarRegras();
	public abstract boolean terminarRegras();
}
