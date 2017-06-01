//Trabalho realizado por Ariane Hélida e Jean Marcos Ciência da computação POOII 5º Periodo
package Apresentação;

import java.io.File;

import Jogo.Jogo;
import ManipulacaoArquivo.*;

public class Main {

	public static void main(String[] args) {
	
		
		Jogo jogo = new Jogo();
		jogo.novoJogo();
		System.out.println("GAME OVER!!!");
		jogo.gameOver();
	}

}
