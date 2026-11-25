package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.C_MapadeCalor;
import Controller.C_Registro;
import Model.E_Usuario;

public class F_DadosRegistros extends JFrame {
	F_DadosRegistros(E_Usuario usuario, C_MapadeCalor mapaDeCalor){
		getContentPane().setBackground(new Color(255, 255, 255));		
		setResizable(false);
		setSize(1076, 541);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNovaTemp = new JLabel("");
		lblNovaTemp.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNovaTemp.setBounds(579, 355, 392, 94);
		getContentPane().add(lblNovaTemp);
		
		JLabel lblQtdMudas = new JLabel("");
		lblQtdMudas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblQtdMudas.setBounds(66, 355, 392, 94);
		getContentPane().add(lblQtdMudas);
		
		JLabel lblCusto = new JLabel("");
		lblCusto.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblCusto.setBounds(579, 180, 392, 94);
		getContentPane().add(lblCusto);
		
		JLabel lblBairro = new JLabel("");
		lblBairro.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblBairro.setBounds(78, 180, 392, 94);
		getContentPane().add(lblBairro);
		
		JLabel sairButton = new JLabel("");
		sairButton.setBounds(944, 46, 61, 42);
		getContentPane().add(sairButton);
		
		sairButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				F_TelaPrincipal tp = new F_TelaPrincipal(usuario, mapaDeCalor);
				tp.setLocationRelativeTo(null);
				tp.setVisible(true);
			}
		});
		
		JLabel barraSuperior = new JLabel("");
		barraSuperior.setIcon(new ImageIcon(F_Registro.class.getResource("/View/barraSuperiorRegistro.png")));
		barraSuperior.setBounds(54, 33, 968, 71);
		getContentPane().add(barraSuperior);
		
		JLabel backgroundRegistroPlantio = new JLabel("");
		backgroundRegistroPlantio.setIcon(new ImageIcon(F_DadosRegistros.class.getResource("/View/dadosRegistroBackground.png")));
		backgroundRegistroPlantio.setBounds(51, 114, 971, 367);
		getContentPane().add(backgroundRegistroPlantio);
		
	}
	
	public void FazerRegistro(E_Usuario usuario, int qMudas, String local, double temperatura) {
		C_Registro cReg = new C_Registro();
		cReg.FazerRegistro(usuario, qMudas, local, temperatura);
	}
	
	public double getReduzirTemperatura(String local, int qtdMudas) {		
		C_Registro cReg = new C_Registro();
		Double temperaturaNova = cReg.ReduzirTemperatura(local, qtdMudas);
		return temperaturaNova;
	}
}
