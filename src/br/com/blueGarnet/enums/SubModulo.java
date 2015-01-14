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
	criarUsuario(99,"Criar Usu�rio",FuncoesExtras.buscarIcone("img/anonymous_add.png"),Administracao.CriarUsuario()),
	editarUsuario(99,"Editar Usu�rio",FuncoesExtras.buscarIcone("img/anonymous_edit.png"),Administracao.EditarUsuario()),
	lstUsuario(99,"Listagem de Usu�rios",FuncoesExtras.buscarIcone("img/anonymous_comment.png"),Administracao.ListarUsuarios()),
	lstEmpresas(99,"Listagem de Empresas",FuncoesExtras.buscarIcone("img/alliance.png"),Administracao.ListarEmpresas()),
	importarAlterdata(99,"Gerar Importa��o para Alterdata",FuncoesExtras.buscarIcone("img/backup_server_save.png"),Administracao.GerarImportacaoAlterdata()),
	emailClientes(99,"Alterar E-mails de Clientes",FuncoesExtras.buscarIcone("img/address_book_edit.png"),Administracao.AlteracaoDeEmail()),
	// TODO: Ajuste de Percentuais
	ajustePercentuais(99,"Ajuste de Percentuais",FuncoesExtras.buscarIcone("img/technical_screwdriver.png"),new JDesktopPane()),
	// TODO: Cadastro - Banco & Ag�ncia
	cadBanco(99,"Cadastro - Banco & Ag�ncia",FuncoesExtras.buscarIcone("img/bank.png"),new JDesktopPane()),
	// TODO: Cadastro - Limite de Faturamento
	cadLimite(99,"Cadastro - Limite de Faturamento",FuncoesExtras.buscarIcone("img/debt.png"),new JDesktopPane()),
	// TODO: Cadastro - Atividades
	cadAtividades(99,"Cadastro - Atividades",FuncoesExtras.buscarIcone("img/task.png"),new JDesktopPane()),
	// TODO: Cadastro - Estados
	cadEstados(99,"Cadastro - Estados",FuncoesExtras.buscarIcone("img/world.png"),new JDesktopPane()),
	// TODO: Cadastro - Sal�rio M�nimo
	cadSalMin(99,"Cadastro - Sal�rio M�nimo",FuncoesExtras.buscarIcone("img/salary.png"),new JDesktopPane()),
	// TODO: Cadastro - Sindicatos
	cadSindicatos(99,"Cadastro - Sindicatos",FuncoesExtras.buscarIcone("img/operator.png"),new JDesktopPane());
	
	/* Sub-M�dulos de Or�amento */
	/* Sub-M�dulos de Fluxo de Caixa */
	/* Sub-M�dulos de Contas a Receber */
	/* Sub-M�dulos de Contas a Pagar */
	
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
