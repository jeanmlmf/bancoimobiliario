package ManipulacaoArquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreverArquivo {

	private File file;
	
	public EscreverArquivo(File file){
		this.file = file;
	}
	
	public void escreveDados(List<String> escrever){
		BufferedWriter escritor;
		

		try {
			escritor = new BufferedWriter(new FileWriter(file));
			for(int i = 0; i<escrever.size();i++){
				escritor.write(escrever.get(i));
				escritor.newLine();
			}
			escritor.close();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch(IOException ex){
			ex.printStackTrace();
			
		}
	}
}
