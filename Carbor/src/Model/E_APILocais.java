package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class E_APILocais {
	
	private String linhaJson; 
	
	public E_APILocais(String bairro) {
		try {
			// Adicionado +Amazonas para garantir precisão e evitar confusões no mapa
			String urlString = "https://nominatim.openstreetmap.org/search?q=" + bairro.replace(" ", "+") + ",+Manaus,+Amazonas&format=json";
			
			URL url = new URL(urlString);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			
			conexao.setRequestMethod("GET");
			conexao.setRequestProperty("User-Agent", "Carbor/1.0 (gdag.eng25@uea.edu.br)");
			
			int resposta = conexao.getResponseCode();
			
			if(resposta == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
				String linha;
				StringBuilder responseContent = new StringBuilder();
				
				while((linha = reader.readLine()) != null) {
					responseContent.append(linha);
				}
				reader.close();
				
				linhaJson = responseContent.toString();
			} else {
				System.out.println("O OpenStreetMap bloqueou a requisição do bairro: " + bairro + " (Código: " + resposta + ")");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public double ObterLatitude() {
		if (linhaJson == null || linhaJson.length() < 10) {
			return 0.0;
		}
		
		try {
			// Usando indexOf (primeiro resultado) e extraindo a coordenada entre as aspas exatas
			int i1 = linhaJson.indexOf("\"lat\":\"") + 7;
			int i2 = linhaJson.indexOf("\"", i1); // Busca aspas de fechamento
			String lat = linhaJson.substring(i1, i2);
			return Double.parseDouble(lat);
		} catch (Exception e) {
			return 0.0;
		}
	}
	
	public double ObterLongitude() {
		if (linhaJson == null || linhaJson.length() < 10) {
			return 0.0;
		}
		
		try {
			// Usando indexOf (primeiro resultado) e extraindo a coordenada entre as aspas exatas
			int i1 = linhaJson.indexOf("\"lon\":\"") + 7;
			int i2 = linhaJson.indexOf("\"", i1); // Busca aspas de fechamento
			String lon = linhaJson.substring(i1, i2);
			return Double.parseDouble(lon);
		} catch (Exception e) {
			return 0.0;
		}
	}
}