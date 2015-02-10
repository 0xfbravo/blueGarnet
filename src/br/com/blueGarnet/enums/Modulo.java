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

public enum Modulo{
	administracao(100,"Administração","img/directive_board.png",0),
	orcamento(100,"Orçamento","img/report2.png",1),
	fluxoCaixa(1,"Fluxo de Caixa","img/bank_transaction.png",2),
	contasReceber(1,"Contas a Receber","img/wallet.png",3),
	contasPagar(1,"Contas a Pagar","img/paypal.png",4),
	listagens(100,"Listagens","img/white_list.png",5),
	relatorios(100,"Relatórios","img/printer.png",6),
	suporte(255,"Suporte","img/headset.png",7),
	verAtt(255,"Atualizações","img/network.png",8);
	
	private int permissao;
	private int idModulo;
	private String nomeModulo;
	private String icone;
	
	Modulo(int permissao, String nomeMenu, String icone, int idModulo){
		this.setPermissao(permissao);
		this.setNomeModulo(nomeMenu);
		this.setIcone(icone);
		this.setIdModulo(idModulo);
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeMenu) {
		this.nomeModulo = nomeMenu;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}

	public int getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(int idModulo) {
		this.idModulo = idModulo;
	}
}
