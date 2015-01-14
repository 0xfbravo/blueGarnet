package br.com.blueGarnet.enums;

public enum Setor {
	SOCIETARIO("Societário"),FINANCEIRO("Financeiro");
	
	private String nomeCompleto;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	Setor(String nomeCompleto){
		this.setNomeCompleto(nomeCompleto);
	}
}
