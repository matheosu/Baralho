package filaEncadeada;

public class Formulario_FilaEncadeada {

	public static void main(String[] args){
		
		Fila fila = new Fila();
		
		fila.insereNaFila(20);
		fila.insereNaFila(2);
		fila.insereNaFila(8);
		fila.insereNaFila(12);
		fila.insereNaFila(14);
		fila.insereNaFila(23);
		
		fila.imprimeInicio();
		fila.imrpimeFinal();
		
		System.out.println(fila.removeDaFila());
		System.out.println(fila.removeDaFila());
		System.out.println(fila.removeDaFila());
		System.out.println(fila.removeDaFila());
		System.out.println(fila.removeDaFila());
		System.out.println(fila.removeDaFila());
		System.out.println(fila.removeDaFila());
		
		fila.imprimeInicio();
		fila.imrpimeFinal();
		
	}
}
