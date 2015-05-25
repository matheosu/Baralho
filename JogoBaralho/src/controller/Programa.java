package controller;

import java.util.Scanner;

import listaDuplamenteEncadeadaCircular.ListaDuplamenteCircular;
import model.Acao;
import model.Carta;
import model.Jogador;
import model.Jogo;

public class Programa {

	private static final int QTD_GANHADORES = 1;
	
	public static void main (String[] args){
		ListaDuplamenteCircular<Jogador> jogadores = new ListaDuplamenteCircular<Jogador>();

		Scanner input = new Scanner(System.in);
		int qtd=1;
		while(qtd <= Jogo.NUM_MAX_JOGADORES){
			System.out.print("Informe o nome do " + qtd + "º Jogador: ");
			String nome = input.nextLine();
			if(nome == null || "".equals(nome) || nome.length() <= 0){
				System.err.print("\nNome inválido!");
			}else{
				Jogador jogador = new Jogador(nome);
				jogadores.add(jogador);
				++qtd;
			}
		}
		input.close();
		
		Jogo jogo = new Jogo(jogadores);
		while(jogo.getJogadores().size() != QTD_GANHADORES){
			System.out.println("Os jogadores estão assim: " + jogo.getJogadores());
			System.out.println("Vez do jogador: " + jogo.getVez());
			Carta carta = jogo.getRandomCarta();
			System.out.println("Carta escolhida: " + carta);
			jogo = realizarAcao(jogo, carta.getAcao());
			jogo.proximo();
		}
		System.out.println("O ganhador é " + jogo.getVez());
	}
	
	private static Jogo realizarAcao(Jogo jogo, Acao acao){
		switch(acao){
			case PULA_PROXIMO_PASSA_VEZ:
				jogo.proximo();
				break;
			
			case ELIMINA_3_JOGADOR:
				Jogador anteriorPrimeiro = jogo.getVez();
				jogo.proximo();
				jogo.proximo();
				Jogador atual = jogo.getVez();
				jogo.getJogadores().remove(atual);
				jogo.setVez(anteriorPrimeiro);
				break;
				
			case ELIMINA_JOGADOR_ANTERIOR:
				Jogador anterior = jogo.getJogadores().getNodeByInfo(jogo.getVez()).getBack().getInfo();
				jogo.getJogadores().remove(anterior);
				break;
				
			case INVERTER_JOGO:
				jogo.inverteJogo();
				break;
		}
		
		return jogo;
	}
}
