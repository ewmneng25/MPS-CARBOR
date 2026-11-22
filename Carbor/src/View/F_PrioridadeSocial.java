package View;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.C_MapadeCalor;
import Controller.C_PrioridadeSocial;
import Model.E_Usuario;
import java.awt.Font;
import javax.swing.SwingConstants;

public class F_PrioridadeSocial extends JFrame{
	public F_PrioridadeSocial(E_Usuario usuario, C_MapadeCalor mapaDeCalor) {
		getContentPane().setBackground(new Color(255, 255, 255));		
		setResizable(false);
		setSize(1076, 374);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		String bairro;
		Double temp;
		
		C_PrioridadeSocial cPri = new C_PrioridadeSocial(mapaDeCalor);
		
		bairro = cPri.getBairroMaior();
		temp = cPri.getTempMaior();
		
		JLabel statusLbl = new JLabel("");
		statusLbl.setOpaque(true);
		statusLbl.setHorizontalAlignment(SwingConstants.CENTER);
		statusLbl.setForeground(Color.WHITE);
		statusLbl.setFont(new Font("Segoe UI", Font.BOLD, 27));
		statusLbl.setBounds(725, 183, 263, 78);
		if(temp <= 27) {
			statusLbl.setBackground(Color.BLUE);
			statusLbl.setText("Saudável");
		}
		if(temp > 27 && temp <=30) {
			statusLbl.setBackground(Color.GREEN);
			statusLbl.setText("Moderado");
		}
		if(temp > 30 && temp <= 35) {
			statusLbl.setBackground(Color.ORANGE);
			statusLbl.setText("Atenção");
		}
		if(temp > 35) {
			statusLbl.setBackground(Color.RED);
			statusLbl.setText("Alerta");
		}
		getContentPane().add(statusLbl);
		
		JLabel bairroLbl = new JLabel("");
		bairroLbl.setFont(new Font("Segoe UI", Font.PLAIN, 27));
		bairroLbl.setBounds(86, 183, 571, 78);
		bairroLbl.setText(bairro);
		getContentPane().add(bairroLbl);
		
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
		barraSuperior.setIcon(new ImageIcon(F_PrioridadeSocial.class.getResource("/View/barraSuperiorPrioridade.png")));
		barraSuperior.setBounds(54, 33, 968, 71);
		getContentPane().add(barraSuperior);
		
		JLabel prioridadeBackground = new JLabel("");
		prioridadeBackground.setIcon(new ImageIcon(F_PrioridadeSocial.class.getResource("/View/backgroundPrioridade.png")));
		prioridadeBackground.setBounds(54, 114, 976, 187);
		getContentPane().add(prioridadeBackground);
	}
}
