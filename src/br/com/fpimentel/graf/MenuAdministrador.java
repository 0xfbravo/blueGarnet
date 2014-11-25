package br.com.fpimentel.graf;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel � 2014 
*/
import javax.swing.JMenu;

import br.com.fpimentel.util.FuncoesExtras;

public class MenuAdministrador {
	
	public MenuAdministrador(Object a){	
		// ----- Op��es da Barra de Menu
		JMenu administracaoMenu = new JMenu("Administra��o");
		administracaoMenu.setIcon(FuncoesExtras.buscarIcone("img/user_business.jpg"));
		JanelaPrincipal.barraMenu.add(administracaoMenu);
		
			// Adicionar Usu�rio
			administracaoMenu.add(Menu.subMenu("Adicionar Usu�rio","img/user.png",a,1));			
			// Editar Usu�rio
			administracaoMenu.add(Menu.subMenu("Editar Usu�rio","img/page_white_wrench.png",a,2));
			// Listagem de Usu�rios
			administracaoMenu.add(Menu.subMenu("Listagem de Usu�rios","img/book_addresses.png",a,3));
			// Listagem de Empresas
			administracaoMenu.add(Menu.subMenu("Listagem de Empresas","img/book.png",a,4));		
			// Altera��o de E-mails - Clientes
			administracaoMenu.add(Menu.subMenu("Altera��o de E-mails - Clientes","img/envelope.png",a,5));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Gerar Importa��o do Alterdata (Mensalidade Ideal)
			administracaoMenu.add(Menu.subMenu("Gerar Importa��o do Alterdata (Mensalidade Ideal)","img/bricks.png",a,6));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Percentuais
			JMenu percentuais = Menu.subMenuComOpcoes("Cadastro de Percentuais","img/cross_shield.png",a,6);
			administracaoMenu.add(percentuais);
				// Percentuais p/ C�lculo da Mensalidade Ideal
				percentuais.add(Menu.subMenu("Mensalidade Ideal","img/cross_shield.png",a,7));
				// Percentuais Gerais
				percentuais.add(Menu.subMenu("Gerais","img/cross_shield.png",a,7));
				
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Calend�rio Fiscal - ICMS ME
			administracaoMenu.add(Menu.subMenu("Cadastro de Calend�rio Fiscal - ICMS ME","img/cross_shield.png",a,6));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Banco
			administracaoMenu.add(Menu.subMenu("Cadastro de Banco","img/cross_shield.png",a,6));	
			// Cadastro de Ag�ncia
			administracaoMenu.add(Menu.subMenu("Cadastro de Ag�ncia","img/cross_shield.png",a,6));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Limite de Faturamento
			JMenu limiteFaturamento = Menu.subMenuComOpcoes("Cadastro de Limite de Faturamento","img/cross_shield.png",a,6);
			administracaoMenu.add(limiteFaturamento);
				// Empresas Simples
				limiteFaturamento.add(Menu.subMenu("Empresas Simples","img/cross_shield.png",a,7));
				// Empresas Estaduais
				limiteFaturamento.add(Menu.subMenu("Empresas Estaduais","img/cross_shield.png",a,7));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Atividades
			administracaoMenu.add(Menu.subMenu("Cadastro de Atividades","img/cross_shield.png",a,7));
			// Cadastro de Atividades - Impostos (Produ��o)
			administracaoMenu.add(Menu.subMenu("Cadastro de Atividades - Impostos (Produ��o)","img/cross_shield.png",a,8));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Estados
			administracaoMenu.add(Menu.subMenu("Cadastro de Estados","img/cross_shield.png",a,9));		
			// Cadastro de Sal�rio M�nimo
			administracaoMenu.add(Menu.subMenu("Cadastro de Sal�rio M�nimo","img/cross_shield.png",a,10));
			// Cadastro de Sindicatos
			administracaoMenu.add(Menu.subMenu("Cadastro de Sindicatos","img/cross_shield.png",a,10));
	}

}
