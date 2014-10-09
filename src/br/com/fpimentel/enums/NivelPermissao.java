package br.com.fpimentel.enums;

public enum NivelPermissao {
	Dev(99,"Desenvolvedor"),Adm(0,"Administrador"),Financeiro(1,"Financeiro"),
		Fiscal(2,"Fiscal"),Contabil(3,"Contabil");
	
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
