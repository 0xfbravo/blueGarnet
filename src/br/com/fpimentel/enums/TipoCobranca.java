package br.com.fpimentel.enums;

public enum TipoCobranca {
	Todos("T","TODOS"),Carteira("C","CARTEIRA"),Boleto("B","BOLETO");
	
	private String nomeReduzido;
	private String nomeCompleto;
	
	public String getNomeReduzido() {
		return nomeReduzido;
	}

	public void setNomeReduzido(String nomeReduzido) {
		this.nomeReduzido = nomeReduzido;
	}

	TipoCobranca(String nomeReduzido, String nomeCompleto){
		this.setNomeReduzido(nomeReduzido);
		this.setNomeCompleto(nomeCompleto);
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
}
