package br.com.fpimentel.graf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.fpimentel.Config;
import br.com.fpimentel.Database;
import br.com.fpimentel.enums.TipoInfoSplash;
import br.com.fpimentel.util.SplashBG;

public class Login extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// ----- Painel Interno LOGIN
	JDesktopPane PainelInterno = new JDesktopPane();
	
	/* Definições de Janela */
	public Login(String NomeJanela, int Largura, int Altura) {

		setIconImage(Config.imagemTituloJanela.getImage());		
		setVisible(true);
		setSize(Largura, Altura);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(NomeJanela);
		requestFocusInWindow();
		
		PainelInterno.setBackground(new Color(255,255,255,3));
		getContentPane().add(PainelInterno, BorderLayout.CENTER);
		
		JDesktopPane PainelInterno = new JDesktopPane();
		JButton btnEntrar = new JButton("Entrar");
		JTextField campoUsuario = new JTextField();
		JPasswordField campoSenha = new JPasswordField();
		
		setResizable(false);
		getContentPane().add(PainelInterno);
		// ----- Usuário
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
		// ----- Senha	
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
						campoSenha.requestFocus();
						break;
					default:
						break;
				}
			}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		// ----- Botão Entrar
		btnEntrar.setBounds(210, 115, 73, 35);
		PainelInterno.add(btnEntrar);
		/*
		 *  Ação ao clicar no botão de Logar
		 */
		btnEntrar.addActionListener(new ActionListener(){
		@SuppressWarnings("static-access")
		public void actionPerformed(ActionEvent e){
			String senha = new String(campoSenha.getPassword());
			setVisible(false);
			
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
			if(consultDB.acessarSistema(campoUsuario.getText(), senha) == true){
				splash.mudaMensagem("Conexão realizada com sucesso!",TipoInfoSplash.sucesso);
				try {
					procConsultDB.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				procConsultDB.interrupt();
				splash.splJanela.setVisible(false);
				PainelInterno.removeAll();
				PainelInterno.repaint();
				new JanelaPrincipal(Config.nomePrograma,Config.larguraPrograma,Config.alturaPrograma,campoUsuario.getText());
			} else {
				splash.splJanela.setVisible(false);
				setVisible(true);
			}
		}
		});
	}
}
