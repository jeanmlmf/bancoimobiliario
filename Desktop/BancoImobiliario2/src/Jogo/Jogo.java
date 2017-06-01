package Jogo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import Imoveis.Imovel;
import Jogadores.GerarJogadores;
import Jogadores.Jogador;
import ManipulacaoArquivo.EscreverArquivo;
import ManipulacaoArquivo.LerArquivo;
import Tabuleiro.*;
/**
 * 
 * @author Ariane e Jean
 * A classe Jogo representa o jogo em si. Possui um tabuleiro
 * e uma lista de jogadores que participarão do jogo.
 *
 */
public class Jogo {
	private Tabuleiro tab_;
	private ArrayList<Jogador> jogadores_ = new ArrayList<Jogador>();
	/**Funçao que inicia o novo jogo, faz a criação e a geração de 
	 * um tabuleiro, gera os jogadores e realiza as jogadas. 
	 */
	public void novoJogo(){
		this.tab_ = new Tabuleiro();
		this.tab_.gerarTabuleiro();
		this.tab_.criaListaJogadores();
		//this.tab_.imprimeTabuleiro();
		File file = new File("jogadas4.txt");
		LerArquivo leituraJogadas = new LerArquivo(file, 0);
		GerarJogadores gerar = new GerarJogadores(Integer.parseInt(leituraJogadas.getDadosArquivo().get(0).get(1)),(double)Integer.parseInt(leituraJogadas.getDadosArquivo().get(0).get(2)));
		this.jogadores_ = gerar.cadastraJogadores();
		/*for(int i = 0; i < this.jogadores_.size(); i++){
			System.out.println("Nome: "+jogadores_.get(i).getNome()+" Ordem " + jogadores_.get(i).getOrdemJogada()+
					" Posicao"+jogadores_.get(i).getPosicao()+" Dinheiro "+jogadores_.get(i).getBanco());
		}*/
		/**
		 * For que controla as linhas
		 */
		for (int i = 1; i <leituraJogadas.getDadosArquivo().size(); i++) {
			/**
			 * Verifica se a proxima linha possui o comando DUMP o qual significa fim de jogo 
			 */
			if(leituraJogadas.getDadosArquivo().get(i).get(0) != "DUMP"){
				/**
				 * For que controla as colunas
				 */
				for (int j = 1; j < leituraJogadas.getDadosArquivo().get(i).size(); j++) {
					/**
					 * For que passa por todos os jogadores e o if verifica se o jogador 
					 * que está no for é o que deve realizar a jogada e se esse jogador 
					 * ainda não faliu
					 */
					for(int k = 0; k < gerar.getQuantidadeJogadores(); k++){
						if(this.jogadores_.get(k).getOrdemJogada() == Integer.parseInt(leituraJogadas.getDadosArquivo().get(i).get(j))&&this.jogadores_.get(k).isFaliu()==false){
							j++;
							int posicaoAnterior = jogadores_.get(k).getPosicao();
							/**
							 * Seta a posição do jogador de acordo com o valor do dado tirado
							 */
							this.jogadores_.get(k).setPosicao((Integer.parseInt(leituraJogadas.getDadosArquivo().get(i).get(j))+this.jogadores_.get(k).getPosicao())%this.tab_.getTamanho());
							/**
							 * Os condicionais abaixo são responsaveis por verificar o que esta na posicão
							 * que o jogador caiu, para então realizar o pagamento do aluguel ou compra de um 
							 * imovel. Neles também é verificado se o jogador parou na posição passe a vez(nenhum 
							 * valor é debitado do saldo e acrescenta +1 na variavel passeVez do jogador) ou start
							 * (nada acontece) 
							 *  
							 */
							if(this.tab_.getListaJogadores().get(this.jogadores_.get(k).getPosicao()).getNome()== "banco"){
								this.jogadores_.set(k, comprarImovel(this.jogadores_.get(k)));
							}
							else if(this.tab_.getListaImoveis().get(this.jogadores_.get(k).getPosicao()).getNome() == "Start"){
								
								
							}
							else if(this.tab_.getListaImoveis().get(this.jogadores_.get(k).getPosicao()).getNome() == "Passe a vez"){
								this.jogadores_.get(k).setPasseVez(this.jogadores_.get(k).getPasseVez()+1);
							}
							else{
								this.jogadores_.set(k, pagarAluguel(this.jogadores_.get(k)));
								j++;
							}
							/**
							 * verica se o jogador passou pelo o inicio para que o mesmo ganhe 500,00
							 * e aumente +1 no numero de voltas 
							 */
							if(this.jogadores_.get(k).getPosicao() < posicaoAnterior){
								this.jogadores_.get(k).setVoltas(this.jogadores_.get(k).getVoltas()+1);
								this.jogadores_.get(k).setBanco(this.jogadores_.get(k).getBanco() + 500.00);
							}
							/**
							 * Quando o algoritmo entra no if quer dizer que ele já encontrou
							 * o jogador, então é necessário parar o for de acordo com a linha
							 * k = gerar.getQuantidadeJogadores();
							 */
							k = gerar.getQuantidadeJogadores();
						} 
						
					}
					
				}
				
			}
		}
	}
	public boolean checaFim(){
		int x = 0;
		for(int i = 0; i<this.jogadores_.size(); i++){
			if(this.jogadores_.get(i).getOrdemJogada()<0){
				x++;
			}
		}
		if(x==this.jogadores_.size()-1){
			return true;
		}
		return false;
	}
	/**
	 * Funçao que mostra a lista de imoveis adquiridos por
	 * cada jogador
	 * @param j
	 */
	public static void verListaImoveis(Jogador j){
		int i;
		for(i = 0; i < j.getImoveis().size(); i++){
			System.out.println("Lista de Imoveis Adquiridos:\n" + j.getImoveis().get(i).getNome());
		}
	}
	
