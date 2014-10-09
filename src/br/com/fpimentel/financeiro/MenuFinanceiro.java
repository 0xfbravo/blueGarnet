package br.com.fpimentel.financeiro;
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

import br.com.fpimentel.Janela;
import br.com.fpimentel.Menu;
import br.com.fpimentel.util.Arquivos;

public class MenuFinanceiro {
	
	public MenuFinanceiro(Object f){
		/*
		 * 	Módulo: Orçamento
		 */
		JMenu orcamento = new JMenu("Orçamento");
		orcamento.setIcon(Arquivos.buscarIcone("img/calculator.png"));
		Janela.barraMenu.add(orcamento);
			// Gerar Orçamento
				orcamento.add(Menu.subMenu("Gerar Orçamento","img/cross_shield.png",f,0));
			// Importar Dados CP & CR
				orcamento.add(Menu.subMenu("Importar Dados CP & CR","img/cross_shield.png",f,1));	
			// SEPARADOR
				orcamento.addSeparator();
			// Atualização Individual
				orcamento.add(Menu.subMenu("Atualização Individual","img/cross_shield.png",f,2));
			// Atualização Geral
				orcamento.add(Menu.subMenu("Atualização Geral","img/cross_shield.png",f,3));
			// SEPARADOR
				orcamento.addSeparator();
			// Eventos
				orcamento.add(Menu.subMenu("Eventos","img/cross_shield.png",f,4));
			// Relatórios
				orcamento.add(Menu.subMenu("Relatórios","img/cross_shield.png",f,5));
					// Relatórios possuem 2 sub-divisões, verificar; opções 6 e 7 ocupadas;
		
		/*
		 * 	Módulo: Fluxo de Caixa
		 */
		JMenu flxCaixa = new JMenu("Fluxo de Caixa");
		flxCaixa.setIcon(Arquivos.buscarIcone("img/arrow_refresh.png"));
		Janela.barraMenu.add(flxCaixa);
			// Caixa Diário
			flxCaixa.add(Menu.subMenu("Caixa Diário","img/cross_shield.png",f,17));
			// Fechamento Caixa
			flxCaixa.add(Menu.subMenu("Fechamento Caixa","img/cross_shield.png",f,18));
			// SEPARADOR
			flxCaixa.addSeparator();
			// Conta Bancária
			flxCaixa.add(Menu.subMenu("Conta Bancária","img/cross_shield.png",f,18));	
			// Suprimento Contas
			flxCaixa.add(Menu.subMenu("Suprimento Contas","img/cross_shield.png",f,18));	
			// Consulta Cheques
			flxCaixa.add(Menu.subMenu("Consulta Cheques","img/cross_shield.png",f,18));	
			// SEPARADOR
			flxCaixa.addSeparator();			
			// Histórico
			flxCaixa.add(Menu.subMenu("Histórico","img/cross_shield.png",f,8));
				// Relatórios possuem 2 sub-divisões, verificar; opções 9 e 10 ocupadas;
			// Projetado
			flxCaixa.add(Menu.subMenu("Projetado","img/cross_shield.png",f,11));
				// Relatórios possuem 2 sub-divisões, verificar; opções 12 e 13 ocupadas;
			// Combinado
			flxCaixa.add(Menu.subMenu("Combinado","img/cross_shield.png",f,14));
				// Relatórios possuem 2 sub-divisões, verificar; opções 15 e 16 ocupadas;
			// SEPARADOR
			flxCaixa.addSeparator();
			// Relatório Caixa Consolidado
			flxCaixa.add(Menu.subMenu("Relatório Caixa Consolidado","img/cross_shield.png",f,18));	
		
		/*
		 * 	Módulo: Contas a Receber
		 */
		JMenu contasReceber = new JMenu("Contas a Receber");
		contasReceber.setIcon(Arquivos.buscarIcone("img/money_dollar.png"));
		Janela.barraMenu.add(contasReceber);
			// Gerar Cobranças
			contasReceber.add(Menu.subMenu("Gerar Cobranças","img/zone_money.png",f,2));
		
		/*
		 * 	Módulo: Contas a Pagar
		 */
		JMenu contasPagar = new JMenu("Contas a Pagar");
		contasPagar.setIcon(Arquivos.buscarIcone("img/money.png"));
		Janela.barraMenu.add(contasPagar);
	}

}
