package Jogadores;

import java.util.ArrayList;

import Imoveis.Imovel;
/**
 * @author Ariane e Jean
 * Representa os jogadores do Banco Imobiliario
 * Seus atributos representam:
 * nome-> String com nome do jogador
 * posicao-> Posicao em que o Jogador estará no tabuleiro
 * ordemJogada-> Qual a ordem que ele irá jogar os dados. Exemplo: Primeiro, Segundo, etc
 * voltas-> Quantidade de voltas que o jogador fez no tabuleiro
 * passeVez->Quantidade de vezes que o jogador parou na posicao Passe a Vez
 * gastouCompras-> Valor gasto na compra de imoveis
 * banco-> Valor que possui para fazer compras e pagar alguel
 * aluguel-> Aluguel recebido pelos outros jogadores
 * aluguelPago-> Aluguel pago para outros jogadores
 * faliu-> boolean que representa se o jogador faliu ou não durante o jogo
 * imoveis-> ArrayList que mostra os imoveis adquidos pelo jogador
 */
public class Jogador {
	private String nome;
	private int posicao;
	private int ordemJogada;
	private int voltas;
	private int passeVez;
	private double gastouCompras;
	private double banco;
	private double aluguel;
	private double aluguelPago;
	private boolean faliu;
	private ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
	
	public double getAluguelPago() {
		return aluguelPago;
	}

	public void setAluguelPago(double aluguelPago) {
		this.aluguelPago = aluguelPago;
	}


	public int getOrdemJogada() {
		return ordemJogada;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public void setOrdemJogada(int ordemJogada) {
		this.ordemJogada = ordemJogada;
	}

	public boolean isFaliu() {
		return faliu;
	}

	public void setFaliu(boolean faliu) {
		this.faliu = faliu;
	}


	public double getAluguel() {
		return aluguel;
	}

	public ArrayList<Imovel> getImoveis() {
		return imoveis;
	}
	public void setImoveis(ArrayList<Imovel> imoveis) {
		this.imoveis.add(imoveis.get(0));
	}
	public void setAluguel(double aluguel) {
		this.aluguel = aluguel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getBanco() {
		return banco;
	}
	public void setBanco(double banco) {
		this.banco = banco;
	}
	/**
	 * Construtor que recebe String pra colocar no nome e um valor para colocar
	 * no valor inicial. O jogador banco no começo é o dono de todos os imoveis e
	 * possui valor inicial considerado infinito. Os demais jogadores comecam com
	 * os atributos voltas, passeVez, aluguelPago, aluguel, gastouCompras e posicao igual a zero.
	 * O atributo faliu inicia com false.
	 * @param nome
	 * @param valor
	 */
	public Jogador(String nome, double valor){
		if(nome.equals("banco")){
			this.faliu = false;
			this.nome = nome;
			this.banco = 1000000000;
		}
		else{
			this.voltas = 0;
			this.passeVez = 0;
			this.aluguelPago = 0;
			this.aluguel = 0;
			this.gastouCompras = 0;
			this.nome = nome;
			this.posicao = 0;
			this.banco = valor;
			this.faliu = false;
		}
	}

	public int getVoltas() {
		return voltas;
	}

	public void setVoltas(int voltas) {
		this.voltas = voltas;
	}

	public int getPasseVez() {
		return passeVez;
	}

	public void setPasseVez(int passeVez) {
		this.passeVez = passeVez;
	}

	public double getGastouCompras() {
		return gastouCompras;
	}

	public void setGastouCompras(double gastouCompras) {
		this.gastouCompras = gastouCompras;
	}
	
}
