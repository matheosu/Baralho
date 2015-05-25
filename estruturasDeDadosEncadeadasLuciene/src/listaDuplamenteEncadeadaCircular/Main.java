package listaDuplamenteEncadeadaCircular;

public class Main {

	public static void main(String[] args) {
		ListaDuplamenteCircular<Integer> ldc = new ListaDuplamenteCircular<Integer>();
		
		ldc.add(1);
		ldc.add(6);
		ldc.add(5);
		ldc.add(4);
		ldc.add(3);
		ldc.add(2);
		
		System.out.println(ldc);
		
		ldc.remove(1);
		ldc.remove(2);
		ldc.remove(3);
		ldc.remove(4);
		ldc.remove(5);
		ldc.remove(6);
		
		System.out.println(ldc);
	}

}
