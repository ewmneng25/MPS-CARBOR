package Model;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;

public class E_ListaRegistros {
	
	private List<E_Registro> ListRegistros;
	
	public E_ListaRegistros(E_Usuario usuario) {
		
		this.ListRegistros = new ArrayList();
		
		final String caminhoArquivo = "dadosR.csv";
		File arquivo = new File(caminhoArquivo);
		
		if(arquivo.exists()) {
			try(BufferedReader br = new BufferedReader(new FileReader(arquivo))){
				String linha;
				boolean p_linha = true;
				while((linha = br.readLine()) != null) {
					
					if(p_linha) {//iguinorar cabeçalho
						p_linha = false;
						continue;
					}
					
					String[] partes = linha.split(";");
					
					if(partes.length >= 5 && partes[0].equals(usuario.getEmail())) {
						E_Registro registro = new E_Registro();
						registro.setLocal(partes[1]);
						registro.setqMudas(Integer.parseInt(partes[2]));
						Double temp = Double.parseDouble(partes[3]);
						String tempFormat = String.format("%.1f", temp).replace(",", ".");
						registro.setTemperatura(Double.parseDouble(tempFormat));
						float orc = Float.parseFloat(partes[4]);
						String orcFormat = String.format("%.1f", orc).replace(",", ".");
						registro.setOrcamento(Float.parseFloat(orcFormat));
						ListRegistros.add(registro);
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void AdicionarRegistro(E_Registro registro) {
		ListRegistros.add(registro);
	}
	
	public List<E_Registro> getListRegistros(){
		return ListRegistros;
	}
}