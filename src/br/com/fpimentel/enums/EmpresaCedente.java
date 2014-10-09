package br.com.fpimentel.enums;

public enum EmpresaCedente {
	SemEmpresa("P/ COBRAN�AS CONVERTIDAS S/ EMPRESA","001"),Malote("SERVI�OS DE MALOTE","002"),
		Contabilidade("SERVI�OS DE CONTABILIDADE","003"),Bureau("SJT BUREAU DE SERVI�OS","004"),
			Pessoal("EDSON DUPRET","005");
	
	private String numeracao;
	private String nomeEmpresa;
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	EmpresaCedente(String nomeEmpresa,String numeracao){
		this.setNumeracao(numeracao);
		this.setNomeEmpresa(nomeEmpresa);
	}

	public String getNumeracao() {
		return numeracao;
	}

	public void setNumeracao(String numeracao) {
		this.numeracao = numeracao;
	}

}
