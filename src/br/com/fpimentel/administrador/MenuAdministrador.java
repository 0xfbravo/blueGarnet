package br.com.fpimentel.administrador;

import javax.swing.JMenu;

import br.com.fpimentel.Janela;
import br.com.fpimentel.Menu;
import br.com.fpimentel.util.Arquivos;

public class MenuAdministrador {
	
	public MenuAdministrador(Object a){	
		// ----- Opções da Barra de Menu
		JMenu administracaoMenu = new JMenu("Administração");
		administracaoMenu.setIcon(Arquivos.buscarIcone("img/user_business.jpg"));
		Janela.barraMenu.add(administracaoMenu);
		
			/*
			 * 	Adicionar Usuário
			 */
			administracaoMenu.add(Menu.subMenu("Adicionar Usuário","img/user.png",a,1));
			
			/*
			 * 	Editar Usuário
			 */
			administracaoMenu.add(Menu.subMenu("Editar Usuário","img/page_white_wrench.png",a,2));

			/*
			 * 	Listagem de Usuários
			 */
			administracaoMenu.add(Menu.subMenu("Listagem de Usuários","img/book_addresses.png",a,3));

			/*
			 * 	Listagem de Empresas
			 */
			administracaoMenu.add(Menu.subMenu("Listagem de Empresas","img/book.png",a,4));
	}

}
