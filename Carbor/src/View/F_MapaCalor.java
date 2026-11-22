package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Model.E_Usuario;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.BevelBorder;

import Controller.C_MapadeCalor;

public class F_MapaCalor extends JFrame{
	public F_MapaCalor(E_Usuario usuario, C_MapadeCalor mapaDeCalor) {
		getContentPane().setBackground(new Color(255, 255, 255));		
		setResizable(false);
		setSize(1076, 766);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
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
		barraSuperior.setIcon(new ImageIcon(F_MapaCalor.class.getResource("/View/barraSuperiorMapa.png")));
		barraSuperior.setBounds(54, 33, 968, 71);
		getContentPane().add(barraSuperior);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 142, 1042, 577);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(4, 4, 3, 3));
		
		List<Double> temp = mapaDeCalor.getTempList();
		List<String> bairros = mapaDeCalor.getBairrosList();

		for(int k = 0; k < temp.size(); k++) {
			JPanel panel_interno = new JPanel();
			String bairro = bairros.get(k);
			double tempDouble = temp.get(k);
			panel_interno.setToolTipText(bairro);
			if(tempDouble == 0.0) {
				String tempLbl = String.valueOf(tempDouble);
				JLabel lblTemp = new JLabel(tempLbl+ "ºC");
				lblTemp.setFont(new Font("Segoe UI", Font.BOLD, 17));
				lblTemp.setForeground(Color.WHITE);
				panel_interno.add(lblTemp);
				panel_interno.setBackground(Color.GRAY);
			}
			if(tempDouble <= 27 && tempDouble != 0.0) {
				String tempLbl = String.valueOf(tempDouble);
				JLabel lblTemp = new JLabel(tempLbl+ "ºC");
				lblTemp.setFont(new Font("Segoe UI", Font.BOLD, 17));
				lblTemp.setForeground(Color.WHITE);
				panel_interno.add(lblTemp);
				panel_interno.setBackground(Color.BLUE);
			}
			if(tempDouble > 27 && tempDouble <= 30) {
				String tempLbl = String.valueOf(tempDouble);
				JLabel lblTemp = new JLabel(tempLbl+ "ºC");
				lblTemp.setFont(new Font("Segoe UI", Font.BOLD, 17));
				lblTemp.setForeground(Color.WHITE);
				panel_interno.add(lblTemp);
				panel_interno.setBackground(Color.GREEN);
			}
			if(tempDouble > 30 && tempDouble <= 35) {
				String tempLbl = String.valueOf(tempDouble);
				JLabel lblTemp = new JLabel(tempLbl+ "ºC");
				lblTemp.setFont(new Font("Segoe UI", Font.BOLD, 17));
				lblTemp.setForeground(Color.WHITE);
				panel_interno.add(lblTemp);
				panel_interno.setBackground(Color.ORANGE);
			}
			if(tempDouble > 35) {
				String tempLbl = String.valueOf(tempDouble);
				JLabel lblTemp = new JLabel(tempLbl+ "ºC");
				lblTemp.setFont(new Font("Segoe UI", Font.BOLD, 17));
				lblTemp.setForeground(Color.WHITE);
				panel_interno.add(lblTemp);
				panel_interno.setBackground(Color.RED);
			}
			panel.add(panel_interno);
		}
		
	}
}
