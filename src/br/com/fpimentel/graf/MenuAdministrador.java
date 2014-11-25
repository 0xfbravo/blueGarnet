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
import javax.swing.JMenu;

import br.com.fpimentel.util.FuncoesExtras;

public class MenuAdministrador {
	
	public MenuAdministrador(Object a){	
		// ----- Opções da Barra de Menu
		JMenu administracaoMenu = new JMenu("Administração");
		administracaoMenu.setIcon(FuncoesExtras.buscarIcone("img/user_business.jpg"));
		JanelaPrincipal.barraMenu.add(administracaoMenu);
		
			// Adicionar Usuário
			administracaoMenu.add(Menu.subMenu("Adicionar Usuário","img/user.png",a,1));			
			// Editar Usuário
			administracaoMenu.add(Menu.subMenu("Editar Usuário","img/page_white_wrench.png",a,2));
			// Listagem de Usuários
			administracaoMenu.add(Menu.subMenu("Listagem de Usuários","img/book_addresses.png",a,3));
			// Listagem de Empresas
			administracaoMenu.add(Menu.subMenu("Listagem de Empresas","img/book.png",a,4));		
			// Alteração de E-mails - Clientes
			administracaoMenu.add(Menu.subMenu("Alteração de E-mails - Clientes","img/envelope.png",a,5));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Gerar Importação do Alterdata (Mensalidade Ideal)
			administracaoMenu.add(Menu.subMenu("Gerar Importação do Alterdata (Mensalidade Ideal)","img/bricks.png",a,6));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Percentuais
			JMenu percentuais = Menu.subMenuComOpcoes("Cadastro de Percentuais","img/cross_shield.png",a,6);
			administracaoMenu.add(percentuais);
				// Percentuais p/ Cálculo da Mensalidade Ideal
				percentuais.add(Menu.subMenu("Mensalidade Ideal","img/cross_shield.png",a,7));
				// Percentuais Gerais
				percentuais.add(Menu.subMenu("Gerais","img/cross_shield.png",a,7));
				
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Calendário Fiscal - ICMS ME
			administracaoMenu.add(Menu.subMenu("Cadastro de Calendário Fiscal - ICMS ME","img/cross_shield.png",a,6));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Banco
			administracaoMenu.add(Menu.subMenu("Cadastro de Banco","img/cross_shield.png",a,6));	
			// Cadastro de Agência
			administracaoMenu.add(Menu.subMenu("Cadastro de Agência","img/cross_shield.png",a,6));
			
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
			// Cadastro de Atividades - Impostos (Produção)
			administracaoMenu.add(Menu.subMenu("Cadastro de Atividades - Impostos (Produção)","img/cross_shield.png",a,8));
			
			// SEPARADOR
			administracaoMenu.addSeparator();
			
			// Cadastro de Estados
			administracaoMenu.add(Menu.subMenu("Cadastro de Estados","img/cross_shield.png",a,9));		
			// Cadastro de Salário Mínimo
			administracaoMenu.add(Menu.subMenu("Cadastro de Salário Mínimo","img/cross_shield.png",a,10));
			// Cadastro de Sindicatos
			administracaoMenu.add(Menu.subMenu("Cadastro de Sindicatos","img/cross_shield.png",a,10));
	}

}
