//Trabalho realizado por Ariane H�lida e Jean Marcos Ci�ncia da computa��o POOII 5� Periodo
package Apresenta��o;

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
