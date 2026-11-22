package Carbor;

import java.util.ArrayList;
import java.util.List;

import Controller.C_MapadeCalor;
import View.F_Login;
import View.F_TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		C_MapadeCalor cMapaCalor = new C_MapadeCalor();
		F_Login tp = new F_Login();
		tp.setMapadeCalor(cMapaCalor);
		tp.setLocationRelativeTo(null);
		tp.setVisible(true);	

	}

}
