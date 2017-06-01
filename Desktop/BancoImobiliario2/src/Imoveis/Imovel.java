package Imoveis;
/**
 * 
 * @author Ariane e Jean
 *A classe imovel é responsável por representar genericamente um imovel
 *que estará presente em cada posição do tabuleiro.O atributo nome refere-se
 *ao nome do imovel, o atributo valor representa o valor pra compra deste imovel,
 *já taxa é o valor do aluguel que o jogador pagará se caso cair na posição de um
 * imovel que já existe um dono.
 */
public class Imovel {
	private String nome = new String();
	private double valor;
	private double taxa;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public double getTaxa() {
		return taxa;
	}
	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}
}
