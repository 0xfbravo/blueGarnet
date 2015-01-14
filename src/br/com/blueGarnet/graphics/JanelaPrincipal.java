package br.com.blueGarnet.graphics;

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
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.com.blueGarnet.system.Config;

public class JanelaPrincipal extends JFrame{
	private static final long serialVersionUID = 1L;	
	// ----- Painel Interno JANELA PRINCIPAL
	public static JPanel PainelInterno = new JPanel();
	public static JTabbedPane subModulos = new JTabbedPane();
	/* ------------------------------------------------------------- */
	public JanelaPrincipal(int nivelPermissao) {
		setSize(Config.larguraPrograma, Config.alturaPrograma);
		setIconImage(Config.imagemTituloJanela.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(Config.nomePrograma);
		setLocationRelativeTo(null);
		setVisible(true);
		
		PainelInterno.setBackground(Color.LIGHT_GRAY);
		PainelInterno.setLayout(new BorderLayout());
		subModulos.setBackground(new Color(236, 240, 241));
		subModulos.addTab("<html>Seja bem-vindo ao <b style='color:#34495e;'>"+Config.nomePrograma+"</b></html>",Config.imagemTituloJanela, new NovidadesVersao());
		PainelInterno.add(subModulos);
		
		add(PainelInterno, BorderLayout.CENTER);
		add(new Menu(), BorderLayout.WEST);
		
		// Copyright © Fellipe Pimentel 2014
		Copyright();
		
		invalidate();
		validate();
	}

	/**
     * Exibe o Copyright do Programa
     * 
     */
	public void Copyright(){
		JLabel lblCopyright = new JLabel(
				"<html>"
					+ "<div style='padding:3px; float: right; margin-right: 10px; font-size:7px;'>"
						+ "<i><b>::</b></i> Desenvolvido por Fellipe Pimentel © 2014<br>"
						+ "<div style='margin-left:95px;'><i>www.fcode.co</i></div>"
						+ "</div>" +
			   "</html>"
				);
		lblCopyright.setForeground(Color.WHITE);
		lblCopyright.setHorizontalAlignment(JButton.RIGHT);
		lblCopyright.setOpaque(true);
		lblCopyright.setBackground(new Color(54,54,54));
		add(lblCopyright, BorderLayout.SOUTH);
	}
	
	/**
     * Exibe o arquivo (boleto) na tela.
     * 
     * @param arquivoBoleto
     */
    public static void mostreBoletoNaTela(File arquivoBoleto) {
    	java.awt.Desktop desktop = java.awt.Desktop.getDesktop();  
    	try { desktop.open(arquivoBoleto); }
    	catch (IOException e) {
    		JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    	}
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
