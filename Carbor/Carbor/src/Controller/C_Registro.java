package Controller;

import javax.swing.JOptionPane;

import Model.APILocais;
import Model.APITemperatura;
import Model.E_DataRegistros;
import Model.E_ListaRegistros;
import Model.E_Registro;
import Model.E_Usuario;

public class C_Registro {
		
	public void FazerRegistro(E_Usuario usuario, int qMudas, String local, double temperatura) {
		E_DataRegistros dataRegistros = new E_DataRegistros();
		E_Registro registros = new E_Registro();
		registros.FazerRegistro(qMudas, local, temperatura);
		dataRegistros.SalvarRegistro(usuario, registros);
	}
	
	public double ReduzirTemperatura(String local, int qMudas) {
		APITemperatura apiTemp = new APITemperatura();
		APILocais apiLocais = new APILocais(local);
		Double latitude = apiLocais.ObterLatitude();
		Double longitude = apiLocais.ObterLongitude();
		String temp = apiTemp.BuscarTemperatura(latitude, longitude);
		String veloc = apiTemp.BuscarVelocidade(latitude, longitude);
		String et = apiTemp.BuscarET0(latitude, longitude);
		Double T = Double.parseDouble(temp);
		Double v = Double.parseDouble(veloc);
		Double et0 = Double.parseDouble(et);
		E_Registro registros = new E_Registro();
		Double temperatura = registros.ReduzirTemperatura(T, v, et0, qMudas);
		return temperatura;
	}
}
