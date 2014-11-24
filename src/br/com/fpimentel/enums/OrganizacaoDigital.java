package br.com.fpimentel.enums;

import java.util.ArrayList;
import java.util.EnumSet;

public class OrganizacaoDigital {

	public ArrayList<Unidade> unidade = new ArrayList<Unidade>(EnumSet.allOf(Unidade.class));
	
	public enum Unidade{
		Societario(0,"Societ�rio"),Financeiro(1,"Financeiro");
		private String nome;
		private int id;
		public ArrayList<OrganizacaoFIN> organizacaoFIN;
		public ArrayList<OrganizacaoSOC> organizacaoSOC;

		Unidade(int id, String nome){
			switch(id){
				case 0:
					/*Societ�rio*/
					this.organizacaoSOC = new ArrayList<OrganizacaoSOC>(EnumSet.allOf(OrganizacaoSOC.class));
					break;
				case 1:
					/*Financeiro*/
					this.organizacaoFIN = new ArrayList<OrganizacaoFIN>(EnumSet.allOf(OrganizacaoFIN.class));
					break;
			}
			this.nome = nome;
			this.id = id;
		}
		
		public int getID() {
			return id;
		}

		public void setID(int id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
	}

	public enum OrganizacaoFIN{
		FIN_COBRANCA(0,"Cobran�as"),FIN_PEDENCIAS(1,"Pend�ncias");
		private String nome;
		private int id;
		public ArrayList<FinCobrancas> finCobrancas;
		public ArrayList<FinPendencias> finPendencias;

		OrganizacaoFIN(int id, String nome){
			switch(id){
				case 0:
					/*Cobran�as*/
					this.finCobrancas = new ArrayList<FinCobrancas>(EnumSet.allOf(FinCobrancas.class));
					break;
				case 1:
					/*Pend�ncias*/
					this.finPendencias = new ArrayList<FinPendencias>(EnumSet.allOf(FinPendencias.class));
					break;
			}
			this.nome = nome;
			this.id = id;
		}
		
		public int getID() {
			return id;
		}

		public void setID(int id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
	}
	public enum OrganizacaoSOC{
		SOC_CONTRATO(0,"Contrato"),SOC_FEDERAL(1,"Federal"),SOC_ESTADUAL(2,"Estadual"),
			SOC_MUNICIPAL(3,"Municipal"),SOC_OUTROS(4,"Outros");
		private String nome;
		private int id;
		public ArrayList<SocContrato> socContrato;
		public ArrayList<SocFederal> socFederal;
		public ArrayList<SocEstadual> socEstadual;
		public ArrayList<SocMunicipal> socMunicipal;
		public ArrayList<SocOutros> socOutros;

		OrganizacaoSOC(int id, String nome){
			switch(id){
				case 0:
					/*Contrato*/
					this.socContrato = new ArrayList<SocContrato>(EnumSet.allOf(SocContrato.class));
					break;
				case 1:
					/*Federal*/
					this.socFederal = new ArrayList<SocFederal>(EnumSet.allOf(SocFederal.class));
					break;
				case 2:
					/*Estadual*/
					this.socEstadual = new ArrayList<SocEstadual>(EnumSet.allOf(SocEstadual.class));
					break;
				case 3:
					/*Municipal*/
					this.socMunicipal = new ArrayList<SocMunicipal>(EnumSet.allOf(SocMunicipal.class));
					break;
				case 4:
					/*Outros*/
					this.socOutros = new ArrayList<SocOutros>(EnumSet.allOf(SocOutros.class));
					break;
			}
			this.nome = nome;
			this.id = id;
		}
		
		public int getID() {
			return id;
		}

		public void setID(int id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	}

	
	/* Financeiro */
	public enum FinCobrancas {
		REL_COBRANCAS("001","Rela��o de Cobran�as Previstas & Eventuais"),
			PROTOCOLO_DOC("002","Protocolo de Documentos"),
				BOLETOS("003","Boletos");
		
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
		
		FinCobrancas(String codigo, String nomeCompleto){
			this.setCodigo(codigo);
			this.setNomeCompleto(nomeCompleto);	
		}

	}

	public enum FinPendencias {
		COM_EXTERNOS("001","Comunidados Externos - Presta��o de Servi�os Suspensa"),
			EMAIL_PENDENCIAS("002","E-mail de Cobran�as de Pend�ncias");
		
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
		
		FinPendencias(String codigo, String nomeCompleto){
			this.setCodigo(codigo);
			this.setNomeCompleto(nomeCompleto);	
		}

	}

	/* Societ�rio */
	public enum SocContrato {
		CONTRATO_SOCIAL("001","Contrato Social"),ALTERACAO_CONTRATUAL("002","Altera��o Contratual");
		
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
		
		SocContrato(String codigo, String nomeCompleto){
			this.setCodigo(codigo);
			this.setNomeCompleto(nomeCompleto);	
		}
	}

