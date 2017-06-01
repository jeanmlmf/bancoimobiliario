package Excessões;

public class PertenceAJogador extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void printmsg(){
		System.out.println("O Imovel pertence à um jogador e não pode ser comprado\n");
	}

}
