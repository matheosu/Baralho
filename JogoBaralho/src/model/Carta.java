package model;

public class Carta {

	public static final long MIN_VALUE_CARTA = 1;
	public static final long MAX_VALUE_CARTA = 13;
	
	private int numero;

	private Acao acao;
	
	public Carta(int numero){
		if(numero >= MIN_VALUE_CARTA && numero <= MAX_VALUE_CARTA){
			this.setNumero(numero);
			this.setAcaoPorNumero(numero);
		} else {
			throw new IllegalArgumentException("Número tem que estar entre " + MIN_VALUE_CARTA + " e " + MAX_VALUE_CARTA);
		}
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Acao getAcao() {
		return acao;
	}

	private void setAcaoPorNumero(int numero) {
		if(numero == Acao.PULA_PROXIMO_PASSA_VEZ.getValue()){
			this.acao = Acao.PULA_PROXIMO_PASSA_VEZ;
			return;
		}
		
		if(numero == Acao.ELIMINA_3_JOGADOR.getValue()){
			this.acao = Acao.ELIMINA_3_JOGADOR;
			return;
		}
			
		if(numero == Acao.ELIMINA_JOGADOR_ANTERIOR.getValue()){
			this.acao = Acao.ELIMINA_JOGADOR_ANTERIOR;
			return;
		}
		
		if(numero == Acao.INVERTER_JOGO.getValue()){
			this.acao = Acao.INVERTER_JOGO;
			return;
		}
		
		this.acao = null;
		
	}
	
	@Override
	public String toString() {
		return "Carta " + numero + " [" + acao + "]";
	}
	
}
