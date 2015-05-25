package listaDuplamenteEncadeadaCircular;


public class ListaDuplamenteCircular<E>{

	private Node<E> firstNode;
	private int size;

	public ListaDuplamenteCircular(){
		this.firstNode = null;
	}
	
	public Node<E> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node<E> firstNode) {
		this.firstNode = firstNode;
	}
	
	public boolean isEmpty(){
		return this.firstNode == null;
	}
	
	public void add(E info){
		if(isEmpty()){
			this.firstNode = new Node<E>(info);
		}else{
			Node<E> newNode = new Node<E>(info, firstNode.getFront(), firstNode);
			this.firstNode.getFront().setBack(newNode);
			this.firstNode.setFront(newNode);
		}
		size++;
	}

	public boolean remove(E info){
		if(isEmpty())
			return false;
		
		if(firstNode.getInfo() == info){
			if(firstNode.getFront() == firstNode){
				firstNode = null;
				--size;
				return true;
			}
			
			Node<E> nodeAuxF = firstNode.getFront();
			Node<E> nodeAuxB = firstNode.getBack();
			nodeAuxF.setBack(nodeAuxB);
			nodeAuxB.setFront(nodeAuxF);
			firstNode = nodeAuxF;
			--size;
			return true;
		} else {			
			Node<E> nodeAux = firstNode.getFront();
			while(nodeAux != firstNode){
				if(nodeAux.getInfo() == info){
					nodeAux.getBack().setFront(nodeAux.getFront());
					nodeAux.getFront().setBack(nodeAux.getBack());
					--size;
					return true;
				}
				
				nodeAux = nodeAux.getFront();
			}
		}
		
		return false;
		
	}
	
	public Node<E> getNodeByInfo(E info){
		if(isEmpty())
			return null;
		
		if(firstNode.getInfo() == info)
			return firstNode;
		
		Node<E> nodeAux = firstNode.getFront();
		while(nodeAux != firstNode){
			if(nodeAux.getInfo() == info)
				return nodeAux;
			nodeAux = nodeAux.getFront();
		}

		return null;
	}
	
	
	public int size(){
		return this.size;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		if(!isEmpty()){
			Node<E> nodeAux = firstNode;
			result += nodeAux.getInfo();
			nodeAux= nodeAux.getFront();
			if(nodeAux != firstNode)
				result += " | ";
			
			while(nodeAux != firstNode){
				result += nodeAux.getInfo();
				nodeAux = nodeAux.getFront();
				if(nodeAux != firstNode)
					result += " | ";
			}
			
		} else {
			result = " Sem Resultados ";
		}
		
		return "Lista Duplamente Circular [" + result + "]";
	}
	
	
	
}
