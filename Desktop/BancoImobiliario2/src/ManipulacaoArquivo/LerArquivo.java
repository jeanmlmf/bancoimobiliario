package ManipulacaoArquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 * A classe LerArquivo representa a leitura de arquivos
 * de texto. O atributo file refere-se ao arquivo que deve
 * ser lido. Já o atributo dadosArquivo são as informações 
 * que estavam no arquivo organizadas de forma a utilizar
 * ao longo do programa
 * 
 */
public class LerArquivo {
	private File file;
	private List<List<String>> dadosArquivo;
	public LerArquivo(File file, int i){
		this.file = file;
		this.dadosArquivo = new ArrayList<List<String>>();
		if( i == 1){
			criaListaDadosdoArquivo();
			//imprimeLista();
		}
		else{
			criaListaDadosdoArquivoJogadas();
			imprimeLista();
		}
	}
	
	public List<String> leituraDados() {

		List<String> data = new ArrayList<String>();
		BufferedReader leitor;

		try {
			leitor = new BufferedReader(new FileReader(file));

			try {

				while (leitor.ready()) {
					String comando = leitor.readLine();
					data.add(comando);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return data;
	}
	public List<String> geraDadosSeparados(String comando) {
		List<String> novo = new ArrayList<String>();
		String[] split = comando.split(";");

		if (split.length <= 0)
			return null;

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}

		return novo;
	}
	
	private void criaListaDadosdoArquivo() {
		int i;
		List<String> dataFile = leituraDados();
		for (i = 0; i < dataFile.size(); i++) {

			if (dataFile.get(i).length() > 0) {
				dadosArquivo.add(geraDadosSeparados(dataFile.get(i)));
			} 
		}
	}
	public void imprimeLista(){
		for (int i = 0; i <dadosArquivo.size(); i++) {
			for (int j = 0; j < dadosArquivo.get(i).size(); j++) {
				
			//int a=	Integer.parseInt());
			System.out.print( " " +dadosArquivo.get(i).get(j)+" ");
			}
			System.out.print( "\n");
			
			
			
		}
	}

	public List<List<String>> getDadosArquivo() {
		return dadosArquivo;
	}
	/**
	 * Separa somente a primeira do arquivo jogadas porque o split é %
	 * @param comando
	 * @return
	 */
	public List<String> geraDadosSeparadosJogador(String comando) {
		List<String> novo = new ArrayList<String>();
		String[] split = comando.split("%");

		if (split.length <= 0)
			return null;

		for (String string : split) {
			if (!string.isEmpty())
				novo.add(string);
		}

		return novo;
	}
	//faz a leitura do arquivo completo com as separacoes do arquivo jogada
	private void criaListaDadosdoArquivoJogadas() {
		int i;
		List<String> dataFile = leituraDados();
		dadosArquivo.add(geraDadosSeparadosJogador(dataFile.get(0)));
		for (i = 1; i < dataFile.size(); i++) {

			if (dataFile.get(i).length() > 0) {
				dadosArquivo.add(geraDadosSeparados(dataFile.get(i)));
			} 
		}
	}

}
