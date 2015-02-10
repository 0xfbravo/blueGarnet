package br.com.blueGarnet.enums;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel © 2014
										 www.fcode.co
*/

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

import br.com.blueGarnet.modules.Administracao;
import br.com.blueGarnet.others.FuncoesExtras;

public enum SubModulo{
	
	/* Sub-Módulos de Administração */
	criarUsuario(Modulo.administracao.getIdModulo(),"Criar Usuário",FuncoesExtras.buscarIcone("img/anonymous_add.png"),Administracao.CriarUsuario()),
	editarUsuario(Modulo.administracao.getIdModulo(),"Editar Usuário",FuncoesExtras.buscarIcone("img/anonymous_edit.png"),Administracao.EditarUsuario()),
	importarAlterdata(Modulo.administracao.getIdModulo(),"Gerar Importação para Alterdata",FuncoesExtras.buscarIcone("img/backup_server_save.png"),Administracao.GerarImportacaoAlterdata()),
	emailClientes(Modulo.administracao.getIdModulo(),"Alterar E-mails de Clientes",FuncoesExtras.buscarIcone("img/address_book_edit.png"),Administracao.AlteracaoDeEmail()),
	// TODO: Ajuste de Percentuais
	ajustePercentuais(Modulo.administracao.getIdModulo(),"Ajuste de Percentuais",FuncoesExtras.buscarIcone("img/technical_screwdriver.png"),Administracao.AjustePercentuais()),
	// TODO: Cadastro - Banco & Agência
	cadBanco(Modulo.administracao.getIdModulo(),"Cadastro - Banco & Agência",FuncoesExtras.buscarIcone("img/bank.png"),new JDesktopPane()),
	// TODO: Cadastro - Limite de Faturamento
	cadLimite(Modulo.administracao.getIdModulo(),"Cadastro - Limite de Faturamento",FuncoesExtras.buscarIcone("img/debt.png"),new JDesktopPane()),
	// TODO: Cadastro - Atividades
	cadAtividades(Modulo.administracao.getIdModulo(),"Cadastro - Atividades",FuncoesExtras.buscarIcone("img/task.png"),new JDesktopPane()),
	// TODO: Cadastro - Estados
	cadEstados(Modulo.administracao.getIdModulo(),"Cadastro - Estados",FuncoesExtras.buscarIcone("img/world.png"),new JDesktopPane()),
	// TODO: Cadastro - Salário Mínimo
	cadSalMin(Modulo.administracao.getIdModulo(),"Cadastro - Salário Mínimo",FuncoesExtras.buscarIcone("img/salary.png"),new JDesktopPane()),
	// TODO: Cadastro - Sindicatos
	cadSindicatos(Modulo.administracao.getIdModulo(),"Cadastro - Sindicatos",FuncoesExtras.buscarIcone("img/operator.png"),new JDesktopPane()),
	
	
	/* Sub-Módulos de Orçamento */
	gerOrcamento(Modulo.orcamento.getIdModulo(),"Gerar Orçamento",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	importDados(Modulo.orcamento.getIdModulo(),"Importar Dados CP/CR",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attIndividual(Modulo.orcamento.getIdModulo(),"Atualização Individual",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attGeral(Modulo.orcamento.getIdModulo(),"Atualização Geral",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	eventos(Modulo.orcamento.getIdModulo(),"Eventos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	
	/* Sub-Módulos de Fluxo de Caixa */
	cxDiario(Modulo.fluxoCaixa.getIdModulo(),"Caixa Diário",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	fchCaixa(Modulo.fluxoCaixa.getIdModulo(),"Fechamento de Caixa",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	accBancaria(Modulo.fluxoCaixa.getIdModulo(),"Conta Bancária",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	supContas(Modulo.fluxoCaixa.getIdModulo(),"Suprimento de Contas",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	consultChq(Modulo.fluxoCaixa.getIdModulo(),"Consulta de Cheques",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	hist(Modulo.fluxoCaixa.getIdModulo(),"Histórico",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	proj(Modulo.fluxoCaixa.getIdModulo(),"Projetado",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	comb(Modulo.fluxoCaixa.getIdModulo(),"Combinado",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	
	/* Sub-Módulos de Contas a Receber */
	lncBaixa(Modulo.contasReceber.getIdModulo(),"Lançamentos & Baixas",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	gerCobran(Modulo.contasReceber.getIdModulo(),"Gerar Cobranças",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	gerNF(Modulo.contasReceber.getIdModulo(),"Geração de NF",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	gerRPS(Modulo.contasReceber.getIdModulo(),"Geração de RPS",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attNF(Modulo.contasReceber.getIdModulo(),"Atualização de NF",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attRPS(Modulo.contasReceber.getIdModulo(),"Atualização de RPS",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	indDesempenho(Modulo.contasReceber.getIdModulo(),"Índices de Desempenho",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	/* Sub-Módulos de Listagens */
	lstUsuario(Modulo.listagens.getIdModulo(),"Listagem de Usuários",FuncoesExtras.buscarIcone("img/anonymous_comment.png"),Administracao.ListarUsuarios()),
	lstEmpresas(Modulo.listagens.getIdModulo(),"Listagem de Empresas",FuncoesExtras.buscarIcone("img/alliance.png"),Administracao.ListarEmpresas()),
	lstCobrancas(Modulo.listagens.getIdModulo(),"Listagem de Cobranças",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	lstPgtoPer(Modulo.listagens.getIdModulo(),"Pagamentos do Período",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	lstFatur(Modulo.listagens.getIdModulo(),"Listagem de Faturamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	lstClientes(Modulo.listagens.getIdModulo(),"Listagem de Clientes",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	/* Sub-Módulos de Relatórios */
	relOrc(Modulo.relatorios.getIdModulo(),"Orçamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relCxCon(Modulo.relatorios.getIdModulo(),"Caixa Consolidado",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relCobrancas(Modulo.relatorios.getIdModulo(),"Cobranças",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relFatur(Modulo.relatorios.getIdModulo(),"Faturamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relPagto(Modulo.relatorios.getIdModulo(),"Pagamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	/* Sub-Módulos de Contas a Pagar */
	gastEfet(Modulo.contasPagar.getIdModulo(),"Gastos Efetuados & Previstos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane());
	
	private int permissao;
	private String nomeSubModulo;
	private ImageIcon icone;
	private JDesktopPane j;
	private JScrollPane jsp;
	
	SubModulo(int permissao,String nomeSubModulo,ImageIcon img, JDesktopPane j){
		this.setPermissao(permissao);
		this.setNomeSubModulo(nomeSubModulo);
		this.setIcone(img);
		this.setJ(j);
	}
	SubModulo(int permissao,String nomeSubModulo,ImageIcon img, JScrollPane jsp){
		this.setPermissao(permissao);
		this.setNomeSubModulo(nomeSubModulo);
		this.setIcone(img);
		this.setJsp(jsp);
	}
	
	public int getPermissao() {
		return permissao;
	}
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	public String getNomeSubModulo() {
		return nomeSubModulo;
	}
	public void setNomeSubModulo(String nomeSubModulo) {
		this.nomeSubModulo = nomeSubModulo;
	}
	public ImageIcon getIcone() {
		return icone;
	}
	public void setIcone(ImageIcon icone) {
		this.icone = icone;
	}
	public JDesktopPane getJ() {
		return j;
	}
	public void setJ(JDesktopPane j) {
		this.j = j;
	}
	public JScrollPane getJsp() {
		return jsp;
	}
	public void setJsp(JScrollPane jsp) {
		this.jsp = jsp;
	}
}
/*b.addActionListener(new ActionListener(){
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(t.getId()){
		case 99:
			JanelaPrincipal.SubModulo.removeAll();
			JanelaPrincipal.SubModulo.addTab("Criar Usuário",FuncoesExtras.buscarIcone("img/anonymous_add.png"),Administracao.CriarUsuario());
			JanelaPrincipal.SubModulo.addTab("Editar Usuário",FuncoesExtras.buscarIcone("img/anonymous_edit.png"),Administracao.EditarUsuario());
			JanelaPrincipal.SubModulo.addTab("Listagem de Usuários",FuncoesExtras.buscarIcone("img/anonymous_comment.png"),Administracao.ListarUsuarios());
			JanelaPrincipal.SubModulo.addTab("Listagem de Empresas",FuncoesExtras.buscarIcone("img/alliance.png"),Administracao.ListarEmpresas());
			JanelaPrincipal.SubModulo.addTab("Gerar Importação para Alterdata",FuncoesExtras.buscarIcone("img/backup_server_save.png"),Administracao.GerarImportacaoAlterdata());
			JanelaPrincipal.SubModulo.addTab("Alterar E-mails de Clientes",FuncoesExtras.buscarIcone("img/address_book_edit.png"),Administracao.AlteracaoDeEmail());
			// TODO: Ajuste de Percentuais
			//JanelaPrincipal.SubModulo.addTab("Ajuste de Percentuais",FuncoesExtras.buscarIcone("img/technical_screwdriver.png"),new JDesktopPane());
			// TODO: Cadastro - Banco & Agência
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Banco & Agência",FuncoesExtras.buscarIcone("img/bank.png"),new JDesktopPane());
			// TODO: Cadastro - Limite de Faturamento
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Limite de Faturamento",FuncoesExtras.buscarIcone("img/debt.png"),new JDesktopPane());
			// TODO: Cadastro - Atividades
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Atividades",FuncoesExtras.buscarIcone("img/task.png"),new JDesktopPane());
			// TODO: Cadastro - Estados
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Estados",FuncoesExtras.buscarIcone("img/world.png"),new JDesktopPane());
			// TODO: Cadastro - Salário Mínimo
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Salário Mínimo",FuncoesExtras.buscarIcone("img/salary.png"),new JDesktopPane());
			// TODO: Cadastro - Sindicatos
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Sindicatos",FuncoesExtras.buscarIcone("img/operator.png"),new JDesktopPane());
		break;
		
		// TODO: Módulo - Orçamento
		case 0:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este módulo ainda não foi habilitado,<br>"
							+ " é possível que esteja funcional na próxima revisão do Sistema blueGarnet.</html>",
							"Módulo não habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: Módulo - Fluxo de Caixa
		case 1:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este módulo ainda não foi habilitado,<br>"
							+ " é possível que esteja funcional na próxima revisão do Sistema blueGarnet.</html>",
							"Módulo não habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: Módulo - Contas a Receber
		case 2:
			JanelaPrincipal.SubModulo.removeAll();
			JanelaPrincipal.SubModulo.addTab("Gerar Cobranças",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane());
			JanelaPrincipal.SubModulo.addTab("Lançamentos & Baixas",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane());
		break;
		
		
		// TODO: Módulo - Contas a Pagar
		case 3:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este módulo ainda não foi habilitado,<br>"
							+ " é possível que esteja funcional na próxima revisão do Sistema blueGarnet.</html>",
							"Módulo não habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: Módulo de Relatórios
		case 4:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este módulo ainda não foi habilitado,<br>"
							+ " é possível que esteja funcional na próxima revisão do Sistema blueGarnet.</html>",
							"Módulo não habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: Módulo de Suporte
		case 5:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este módulo ainda não foi habilitado,<br>"
							+ " é possível que esteja funcional na próxima revisão do Sistema blueGarnet.</html>",
							"Módulo não habilitado", JOptionPane.ERROR_MESSAGE);
			//new TicketSuporte();
		break;
		default:
		break;
	}
	}
	
});
add(b);*/
