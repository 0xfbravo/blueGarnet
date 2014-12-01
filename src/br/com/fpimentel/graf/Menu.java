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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.com.fpimentel.administrador.Administracao;
import br.com.fpimentel.dev.MenuDesenvolvedor;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.financeiro.ContasReceber;
import br.com.fpimentel.util.FuncoesExtras;

public class Menu{
	public static ContasReceber contasReceber = new ContasReceber();
	public static Administracao administrador = new Administracao();

	/*
	 * Método para criação do SubMenu c/ Opções
	 	
	public static JMenu subMenuComOpcoes(String nome, String localIMG, Object o,int valorMenu){
		JMenu s = new JMenu(nome);
		s.setIcon(FuncoesExtras.buscarIcone(localIMG));
		s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		return s;
	}
	/*
	 * Método para criação do SubMenu
	 	
	public static JMenuItem subMenu(String nome, String localIMG, Object o,int valorMenu){
		JMenuItem s = new JMenuItem(nome);
		s.setIcon(FuncoesExtras.buscarIcone(localIMG));
		s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(o == administrador){
					switch(valorMenu){
						case 1:
							administrador.CriarUsuario();
						break;
						case 2:
							administrador.EditarUsuario();
						break;
						case 3:
							administrador.ListarUsuarios();
						break;
						case 4:
							administrador.ListarEmpresas();
						break;
						case 5:
							administrador.AlteracaoDeEmail();
						break;
						case 6:
							administrador.GerarImportacaoAlterdata();
						break;
					}
				}
				if(o == contasReceber){
					switch(valorMenu){
						case 1:
							contasReceber.GerarCobrancas();
						break;
						case 2:
						break;
						case 3:
						break;
						case 4:
						break;
						case 5:
						break;
						case 6:
						break;
						case 7:
						break;
						case 8:
						break;
						case 9:
						break;
						case 10:
						break;
						case 11:
						break;
						case 12:
						break;
						case 13:
						break;
						case 14:
						break;
						case 15:
						break;
						case 16:
						break;
					}
				}
			}
		});
		return s;
	}
	/*
	 * Método para criação do MENU
	 */	
	public Menu(int Permissao, JFrame j){
		
		/*----------------------------------------*
		 *  Menu Diferenciado para Administradores
		 *----------------------------------------*/	
		if(Permissao >= NivelPermissao.Adm.getNumPermissao()){
			//new MenuAdministrador(administrador);
			BotaoMenu item = new BotaoMenu("Administração [EM DESENVOLVIMENTO]","img/businessman193.png");
			JanelaPrincipal.barraMenuL.add(item);
			item.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JDesktopPane jdp = new JDesktopPane();
					jdp.setBackground(Color.RED);
					jdp.setPreferredSize(new Dimension(JanelaPrincipal.PainelInterno.getWidth()/2,JanelaPrincipal.PainelInterno.getHeight()));
					JanelaPrincipal.PainelInterno.add(jdp);
					j.invalidate();
					j.validate();
				}
				
			});
		}
		
		
		/*----------------------------------*
		 *  Menu Diferenciado para Financeiro
		 *----------------------------------*/
		if(Permissao >= NivelPermissao.Financeiro.getNumPermissao()){
			//new MenuFinanceiro(contasReceber); // Mudar para financeiro depois
			
			BotaoMenu item2 = new BotaoMenu("Orçamento [EM DESENVOLVIMENTO]","img/calculator69.png");
			JanelaPrincipal.barraMenuL.add(item2);
			BotaoMenu item3 = new BotaoMenu("Fluxo de Caixa [EM DESENVOLVIMENTO]","img/refresh46.png");
			JanelaPrincipal.barraMenuL.add(item3);
			BotaoMenu item4 = new BotaoMenu("Contas a Receber [EM DESENVOLVIMENTO]","img/dollar179.png");
			JanelaPrincipal.barraMenuL.add(item4);
			BotaoMenu item5 = new BotaoMenu("Contas a Pagar [EM DESENVOLVIMENTO]","img/job6.png");
			JanelaPrincipal.barraMenuL.add(item5);
			BotaoMenu item6 = new BotaoMenu("Operacional [EM DESENVOLVIMENTO]","img/seo1.png");
			JanelaPrincipal.barraMenuL.add(item6);
		}
		
		/*
		 * 	Módulo: Operacional
		 */
		JMenu operacional = new JMenu("Operacional");
		operacional.setIcon(FuncoesExtras.buscarIcone("img/monitor.png"));
		JanelaPrincipal.barraMenu.add(operacional);
			
		/*
		 * 	Módulo: Funções Extras
		 */
		JMenu extras = new JMenu("Funções Extras");
		extras.setIcon(FuncoesExtras.buscarIcone("img/plugin2.png"));
		JanelaPrincipal.barraMenu.add(extras);
			// Sub-menu 1
			JMenuItem digitalizacao = new JMenuItem("Digitalização de Documentos");
			digitalizacao.setIcon(FuncoesExtras.buscarIcone("img/doc_convert.png"));
			extras.add(digitalizacao);
			digitalizacao.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					FuncoesExtras.Digitalizacao();
				}
			});
			// Sub-menu 2
			JMenuItem renomearBoletos = new JMenuItem("Renomear Boletos");
			renomearBoletos.setIcon(FuncoesExtras.buscarIcone("img/page_white_stack.png"));
			extras.add(renomearBoletos);
			renomearBoletos.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					FuncoesExtras.RenomearBoletos();
				}
			});
			JMenuItem documentosExp = new JMenuItem("Documentos Expedição");
			documentosExp.setIcon(FuncoesExtras.buscarIcone("img/script.png"));
			extras.add(documentosExp);
			documentosExp.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					FuncoesExtras.RenomearBoletos();
				}
			});
			
			BotaoMenu item7 = new BotaoMenu("Funções Extras [EM DESENVOLVIMENTO]","img/plugin.png");
			JanelaPrincipal.barraMenuL.add(item7);
			
		if(Permissao == NivelPermissao.Dev.getNumPermissao()){	
			new MenuDesenvolvedor();
			BotaoMenu item8 = new BotaoMenu("Funções BETA [EM DESENVOLVIMENTO]","img/radioactive3.png");
			JanelaPrincipal.barraMenuL.add(item8);
		}
		
	}
}
