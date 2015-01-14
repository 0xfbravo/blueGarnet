package br.com.blueGarnet.enums;

public enum Modulo{
	administracao(99,"Administra��o","img/directive_board.png"),
	orcamento(0,"Or�amento","img/report2.png"),
	fluxoCaixa(1,"Fluxo de Caixa","img/bank_transaction.png"),
	contasReceber(2,"Contas a Receber","img/wallet.png"),
	contasPagar(3,"Contas a Pagar","img/paypal.png"),
	relatorios(4,"Relat�rios","img/printer.png"),
	suporte(5,"Suporte","img/headset.png");
	
	private int permissao;
	private String nomeModulo;
	private String icone;
	
	Modulo(int permissao, String nomeMenu, String icone){
		this.setPermissao(permissao);
		this.setNomeModulo(nomeMenu);
		this.setIcone(icone);
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
}