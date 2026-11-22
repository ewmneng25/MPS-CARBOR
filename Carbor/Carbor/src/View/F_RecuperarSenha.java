package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import Controller.C_Login;

public class F_RecuperarSenha extends JFrame{
	private JPasswordField textSenha;
	public F_RecuperarSenha() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		getContentPane().setFocusable(true);
		
		JTextArea textEmail = new JTextArea();
		textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textEmail.setBounds(185, 208, 364, 33);
		getContentPane().add(textEmail);
		String startTextEmail = "Digite seu e-mail";
		textEmail.setForeground(Color.GRAY);
		textEmail.setText(startTextEmail);
		
		textEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(textEmail.getText().equals(startTextEmail)) {
					textEmail.setText("");
					textEmail.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(textEmail.getText().isEmpty()) {
					textEmail.setText(startTextEmail);
					textEmail.setForeground(Color.GRAY);
				}
				
			}
		});
		
		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textSenha.setBounds(185, 292, 364, 33);
		textSenha.setBorder(null);
		getContentPane().add(textSenha);
		
		String startTextSenha = "Digite sua senha";
		
		textSenha.setText(startTextSenha);
		textSenha.setEchoChar((char) 0);
		textSenha.setForeground(Color.GRAY);
		
		textSenha.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				String senhaAtual = new String(textSenha.getPassword());
				
				if(senhaAtual.equals(startTextSenha)) {
					textSenha.setText("");
					textSenha.setForeground(Color.BLACK);
					textSenha.setEchoChar('•');
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(textSenha.getPassword().length  == 0) {
					textSenha.setText(startTextSenha);
					textSenha.setForeground(Color.GRAY);
					textSenha.setEchoChar((char) 0);
				}
			}
			
		});
		
		String startTextNome = "Digite seu nome";
		
		JLabel salvarButton = new JLabel("");
		salvarButton.setBounds(433, 365, 135, 54);
		getContentPane().add(salvarButton);
		
		
		salvarButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String email, senha;
				email = textEmail.getText();
				senha = textSenha.getText();
				try {
					if(alterarSenha(email, senha)) {
						dispose();
						F_Login tLogin = new F_Login();
						tLogin.setLocationRelativeTo(null);
						tLogin.setVisible(true);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel sairButton = new JLabel("");
		sairButton.setBounds(296, 365, 135, 54);
		getContentPane().add(sairButton);
		
		sairButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				dispose();
				F_Login tLogin = new F_Login();
				tLogin.setLocationRelativeTo(null);
				tLogin.setVisible(true);
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(F_RecuperarSenha.class.getResource("/View/recuperarSenhaBackground.png")));
		background.setBounds(43, 10, 680, 571);
		getContentPane().add(background);
		setLocationRelativeTo(null);
		setSize(737, 645);
		setResizable(false);
	}
	
	public boolean alterarSenha(String email, String senha) throws IOException {
		C_Login esqSenha = new C_Login();
		boolean alterado = esqSenha.alterarLogin(email, senha);
		if(alterado) {
			return true;
		}else {
			return false;
		}
		
		
		
	}
	
}
