package controller;

import viewer.IViewer;
import viewer.IViewerRegras;
import viewer.RegrasViewer;

public class RegrasController implements IControllerRegras {

	private IControllerInicio ctrl;
	
	private IViewerRegras vw;
	
	
	public RegrasController(IControllerInicio c){
		this.ctrl = c;
	}
	
	@Override
	public IViewer getViewer() {
		return vw;
	}

	@Override
	public boolean iniciar() {
		this.vw = new RegrasViewer(this);
		return true;
	}

	@Override
	public boolean terminar() {
		return this.ctrl.terminarRegras();
	}

	@Override
	public void visibleViewer(boolean flag) {
		this.vw.setVisible(flag);
	}

}
