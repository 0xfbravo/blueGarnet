package br.com.fpimentel.administrador;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.fpimentel.Janela;
import br.com.fpimentel.db.Database;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.util.*;

public class Administrador extends Janela{
	static String queryLogin = "SELECT Usuario,Permissao FROM informacoesLogin";
	
	/*
	 * Método de Edição de Usuários do SQL
	 */		
	public void EditarUsuario(){
		try{	    
			JInternalFrame JIF = createFrame("Adicionar Usuário",200,500);
			PainelInterno.add(JIF);
			JDesktopPane PainelInternoJIF = new JDesktopPane();
			JIF.getContentPane().add(PainelInternoJIF, BorderLayout.CENTER);
			JIF.setFrameIcon(Arquivos.buscarIcone("img/page_white_wrench.png"));

			// ----- Botão Adicionar
			JButton btnAdicionar = new JButton("Salvar");
			btnAdicionar.setBounds(390, 125, 73, 35);
			PainelInternoJIF.add(btnAdicionar);
			
			JTable tabela = new JTable(buildTableModel(Database.consultaDB(queryLogin),false));
			tabela.setEnabled(false);
			JIF.add(tabela);
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * Método de Criação de Usuários do SQL
	 */		
	@SuppressWarnings({ "unchecked"})
	public void CriarUsuario(){
		try{	    
			JInternalFrame JIF = createFrame("Adicionar Usuário",200,500);
			PainelInterno.add(JIF);
			JDesktopPane PainelInternoJIF = new JDesktopPane();
			JIF.getContentPane().add(PainelInternoJIF, BorderLayout.CENTER);
			JIF.setFrameIcon(Arquivos.buscarIcone("img/user.png"));
			
			// ----- Usuário
			JLabel lblUsurio = new JLabel("Usuário:");
			lblUsurio.setBounds(30, 17, 52, 14);
			PainelInternoJIF.add(lblUsurio);	
			JButton btnAdicionar = new JButton("Adicionar");
			JTextField novoUsuario = new JTextField();
			JPasswordField novaSenha = new JPasswordField();
		
			novoUsuario.setColumns(10);
			novoUsuario.setBounds(30, 34, 256, 25);
			PainelInternoJIF.add(novoUsuario);
			novoUsuario.setName("Usuário");	
			// ----- Senha	
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setBounds(30, 64, 92, 14);
			PainelInternoJIF.add(lblSenha);
			novaSenha.setBounds(30, 81, 256, 25);
			PainelInternoJIF.add(novaSenha);
			novaSenha.setName("Senha");	
			// ----- AdmPermissao Antiga
			//JCheckBox permissaoAdm = new JCheckBox("Administrador");
			//permissaoAdm.setBounds(335, 34, 120, 14);
			//PainelInternoJIF.add(permissaoAdm);
			// ------ Tipo de Permissão
			JLabel lblTipoPermissao = new JLabel("Tipo de Permissão");
			lblTipoPermissao.setBounds(30, 111, 180, 14);
			PainelInternoJIF.add(lblTipoPermissao);
			@SuppressWarnings("rawtypes")
			JComboBox tipoPermissao = new JComboBox();
			tipoPermissao.addItem(NivelPermissao.Dev.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Adm.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Financeiro.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Fiscal.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Contabil.getNomePermissao());
			tipoPermissao.setBounds(30, 131, 140, 25);
			tipoPermissao.setToolTipText("Selecione o tipo de Permissão");
			PainelInternoJIF.add(tipoPermissao);
			
			// ----- Botão Adicionar
			btnAdicionar.setBounds(390, 125, 73, 35);
			PainelInternoJIF.add(btnAdicionar);
		/*
		 *  Ação ao clicar no botão de Adicionar Usuário
		 */
		btnAdicionar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				  String senha = new String(novaSenha.getPassword());
				  String verificarUsuario = "SELECT Usuario,Permissao FROM informacoesLogin WHERE Usuario='"+novoUsuario.getText()+"'";
				  String updateDB = "INSERT INTO informacoesLogin(Usuario,Senha,Permissao) VALUES";
				  ResultSet rs = Database.consultaDB(verificarUsuario);
				  try {
					if(rs.getString("Usuario") == novoUsuario.getText()){
						JOptionPane.showMessageDialog(null, "O nome de Usuário já está em uso.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}
				  }
				  catch (HeadlessException e1){
					  JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				  }
				  catch (SQLException e1) {
					  JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				  }
				
				// -- Usuário VAZIO
				if(novoUsuario.getText().equals("")){
					JOptionPane.showMessageDialog(null, "O nome de Usuário NÃO pode estar em branco.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				// -- Senha VAZIA
				else if(senha.equals("")){
					JOptionPane.showMessageDialog(null, "A Senha NÃO pode estar em branco.", "Aviso", JOptionPane.WARNING_MESSAGE);
				} else {
					// -----
					//  Criação dos Usuário c/ suas
					//     devidas Permissões
					// -----
					// Desenvolvedor
					if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Dev.getNomePermissao()){
						Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Dev.getNumPermissao()+")");
						JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
					}
					// Administrador
					if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Adm.getNomePermissao()){
						Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Adm.getNumPermissao()+")");
						JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
					}
					// Financeiro
					if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Financeiro.getNomePermissao()){
						Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Financeiro.getNumPermissao()+")");
						JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
					}
					// Fiscal
					if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Fiscal.getNomePermissao()){
						Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Fiscal.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
					}
					// Contábil
					if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Contabil.getNomePermissao()){
						Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Contabil.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
					}
					
				}
			}
		});
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * Método de Listar EMPRESAS do SQL
	 *    buscando informações do DB da ALTERDATA
	 */	
	public void ListarEmpresas(){
		try{		    
		    JInternalFrame JIF = createFrame("Listagem de Empresas",500,500);
		    JIF.setFrameIcon(Arquivos.buscarIcone("img/book.png"));
		    PainelInterno.add(JIF);
		
		    JTable tabela = new JTable(buildTableModel(
		    		Database.consultaDB("select CdEmpresa,NmEmpresa from wphd.Empresa order by CdEmpresa ASC",true),false));
		    tabela.setEnabled(false);
		    tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Código");
		    tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
		    tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nome");
		    JIF.add(new JScrollPane(tabela));
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/*
	 * Método de Listar Usuários do SQL
	 */	
	public void ListarUsuarios(){
		try{
		    
		    JInternalFrame JIF = createFrame("Listagem de Usuários",500,500);
		    JIF.setFrameIcon(Arquivos.buscarIcone("img/book_addresses.png"));
		    PainelInterno.add(JIF);
		
		    JTable tabela = new JTable(buildTableModel(Database.consultaDB(queryLogin+" order by Permissao ASC"),true));
		    tabela.setEnabled(false);
		    tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Usuário");
		    tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(200);
		    tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nível de Permissão");
		    JIF.add(new JScrollPane(tabela));
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

}