	public boolean falirJogador(Jogador jog){
		if(jog.getBanco()<=0){
			if(jog.getOrdemJogada()>=0){
				for(int i = 0 ; i < this.tab_.getTamanho(); i++){
					if(this.tab_.getListaJogadores().get(i).equals(jog)){
						this.tab_.getListaJogadores().set(i, new Jogador("banco", -1));
					}
				}
				System.out.println("Jogador" + (jog.getOrdemJogada()+1) + ": Faliu!!");
				jog.setOrdemJogada(jog.getOrdemJogada()-6);
				return true;
			}
		}
		return false;

	}
	
	public void gameOver(){
		List<String> escrita = new ArrayList<String>();
		for(int i = 0; i < this.jogadores_.size(); i++){
			escrita.add(new String("Nome: "+jogadores_.get(i).getNome()+" Ordem " + jogadores_.get(i).getOrdemJogada()+
					" Posicao"+jogadores_.get(i).getPosicao()+" Dinheiro "+jogadores_.get(i).getBanco() +
					" Aluguel Pago "+ jogadores_.get(i).getAluguelPago() + " Aluguel Rec " +jogadores_.get(i).getAluguel()
					+" Voltas "+ jogadores_.get(i).getVoltas() + " Compras "+jogadores_.get(i).getGastouCompras()
					+" Passe "+jogadores_.get(i).getPasseVez()));
		}
		EscreverArquivo escrever = new EscreverArquivo(new File("estatisticas.txt"));
		escrever.escreveDados(escrita);
	}
	/**
	 * Função que compra o imovel em que está na posição
	 * que o jogador parou. Retira do jogador o valor de compra
	 * do imovel e acrscenta o valor da compra no atributo GastouCompras
	 * @param jog
	 * @return
	 */
	public Jogador comprarImovel(Jogador jog){
			jog.setBanco((jog.getBanco() - this.tab_.getListaImoveis().get(jog.getPosicao()).getValor()));
			jog.setGastouCompras(jog.getGastouCompras()+this.tab_.getListaImoveis().get(jog.getPosicao()).getValor());
			this.tab_.setListaJogadores(jog);;
			ArrayList <Imovel> imovel = new ArrayList<Imovel>();
			imovel.add(this.tab_.getListaImoveis().get(jog.getPosicao()));
			jog.setImoveis(imovel);
			return jog;
	}
	/**
	 * Função que em que um jogador paga o aluguel por ter parado em posicao que possui
	 * um imovel que não pertence ao Banco. Recebe o jogador que ira pagar o aluguel e retorno o
	 * mesmo depois de realizar os cálculos necessários
	 * @param jog
	 * @return
	 */
	public Jogador pagarAluguel(Jogador jog){
		/**O primeiro if verifica se o imovel não é do jogador para que ele possa pagar o aluguel, então retira
		 * do dinheito acumulado o valor do aluguel e acrescenta na variavel que guarda o valor de alugueis
		 * pagos o valor da taxa do imovel que está na posicao que ele parou. Além disso soma o aluguel no valor
		 * do dono do imovel.		 * 
		 */
		if(!this.tab_.getListaJogadores().get(jog.getPosicao() % this.tab_.getTamanho()).equals(jog)){
			jog.setBanco((jog.getBanco() - this.tab_.getListaImoveis().get(jog.getPosicao()).getTaxa()));
			jog.setAluguelPago((jog.getAluguelPago() + this.tab_.getListaImoveis().get(jog.getPosicao()).getTaxa()));
			int i = this.tab_.getListaJogadores().get(jog.getPosicao()%this.tab_.getTamanho()).getOrdemJogada() ;
			if(i!=-1){
				this.jogadores_.get((i-1)).setAluguel((this.jogadores_.get((i-1)).getAluguel()+this.tab_.getListaImoveis().get(jog.getPosicao()).getTaxa()));
				this.jogadores_.get((i-1)).setBanco((this.jogadores_.get((i-1)).getAluguel() + this.jogadores_.get((i-1)).getBanco()));
			}
		}
		return jog;
	}

}
