package listaEncadeada;

public class Lista {
	
	private Noh inicio;
	
	public Lista() {
		super();
		criaLista();
	}

	//Uma lista linear encadeada passa a existir
	//qdo o atributo inicio � criado com o valor NULL
	//Neste momento, a lista passa a existir, mas ainda n�o tem nenhum n� alocado
	private void criaLista(){
		inicio = null;
	}
	
	public void insereNoInicio(int novaInfo){
		Noh novoNoh = new Noh();
		novoNoh.setInfo(novaInfo);
		novoNoh.setProx(inicio);
		inicio = novoNoh;
	}
	
	public void imprimeLista(){
		for(Noh noh=inicio; noh!=null; noh=noh.getProx()){
			System.out.println(noh.getInfo());
		}
	}
	
	public boolean isListaVazia(){
		if (inicio==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void insereNoFinal(int novaInfo){
		//percorre a lista para encontrar o ultimo noh
		Noh nohAux=inicio;
		for( ; nohAux.getProx()!=null; nohAux=nohAux.getProx());
		Noh novoNoh = new Noh();
		novoNoh.setInfo(novaInfo);
		novoNoh.setProx(null);//ou novoNoh.setProx(nohAux.getProx());
		nohAux.setProx(novoNoh);
	}
	
	//suponhamos que n�o exitam repeti��es na lista
	public void removeNoh(int info) {
		boolean achou=false;
		
		if(!this.isListaVazia()){
			//o inicio ser� removido
			if(inicio.getInfo()== info){
				inicio=inicio.getProx();
			}else{
				Noh nohAnt=inicio;
				//Come�a a percorrer a lista do segundo elemento
				for(Noh noh=inicio.getProx(); noh!=null; noh=noh.getProx()){
					if (noh.getInfo()== info){
						nohAnt.setProx(noh.getProx());
						achou=true;
						System.out.println("Elemento Removido :-)");
					}
					nohAnt=noh;
				}	
			}
		}else{
			System.out.println("Lista Vazia!");
		}
		
		if (!achou){
			System.out.println("N�o achou :-(");
		}
	}
}
