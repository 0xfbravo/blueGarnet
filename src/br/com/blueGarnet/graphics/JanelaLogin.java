package br.com.blueGarnet.graphics;
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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.blueGarnet.system.Config;
import br.com.blueGarnet.users.Usuario;

@SuppressWarnings("serial")
public class JanelaLogin extends JFrame{
	
	JDesktopPane PainelInterno = new JDesktopPane(); 	// Painel Interno
	JButton btnEntrar = new JButton("Entrar");			// Botão Entrar
	JTextField campoUsuario = new JTextField();			// Campo de Usuário
	JPasswordField campoSenha = new JPasswordField();	// Campo de Senha
	
	public JanelaLogin() {
		// Definições de Janela
		setVisible(true);
		setSize(320, 185);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(Config.nomePrograma);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Config.imagemTituloJanela.getImage());		
		
		PainelInterno.setBackground(new Color(255,255,255,3));
		getContentPane().add(PainelInterno, BorderLayout.CENTER);		
		
		// Campo Usuário
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
		
		// Campo Senha
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
		
		// Botão "Entrar"
		btnEntrar.setBounds(210, 115, 73, 35);
		PainelInterno.add(btnEntrar);
		btnEntrar.addActionListener( event -> {
				setVisible(false);
				String senha = new String(campoSenha.getPassword());
				Usuario u = new Usuario(campoUsuario.getText(),senha);
				if(!u.acessarSistema()) setVisible(true);
		});
	}
}
