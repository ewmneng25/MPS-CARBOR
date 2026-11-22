package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

import Controller.C_Login;
import Controller.C_MapadeCalor;
import Model.E_Usuario;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class F_Login extends JFrame{
	private JPasswordField textSenha;
	private C_MapadeCalor mapaDeCalor;
	public F_Login() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		getContentPane().setFocusable(true);
		
		JLabel cadastrarButton = new JLabel("");
		cadastrarButton.setBounds(155, 472, 123, 33);
		getContentPane().add(cadastrarButton);
	
		cadastrarButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				F_Cadastro tCad = new F_Cadastro();
				tCad.setLocationRelativeTo(null);
				tCad.setVisible(true);
				dispose();
			}
		});
		
		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textSenha.setBounds(185, 345, 364, 33);
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
		
		JTextArea textEmail = new JTextArea();
		textEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		textEmail.setBounds(185, 258, 364, 33);
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
		
		JLabel entrarButton = new JLabel("");
		entrarButton.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		entrarButton.setBackground(new Color(255, 255, 255));
		entrarButton.setBounds(305, 411, 123, 56);
		getContentPane().add(entrarButton);
		
		entrarButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String email, senha;
				email = textEmail.getText();
				senha = textSenha.getText();
				FazerLogin(email, senha);	
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(F_Login.class.getResource("/View/loginBackground.png")));
		background.setBounds(43, 10, 680, 571);
		getContentPane().add(background);
		
		JLabel esquecerSenhaButton = new JLabel("");
		esquecerSenhaButton.setBounds(427, 472, 148, 33);
		getContentPane().add(esquecerSenhaButton);
		setLocationRelativeTo(null);
		esquecerSenhaButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				F_RecuperarSenha tEsqSenha = new F_RecuperarSenha();
				tEsqSenha.setLocationRelativeTo(null);
				tEsqSenha.setVisible(true);
				dispose();
			}
		});
		setSize(737, 645);
		setResizable(false);
		
	}
	
	public void FazerLogin(String email, String senha) {
		boolean logado;
		E_Usuario user = new E_Usuario();
		user.setEmail(email);
		user.setSenha(senha);
		C_Login controlLog = new C_Login();
		logado = controlLog.FazerLogin(email, senha);
		if(logado) {
			JOptionPane.showMessageDialog(null, "Login realizado!");
			F_TelaPrincipal tp = new F_TelaPrincipal(user, mapaDeCalor);
			tp.setLocationRelativeTo(null);
			tp.setVisible(true);
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
		}
	}
	
	public void setMapadeCalor(C_MapadeCalor mapaDeCalor) {
		this.mapaDeCalor = mapaDeCalor;
	}
}
