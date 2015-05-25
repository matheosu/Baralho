package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Jogador;

public class ReadUtil {

	public static List<Jogador> lerJogadores(String path){
	
		List<Jogador> jogadoresDaLista = new ArrayList<Jogador>();
		Scanner is;
		try {
			is = new Scanner(new BufferedReader(new FileReader(path)));
			while(is.hasNext()){
				String nome = is.nextLine();
				Jogador jogador = new Jogador(nome);
				jogadoresDaLista.add(jogador);
			}
			is.close();
		} catch (FileNotFoundException fnfe) {
			System.err.println("Não achei o candango");
			fnfe.printStackTrace();
		}
		
		return jogadoresDaLista;
	}
}
