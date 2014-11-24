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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import br.com.fpimentel.administrador.Administrador;
import br.com.fpimentel.administrador.MenuAdministrador;
import br.com.fpimentel.dev.MenuDesenvolvedor;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.financeiro.ContasReceber;
import br.com.fpimentel.financeiro.MenuFinanceiro;
import br.com.fpimentel.util.FuncoesExtras;

public class Menu extends Janela{
	public static ContasReceber contasReceber = new ContasReceber();
	public static Administrador administrador = new Administrador();

	/*
	 * Método para criação do SubMenu c/ Opções
	 */	
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
	 */	
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
							contasReceber.JanelaGerarCobrancas();
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
	public static void criarMenu(int Administrador){
		
		/*----------------------------------------*
		 *  Menu Diferenciado para Administradores
		 *----------------------------------------*/	
		if(Administrador == NivelPermissao.Adm.getNumPermissao() ||
		   Administrador == NivelPermissao.Dev.getNumPermissao()){
			new MenuAdministrador(administrador);		
		}
		
		
		/*----------------------------------*
		 *  Menu Diferenciado para Financeiro
		 *----------------------------------*/
		if(Administrador == NivelPermissao.Financeiro.getNumPermissao() ||
				Administrador == NivelPermissao.Adm.getNumPermissao() ||
					Administrador == NivelPermissao.Dev.getNumPermissao()){
			new MenuFinanceiro(contasReceber); // Mudar para financeiro depois
		}
		
		/*
		 * 	Módulo: Operacional
		 */
		JMenu operacional = new JMenu("Operacional");
		operacional.setIcon(FuncoesExtras.buscarIcone("img/monitor.png"));
		barraMenu.add(operacional);
			
		/*
		 * 	Módulo: Funções Extras
		 */
		JMenu extras = new JMenu("Funções Extras");
		extras.setIcon(FuncoesExtras.buscarIcone("img/plugin2.png"));
		barraMenu.add(extras);
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
		
		if(Administrador == NivelPermissao.Dev.getNumPermissao()){	
			new MenuDesenvolvedor();
		}
		/*
		ItemMenu item = new ItemMenu("Administração [EM DESENVOLVIMENTO]","img/businessman193.png");
		barraMenuL.add(item);
		ItemMenu item2 = new ItemMenu("Orçamento [EM DESENVOLVIMENTO]","img/calculator69.png");
		barraMenuL.add(item2);
		ItemMenu item3 = new ItemMenu("Fluxo de Caixa [EM DESENVOLVIMENTO]","img/refresh46.png");
		barraMenuL.add(item3);
		ItemMenu item4 = new ItemMenu("Contas a Receber [EM DESENVOLVIMENTO]","img/dollar179.png");
		barraMenuL.add(item4);
		ItemMenu item5 = new ItemMenu("Contas a Pagar [EM DESENVOLVIMENTO]","img/job6.png");
		barraMenuL.add(item5);
		ItemMenu item6 = new ItemMenu("Operacional [EM DESENVOLVIMENTO]","img/seo1.png");
		barraMenuL.add(item6);
		ItemMenu item7 = new ItemMenu("Funções Extras [EM DESENVOLVIMENTO]","img/plugin.png");
		barraMenuL.add(item7);
		ItemMenu item8 = new ItemMenu("Funções BETA [EM DESENVOLVIMENTO]","img/radioactive3.png");
		barraMenuL.add(item8);*/
	}
}
