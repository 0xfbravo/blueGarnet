package br.com.blueGarnet.enums;

public enum Mes {
	JANEIRO(1,"Janeiro"),FEVEREIRO(2,"Fevereiro"),MARCO(3,"Março"),ABRIL(4,"Abril"),
		MAIO(5,"Maio"),JUNHO(6,"Junho"),JULHO(7,"Julho"),AGOSTO(8,"Agosto"),
			SETEMBRO(9,"Setembro"),OUTUBRO(10,"Outubro"),NOVEMBRO(11,"Novembro"),
				DEZEMBRO(12,"Dezembro");
	
	private int numeroMes;
	private String nomeMes;
	
	public int getNumeroMes() {
		return numeroMes;
	}
	public void setNumeroMes(int numeroMes) {
		this.numeroMes = numeroMes;
	}
	public String getNomeMes() {
		return nomeMes;
	}
	public void setNomeMes(String nomeMes) {
		this.nomeMes = nomeMes;
	}
	
	Mes(int numeroMes,String nomeMes){
		this.setNomeMes(nomeMes);
		this.setNumeroMes(numeroMes);
	}
}
