package Controller;

import java.util.Arrays;
import java.util.List;

public class C_PrioridadeSocial {
	
	private String bairroMaior;
	private Double tempMaior;
	
	public C_PrioridadeSocial(C_MapadeCalor mapaDeCalor) {
		
		List<Integer> populacoesBairros = Arrays.asList(
			    27000,   // Centro (Zona Sul)
			    21000,   // Cachoeirinha (Zona Sul)
			    10500,   // Adrianópolis (Zona Centro-Sul)
			    40000,   // Parque 10 de Novembro (Zona Centro-Sul)
			    23500,   // Aleixo (Zona Centro-Sul)
			    85000,   // Compensa (Zona Oeste)
			    5500,    // Ponta Negra (Zona Oeste)
			    33000,   // Tarumã (Zona Oeste)
			    76000,   // Alvorada (Zona Centro-Oeste)
			    20000,   // Dom Pedro (Zona Centro-Oeste)
			    56000,   // Coroado (Zona Leste)
			    77000,   // São José Operário (Zona Leste)
			    130000,  // Jorge Teixeira (Zona Leste)
			    121000,  // Cidade Nova (Zona Norte)
			    65000,   // Nova Cidade (Zona Norte)
			    27000    // Santa Etelvina (Zona Norte)
			);
		
		List<String> bairrosList = mapaDeCalor.getBairrosList();
		List<Double> tempList = mapaDeCalor.getTempList();
		
		Double maior = tempList.get(0);
		int bairroPrioriIndice = 0;
		
		for(int j = 1; j < tempList.size(); j++) {
			double tempAtual = tempList.get(j);
			double tempMaiorBairro = tempList.get(bairroPrioriIndice);
			if(tempAtual > tempMaiorBairro) {
				bairroPrioriIndice = j;
			}else if(tempAtual == tempMaiorBairro) {
				if(populacoesBairros.get(j) > populacoesBairros.get(bairroPrioriIndice)) {
					bairroPrioriIndice = j;
				}
			}
		}
		
		bairroMaior = bairrosList.get(bairroPrioriIndice);
		tempMaior = tempList.get(bairroPrioriIndice);
	}

	public String getBairroMaior() {
		return bairroMaior;
	}

	public Double getTempMaior() {
		return tempMaior;
	}
}
