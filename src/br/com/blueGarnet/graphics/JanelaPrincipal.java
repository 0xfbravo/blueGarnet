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

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Config;
import br.com.blueGarnet.system.Database;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame{
	
	public static JPanel PainelInterno = new JPanel();
	public static JTabbedPane subModulos = new JTabbedPane();
	public static JMenuBar barraMenu = new JMenuBar();
	
	public JanelaPrincipal(int nivelPermissao) {
		setSize(Config.larguraPrograma, Config.alturaPrograma);
		setIconImage(Config.imagemTituloJanela.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Config.nomePrograma);
		setLocationRelativeTo(null);
		setVisible(true);
		
		PainelInterno.setBackground(Color.LIGHT_GRAY);
		PainelInterno.setLayout(new BorderLayout());
		
		PainelInterno.add(StatusBar(), BorderLayout.SOUTH);
		
		barraMenu.add(Box.createHorizontalGlue());
		barraMenu.add(new JMenu("Ajuda"));
		PainelInterno.add(barraMenu, BorderLayout.NORTH);
		
		subModulos.setBackground(new Color(236, 240, 241));
		subModulos.addTab("<html>Seja bem-vindo ao <b style='color:#34495e;'>"+Config.nomePrograma+"</b></html>",Config.imagemTituloJanela, new NovidadesVersao());
		PainelInterno.add(subModulos);
		
		add(PainelInterno, BorderLayout.CENTER);
		add(new Menu(nivelPermissao), BorderLayout.WEST);
		
		add(Copyright(), BorderLayout.SOUTH);
		invalidate();
		validate();
	}
	
	/**
     * Exibe o Copyright do Programa
     * 
     */
	public JLabel StatusBar(){
		JLabel lblStatusBar = new JLabel(
				"<html>"
					+ "<div style='padding:3px; margin-let: 20px; font-size:7px;'>"
						+ "Você está conectado ao DB!"
						+ "</div>" +
			   "</html>"
				);
		lblStatusBar.setForeground(new Color(127, 140, 141));
		lblStatusBar.setHorizontalAlignment(JButton.LEFT);
		lblStatusBar.setOpaque(true);
		lblStatusBar.setIcon(FuncoesExtras.buscarIcone("img/world2.png"));
		lblStatusBar.setBackground(new Color(189, 195, 199));
		return lblStatusBar;
	}
	
	/**
     * Exibe o Copyright do Programa
     * 
     */
	public JLabel Copyright(){
		JLabel lblCopyright = new JLabel(
				"<html>"
					+ "<div style='padding:3px; margin-right: 10px; font-size:7px;'>"
						+ "<i><b>::</b></i> Desenvolvido por Fellipe Pimentel © 2014<br>"
						+ "<div style='margin-left:95px;'><i>www.fcode.co</i></div>"
						+ "</div>" +
			   "</html>"
				);
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setHorizontalAlignment(JButton.RIGHT);
		lblCopyright.setOpaque(true);
		lblCopyright.setBackground(new Color(54,54,54));
		return lblCopyright;
	}	
	
	/**
	 * Método para criação da Janela Interna
	 * 
	 */
	public static JFrame createFrame(String t, int Altura, int Largura) {
		      JFrame f = new JFrame(t);
		      f.setResizable(false);
		      f.setVisible(true);
		      f.setSize(Largura,Altura);
		      f.setLocationRelativeTo(null);
		      return f;
	}
}
