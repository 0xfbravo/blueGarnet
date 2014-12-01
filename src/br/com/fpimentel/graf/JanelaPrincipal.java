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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.fpimentel.Config;
import br.com.fpimentel.Database;
import br.com.fpimentel.administrador.Administracao;
import br.com.fpimentel.administrador.MenuAdm;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.financeiro.Orcamento;

public class JanelaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomeUsuario;
	public String getNomeUsuario(){ return this.nomeUsuario; }
	public void setNomeUsuario(String nomeUsuario){ this.nomeUsuario = nomeUsuario; }
	
	// ----- Painel Interno JANELA PRINCIPAL
	public static JPanel PainelInterno = new JPanel();
	// ----- Menu
	public static JMenuBar barraMenu = new JMenuBar();
	public static JDesktopPane barraMenuL = new JDesktopPane();
	
	
	/* ------------------------------------------------------------- */
	public JanelaPrincipal(String NomeJanela, int Largura, int Altura,String nomeUsuario) {
		setIconImage(Config.imagemTituloJanela.getImage());
		this.setNomeUsuario(nomeUsuario);
		setVisible(true);
		setSize(Largura, Altura);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(NomeJanela);
		setResizable(true);
		
		PainelInterno.setBackground(Color.LIGHT_GRAY);
		PainelInterno.setLayout(new FlowLayout());
		PainelInterno.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				PainelInterno.removeAll();
				PainelInterno.repaint();
				invalidate();
				validate();
			}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}
			
		});
		getContentPane().setLayout(new BorderLayout());
		add(PainelInterno,BorderLayout.CENTER);
		PainelInterno.setLayout(new BorderLayout());
		// Criação do Menu
		//new Menu(verificarPermissao(),this);
		/*----------------------------------------*
		 *  Menu Diferenciado para Administradores
		 *----------------------------------------*/	
		if(verificarPermissao() >= NivelPermissao.Adm.getNumPermissao()){
			//new MenuAdministrador(administrador);
			BotaoMenu item = new BotaoMenu("Administração","img/businessman193.png");
			barraMenuL.add(item);
			item.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {new MenuAdm(JanelaPrincipal.this,item);}
			});
		}
		/*----------------------------------*
		 *  Menu Diferenciado para Financeiro
		 *----------------------------------*/
		if(verificarPermissao() >= NivelPermissao.Financeiro.getNumPermissao()){
			//new MenuFinanceiro(contasReceber); // Mudar para financeiro depois
			
			BotaoMenu item2 = new BotaoMenu("Orçamento","img/calculator69.png");
			barraMenuL.add(item2);
			item2.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) { new Orcamento(JanelaPrincipal.this,item2);}	
			});
			BotaoMenu item3 = new BotaoMenu("Fluxo de Caixa","img/refresh46.png");
			barraMenuL.add(item3);
			item3.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					PainelInterno.removeAll();
					PainelInterno.repaint();
					JDesktopPane jdp = new JDesktopPane();
					jdp.setBackground(Color.WHITE);
					jdp.setPreferredSize(new Dimension(PainelInterno.getWidth()/2,PainelInterno.getHeight()));
					PainelInterno.add(jdp);
					invalidate();
					validate();
				}
				
			});
			BotaoMenu item4 = new BotaoMenu("Contas a Receber","img/dollar179.png");
			barraMenuL.add(item4);
			item4.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					PainelInterno.removeAll();
					PainelInterno.repaint();
					JDesktopPane jdp = new JDesktopPane();
					jdp.setBackground(Color.CYAN);
					jdp.setPreferredSize(new Dimension(PainelInterno.getWidth()/2,PainelInterno.getHeight()));
					PainelInterno.add(jdp);
					invalidate();
					validate();
				}
				
			});
			BotaoMenu item5 = new BotaoMenu("Contas a Pagar","img/job6.png");
			barraMenuL.add(item5);
			item5.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					PainelInterno.removeAll();
					PainelInterno.repaint();
					JDesktopPane jdp = new JDesktopPane();
					jdp.setBackground(Color.MAGENTA);
					jdp.setPreferredSize(new Dimension(PainelInterno.getWidth()/2,PainelInterno.getHeight()));
					PainelInterno.add(jdp);
					invalidate();
					validate();
				}
				
			});
			BotaoMenu item6 = new BotaoMenu("Operacional","img/seo1.png");
			barraMenuL.add(item6);
			item6.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					PainelInterno.removeAll();
					PainelInterno.repaint();
					JDesktopPane jdp = new JDesktopPane();
					jdp.setBackground(Color.BLUE);
					jdp.setPreferredSize(new Dimension(PainelInterno.getWidth()/2,PainelInterno.getHeight()));
					PainelInterno.add(jdp);
					invalidate();
					validate();
				}
				
			});
		}
		
		BotaoMenu item7 = new BotaoMenu("Funções Extras","img/plugin.png");
		barraMenuL.add(item7);
		item7.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				PainelInterno.removeAll();
				PainelInterno.repaint();
				JDesktopPane jdp = new JDesktopPane();
				jdp.setBackground(Color.BLACK);
				jdp.setPreferredSize(new Dimension(PainelInterno.getWidth()/2,PainelInterno.getHeight()));
				PainelInterno.add(jdp);
				invalidate();
				validate();
			}
			
		});
		
		if(verificarPermissao() == NivelPermissao.Dev.getNumPermissao()){	
			//new MenuDesenvolvedor();
			BotaoMenu item8 = new BotaoMenu("Funções BETA","img/radioactive3.png");
			barraMenuL.add(item8);
			item8.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					PainelInterno.removeAll();
					PainelInterno.repaint();
					JDesktopPane jdp = new JDesktopPane();
					jdp.setBackground(Color.ORANGE);
					jdp.setPreferredSize(new Dimension(PainelInterno.getWidth()/2,PainelInterno.getHeight()));
					PainelInterno.add(jdp);
					invalidate();
					validate();
				}
				
			});
		}
		//setJMenuBar(barraMenu);
		barraMenuL.setLayout(new GridLayout(0,1));
		barraMenuL.setBackground(new Color(28,57,85));
		add(barraMenuL, BorderLayout.WEST);
		
		// Copyright
		JLabel lblCopyright = new JLabel(
				"<html>"
					+ "<div style='padding:2px; float: right; margin-right: 10px;'>"
						+ "<i><b>::</b></i> Desenvolvido por <i>Fellipe Pimentel © 2014</i><br>"
						+ "<i><b>::</b></i> Contato: <i>fellipe.bravo@gmail.com</i>"
						+ "</div>" +
			   "</html>"
				);
		lblCopyright.setForeground(new Color(255,255,255,5));
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
	public static JFrame createFrame(String t, int Altura, int Largura) {
		      JFrame f = new JFrame(t);
		      f.setResizable(false);
		      f.setVisible(true);
		      f.setSize(Largura,Altura);
		      f.setLocationRelativeTo(null);
		      return f;
	}
}
