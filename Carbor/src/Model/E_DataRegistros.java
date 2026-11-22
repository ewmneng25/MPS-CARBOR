package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class E_DataRegistros {
	
	private final String caminhoArquivo = "dadosR.csv";//dadosRegistros
	
	public boolean SalvarRegistro(E_Usuario usuario, E_Registro registro) {
		File arquivo = new File(caminhoArquivo);
		
		try(PrintWriter pw = new PrintWriter(new FileWriter(caminhoArquivo, true))){
			if(!arquivo.exists()) {
				pw.println("Email;Local;Mudas;Nova Temperatura;Orcamento");
			}
			
			String linha = usuario.getEmail() + ";" + registro.ConsultarLocal() + ";" + String.valueOf(registro.ConsultarMudas()) + ";" + String.valueOf(registro.ConsultarTemperatura()) + ";" + String.valueOf(registro.ConsultarOrcamento());
			pw.println(linha);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}