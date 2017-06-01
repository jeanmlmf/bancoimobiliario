package Jogadores;

import java.util.ArrayList;
/**
 * 
 * @author User
 *A classe GerarJogadores representa o conjunto de jogadores que participaram do jogo
 *Seus atributos quantidadeJogadores e valorIncial referem-se respectivamente ao numero
 *de jogadores que participarão do jogo e o valor inicial de dinheiro que cada jogador possui
 *para compra de imoveis e pagamento de aluguel. Possui um construtor que seta os valores dos 
 *atributos de acordo com os paramentros recebidos na função.
 */
public class GerarJogadores {
	private int quantidadeJogadores;
	private double valorInicial;
	
	public GerarJogadores(int quant, double valor){
		this.quantidadeJogadores = quant;
		this.valorInicial = valor;
	}
	/**
	 * A função cadastraJogadores() é responsável por criar um
	 * ArrayList de Jogadores onde sera instanciados jogadores com
	 * o nome e com o valor inicial de banco. Por fim retornara esse
	 * ArrayList. O tamanho do Array será proporcional a quantidadeJogadores
	 * setada no construtor
	 * @return
	 */
	public ArrayList<Jogador> cadastraJogadores(){
		ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
		int i;
		for(i = 0; i< this.quantidadeJogadores; i++){
			jogadores.add(new Jogador(("Jogador " +i), this.valorInicial));
			jogadores.get(i).setOrdemJogada((i+1));
		}
		
		
		return jogadores;
	}

	public double getValorInicial() {
		return valorInicial;
	}

	public void setValorInicial(double valorInicial) {
		this.valorInicial = valorInicial;
	}

	public int getQuantidadeJogadores() {
		return quantidadeJogadores;
	}
}
