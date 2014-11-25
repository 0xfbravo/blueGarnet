package br.com.fpimentel.graf;
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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import br.com.fpimentel.Config;
import br.com.fpimentel.db.Database;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.util.BackgroundPane;

public class JanelaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeUsuario;
	public String getNomeUsuario(){ return this.nomeUsuario; }
	public void setNomeUsuario(String nomeUsuario){ this.nomeUsuario = nomeUsuario; }
	
	// ----- Painel Interno JANELA PRINCIPAL
	public static JDesktopPane PainelInterno = new JDesktopPane();
	// ----- Menu
	public static JMenuBar barraMenu = new JMenuBar();
	public static JDesktopPane barraMenuL = new JDesktopPane();
	
	
	/* ------------------------------------------------------------- */
	public JanelaPrincipal(String NomeJanela, int Largura, int Altura,String nomeUsuario) {
		PainelInterno = new BackgroundPane();
		setIconImage(Config.imagemTituloJanela.getImage());
		this.setNomeUsuario(nomeUsuario);
		setVisible(true);
		setSize(Largura, Altura);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(NomeJanela);
		setResizable(true);
		
		PainelInterno.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(PainelInterno);
	
		// ----- Criação do Menu na Janela
		@SuppressWarnings("unused")
		Menu menu = new Menu();
		Menu.criarMenu(verificarPermissao());
		setJMenuBar(barraMenu);
		GridLayout layoutMenu = new GridLayout(0,1);
		barraMenuL.setLayout(layoutMenu);
		add(barraMenuL, BorderLayout.WEST);
		JLabel lblCopyright = new JLabel("Desenvolvido por Fellipe Pimentel © 2014");
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setOpaque(true);
		lblCopyright.setBackground(new Color(45,45,45));
		add(lblCopyright, BorderLayout.SOUTH);
	}
	
	/* ------------------------------------------------------------- */	
	/*
	 * Método para verificarPermissao
	 * 		a partir do Usuário salvo é feita uma busca
	 * 		se ele tem permissão de Administrador ou não
	 */
	public int verificarPermissao(){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(Database.url,Database.userDB,Database.passDB);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    rs = stmt.executeQuery("SELECT Permissao FROM bg_informacoesLogin WHERE Usuario='"+this.getNomeUsuario()+"'");
		    while(rs.next()){
		    	if(rs.getInt("Permissao") == NivelPermissao.Adm.getNumPermissao()){
		    		return NivelPermissao.Adm.getNumPermissao();
		    	}
		    	else if(rs.getInt("Permissao") == NivelPermissao.Dev.getNumPermissao()){
		    		return NivelPermissao.Dev.getNumPermissao();
		    	}
		    	else if(rs.getInt("Permissao") == NivelPermissao.Financeiro.getNumPermissao()){
		    		return NivelPermissao.Financeiro.getNumPermissao();
		    	}
		    	else if(rs.getInt("Permissao") == NivelPermissao.Fiscal.getNumPermissao()){
		    		return NivelPermissao.Fiscal.getNumPermissao();
		    	}
		    	else if(rs.getInt("Permissao") == NivelPermissao.Contabil.getNumPermissao()){
		    		return NivelPermissao.Contabil.getNumPermissao();
		    	}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return 255;
	}
	
	/**
     * Exibe o arquivo (boleto) na tela.
     * 
     * @param arquivoBoleto
     */
    public static void mostreBoletoNaTela(File arquivoBoleto) {

            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
            
            try {
                    desktop.open(arquivoBoleto);
            } catch (IOException e) {
            	JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
            }

    }		
	
	/*
	 * Método para criação da Janela Interna
	 */
	public static JInternalFrame createFrame(String t, int Altura, int Largura) {
		      JInternalFrame f = new JInternalFrame(t);
		      f.setResizable(false);
		      f.setClosable(true);
		      f.setVisible(true);
		      f.setSize(Largura,Altura);
		      Dimension tamanhoPainelInterno = PainelInterno.getSize();
		      //System.out.println(tamanhoPainelInterno.toString());
		      Dimension tamanhoJanelaInterna = f.getSize();
		      //System.out.println(tamanhoJanelaInterna.toString());
		      f.setLocation((tamanhoPainelInterno.width - tamanhoJanelaInterna.width)/2,
		          (tamanhoPainelInterno.height- tamanhoJanelaInterna.height)/2);
		      return f;
	}
}
