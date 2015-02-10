package br.com.blueGarnet.enums;

public enum Percentuais {
	/*
	 * Percentuais
	 * 0 - Escrita Fiscal
	 * 1 - Escrita Fiscal & Contabilidade
	 * 2 - Departamento Pessoal
	 * 3 - Contabilidade
	 */
	lancamentos(0,"Lançamentos"),ecf(0,"ECF"),subseries(0,"Subséries"),icms(0,"ICMS ST"),
	desoneracao(0,"Desoneração Fol. Pgto."),sintegra(0,"Sintegra"),spedFiscal(0,"SPED Fiscal"),
	spedContrib(0,"SPED Contribuições"),ipi(0,"IPI"),iss(0,"ISS"),efd(0,"EFD - IRPJ"),fatMensal(0,"Faturamento Mensal");
	private int idSetor;
	private String nome;
	
	Percentuais(int idSetor, String nome){
		this.setIdSetor(idSetor);
		this.setNome(nome);
	}

	public int getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(int idSetor) {
		this.idSetor = idSetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
