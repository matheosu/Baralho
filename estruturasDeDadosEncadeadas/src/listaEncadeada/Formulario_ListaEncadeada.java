package listaEncadeada;


public class Formulario_ListaEncadeada {

	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.insereNoInicio(4);
		lista.insereNoInicio(3);
		lista.insereNoInicio(2);
		lista.insereNoInicio(1);
		
		lista.imprimeLista();
		System.out.println("Terminou a impressão!");
		
		lista.insereNoFinal(5);
		lista.insereNoFinal(6);
		lista.insereNoFinal(7);
		
		lista.imprimeLista();
		System.out.println("Terminou a impressão!");
		
		lista.removeNoh(4);
		lista.removeNoh(10);
		
		lista.imprimeLista();
		System.out.println("Terminou a impressão!");
		
		System.out.println("The End :-)");

	}

}
