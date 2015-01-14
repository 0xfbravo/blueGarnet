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

public enum NivelPermissao {
	Dev(100,"Desenvolvedor"),
	Adm(99,"Administrador"),
	Financeiro(1,"Financeiro"),
	Fiscal(2,"Fiscal"),
	Contabil(3,"Contábil");
	
	private int numPermissao;
	private String nomePermissao;
	
	NivelPermissao(int numPermissao, String nomePermissao){
		this.setNumPermissao(numPermissao);
		this.setNomePermissao(nomePermissao);
	}

	public int getNumPermissao() {
		return numPermissao;
	}

	public void setNumPermissao(int numPermissao) {
		this.numPermissao = numPermissao;
	}

	public String getNomePermissao() {
		return nomePermissao;
	}

	public void setNomePermissao(String nomePermissao) {
		this.nomePermissao = nomePermissao;
	}

}
