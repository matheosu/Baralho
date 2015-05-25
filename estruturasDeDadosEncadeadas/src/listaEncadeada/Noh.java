package listaEncadeada;


//classe que define a estrutura do noh
//assim como seus m�todos b�sicos de acesso
public class Noh {

	private int info;
	private Noh prox;//atributo que guarda a referencia do pr�ximo noh
	
	public int getInfo(){
		return info;
	}
	
	public void setInfo(int valorInfo){
		this.info = valorInfo;
	}
	
	public Noh getProx() {
		return prox;
	}
	
	public void setProx(Noh proxNoh){
		this.prox = proxNoh;
	}

}
