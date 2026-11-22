package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.C_MapadeCalor;
import Model.E_Usuario;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class F_TelaPrincipal extends JFrame{
	public JLabel panoramaButton;
	public JLabel registroPlantioButton;
	public JLabel prioridadeSocialButton;
	public JLabel sairButton;
	public JLabel mapaCalorButton; 
	private C_MapadeCalor mapaDeCalor;
	
	public F_TelaPrincipal(E_Usuario usuario, C_MapadeCalor mapaDeCalor){
		
		this.mapaDeCalor = mapaDeCalor;
		getContentPane().setBackground(new Color(255, 255, 255));		
		setResizable(false);
		setSize(1076, 766);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panoramaButton = new JLabel("");
		panoramaButton.setIcon(new ImageIcon(F_TelaPrincipal.class.getResource("/view/PanoramaIcon.png")));
		panoramaButton.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
				F_Panorama tPan = new F_Panorama(usuario, mapaDeCalor);
				tPan.setLocationRelativeTo(null);
				tPan.setVisible(true);
				dispose();
			}
		});

		panoramaButton.setBounds(54, 127, 285, 265);
		getContentPane().add(panoramaButton);
		
		registroPlantioButton = new JLabel("");
	    registroPlantioButton.setIcon(new ImageIcon(F_TelaPrincipal.class.getResource("/view/RegistroPlantIcon.png")));
	    registroPlantioButton.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
				F_Registro tReg = new F_Registro(usuario, mapaDeCalor);
				tReg.setLocationRelativeTo(null);
				tReg.setVisible(true);
				dispose();
			}
		});
		registroPlantioButton.setBounds(737, 127, 285, 265);
		getContentPane().add(registroPlantioButton);
		
		prioridadeSocialButton = new JLabel("");
		prioridadeSocialButton.setIcon(new ImageIcon(F_TelaPrincipal.class.getResource("/view/PrioridadeIcon.png")));
		prioridadeSocialButton.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
				F_PrioridadeSocial tPriori = new F_PrioridadeSocial(usuario, mapaDeCalor);
				tPriori.setLocationRelativeTo(null);
				tPriori.setVisible(true);
				dispose();
			}
		});
		prioridadeSocialButton.setBounds(54, 424, 285, 265);
		getContentPane().add(prioridadeSocialButton);
		
		sairButton = new JLabel("");
		sairButton.setIcon(new ImageIcon(getClass().getResource("sairIcon.png")));
		sairButton.setBounds(737, 424, 285, 265);
		getContentPane().add(sairButton);
		
		mapaCalorButton = new JLabel("");
		mapaCalorButton.setIcon(new ImageIcon(F_TelaPrincipal.class.getResource("/view/MapaCalorIcon.png")));
		mapaCalorButton.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
				F_MapaCalor tMap = new F_MapaCalor(usuario, mapaDeCalor);
				tMap.setLocationRelativeTo(null);
				tMap.setVisible(true);
				dispose();
			}
		});
		mapaCalorButton.setBounds(389, 127, 285, 265);
		getContentPane().add(mapaCalorButton);
		
		JLabel relatorioGeralButton = new JLabel("");
		relatorioGeralButton.setIcon(new ImageIcon(F_TelaPrincipal.class.getResource("/view/RelatorioIcon.png")));
		relatorioGeralButton.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
				F_Relatorio tRelat = new F_Relatorio(usuario, mapaDeCalor);
				tRelat.setLocationRelativeTo(null);
				tRelat.setVisible(true);
				dispose();
			}
		});
		relatorioGeralButton.setBounds(389, 424, 285, 267);
		getContentPane().add(relatorioGeralButton);
		
		JLabel barraSuperior = new JLabel("");
		barraSuperior.setIcon(new ImageIcon(F_TelaPrincipal.class.getResource("/view/BarraSuperiorIcon.png")));
		barraSuperior.setBounds(54, 33, 968, 71);
		getContentPane().add(barraSuperior);
		
		
		sairButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
	}
}

