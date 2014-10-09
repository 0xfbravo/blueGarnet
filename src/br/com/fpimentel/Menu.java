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
import br.com.fpimentel.financeiro.Cobrancas;
import br.com.fpimentel.financeiro.MenuFinanceiro;
import br.com.fpimentel.util.Arquivos;

public class Menu extends Janela{
	public static Cobrancas cobranca = new Cobrancas();
	public static Administrador administrador = new Administrador();

	/*
	 * Método para criação do SubMenu
	 */	
	public static JMenuItem subMenu(String nome, String localIMG, Object o,int valorMenu){
		JMenuItem s = new JMenuItem(nome);
		s.setIcon(Arquivos.buscarIcone(localIMG));
		s.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(o == administrador && valorMenu == 1){ administrador.CriarUsuario(); }
				else if(o == administrador && valorMenu == 2){ administrador.EditarUsuario(); }
				else if(o == administrador && valorMenu == 3){ administrador.ListarUsuarios(); }
				else if(o == administrador && valorMenu == 4){ administrador.ListarEmpresas(); }
				
				if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
				else if(o == cobranca && valorMenu == 0){}
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
			new MenuFinanceiro(cobranca); // Mudar para financeiro depois
		}
		
		/*
		 * 	Módulo: Operacional
		 */
		JMenu operacional = new JMenu("Operacional");
		operacional.setIcon(Arquivos.buscarIcone("img/monitor.png"));
		barraMenu.add(operacional);
			
		/*
		 * 	Módulo: Ajuda
		 */
		JMenu ajuda = new JMenu("Ajuda");
		ajuda.setIcon(Arquivos.buscarIcone("img/help.png"));
		barraMenu.add(ajuda);
		
		if(Administrador == NivelPermissao.Dev.getNumPermissao()){	
			new MenuDesenvolvedor();
		}
	}
}
