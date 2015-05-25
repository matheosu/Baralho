package controller;

import viewer.IViewer;
import viewer.InicioViewer;

public class InicioController implements IControllerInicio{

	/* Controller's */
	private IControllerJogo jogoCtrl;
	private IControllerRegras regrasCtrl;
	
	/* Initial Viewer */
	private IViewer inicioViewer;

	
	public InicioController(){
		this.jogoCtrl = new JogoController(this);
		this.regrasCtrl = new RegrasController(this);
	}
	
	public static void main(String[] args){
		IControllerInicio i = new InicioController();
		i.iniciar();
	}
	
	@Override
	public IViewer getViewer() {
		return inicioViewer;
	}

	@Override
	public boolean iniciar() {
		this.inicioViewer = new InicioViewer(this);
		return true;
	}

	@Override
	public boolean terminar() {
		System.exit(0);
		return true;
	}

	@Override
	public boolean iniciarJogo() {
		visibleViewer(false);
		return this.jogoCtrl.iniciar();
	}

	@Override
	public boolean terminarJogo() {
		visibleViewer(true);
		return true;
	}

	@Override
	public boolean iniciarRegras() {
		visibleViewer(false);
		return this.regrasCtrl.iniciar();
	}

	@Override
	public boolean terminarRegras() {
		visibleViewer(true);
		return true;
	}
	
	@Override
	public void visibleViewer(boolean flag){
		this.inicioViewer.setVisible(flag);
	}
}
