package Model;

import java.net.URI;// indentificar se é valido URL
import java.net.http.HttpClient;//gerencia a comunicação entre programa e internet
import java.net.http.HttpRequest;//representa oq estou pedindo 
import java.net.http.HttpResponse;//representa a resposta do servidor

public class APITemperatura {
	
	public static String BuscarTemperatura(double latitude, double longitude) {
		
		String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=temperature_2m";
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if(response.statusCode() == 200) {
				String temp = response.body();
				
				int i1 = temp.lastIndexOf(":");
				int i2 = temp.lastIndexOf("}}");
				
				temp = temp.substring(i1 + 1, i2);
				
				return temp;
			}else {
				return "Erro";
			}
		}catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	public static String BuscarVelocidade(double latitude, double longitude) {
		String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=wind_speed_10m";
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if(response.statusCode() == 200) {
				String vel = response.body();
				
				int i1 = vel.lastIndexOf(":");
				int i2 = vel.lastIndexOf("}}");
				
				vel = vel.substring(i1 + 1, i2);
				
				return vel;
			}else {
				return "Erro";
			}
			
		}catch(Exception e) {
			return "Erro: " + e.getMessage();
		}
	}
	
	public static String BuscarET0(double latitude, double longitude) {
		String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&current=et0_fao_evapotranspiration";
		
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(url))
					.GET()
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			if(response.statusCode() == 200) {
				String et0 = response.body();
				
				int i1 = et0.lastIndexOf(":");
				int i2 = et0.lastIndexOf("}}");
				
				et0 = et0.substring(i1 + 1, i2);
				
				return et0;
			}else {
				return "Erro";
			}
		}catch(Exception e) {
			return "Erro" + e.getMessage();
		}
	}
}