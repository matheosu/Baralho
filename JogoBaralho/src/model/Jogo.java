package model;

import java.util.Random;

import listaDuplamenteEncadeadaCircular.ListaDuplamenteCircular;

public class Jogo {
	
	public static final int NUM_MAX_JOGADORES = 10;

	private ListaDuplamenteCircular<Jogador> jogadores;
	private Carta[] cartas;
	private Sentido sentido;
	private Jogador vez;
	
	public Jogo(ListaDuplamenteCircular<Jogador> jogadores){
		this.setJogadores(jogadores);
		this.setSentido(Sentido.ANTI_HORARIO);
		this.setCartas(gerarCartas());
		this.setVez(jogadores.getFirstNode().getInfo());
	}

	private Carta[] gerarCartas() {
		Carta carta1 = new Carta(1);
		Carta carta3 = new Carta(3);
		Carta carta9 = new Carta(9);
		Carta carta13 = new Carta(13);
		return new Carta[]{carta1, carta3, carta9, carta13};
	}

	public ListaDuplamenteCircular<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ListaDuplamenteCircular<Jogador> jogadores) {
		if(jogadores == null)
			throw new NullPointerException("Jogadores não pode ser nulo");
		
		if(jogadores.size() < NUM_MAX_JOGADORES)
			throw new IllegalArgumentException("Mínimo de jogadores permitidos: " + NUM_MAX_JOGADORES);
		
		this.jogadores = jogadores;
	}

	public Carta[] getCartas() {
		return cartas;
	}

	public void setCartas(Carta[] cartas) {
		this.cartas = cartas;
	}

	public Sentido getSentido() {
		return sentido;
	}

	public void setSentido(Sentido sentido) {
		this.sentido = sentido;
	}

	public Jogador getVez() {
		return vez;
	}

	public void setVez(Jogador vez) {
		this.vez = vez;
	}

	public Carta getRandomCarta() {
		Random r = new Random();
		return this.cartas[(r.nextInt(this.cartas.length))];
	}

	public void proximo(){
		if(sentido == Sentido.HORARIO)
			this.setVez(jogadores.getNodeByInfo(vez).getFront().getInfo());
		else if (sentido == Sentido.ANTI_HORARIO)
			this.setVez(jogadores.getNodeByInfo(vez).getBack().getInfo());
	}
	
	public void inverteJogo(){
		if(sentido == Sentido.HORARIO)
			this.setSentido(Sentido.ANTI_HORARIO);
		else if (sentido == Sentido.ANTI_HORARIO)
			this.setSentido(Sentido.HORARIO);
	}
}
