package Imoveis;
/**  
 * @author Ariane e Jean
 * A classe Start é uma herança da classe Imovel.
 * Possui todos os atributos da classe mãe e em seu construtor
 * seta a variavel nome para "Start". Representa a posicao inicial
 * por isso possui taxa e valor igual a zero.
 */
public class Start extends Imovel{
	public Start (){
		this.setNome("Start");
		this.setValor(0);
		this.setTaxa(0);
	}

}
