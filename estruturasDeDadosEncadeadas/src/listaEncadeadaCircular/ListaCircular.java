package listaEncadeadaCircular;

import listaEncadeada.Noh;

public class ListaCircular {

	private Noh ptLista;

	public ListaCircular() {
		ptLista = null;
	}

	public Noh getPtLista() {
		return ptLista;
	}

	public void setPtLista(Noh ptLista) {
		this.ptLista = ptLista;
	}

	public boolean isListaCircularVazia() {
		return ptLista == null;
	}

	public void insere(int info) {
		Noh novoNoh = new Noh();
		novoNoh.setInfo(info);

		if (isListaCircularVazia()) {
			novoNoh.setProx(novoNoh);
			ptLista = novoNoh;
		} else {
			novoNoh.setProx(ptLista.getProx());
			ptLista.setProx(novoNoh);
		}

	}
	
	public void insereOrdenadaCrescente(int info){
		if(!isListaCircularVazia()){
			Noh novoNoh = new Noh();
			novoNoh.setInfo(info);
			if(novoNoh.getInfo() < ptLista.getInfo()){
				novoNoh.setProx(ptLista.getProx());
				ptLista.setProx(novoNoh);
				ptLista = novoNoh;
			}else{
				Noh nohAux = ptLista;
				while(nohAux.getProx() != ptLista){
					if(nohAux.getProx().getInfo() < novoNoh.getInfo()){
						novoNoh.setProx(nohAux);
						nohAux.getProx().setProx(novoNoh);
						return;
					}
					nohAux = nohAux.getProx();
				}
				
				
			}
		}else{
			insere(info);
		}
	}

	public boolean remove(int info) {
		if (isListaCircularVazia())
			return false;

		if (ptLista.getInfo() == info) {
			if(ptLista.getProx() == ptLista){
				ptLista = null;
				return true;
			}
				
			Noh nohAux = ptLista;
			
			while(nohAux.getProx() != ptLista){
				nohAux = nohAux.getProx();
			}
			nohAux.setProx(ptLista.getProx());
			ptLista = ptLista.getProx();
			return true;
		} else {
			Noh nohAnterior = ptLista;
			for(Noh nohAux = ptLista.getProx(); nohAux != ptLista; nohAux=nohAux.getProx()){
				if(nohAux.getInfo() == info){
					nohAnterior.setProx(nohAux.getProx());
					return true;
				}
				nohAnterior = nohAux;
			}
		}
		
		return false;

	}
	
	@Override
	public String toString() {
		String resultado = "";

		if(!isListaCircularVazia()){
			Noh nohAux = ptLista;
			resultado += nohAux.getInfo();
			nohAux = nohAux.getProx();
			if (nohAux != ptLista)
				resultado += " | ";
	
			while (nohAux != ptLista) {
				resultado += nohAux.getInfo();
				nohAux = nohAux.getProx();
	
				if (nohAux != ptLista)
					resultado += " | ";
			}
		}else{
			resultado = " Sem resultados ";
		}

		return "ListaCircular [" + resultado + "]";

	}

}
