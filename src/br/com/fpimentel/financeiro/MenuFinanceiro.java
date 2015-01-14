package br.com.fpimentel.financeiro;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel � 2014 
*/

public class MenuFinanceiro {
	
	/*public MenuFinanceiro(Object f){
		/*
		 * 	M�dulo: Or�amento
		
		JMenu orcamento = new JMenu("Or�amento");
		orcamento.setIcon(FuncoesExtras.buscarIcone("img/calculator.png"));
		JanelaPrincipal.barraMenu.add(orcamento);
			// Gerar Or�amento
				orcamento.add(Menu.subMenu("Gerar Or�amento","img/cross_shield.png",f,0));
			// Importar Dados CP & CR
				orcamento.add(Menu.subMenu("Importar Dados CP & CR","img/cross_shield.png",f,1));	
			// SEPARADOR
				orcamento.addSeparator();
			// Atualiza��o Individual
				orcamento.add(Menu.subMenu("Atualiza��o Individual","img/cross_shield.png",f,2));
			// Atualiza��o Geral
				orcamento.add(Menu.subMenu("Atualiza��o Geral","img/cross_shield.png",f,3));
			// SEPARADOR
				orcamento.addSeparator();
			// Eventos
				orcamento.add(Menu.subMenu("Eventos","img/cross_shield.png",f,4));
			// Relat�rios
				orcamento.add(Menu.subMenu("Relat�rios","img/cross_shield.png",f,5));
					// Relat�rios possuem 2 sub-divis�es, verificar; op��es 6 e 7 ocupadas;
		
		/*
		 * 	M�dulo: Fluxo de Caixa
		
		JMenu flxCaixa = new JMenu("Fluxo de Caixa");
		flxCaixa.setIcon(FuncoesExtras.buscarIcone("img/arrow_refresh.png"));
		JanelaPrincipal.barraMenu.add(flxCaixa);
			// Caixa Di�rio
			flxCaixa.add(Menu.subMenu("Caixa Di�rio","img/cross_shield.png",f,17));
			// Fechamento Caixa
			flxCaixa.add(Menu.subMenu("Fechamento Caixa","img/cross_shield.png",f,18));
			// SEPARADOR
			flxCaixa.addSeparator();
			// Conta Banc�ria
			flxCaixa.add(Menu.subMenu("Conta Banc�ria","img/cross_shield.png",f,18));	
			// Suprimento Contas
			flxCaixa.add(Menu.subMenu("Suprimento Contas","img/cross_shield.png",f,18));	
			// Consulta Cheques
			flxCaixa.add(Menu.subMenu("Consulta Cheques","img/cross_shield.png",f,18));	
			// SEPARADOR
			flxCaixa.addSeparator();			
			// Hist�rico
			flxCaixa.add(Menu.subMenu("Hist�rico","img/cross_shield.png",f,8));
				// Relat�rios possuem 2 sub-divis�es, verificar; op��es 9 e 10 ocupadas;
			// Projetado
			flxCaixa.add(Menu.subMenu("Projetado","img/cross_shield.png",f,11));
				// Relat�rios possuem 2 sub-divis�es, verificar; op��es 12 e 13 ocupadas;
			// Combinado
			flxCaixa.add(Menu.subMenu("Combinado","img/cross_shield.png",f,14));
				// Relat�rios possuem 2 sub-divis�es, verificar; op��es 15 e 16 ocupadas;
			// SEPARADOR
			flxCaixa.addSeparator();
			// Relat�rio Caixa Consolidado
			flxCaixa.add(Menu.subMenu("Relat�rio Caixa Consolidado","img/cross_shield.png",f,18));	
		
		/*
		 * 	M�dulo: Contas a Receber
		 
		JMenu contasReceber = new JMenu("Contas a Receber");
		contasReceber.setIcon(FuncoesExtras.buscarIcone("img/money_dollar.png"));
		JanelaPrincipal.barraMenu.add(contasReceber);
			// Lan�amentos & Baixas
			contasReceber.add(Menu.subMenu("Lan�amentos & Baixas","img/cross_shield.png",f,30));	
			// Gerar Cobran�as
			contasReceber.add(Menu.subMenu("Gerar Cobran�as","img/zone_money.png",f,1));
			// Relat�rios de Cobran�a
			contasReceber.add(Menu.subMenu("Relat�rios de Cobran�a","img/cross_shield.png",f,30));
			// SEPARADOR
			contasReceber.addSeparator();
			// Gera��o de NF
			contasReceber.add(Menu.subMenu("Gera��o de NF","img/cross_shield.png",f,30));
			// Gera��o de RPS
			contasReceber.add(Menu.subMenu("Gera��o de RPS","img/cross_shield.png",f,30));
			// Atualiza��o de NF
			contasReceber.add(Menu.subMenu("Atualiza��o de NF","img/cross_shield.png",f,30));
			// Atualiza��o de RPS
			contasReceber.add(Menu.subMenu("Atualiza��o de RPS","img/cross_shield.png",f,30));
			// �ndices de Desempenho
			contasReceber.add(Menu.subMenu("�ndices de Desempenho","img/cross_shield.png",f,30));
			// Relat�rios de Faturamento
			contasReceber.add(Menu.subMenu("Relat�rios de Faturamento","img/cross_shield.png",f,30));
			// SEPARADOR
			contasReceber.addSeparator();
			// Listagem de Cobran�as
			contasReceber.add(Menu.subMenu("Listagem de Cobran�as","img/cross_shield.png",f,30));
			// Listagem de Faturamentos
			contasReceber.add(Menu.subMenu("Listagem de Faturamentos","img/cross_shield.png",f,30));
			// Listagem de Clientes
			contasReceber.add(Menu.subMenu("Listagem de Clientes","img/cross_shield.png",f,30));
		
		/*
		 * 	M�dulo: Contas a Pagar
		 
		JMenu contasPagar = new JMenu("Contas a Pagar");
		contasPagar.setIcon(FuncoesExtras.buscarIcone("img/money.png"));
		JanelaPrincipal.barraMenu.add(contasPagar);
			// Gastos Efetuados & Previstos
			contasPagar.add(Menu.subMenu("Gastos Efetuados & Previstos","img/cross_shield.png",f,30));
			// Listagem de Pagamentos do Per�odo
			contasPagar.add(Menu.subMenu("Listagem de Pagamentos do Per�odo","img/cross_shield.png",f,30));
			// Relat�rios de Pagamento
			contasPagar.add(Menu.subMenu("Relat�rios de Pagamento","img/cross_shield.png",f,30));
	}*/

}
