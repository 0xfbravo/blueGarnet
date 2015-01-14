package br.com.blueGarnet.enums;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/
public enum SituacaoCobranca {
	Receber("G","A RECEBER"),Todas("T","TODAS"),Baixadas("B","BAIXADAS (Recebidas)"),
		AtualOrc("A","ATUAL ORÇ (Recebidas)");
	
	private String nomeReduzido;
	private String nomeCompleto;
	
	public String getNomeReduzido() {
		return nomeReduzido;
	}

	public void setNomeReduzido(String nomeReduzido) {
		this.nomeReduzido = nomeReduzido;
	}

	SituacaoCobranca(String nomeReduzido, String nomeCompleto){
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