	public enum SocFederal {
		COMPROVANTE_CNPJ("001","Comprovante de Inscri��o de CNPJ"),
			CHAVE_SIMPLESNAC("002","Chave Simples Nacional"),
				CERTID_FEDERAIS("003","Certid�es Federais");
		
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
		
		SocFederal(String codigo, String nomeCompleto){
			this.setCodigo(codigo);
			this.setNomeCompleto(nomeCompleto);	
		}

	}
	
	public enum SocEstadual {
		BOMBEIROS("001","Bombeiros - Certificado de Aprova��o & Laudo de Exig�ncia"),
			INSCR_ESTADUAL("002","Inscri��o Estadual"),
				CERTID_ESTADUAI("003","Certid�es Estaduais");
		
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
		
		SocEstadual(String codigo, String nomeCompleto){
			this.setCodigo(codigo);
			this.setNomeCompleto(nomeCompleto);	
		}

	}

	public enum SocMunicipal {
		ALVARA("001","Alvar�"),FICHA_INSC_MUNICIPAL("002","Ficha de Inscri��o Municipal"),
			COPIAS("003","C�pia da Taxa Paga & C�pia da Planta do Letreiro"),
				CONSULTA_PREVIA("004","Consulta Pr�via"), CERTIDAO_ISS("005", "Certid�o de ISS"),
					VIGILANCIA_SANITARIA("006","Vigil�ncia Sanit�ria");
		
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
		
		SocMunicipal(String codigo, String nomeCompleto){
			this.setCodigo(codigo);
			this.setNomeCompleto(nomeCompleto);	
		}

	}

	public enum SocOutros {
		DOC_PESSOAIS("001","Documentos Pessoais dos S�cios"),
			CONTRATO_LOCACAO("002","Contrato de Loca��o"),
				PROTOC_ENTREGA("003","Protocolo de Entrega"),
					MEMO_REUNIOES("004","Mem�ria de Reuni�es");
		
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
	
	/***
	 * Main para DEBUG
	 */
	/*
	public static void main (String[] args) {
    EnumDigitalizacao e1 = new EnumDigitalizacao();
    System.out.println("Unidades Dispon�veis: "+e1.unidade);

    	for(int i= 0; i < e1.unidade.size(); i++){
    		System.out.println("\n� Listagem do "+e1.unidade.get(i).getNome());
    		switch(e1.unidade.get(i).getID()){
    			// Listagem do ArrayList do SOCIET�RIO
    			case 0:
    				System.out.println(e1.unidade.get(i).organizacaoSOC);
    				for(int j= 0; j < e1.unidade.get(i).organizacaoSOC.size(); j++){
    					switch(e1.unidade.get(i).organizacaoSOC.get(j).getID()){
    						case 0:
    							// Contrato
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoSOC.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoSOC.get(j).socContrato.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoSOC.get(j)
    											.socContrato.get(k).getNomeCompleto());
    							}
    						break;
    							
    						case 1:
    							// Federal
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoSOC.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoSOC.get(j).socFederal.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoSOC.get(j)
    											.socFederal.get(k).getNomeCompleto());
    							}
    						break;
    							
    						case 2:
    							// Estadual
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoSOC.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoSOC.get(j).socEstadual.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoSOC.get(j)
    											.socEstadual.get(k).getNomeCompleto());
    							}
    						break;
    						
    						case 3:
    							// Municipal
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoSOC.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoSOC.get(j).socMunicipal.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoSOC.get(j)
    											.socMunicipal.get(k).getNomeCompleto());
    							}
    						break; 
    						
    						case 4:
    							// Outros
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoSOC.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoSOC.get(j).socOutros.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoSOC.get(j)
    											.socOutros.get(k).getNomeCompleto());
    							}
    						break;  
    					}
    				}
    				break;
    		
    			// Listagem do ArrayList do FINANCEIRO
    			case 1:
    				System.out.println(e1.unidade.get(i).organizacaoFIN);
    				for(int j= 0; j < e1.unidade.get(i).organizacaoFIN.size(); j++){
    					switch(e1.unidade.get(i).organizacaoFIN.get(j).getID()){
    						case 0:
    							// Cobran�as
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoFIN.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoFIN.get(j).finCobrancas.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoFIN.get(j)
    											.finCobrancas.get(k).getNomeCompleto());
    							}
    							break;
    							
    						case 1:
    							// Pend�ncias
    							System.out.println("\t:: "+e1.unidade.get(i).organizacaoFIN.get(j).getNome()+" ::");
    							for(int k=0; k < e1.unidade.get(i).organizacaoFIN.get(j).finPendencias.size(); k++){
    								System.out.println(" - "+e1.unidade.get(i).organizacaoFIN.get(j)
    											.finPendencias.get(k).getNomeCompleto());
    							}
    							break;
    					}
    				}
    			break;
    		}
    	}
}*/
}
