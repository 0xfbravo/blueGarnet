package br.com.fpimentel.enums;

public enum SocOutros {
	DOC_PESSOAIS("001","Documentos Pessoais dos Sócios"),
		CONTRATO_LOCACAO("002","Contrato de Locação"),
			PROTOC_ENTREGA("003","Protocolo de Entrega"),
				MEMO_REUNIOES("004","Memória de Reuniões");
	
	private String codigo;
	private String nomeCompleto;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	
	SocOutros(String codigo, String nomeCompleto){
		this.setCodigo(codigo);
		this.setNomeCompleto(nomeCompleto);	
	}

}
