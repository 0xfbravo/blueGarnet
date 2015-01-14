package br.com.blueGarnet.graphics;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDesktopPane;

import br.com.blueGarnet.others.FuncoesExtras;
import br.com.fpimentel.administrador.Administracao;
import br.com.fpimentel.funcextra.TicketSuporte;

@SuppressWarnings("serial")
public class Menu extends JDesktopPane{
	
	public Menu(){
		setLayout(new GridLayout(0,1));
		setBackground(new Color(44, 62, 80));
		add(Box.createVerticalGlue());
		for(tipoMenu t : tipoMenu.values()){
			BotaoMenu b = new BotaoMenu(t.getNomeMenu(), t.getCaminhoImg());
			b.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					switch(t.getId()){
					case 99:
						JanelaPrincipal.subMenu.removeAll();
						JanelaPrincipal.subMenu.addTab("Criar Usuário",FuncoesExtras.buscarIcone("img/anonymous_add.png"),Administracao.CriarUsuario());
						//JanelaPrincipal.subMenu.addTab("Editar Usuário",FuncoesExtras.buscarIcone("img/anonymous_edit.png"),Administracao.EditarUsuario());
						JanelaPrincipal.subMenu.addTab("Listagem de Usuários",FuncoesExtras.buscarIcone("img/anonymous_comment.png"),new JDesktopPane());
						JanelaPrincipal.subMenu.addTab("Listagem de Empresas",FuncoesExtras.buscarIcone("img/alliance.png"),new JDesktopPane());
						JanelaPrincipal.subMenu.addTab("Gerar Importação para Alterdata",FuncoesExtras.buscarIcone("img/backup_server_save.png"),Administracao.GerarImportacaoAlterdata());
						//JanelaPrincipal.subMenu.addTab("Alterar E-mails de Clientes",FuncoesExtras.buscarIcone("img/address_book_edit.png"),Administracao.AlteracaoDeEmail());
						// TODO: Ajuste de Percentuais
						//JanelaPrincipal.subMenu.addTab("Ajuste de Percentuais",FuncoesExtras.buscarIcone("img/technical_screwdriver.png"),new JDesktopPane());
						// TODO: Cadastro - Banco & Agência
						//JanelaPrincipal.subMenu.addTab("Cadastro - Banco & Agência",FuncoesExtras.buscarIcone("img/bank.png"),new JDesktopPane());
						// TODO: Cadastro - Limite de Faturamento
						//JanelaPrincipal.subMenu.addTab("Cadastro - Limite de Faturamento",FuncoesExtras.buscarIcone("img/debt.png"),new JDesktopPane());
						// TODO: Cadastro - Atividades
						//JanelaPrincipal.subMenu.addTab("Cadastro - Atividades",FuncoesExtras.buscarIcone("img/task.png"),new JDesktopPane());
						// TODO: Cadastro - Estados
						//JanelaPrincipal.subMenu.addTab("Cadastro - Estados",FuncoesExtras.buscarIcone("img/world.png"),new JDesktopPane());
						// TODO: Cadastro - Salário Mínimo
						//JanelaPrincipal.subMenu.addTab("Cadastro - Salário Mínimo",FuncoesExtras.buscarIcone("img/salary.png"),new JDesktopPane());
						// TODO: Cadastro - Sindicatos
						//JanelaPrincipal.subMenu.addTab("Cadastro - Sindicatos",FuncoesExtras.buscarIcone("img/operator.png"),new JDesktopPane());
					break;
					case 5:
						new TicketSuporte();
					break;
					default:
					break;
				}
				}
				
			});
			add(b);
		}
		add(Box.createVerticalGlue());
	}
	
	public enum tipoMenu{
		administracao(99,"Administração","img/directive_board.png"),
		orcamento(0,"Orçamento","img/report2.png"),
		fluxoCaixa(1,"Fluxo de Caixa","img/bank_transaction.png"),
		contasReceber(2,"Contas a Receber","img/wallet.png"),
		contasPagar(3,"Contas a Pagar","img/paypal.png"),
		relatorios(4,"Relatórios","img/printer.png"),
		suporte(5,"Suporte","img/headset.png");
		
		private int id;
		private String nomeMenu;
		private String caminhoImg;
		
		tipoMenu(int id, String nomeMenu, String caminhoImg){
			this.setId(id);
			this.setNomeMenu(nomeMenu);
			this.setCaminhoImg(caminhoImg);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNomeMenu() {
			return nomeMenu;
		}

		public void setNomeMenu(String nomeMenu) {
			this.nomeMenu = nomeMenu;
		}

		public String getCaminhoImg() {
			return caminhoImg;
		}

		public void setCaminhoImg(String caminhoImg) {
			this.caminhoImg = caminhoImg;
		}
	}
}
