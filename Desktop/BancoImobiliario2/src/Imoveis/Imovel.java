package Imoveis;
/**
 * 
 * @author Ariane e Jean
 *A classe imovel � respons�vel por representar genericamente um imovel
 *que estar� presente em cada posi��o do tabuleiro.O atributo nome refere-se
 *ao nome do imovel, o atributo valor representa o valor pra compra deste imovel,
 *j� taxa � o valor do aluguel que o jogador pagar� se caso cair na posi��o de um
 * imovel que j� existe um dono.
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
