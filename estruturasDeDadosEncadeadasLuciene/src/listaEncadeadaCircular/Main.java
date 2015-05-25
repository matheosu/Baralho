package listaEncadeadaCircular;

public class Main {

	public static void main(String[] args) {
		ListaCircular circular  = new ListaCircular();
		
		circular.insere(12);
		circular.insere(6);
		circular.insere(8);
		circular.insere(11);
		circular.insere(9);
		circular.insere(3);
		
		System.out.println(circular);
		
		circular.remove(12);
		circular.remove(3);
		circular.remove(9);
		circular.remove(11);
		circular.remove(8);
		circular.remove(6);
		
		System.out.println(circular);
		
		circular.insereOrdenadaCrescente(9);
		circular.insereOrdenadaCrescente(7);
		circular.insereOrdenadaCrescente(6);
		circular.insereOrdenadaCrescente(5);
		
		System.out.println(circular);
	}

}
