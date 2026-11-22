package View;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Controller.C_MapadeCalor;
import Model.E_Usuario;
import java.awt.Font;

public class F_Panorama extends JFrame{
	public F_Panorama(E_Usuario usuario, C_MapadeCalor mapaDeCalor) {
		getContentPane().setBackground(new Color(255, 255, 255));		
		setResizable(false);
		setSize(1076, 374);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		Double tempMedia = mapaDeCalor.getTempMedia();
		String tempFormat = String.format("%.1f", tempMedia);
		
		JLabel statusLbl = new JLabel("");
		statusLbl.setHorizontalAlignment(SwingConstants.CENTER);
		statusLbl.setForeground(new Color(255, 255, 255));
		statusLbl.setFont(new Font("Segoe UI", Font.BOLD, 27));
		statusLbl.setOpaque(true);;
		statusLbl.setBounds(725, 183, 263, 78);
		
		if(tempMedia <= 27) {
			statusLbl.setBackground(Color.BLUE);
			statusLbl.setText("Saudável");
		}
		if(tempMedia > 27 && tempMedia <=30) {
			statusLbl.setBackground(Color.GREEN);
			statusLbl.setText("Moderado");
		}
		if(tempMedia > 30 && tempMedia <= 35) {
			statusLbl.setBackground(Color.ORANGE);
			statusLbl.setText("Atenção");
		}
		if(tempMedia > 35) {
			statusLbl.setBackground(Color.RED);
			statusLbl.setText("Alerta");
		}
		
		getContentPane().add(statusLbl);
		
		
		JLabel tempMediaLbl = new JLabel("");
		tempMediaLbl.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		tempMediaLbl.setBounds(86, 183, 571, 78);
		tempMediaLbl.setText(tempFormat+ "ºC");
		getContentPane().add(tempMediaLbl);
		
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
		barraSuperior.setIcon(new ImageIcon(F_Panorama.class.getResource("/View/barraSuperiorPanorama.png")));
		barraSuperior.setBounds(54, 33, 968, 71);
		getContentPane().add(barraSuperior);
		
		JLabel backgroundPanorama = new JLabel("");
		backgroundPanorama.setIcon(new ImageIcon(F_Panorama.class.getResource("/View/backgroundPanorama.png")));
		backgroundPanorama.setBounds(54, 114, 976, 187);
		getContentPane().add(backgroundPanorama);
	}
}
