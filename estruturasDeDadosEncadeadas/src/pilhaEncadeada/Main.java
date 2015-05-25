package pilhaEncadeada;

public class Main {

	
	public static void main(String[] args){
		
		Pilha<String> p = new Pilha<String>();
		p.push("Teste1");
		p.push("Teste2");
		p.push("Teste3");
		p.push("Teste4");
		p.push("Teste5");
		p.push("Teste6");
		
		System.out.println(p);
		
		System.out.println(p.pop());
		
		System.out.println(p);
		
	}
}
