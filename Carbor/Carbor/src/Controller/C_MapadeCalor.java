package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Model.APILocais;
import Model.APITemperatura;
import Model.E_MapadeCalor;

public class C_MapadeCalor {
	
	private List<Double> tempList = new ArrayList<Double>();
	private List<String> bairrosList = new ArrayList<String>();
	public List<E_MapadeCalor> coordBairros = new ArrayList<E_MapadeCalor>();
	public APITemperatura apiTemp = new APITemperatura();
	private Double tempMedia = 0.0;
	private Double somaTemp = 0.0;
	
 	public C_MapadeCalor() {
 		List<String> bairrosDeManaus = Arrays.asList(
 			    "Centro",                 // Zona Sul
 			    "Cachoeirinha",           // Zona Sul
 			    "Adrianópolis",           // Zona Centro-Sul
 			    "Parque 10 de Novembro",  // Zona Centro-Sul
 			    "Aleixo",                 // Zona Centro-Sul
 			    "Compensa",               // Zona Oeste
 			    "Ponta Negra",            // Zona Oeste
 			    "Tarumã",                 // Zona Oeste
 			    "Alvorada",               // Zona Centro-Oeste
 			    "Dom Pedro",              // Zona Centro-Oeste
 			    "Coroado",                // Zona Leste
 			    "São José Operário",      // Zona Leste
 			    "Jorge Teixeira",         // Zona Leste
 			    "Cidade Nova",            // Zona Norte
 			    "Nova Cidade",            // Zona Norte
 			    "Santa Etelvina"          // Zona Norte
 			);
 		addCoordBairros(bairrosDeManaus);
 			    
 	    for(E_MapadeCalor i : coordBairros) {
 	    		double latitude = i.getLatitude();
 	    		double longitude = i.getLongitude();
 	    		String bairro = i.getBairro();
 	    		
 	    		String temp = apiTemp.BuscarTemperatura(latitude, longitude);
 	    		double tempDouble = 0.0;
 	    		try {
 	    			tempDouble = Double.parseDouble(temp);
 	    			tempList.add(tempDouble);	
 	    			somaTemp+=tempDouble;
 	    		}catch (NumberFormatException e) {
 	    	        // Se a API falhar, a temperatura desse bairro fica 0.0 para não travar a tela
 	    	        System.out.println("Falha ao buscar temperatura para o bairro: " + bairro);
 	    	        tempDouble = 0.0;
 	    		}
 	    	
 	    		    		
 	    		bairrosList.add(bairro);
 	    		
 	    		try {
	    			Thread.sleep(50);
	    		}catch(InterruptedException e) {
	    			e.printStackTrace();
	    		}
 	    		
 	    }
 	    
 	    tempMedia = somaTemp/16;
 	}
 	
 	public Double getTempMedia() {
		return tempMedia;
	}

	public void setTempMedia(Double tempMedia) {
		this.tempMedia = tempMedia;
	}



	public void addCoordBairros(List<String> bairrosManaus) {
 		for(String i : bairrosManaus) {
 			String stringBusca = i + ", Manaus, Amazonas";
 			APILocais apiLocais = new APILocais(stringBusca);
 			Double latitude = apiLocais.ObterLatitude();
 			Double longitude = apiLocais.ObterLongitude();
 			E_MapadeCalor mp = new E_MapadeCalor(i, latitude, longitude);
 			coordBairros.add(mp);
 			try {
	    			Thread.sleep(1000);
	    		}catch(InterruptedException e) {
	    			e.printStackTrace();
	    		}
 		}
 	}
 	
 	public List<Double> getTempList() {
		return tempList;
	}
 	
 	public List<String> getBairrosList(){
 		return bairrosList;
 	}
 
	
}
