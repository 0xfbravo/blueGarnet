package br.com.fpimentel.enums;

public enum Ano {
	ano1(2000),ano2(2001),ano3(2002),ano4(2003),ano5(2004),ano6(2005),ano7(2006),ano8(2007),
			ano9(2008),ano10(2009),ano11(2010),ano12(2011),ano13(2012),ano14(2013),ano15(2014),
					ano16(2015),ano17(2016),ano18(2017),ano19(2018),ano20(2019),ano21(2020);
	
	private int ano;
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	Ano(int ano){
		this.setAno(ano);
	}
}
