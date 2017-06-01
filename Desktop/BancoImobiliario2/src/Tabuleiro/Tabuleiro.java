package Tabuleiro;

import java.io.File;
import java.util.ArrayList;

import Imoveis.*;
import Jogadores.Jogador;
import ManipulacaoArquivo.LerArquivo;

public class Tabuleiro {
	private int tamanho;
	private ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();
	private ArrayList<Jogador> listaJogadores = new ArrayList<Jogador>();
	

	public void criaListaJogadores(){
		Jogador banco = new Jogador("banco", 10000000);
		Jogador semJogador = new Jogador("Sem jogador",0);
		this.listaJogadores.add(semJogador);
		for(int i=1 ; i<this.tamanho; i++)
			if(this.listaImoveis.get(i).getNome() != "Passe a vez"){
				this.listaJogadores.add(banco);
			}
			else{
				this.listaJogadores.add(semJogador);
			}
	}
	public void gerarTabuleiro(){
		File file = new File("tabuleiro1.txt");
		LerArquivo leitura = new LerArquivo(file, 1);
		int posicao;
		this.tamanho = Integer.parseInt(leitura.getDadosArquivo().get(0).get(0));
		
		for (int i = 1; i <leitura.getDadosArquivo().size(); i++) {
			for (int j = 2; j < leitura.getDadosArquivo().get(i).size(); j++) {
				if(j == 2){
					
					posicao = Integer.parseInt(leitura.getDadosArquivo().get(i).get(j-1));
					if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 1){
						Start start = new Start();
						listaImoveis.add(posicao-1, start);
					}
					else if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 2){
						PasseVez passe = new PasseVez();
						listaImoveis.add(posicao-1, passe);						
					}
					else if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 3){
						j++;
						if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 1){
							Residencia res = new Residencia();
							j++;							
							res.setValor(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)));
							j++;
							res.setTaxa(res.getValor()*((double)(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)))/100));
							listaImoveis.add(posicao-1, res);
						}else if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 2){
							Comercio com = new Comercio();
							j++;
							com.setValor(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)));
							j++;
							com.setTaxa(com.getValor()*((double)(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)))/100));
							listaImoveis.add(posicao-1, com);
						}else if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 3){
							Industria ind = new Industria();
							j++;
							ind.setValor(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)));
							j++;
							ind.setTaxa(ind.getValor()*((double)(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)))/100));
							listaImoveis.add(posicao-1, ind);
						}else if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 4){
							Hotel hot = new Hotel();
							j++;
							hot.setValor(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)));
							j++;
							hot.setTaxa(hot.getValor()*(((double)Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)))/100));
							listaImoveis.add(posicao-1, hot);
						}else if(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)) == 5){
							Hospital hos = new Hospital();
							j++;
							hos.setValor(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)));
							j++;
							hos.setTaxa(hos.getValor()*((double)(Integer.parseInt(leitura.getDadosArquivo().get(i).get(j)))/100));
							listaImoveis.add(posicao-1, hos);
						}
					}
					
				}
				
			}
		}
			
			
			
	}

	public int getTamanho() {
		return tamanho;
	}


	public ArrayList<Imovel> getListaImoveis() {
		return listaImoveis;
	}

	
	public ArrayList<Jogador> getListaJogadores() {
		return listaJogadores;
	}

	public void setListaJogadores(Jogador jog) {
		this.listaJogadores.set(jog.getPosicao(), jog);
	}
	
	public void setListaJogadores(ArrayList<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
	public void imprimeTabuleiro(){
		int i;
		
		for(i = 0; i < this.tamanho; i++){
			System.out.println("Posicao: " +(i+1) +" Imovel: " + listaImoveis.get(i).getNome() + " Taxa: " + listaImoveis.get(i).getTaxa()
					+ " Valor: " + listaImoveis.get(i).getValor() + " Dono " + listaJogadores.get(i));
		}
	}
}
