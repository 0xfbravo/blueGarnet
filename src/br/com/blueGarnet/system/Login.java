package br.com.blueGarnet.system;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel © 2014
										 www.fcode.co
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.blueGarnet.enums.NivelPermissao;
import br.com.blueGarnet.enums.TipoInfoSplash;
import br.com.blueGarnet.graphics.JanelaPrincipal;
import br.com.blueGarnet.graphics.SplashBG;

public class Login extends JFrame{
	private static final long serialVersionUID = 1L;
	
	JDesktopPane PainelInterno = new JDesktopPane(); 	// Painel Interno
	JButton btnEntrar = new JButton("Entrar");			// Botão Entrar
	JTextField campoUsuario = new JTextField();		// Campo de Usuário
	JPasswordField campoSenha = new JPasswordField();	// Campo de Senha
	
	public Login(String NomeJanela, int Largura, int Altura) {
		/* Definições de Janela */
		setIconImage(Config.imagemTituloJanela.getImage());		
		setVisible(true); 
		setSize(Largura, Altura);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(NomeJanela);
		
		PainelInterno.setBackground(new Color(255,255,255,3));
		getContentPane().add(PainelInterno, BorderLayout.CENTER);
		
		setResizable(false);
		/* :: Campo Usuário :: */
		JLabel lblUsurio = new JLabel("Usuário:");
		lblUsurio.setBounds(30, 17, 52, 14);
		PainelInterno.add(lblUsurio);	
		campoUsuario.setColumns(10);
		campoUsuario.setBounds(30, 34, 256, 25);
		PainelInterno.add(campoUsuario);
		campoUsuario.setName("Usuário");	
		campoUsuario.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				switch (arg0.getKeyCode()){
					case KeyEvent.VK_ENTER:
						campoSenha.requestFocus();
						break;
					default:
						break;
				}
			}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		/* :: Campo Senha :: */
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(30, 64, 92, 14);
		PainelInterno.add(lblSenha);
		campoSenha.setBounds(30, 81, 256, 25);
		PainelInterno.add(campoSenha);
		campoSenha.setName("Senha");
		campoSenha.addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent arg0) {}
			@Override
			public void keyReleased(KeyEvent arg0) {
				switch (arg0.getKeyCode()){
					case KeyEvent.VK_ENTER:
						btnEntrar.requestFocus();
						break;
					default:
						break;
				}
			}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		
		/* :: Botão "Entrar" :: */
		btnEntrar.setBounds(210, 115, 73, 35);
		PainelInterno.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				
				String senha = new String(campoSenha.getPassword());
			
				// - Criação SplashScreen & seu Processo
				SplashBG splash = new SplashBG();
				splash.mudaMensagem("Conectando ao servidor...",TipoInfoSplash.acessoDB);
				Thread processoSplash = new Thread(splash);
				processoSplash.start();
			
				// - Criação da Consulta ao DB & seu Processo
				Database consultDB = new Database();
				Thread procConsultDB = new Thread(consultDB);
				procConsultDB.start();
				
				while(procConsultDB.isAlive()){ splash.splJanela.repaint(); }
				
				if(consultDB.acessarSistema(campoUsuario.getText(), senha)){
					splash.mudaMensagem("Conexão realizada com sucesso!",TipoInfoSplash.sucesso);
					try { Thread.sleep(1000); }
					catch (InterruptedException e1) {e1.printStackTrace();}
					procConsultDB.interrupt();
					splash.splJanela.setVisible(false);
					JanelaPrincipal janelaPrincipal = new JanelaPrincipal(verificarPermissao(campoUsuario.getText()));
					janelaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} else {
					splash.splJanela.setVisible(false);
					setVisible(true);
				}
			}
		});
	}

	/* ------------------------------------------------------------- */	
	/*
	 * Método para verificarPermissao
	 * 		a partir do Usuário salvo é feita uma busca
	 * 		se ele tem permissão de Administrador ou não
	 */
	public int verificarPermissao(String user){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(Database.url,Database.userDB,Database.passDB);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    rs = stmt.executeQuery("SELECT Permissao FROM bg_informacoesLogin WHERE Usuario='"+user+"'");
		    while(rs.next()){
		    	switch(rs.getInt("Permissao")){
		    		case 99:
		    			return NivelPermissao.Dev.getNumPermissao();
		    		case 0:
		    			return NivelPermissao.Adm.getNumPermissao();
		    		case 1:
		    			return NivelPermissao.Financeiro.getNumPermissao();
		    		case 2:
		    			return NivelPermissao.Fiscal.getNumPermissao();
		    		case 3:
		    			return NivelPermissao.Contabil.getNumPermissao();
		    	}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return 255;
	}
}
