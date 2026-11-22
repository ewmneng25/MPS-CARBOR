package View;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Controller.C_MapadeCalor;
import Model.E_ListaRegistros;
import Model.E_Registro;
import Model.E_Usuario;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class F_Relatorio extends JFrame{
	public F_Relatorio(E_Usuario usuario, C_MapadeCalor mapaDeCalor) {
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
		barraSuperior.setIcon(new ImageIcon(F_Relatorio.class.getResource("/View/barraSuperiorRelatorio.png")));
		barraSuperior.setBounds(54, 33, 968, 71);
		getContentPane().add(barraSuperior);
		
		String[] colunas = {"E-mail", "Bairro", "Quantidade de Mudas", "Nova Temperatura (ºC)", "Orçamento (R$)"};
		
		DefaultTableModel model = new DefaultTableModel(colunas, 0);
		
		JTable tabelaRelatorio = new JTable(model);
		tabelaRelatorio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(tabelaRelatorio);
		
		JScrollPane scrollPane = new JScrollPane(tabelaRelatorio);
		scrollPane.setBounds(37, 110, 985, 588);
		getContentPane().add(scrollPane);
		
		E_ListaRegistros listaReg = new E_ListaRegistros(usuario);
		List<E_Registro> listaRegTabela = listaReg.getListRegistros(); 
		
		for(E_Registro r : listaRegTabela) {
			model.addRow(new Object[] {
					usuario.getEmail(),
					r.ConsultarLocal(),
					r.ConsultarMudas(),
					r.ConsultarTemperatura(),
					r.ConsultarOrcamento()
			});
		}
	}
}
