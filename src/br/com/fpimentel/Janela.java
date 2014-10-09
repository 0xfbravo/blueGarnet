package br.com.fpimentel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.fpimentel.db.Database;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.util.Arquivos;
import br.com.fpimentel.util.BackgroundPane;

public class Janela extends Database{
	/*
	 *   Definições do Programa
	 */
	static String nomePrograma = "blueGarnet v0.4b";
	static int alturaPrograma = 600, larguraPrograma = 900;
	BufferedImage imagem;
	ImageIcon imagemTituloJanela = Arquivos.buscarIcone("img/blueGarnet.png");
	
	String NomeJanela;
	int Altura,Largura;
	
	private String nomeUsuario;
	public String getNomeUsuario(){ return this.nomeUsuario; }
	public void setNomeUsuario(String nomeUsuario){ this.nomeUsuario = nomeUsuario; }
	
	String Usuario,Senha;
	boolean Adm;
	
	// ----- Janela Externa
	JFrame Janela = new JFrame();
	// ----- Painel Interno JANELA
	protected static JDesktopPane PainelInterno = new BackgroundPane();
	// ----- Menu
	public static JMenuBar barraMenu = new JMenuBar();
	
	
	/* ------------------------------------------------------------- */
	public void JanelaLogin(){
		JDesktopPane PainelInterno = new JDesktopPane();
		Login login = new Login();
		JButton btnEntrar = new JButton("Entrar");
		JTextField campoUsuario = new JTextField();
		JPasswordField campoSenha = new JPasswordField();
		
		Janela.setResizable(false);
		Janela.getContentPane().add(PainelInterno);
		// ----- Usuário
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(30, 17, 52, 14);
		PainelInterno.add(lblUsurio);	
		campoUsuario.setColumns(10);
		campoUsuario.setBounds(30, 34, 256, 25);
		PainelInterno.add(campoUsuario);
		campoUsuario.setName("Usuário");	
		// ----- Senha	
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 64, 92, 14);
		PainelInterno.add(lblSenha);
		campoSenha.setBounds(30, 81, 256, 25);
		PainelInterno.add(campoSenha);
		campoSenha.setName("Senha");	
		// ----- Botão Entrar
		btnEntrar.setBounds(210, 115, 73, 35);
		PainelInterno.add(btnEntrar);
		/*
		 *  Ação ao clicar no botão de Logar
		 */
		btnEntrar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String senha = new String(campoSenha.getPassword());
			if(login.realizarLogin(campoUsuario.getText(), senha) == true){
				Janela.setVisible(false);
				JOptionPane.showMessageDialog(null, "Você acessou o sistema como: "+campoUsuario.getText()+"", "Login com sucesso!", JOptionPane.INFORMATION_MESSAGE);
				PainelInterno.removeAll();
				PainelInterno.repaint();
				@SuppressWarnings("unused")
				Janela janela = new Janela(nomePrograma,larguraPrograma,alturaPrograma,campoUsuario.getText());
			}
		}
		});	
	}
	public Janela(){
		
	}
	public Janela(String NomeJanela, int Largura, int Altura, boolean Login){
		/* Definições de Janela */
		
		Janela.setIconImage(imagemTituloJanela.getImage());
		
		Janela.setVisible(true);
		Janela.setSize(Largura, Altura);
		Janela.setLocationRelativeTo(null);
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Janela.setTitle(NomeJanela);
		
		PainelInterno.setBackground(new Color(255,255,255,3));
		Janela.getContentPane().add(PainelInterno, BorderLayout.CENTER);
		
		if(Login == true){ JanelaLogin(); }
	
	}
	public Janela(String NomeJanela, int Largura, int Altura,String nomeUsuario) {
		Janela.setIconImage(imagemTituloJanela.getImage());
		Janela.setBackground(new Color(255,255,255,80));
		this.setNomeUsuario(nomeUsuario);
		Janela.setVisible(true);
		Janela.setSize(Largura, Altura);
		Janela.setLocationRelativeTo(null);
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Janela.setTitle(NomeJanela);
		Janela.setResizable(false);
		
		PainelInterno.setBackground(Color.LIGHT_GRAY);
		Janela.getContentPane().add(PainelInterno);
	
		// ----- Criação do Menu na Janela
		@SuppressWarnings("unused")
		Menu menu = new Menu();
		Menu.criarMenu(verificarPermissao());
		Janela.setJMenuBar(barraMenu);
		JLabel lblCopyright = new JLabel("Desenvolvido por Fellipe Pimentel © 2014");
		lblCopyright.setBounds(680, 525, 360, 14);
		lblCopyright.setForeground(new Color(255,255,255,45));
		PainelInterno.add(lblCopyright);
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
			Connection conn = DriverManager.getConnection(url,userDB,passDB);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    rs = stmt.executeQuery("SELECT * FROM informacoesLogin");
		    while(rs.next()){
		    	if(rs.getString("Usuario").equals(this.getNomeUsuario()) && rs.getInt("Permissao")
		    			== NivelPermissao.Adm.getNumPermissao()){
		    		return NivelPermissao.Adm.getNumPermissao();
		    	}
		    	else if(rs.getString("Usuario").equals(this.getNomeUsuario()) && rs.getInt("Permissao")
		    			== NivelPermissao.Dev.getNumPermissao()){
		    		return NivelPermissao.Dev.getNumPermissao();
		    	}
		    	else if(rs.getString("Usuario").equals(this.getNomeUsuario()) && rs.getInt("Permissao")
		    			== NivelPermissao.Financeiro.getNumPermissao()){
		    		return NivelPermissao.Financeiro.getNumPermissao();
		    	}
		    	else if(rs.getString("Usuario").equals(this.getNomeUsuario()) && rs.getInt("Permissao")
		    			== NivelPermissao.Fiscal.getNumPermissao()){
		    		return NivelPermissao.Fiscal.getNumPermissao();
		    	}
		    	else if(rs.getString("Usuario").equals(this.getNomeUsuario()) && rs.getInt("Permissao")
		    			== NivelPermissao.Contabil.getNumPermissao()){
		    		return NivelPermissao.Contabil.getNumPermissao();
		    	}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return 255;
	}

	/*
	 * Método para formatação de CNPJ, CPF e etc
	 * 		utilizando Máscaras
	 */
	protected static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
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
	 * Método para verificarLogin
	 * 		recebe o Usuário e procura ele no arquivo
	 */
	public boolean verificarUsuario(String Usuario){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url,userDB,passDB);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    rs = stmt.executeQuery("SELECT * FROM informacoesLogin");
		    while(rs.next()){
		    	if(rs.getString("Usuario").equals(Usuario)){
		    		//System.out.println("O Usuário está ok!");
		    		return true;
		    	}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}	
	
	/*
	 * Método para criação da Janela Interna
	 */
	protected JInternalFrame createFrame(String t, int Altura, int Largura) {
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
	
	/*
	 * Método para criação da Tabelas com SQL
	 */	
	public static DefaultTableModel buildTableModel(ResultSet rs,boolean contemPermissao)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        	if(contemPermissao == true){
	        		if(rs.getObject(columnIndex).toString() == "true"){
	        			vector.add("Administrador");
	        		} else if(rs.getObject(columnIndex).toString() == "false") {
	        			vector.add("Usuário");
	        		} else {
	        		vector.add(rs.getObject(columnIndex));
	        		}
	        	} else {
	        		vector.add(rs.getObject(columnIndex));
	        	}
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}

}
