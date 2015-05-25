package filaEncadeada;

import listaEncadeada.Noh;

public class Fila {

	private Noh inicio;
	private Noh fim;

	public Fila() {
		inicio = fim = null;
	}

	public void insereNaFila(int info) {
		Noh novoNoh = new Noh();
		novoNoh.setInfo(info);
		if (isFilaVazio()) {
			novoNoh.setProx(null);
			inicio = fim = novoNoh;
		} else {
			novoNoh.setProx(null);
			fim.setProx(novoNoh);
			fim = novoNoh;
		}
	}

	public int removeDaFila() {
		if (!isFilaVazio()) {
			if(inicio == fim) {
				int valor = inicio.getInfo();
				inicio = fim = null;
				return valor;
			}else{
				int info = inicio.getInfo();
				inicio = inicio.getProx();
				return info;
			}
		}
		return -1;
	}

	public boolean isFilaVazio() {
		if (inicio == null && fim == null)
			return true;

		return false;
	}

	public void imprimeInicio() {
		if(inicio != null)
			System.out.println("Inicio: " + inicio.getInfo());
	}

	public void imrpimeFinal() {
		if(fim!=null)
			System.out.println("Final: " + fim.getInfo());
	}

}
