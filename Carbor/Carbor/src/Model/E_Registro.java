package Model;

public class E_Registro {

	private int qMudas;
	private String local;
	private float orcamento;
	private double temperatura;
	
	public void Registro() {
		qMudas = 0;
		local = "";
		orcamento = 0;
		temperatura = 0;
	}
	
	public void FazerRegistro(int qMudas, String local, double temperatura) {
		this.qMudas = qMudas;
		this.local = local;
		orcamento = 450*qMudas;
		this.temperatura = temperatura;
	}

	public int ConsultarMudas() {
		return qMudas;
	}
	
	public float ConsultarOrcamento() {
		return orcamento;
	}
	
	public String ConsultarLocal() {
		return local;
	}
	
	public Double ConsultarTemperatura() {
		return temperatura;
	}


	public void setqMudas(int qMudas) {
		this.qMudas = qMudas;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}

	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}
	
	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}
	
	public double velocidade(double v) {//calculo da alteração da velocidade do ar
		double u = v*(1-(1-0.1)*Math.exp(-0.15*(100/2.5)));//velocidade antes do plantio
		
		return u;
	}
	
	public double umidade(double et0, double T, int qMudas) {//calculo da alteração da umidade apartir do plantio
		double etc = et0*0.4*0.5*0.8;//evapotranspiração da cultura
		
		double Ma = (12.57*qMudas)*etc;//massa de agua liberada
		
		double Va = (Math.PI*Math.pow(100, 2))*500;//volume de ar
		
		double h_Ua = (Ma*1000)/Va;//umidade absoluta
		
		double e = 6.105*Math.exp((17.27*T)/(237.3+T));//pressão de satuação
		
		double Uat = (216.7*e)/(T+273.15);//Densidade maxima de vapor
		
		double Ur = (h_Ua/Uat)*100;//Aumento na umidade relativa
		
		return Ur; 
	}
	
	public double ReduzirTemperatura(double T, double v, double et0, int qMudas) {
	    double areaMudas = qMudas * 12.5;
	    double areaCirculo100m = Math.PI * Math.pow(100, 2);
	    double cArb = (areaMudas * 100.0) / areaCirculo100m; 
	    
	    double k = 0.15; 
	    double quedaTemperaturaAr = cArb * k;

	    double T_com_arvores = T - quedaTemperaturaAr;
	    
	    if(areaMudas == 0) {
	    		this.temperatura = T;
	    		System.out.println(temperatura);
	    		return temperatura;
	    }else {
	    		this.temperatura = T_com_arvores + (0.33 * umidade(et0, T, qMudas)) - (0.1 * velocidade(v));
		    System.out.println(temperatura);
		    return temperatura;
	    }
	    
	}
}