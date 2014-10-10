package br.com.fpimentel;
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
import br.com.fpimentel.util.SplashScreen;

public class Janela{
	/*
	 *   Definições do Programa
	 */
	public static String versaoPrograma = "v0.4b";
	static String nomePrograma = "blueGarnet "+versaoPrograma;
	static int alturaPrograma = 600, larguraPrograma = 900;
	BufferedImage imagem;
	ImageIcon imagemTituloJanela = Arquivos.buscarIcone("img/blueGarnet.png");
	
	private String nomeUsuario;
	public String getNomeUsuario(){ return this.nomeUsuario; }
	public void setNomeUsuario(String nomeUsuario){ this.nomeUsuario = nomeUsuario; }
	
	// ----- Janela Externa
	JFrame Janela = new JFrame();
	// ----- Painel Interno JANELA
	public static JDesktopPane PainelInterno = new JDesktopPane();
	// ----- Menu
	public static JMenuBar barraMenu = new JMenuBar();
	
	
	/* ------------------------------------------------------------- */
	public Janela(){}
	public Janela(String NomeJanela, int Largura, int Altura){
		/* Definições de Janela */
		
		Janela.setIconImage(imagemTituloJanela.getImage());
		
		Janela.setVisible(true);
		Janela.setSize(Largura, Altura);
		Janela.setLocationRelativeTo(null);
		Janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Janela.setTitle(NomeJanela);
		
		PainelInterno.setBackground(new Color(255,255,255,3));
		Janela.getContentPane().add(PainelInterno, BorderLayout.CENTER);
		
		JDesktopPane PainelInterno = new JDesktopPane();
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
			Janela.setVisible(false);
			new SplashScreen();
			if(Login.verificarUsuario(campoUsuario.getText()) == true){
					if(Login.verificarSenha(campoUsuario.getText(), senha) == true){
						//JOptionPane.showMessageDialog(null, "Você acessou o sistema como: "+campoUsuario.getText()+"", "Login com sucesso!", JOptionPane.INFORMATION_MESSAGE);
						PainelInterno.removeAll();
						PainelInterno.repaint();
						new Janela(nomePrograma,larguraPrograma,alturaPrograma,campoUsuario.getText());
					} else {
						JOptionPane.showMessageDialog(null, "A senha está errada.", "Erro", JOptionPane.ERROR_MESSAGE);
						Janela.setVisible(true);
					}
			} else {
				JOptionPane.showMessageDialog(null, "O usuário é inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
				Janela.setVisible(true);
			}
		}
		});	
	}
	public Janela(String NomeJanela, int Largura, int Altura,String nomeUsuario) {
		PainelInterno = new BackgroundPane();
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
			Connection conn = DriverManager.getConnection(Database.url,Database.userDB,Database.passDB);
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
	        		vector.add(rs.getObject(columnIndex));
	            	if(contemPermissao == true){
	            		// -- DEBUG
	            		//System.out.println("Coluna recebendo:"+rs.getInt("Permissao"));
	            		if(rs.getInt("Permissao") == NivelPermissao.Adm.getNumPermissao()){
	            			vector.add(NivelPermissao.Adm.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Financeiro.getNumPermissao()){
	            			vector.add(NivelPermissao.Financeiro.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Fiscal.getNumPermissao()){
	            			vector.add(NivelPermissao.Fiscal.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Contabil.getNumPermissao()){
	            			vector.add(NivelPermissao.Contabil.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Dev.getNumPermissao()){
	            			vector.add(NivelPermissao.Dev.getNomePermissao());
	            		}
	            	}
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}

}
