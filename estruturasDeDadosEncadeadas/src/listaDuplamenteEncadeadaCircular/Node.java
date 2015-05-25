package listaDuplamenteEncadeadaCircular;

public class Node<E> {

	private E info;
	private Node<E> front;
	private Node<E> back;

	public Node(){}
	
	/**
	 * Se não informar o nó da frente e o nó atrás, irá setar ele mesmo como nó da frente e de trás;
	 * @param info
	 */
	public Node(E info){
		this.setInfo(info);
		this.setFront(this);
		this.setBack(this);
	}
	
	/**
	 * Se não informar o nó de trás irá setar ele mesmo;
	 * @param info
	 * @param front
	 */
	public Node(E info, Node<E> front){
		this.setInfo(info);
		this.setFront(front);
		this.setBack(this);
	}
	
	/**
	 * Seta a info, o nó da frente e o nó de trás
	 * @param info
	 * @param front
	 * @param back
	 */
	public Node(E info, Node<E> front, Node<E> back){
		this.setInfo(info);
		this.setFront(front);
		this.setBack(back);		
	}
	
	public E getInfo() {
		return info;
	}
	public void setInfo(E info) {
		this.info = info;
	}
	public Node<E> getFront() {
		return front;
	}
	public void setFront(Node<E> front) {
		this.front = front;
	}
	public Node<E> getBack() {
		return back;
	}
	public void setBack(Node<E> back) {
		this.back = back;
	}

	@Override
	public String toString() {
		return "Node [" + info + "]"; 
	}
	
	
}
