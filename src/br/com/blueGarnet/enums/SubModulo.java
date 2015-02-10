package br.com.blueGarnet.enums;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel � 2014
										 www.fcode.co
*/

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;

import br.com.blueGarnet.modules.Administracao;
import br.com.blueGarnet.others.FuncoesExtras;

public enum SubModulo{
	
	/* Sub-M�dulos de Administra��o */
	criarUsuario(Modulo.administracao.getIdModulo(),"Criar Usu�rio",FuncoesExtras.buscarIcone("img/anonymous_add.png"),Administracao.CriarUsuario()),
	editarUsuario(Modulo.administracao.getIdModulo(),"Editar Usu�rio",FuncoesExtras.buscarIcone("img/anonymous_edit.png"),Administracao.EditarUsuario()),
	importarAlterdata(Modulo.administracao.getIdModulo(),"Gerar Importa��o para Alterdata",FuncoesExtras.buscarIcone("img/backup_server_save.png"),Administracao.GerarImportacaoAlterdata()),
	emailClientes(Modulo.administracao.getIdModulo(),"Alterar E-mails de Clientes",FuncoesExtras.buscarIcone("img/address_book_edit.png"),Administracao.AlteracaoDeEmail()),
	// TODO: Ajuste de Percentuais
	ajustePercentuais(Modulo.administracao.getIdModulo(),"Ajuste de Percentuais",FuncoesExtras.buscarIcone("img/technical_screwdriver.png"),Administracao.AjustePercentuais()),
	// TODO: Cadastro - Banco & Ag�ncia
	cadBanco(Modulo.administracao.getIdModulo(),"Cadastro - Banco & Ag�ncia",FuncoesExtras.buscarIcone("img/bank.png"),new JDesktopPane()),
	// TODO: Cadastro - Limite de Faturamento
	cadLimite(Modulo.administracao.getIdModulo(),"Cadastro - Limite de Faturamento",FuncoesExtras.buscarIcone("img/debt.png"),new JDesktopPane()),
	// TODO: Cadastro - Atividades
	cadAtividades(Modulo.administracao.getIdModulo(),"Cadastro - Atividades",FuncoesExtras.buscarIcone("img/task.png"),new JDesktopPane()),
	// TODO: Cadastro - Estados
	cadEstados(Modulo.administracao.getIdModulo(),"Cadastro - Estados",FuncoesExtras.buscarIcone("img/world.png"),new JDesktopPane()),
	// TODO: Cadastro - Sal�rio M�nimo
	cadSalMin(Modulo.administracao.getIdModulo(),"Cadastro - Sal�rio M�nimo",FuncoesExtras.buscarIcone("img/salary.png"),new JDesktopPane()),
	// TODO: Cadastro - Sindicatos
	cadSindicatos(Modulo.administracao.getIdModulo(),"Cadastro - Sindicatos",FuncoesExtras.buscarIcone("img/operator.png"),new JDesktopPane()),
	
	
	/* Sub-M�dulos de Or�amento */
	gerOrcamento(Modulo.orcamento.getIdModulo(),"Gerar Or�amento",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	importDados(Modulo.orcamento.getIdModulo(),"Importar Dados CP/CR",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attIndividual(Modulo.orcamento.getIdModulo(),"Atualiza��o Individual",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attGeral(Modulo.orcamento.getIdModulo(),"Atualiza��o Geral",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	eventos(Modulo.orcamento.getIdModulo(),"Eventos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	
	/* Sub-M�dulos de Fluxo de Caixa */
	cxDiario(Modulo.fluxoCaixa.getIdModulo(),"Caixa Di�rio",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	fchCaixa(Modulo.fluxoCaixa.getIdModulo(),"Fechamento de Caixa",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	accBancaria(Modulo.fluxoCaixa.getIdModulo(),"Conta Banc�ria",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	supContas(Modulo.fluxoCaixa.getIdModulo(),"Suprimento de Contas",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	consultChq(Modulo.fluxoCaixa.getIdModulo(),"Consulta de Cheques",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	hist(Modulo.fluxoCaixa.getIdModulo(),"Hist�rico",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	proj(Modulo.fluxoCaixa.getIdModulo(),"Projetado",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	comb(Modulo.fluxoCaixa.getIdModulo(),"Combinado",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	
	/* Sub-M�dulos de Contas a Receber */
	lncBaixa(Modulo.contasReceber.getIdModulo(),"Lan�amentos & Baixas",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	gerCobran(Modulo.contasReceber.getIdModulo(),"Gerar Cobran�as",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	gerNF(Modulo.contasReceber.getIdModulo(),"Gera��o de NF",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	gerRPS(Modulo.contasReceber.getIdModulo(),"Gera��o de RPS",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attNF(Modulo.contasReceber.getIdModulo(),"Atualiza��o de NF",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	attRPS(Modulo.contasReceber.getIdModulo(),"Atualiza��o de RPS",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	indDesempenho(Modulo.contasReceber.getIdModulo(),"�ndices de Desempenho",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	/* Sub-M�dulos de Listagens */
	lstUsuario(Modulo.listagens.getIdModulo(),"Listagem de Usu�rios",FuncoesExtras.buscarIcone("img/anonymous_comment.png"),Administracao.ListarUsuarios()),
	lstEmpresas(Modulo.listagens.getIdModulo(),"Listagem de Empresas",FuncoesExtras.buscarIcone("img/alliance.png"),Administracao.ListarEmpresas()),
	lstCobrancas(Modulo.listagens.getIdModulo(),"Listagem de Cobran�as",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	lstPgtoPer(Modulo.listagens.getIdModulo(),"Pagamentos do Per�odo",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	lstFatur(Modulo.listagens.getIdModulo(),"Listagem de Faturamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	lstClientes(Modulo.listagens.getIdModulo(),"Listagem de Clientes",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	/* Sub-M�dulos de Relat�rios */
	relOrc(Modulo.relatorios.getIdModulo(),"Or�amentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relCxCon(Modulo.relatorios.getIdModulo(),"Caixa Consolidado",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relCobrancas(Modulo.relatorios.getIdModulo(),"Cobran�as",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relFatur(Modulo.relatorios.getIdModulo(),"Faturamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	relPagto(Modulo.relatorios.getIdModulo(),"Pagamentos",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane()),
	
	/* Sub-M�dulos de Contas a Pagar */
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
			JanelaPrincipal.SubModulo.addTab("Criar Usu�rio",FuncoesExtras.buscarIcone("img/anonymous_add.png"),Administracao.CriarUsuario());
			JanelaPrincipal.SubModulo.addTab("Editar Usu�rio",FuncoesExtras.buscarIcone("img/anonymous_edit.png"),Administracao.EditarUsuario());
			JanelaPrincipal.SubModulo.addTab("Listagem de Usu�rios",FuncoesExtras.buscarIcone("img/anonymous_comment.png"),Administracao.ListarUsuarios());
			JanelaPrincipal.SubModulo.addTab("Listagem de Empresas",FuncoesExtras.buscarIcone("img/alliance.png"),Administracao.ListarEmpresas());
			JanelaPrincipal.SubModulo.addTab("Gerar Importa��o para Alterdata",FuncoesExtras.buscarIcone("img/backup_server_save.png"),Administracao.GerarImportacaoAlterdata());
			JanelaPrincipal.SubModulo.addTab("Alterar E-mails de Clientes",FuncoesExtras.buscarIcone("img/address_book_edit.png"),Administracao.AlteracaoDeEmail());
			// TODO: Ajuste de Percentuais
			//JanelaPrincipal.SubModulo.addTab("Ajuste de Percentuais",FuncoesExtras.buscarIcone("img/technical_screwdriver.png"),new JDesktopPane());
			// TODO: Cadastro - Banco & Ag�ncia
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Banco & Ag�ncia",FuncoesExtras.buscarIcone("img/bank.png"),new JDesktopPane());
			// TODO: Cadastro - Limite de Faturamento
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Limite de Faturamento",FuncoesExtras.buscarIcone("img/debt.png"),new JDesktopPane());
			// TODO: Cadastro - Atividades
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Atividades",FuncoesExtras.buscarIcone("img/task.png"),new JDesktopPane());
			// TODO: Cadastro - Estados
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Estados",FuncoesExtras.buscarIcone("img/world.png"),new JDesktopPane());
			// TODO: Cadastro - Sal�rio M�nimo
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Sal�rio M�nimo",FuncoesExtras.buscarIcone("img/salary.png"),new JDesktopPane());
			// TODO: Cadastro - Sindicatos
			//JanelaPrincipal.SubModulo.addTab("Cadastro - Sindicatos",FuncoesExtras.buscarIcone("img/operator.png"),new JDesktopPane());
		break;
		
		// TODO: M�dulo - Or�amento
		case 0:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este m�dulo ainda n�o foi habilitado,<br>"
							+ " � poss�vel que esteja funcional na pr�xima revis�o do Sistema blueGarnet.</html>",
							"M�dulo n�o habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: M�dulo - Fluxo de Caixa
		case 1:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este m�dulo ainda n�o foi habilitado,<br>"
							+ " � poss�vel que esteja funcional na pr�xima revis�o do Sistema blueGarnet.</html>",
							"M�dulo n�o habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: M�dulo - Contas a Receber
		case 2:
			JanelaPrincipal.SubModulo.removeAll();
			JanelaPrincipal.SubModulo.addTab("Gerar Cobran�as",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane());
			JanelaPrincipal.SubModulo.addTab("Lan�amentos & Baixas",FuncoesExtras.buscarIcone("img/engineering.png"),new JDesktopPane());
		break;
		
		
		// TODO: M�dulo - Contas a Pagar
		case 3:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este m�dulo ainda n�o foi habilitado,<br>"
							+ " � poss�vel que esteja funcional na pr�xima revis�o do Sistema blueGarnet.</html>",
							"M�dulo n�o habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: M�dulo de Relat�rios
		case 4:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este m�dulo ainda n�o foi habilitado,<br>"
							+ " � poss�vel que esteja funcional na pr�xima revis�o do Sistema blueGarnet.</html>",
							"M�dulo n�o habilitado", JOptionPane.ERROR_MESSAGE);
		break;
		
		// TODO: M�dulo de Suporte
		case 5:
			JOptionPane.showMessageDialog(
					JanelaPrincipal.PainelInterno, "<html>"
							+ "Este m�dulo ainda n�o foi habilitado,<br>"
							+ " � poss�vel que esteja funcional na pr�xima revis�o do Sistema blueGarnet.</html>",
							"M�dulo n�o habilitado", JOptionPane.ERROR_MESSAGE);
			//new TicketSuporte();
		break;
		default:
		break;
	}
	}
	
});
add(b);*/
