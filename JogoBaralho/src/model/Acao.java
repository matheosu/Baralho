package model;

public enum Acao {

	PULA_PROXIMO_PASSA_VEZ(1,"Pula o próximo jogador e passa a vez seguinte"),
	ELIMINA_3_JOGADOR(3, "Elimina o terceiro jogador contando a partir do jogador atual"),
	ELIMINA_JOGADOR_ANTERIOR(9,"Elimina o jogador anterior na roda"),
	INVERTER_JOGO(13, "Inverte o sentido do Jogo");
	
	private int value;
	private String descricao;
	
	Acao(int value, String descricao){
		this.setValue(value);
		this.setDescricao(descricao);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString(){
		return descricao;
	}
	
}
