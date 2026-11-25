package Controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import Model.E_DataUsuario;
import Model.E_Usuario;

public class C_Login {
	public E_DataUsuario dataUsuario = new E_DataUsuario();
	
	public boolean FazerLogin(E_Usuario user, String email, String senha) {
		boolean logado = dataUsuario.ConsultarDadosUsuario(email, senha);
		if(logado) {
			user.setEmail(email);
			user.setSenha(senha);
			return true;
		}else {
			return false;
		}
	}
	
	public void CriarLogin(String email, String senha) {
		dataUsuario.CriarLogin(email, senha);
		JOptionPane.showMessageDialog(null, "Cadastro realizado!");
	}
	
	public boolean alterarLogin(String email, String senha) throws IOException {
		boolean alterado = dataUsuario.alterarLogin(email, senha);
		if(alterado) {
			JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "Erro ao alterar a senha");
			return false;
		}
		
	}

}
