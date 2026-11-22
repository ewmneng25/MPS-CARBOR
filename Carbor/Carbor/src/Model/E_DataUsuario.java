package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class E_DataUsuario {
	
	private final String caminhoArquivo = "dadosU.csv";
	
	public boolean ConsultarDadosUsuario(String email, String senha) {
		File arquivo = new File(caminhoArquivo);
		if(!arquivo.exists()) {//verificar se algum usuario foi cadastro
			return false;
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
			String linha;
			boolean p_linha = true;//primeira linha
			
			while((linha = br.readLine()) != null) {
				
				if(p_linha) {//iguinorar cabeçalho
					p_linha = false;
					continue;
				}
				
				String [] partes = linha.split(";");//quebra de linha ate ;
				if(partes.length >= 2) {
					String emailSalvo = partes[0].trim();
					String senhaSalva = partes[1].trim();
					
					if(emailSalvo.equals(email) && senhaSalva.equals(senha)) {
						return true;
					}
				}
			}
		}catch(IOException e) {//exceção
			e.printStackTrace();
		}
		
		return false;//login invalido
	}
	
	
	public void CriarLogin(String email, String senha) {
		File arquivo = new File(caminhoArquivo);
		
		try(PrintWriter pw = new PrintWriter(new FileWriter(caminhoArquivo, true))){
			
			if(arquivo.exists()) {
				pw.println("Email;Senha");
			}
			
			String linha = email + ";" + senha;
			pw.println(linha);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean alterarLogin(String email, String novaSenha) throws IOException {
		File arquivo = new File(caminhoArquivo);
		boolean alterada = false;
		List<String> linhas = new ArrayList<>();
		if(!arquivo.exists()) {//verificar se algum usuario foi cadastro
			return false;
		}
			
			try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
				String linha;
				boolean p_linha = true;//primeira linha
				
				
				while((linha = br.readLine()) != null) {
					
					if(p_linha) {//ignorar cabeçalho
						p_linha = false;
						linhas.add(linha);
						continue;
					}
					
					String [] partes = linha.split(";");//quebra de linha ate ;
					if(partes.length >= 2) {
						String emailSalvo = partes[0].trim();
						
						if(email.equals(emailSalvo)) {
							partes[1] = novaSenha;
							linha = String.join(";", partes);
							alterada = true;
							System.out.println(partes[1]);
						}
					}
					linhas.add(linha);
				}
				
			}catch(IOException e) {//exceção
				e.printStackTrace();
			}
			
			if(alterada) {
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))){
					for(int i = 0; i < linhas.size(); i++) {
						bw.write(linhas.get(i));
						bw.newLine();
					}
					return true;
				}catch(IOException e) {
					return false;
				}
			}
			
			return false;//login invalido
			
			
		}
}
