package pilhaEncadeada;

public class Pilha<T> {

	@SuppressWarnings("hiding")
	class Node<T>{
		T data;
		Node<T> next;
		
		Node(T data){
			this.data = data;
		}
		
		@Override
		public String toString(){
			return data.toString();
		}
	}
	
	private Node<T> topo;
	
	public Pilha(){
		this.topo = null;
	}
	
	public void push(T data){
		Node<T> newNode = new Node<T>(data);
		
		newNode.next = null;
		if(isEmpty()){
			topo = newNode;
		}else{
			Node<T> auxNode = topo;
			while(auxNode.next!=null){
				auxNode = auxNode.next;
			}
			
			auxNode.next = newNode;
			
		}
	}
	
	public T pop(){
		if(isEmpty())
			throw new NullPointerException("Pilha vazia");
		
		Node<T> auxNode = topo;
		
		topo = topo.next;
		
		return auxNode.data;
	}
	
	
	public boolean isEmpty(){
		return this.topo == null;
	}
	
	@Override
	public String toString(){
		String result = "";

		if(!isEmpty()){
			
			Node<T> auxNode = topo;
			
			while(auxNode!=null){
				result+=auxNode;
				auxNode = auxNode.next;
			}
		}
		
		return "Pilha ["+result+"]";
	}
}
