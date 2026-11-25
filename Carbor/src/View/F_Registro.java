package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Controller.C_MapadeCalor;
import Controller.C_Registro;
import Model.E_APITemperatura;
import Model.E_Registro;
import Model.E_Usuario;

import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;

public class F_Registro extends JFrame{
	private int qtdMudas = 0;
	private String orcamentoInicial = "R$ 0,00";
	public F_Registro(E_Usuario usuario, C_MapadeCalor mapaDeCalor) {
		getContentPane().setBackground(new Color(255, 255, 255));		
		setResizable(false);
		setSize(1076, 541);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		String[] bairrosManaus = {
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
			};
		
		JComboBox bairrosComboBox = new JComboBox(bairrosManaus);
		bairrosComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		bairrosComboBox.setBackground(new Color(217, 217, 217));
		bairrosComboBox.setBounds(69, 171, 292, 42);
		bairrosComboBox.setBorder(null);
		getContentPane().add(bairrosComboBox);	
		
		JLabel labelCusto = new JLabel("New label");
		labelCusto.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		labelCusto.setBounds(445, 184, 540, 83);
		labelCusto.setText(orcamentoInicial);
		getContentPane().add(labelCusto);
		
		JLabel labelTemp = new JLabel("New label");
		labelTemp.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		labelTemp.setBounds(445, 362, 540, 83);
		labelTemp.setText("--ºC");
		getContentPane().add(labelTemp);
		
		JTextField txtQtdMudas = new JTextField();
		txtQtdMudas.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtQtdMudas.setBounds(69, 265, 164, 42);
		getContentPane().add(txtQtdMudas);
		txtQtdMudas.setColumns(10);
		txtQtdMudas.setText(String.valueOf(qtdMudas));
		
		txtQtdMudas.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale locale = new Locale("pt", "BR");
				NumberFormat format = NumberFormat.getCurrencyInstance(locale);
				qtdMudas = Integer.parseInt(txtQtdMudas.getText());
				qtdMudas -= 1;
				String local = (String) bairrosComboBox.getSelectedItem();
				Double temperatura = getReduzirTemperatura(local, qtdMudas);
				String tempFormat = String.format("%.1f", temperatura);
				labelTemp.setText(tempFormat+ "ºC");
				String orcamento = format.format(qtdMudas*450);
				labelCusto.setText(orcamento);
				
			}
			
		});
		
		JLabel registrarPlantioButton = new JLabel("");
		registrarPlantioButton.setBounds(50, 334, 325, 131);
		getContentPane().add(registrarPlantioButton);
		
		registrarPlantioButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int qMudas = Integer.parseInt(txtQtdMudas.getText());
				String local = (String) bairrosComboBox.getSelectedItem();
				String temp = labelTemp.getText().replace("ºC", "").replace(",", ".").trim();
				Float temperatura = Float.parseFloat(temp);
				labelTemp.setText(temperatura + "ºC");
				FazerRegistro(usuario, qMudas, local, temperatura);
				JOptionPane.showMessageDialog(null, "Plantio Registrado!");
			}
		});
		
		JLabel reduzirQtdButton = new JLabel("");
		reduzirQtdButton.setIcon(new ImageIcon(F_Registro.class.getResource("/View/reduzirQtd.png")));
		reduzirQtdButton.setBounds(299, 256, 48, 51);
		getContentPane().add(reduzirQtdButton);
		
		reduzirQtdButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Locale locale = new Locale("pt", "BR");
				NumberFormat format = NumberFormat.getCurrencyInstance(locale);
				qtdMudas = Integer.parseInt(txtQtdMudas.getText());
				qtdMudas -= 1;
				String local = (String) bairrosComboBox.getSelectedItem();
				Double temperatura = getReduzirTemperatura(local, qtdMudas);
				String tempFormat = String.format("%.1f", temperatura);
				labelTemp.setText(tempFormat+ "ºC");
				String orcamento = format.format(qtdMudas*450);
				labelCusto.setText(orcamento);
				txtQtdMudas.setText(String.valueOf(qtdMudas));
			}
		});
		
		JLabel aumentarQtdButton = new JLabel("");
		aumentarQtdButton.setIcon(new ImageIcon(F_Registro.class.getResource("/View/aumentarQtd.png")));
		aumentarQtdButton.setBounds(241, 256, 48, 51);
		getContentPane().add(aumentarQtdButton);
		
		aumentarQtdButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Locale locale = new Locale("pt", "BR");
				NumberFormat format = NumberFormat.getCurrencyInstance(locale);
				qtdMudas = Integer.parseInt(txtQtdMudas.getText());
				qtdMudas+=1;
				String local = (String) bairrosComboBox.getSelectedItem();
				Double temperatura = getReduzirTemperatura(local, qtdMudas);
				String tempFormat = String.format("%.1f", temperatura);
				labelTemp.setText(tempFormat+ "ºC");
				String orcamento = format.format(qtdMudas*450);
				labelCusto.setText(orcamento);
				txtQtdMudas.setText(String.valueOf(qtdMudas));
			}
		});		
		
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
		backgroundRegistroPlantio.setIcon(new ImageIcon(F_Registro.class.getResource("/View/backgroundRegistroPlantio.png")));
		backgroundRegistroPlantio.setBounds(51, 114, 1001, 367);
		getContentPane().add(backgroundRegistroPlantio);
		
		bairrosComboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i  = bairrosComboBox.getSelectedIndex();
				List<Double> tempList = mapaDeCalor.getTempList();
				double tempStart = tempList.get(i);
				String tempFormat = String.format("%.1f", tempStart);
				labelTemp.setText(tempFormat+ "ºC");
			}
		});
		
		
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
