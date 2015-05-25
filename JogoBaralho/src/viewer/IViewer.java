package viewer;

import controller.IController;

public interface IViewer {

	public abstract IController getController();
	
	public abstract void setVisible(boolean flag);
}
