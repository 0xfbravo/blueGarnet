package br.com.blueGarnet.modules;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel © 2014
										 www.fcode.co
*/
//TODO: Finalizar Módulo Contas a Receber

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jrimum.bopepo.BancosSuportados;
import org.jrimum.bopepo.Boleto;
import org.jrimum.bopepo.view.BoletoViewer;
import org.jrimum.domkee.comum.pessoa.endereco.CEP;
import org.jrimum.domkee.comum.pessoa.endereco.Endereco;
import org.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import org.jrimum.domkee.financeiro.banco.febraban.Agencia;
import org.jrimum.domkee.financeiro.banco.febraban.Carteira;
import org.jrimum.domkee.financeiro.banco.febraban.Cedente;
import org.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import org.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import org.jrimum.domkee.financeiro.banco.febraban.Sacado;
import org.jrimum.domkee.financeiro.banco.febraban.SacadorAvalista;
import org.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo;
import org.jrimum.domkee.financeiro.banco.febraban.Titulo.Aceite;

import br.com.blueGarnet.enums.EmpresaCedente;
import br.com.blueGarnet.enums.SituacaoCobranca;
import br.com.blueGarnet.enums.TipoCobranca;
import br.com.blueGarnet.graphics.JanelaPrincipal;
import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Database;

public class ContasReceber{
	/* Informações Sacado */
	private String nomeEmpresaSAC;
	private String cnpjSAC;
	private String cepSAC;
	private String enderecoSAC;
	private String bairroSAC;
	private String cidadeSAC;
	/* Informações Cedente */
	private String nomeEmpresaCED;
	private String cnpjCED;
	private int agenciaCED;
	private String codigoCED;
	private String especieDoc;
	private String aceite;
	private int carteira;
	private String nossoNumero;
	private String numDocumento;
	private String valorDocumento;
	private String descontoAbat;
	private String outrasDed;
	private String multa;
	private String outrosAcr;
	private String localPagar;
	private String vencimento;	
	private String instrucao[];
	
	
	/*
	 *     Getters & Setters
	 */	
	public String getCidadeSAC() {
		return cidadeSAC;
	}
	public void setCidadeSAC(String cidadeSAC) {
		this.cidadeSAC = cidadeSAC;
	}
	public String getBairroSAC() {
		return bairroSAC;
	}
	public void setBairroSAC(String bairroSAC) {
		this.bairroSAC = bairroSAC;
	}
	public String[] getInstrucao() {
		return instrucao;
	}
	public void setInstrucao(String instrucao[]) {
		this.instrucao = instrucao;
	}
	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
	public String getLocalPagar() {
		return localPagar;
	}
	public void setLocalPagar(String localPagar) {
		this.localPagar = localPagar;
	}
	public String getOutrosAcr() {
		return outrosAcr;
	}
	public void setOutrosAcr(String outrosAcr) {
		this.outrosAcr = outrosAcr;
	}
	public String getMulta() {
		return multa;
	}
	public void setMulta(String multa) {
		this.multa = multa;
	}
	public String getOutrasDed() {
		return outrasDed;
	}
	public void setOutrasDed(String outrasDed) {
		this.outrasDed = outrasDed;
	}
	public String getDescontoAbat() {
		return descontoAbat;
	}
	public void setDescontoAbat(String descontoAbat) {
		this.descontoAbat = descontoAbat;
	}
	public String getValorDocumento() {
		return valorDocumento;
	}
	public void setValorDocumento(String valorDocumento) {
		this.valorDocumento = valorDocumento;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	public String getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	public int getCarteira() {
		return carteira;
	}
	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}
	public String getAceite() {
		return aceite;
	}
	public void setAceite(String aceite) {
		this.aceite = aceite;
	}
	public String getEspecieDoc() {
		return especieDoc;
	}
	public void setEspecieDoc(String especieDoc) {
		this.especieDoc = especieDoc;
	}
	public String getCodigoCED() {
		return codigoCED;
	}
	public void setCodigoCED(String codigoCED) {
		this.codigoCED = codigoCED;
	}
	public int getAgenciaCED() {
		return agenciaCED;
	}
	public void setAgenciaCED(int agenciaCED) {
		this.agenciaCED = agenciaCED;
	}
	public String getCnpjCED() {
		return cnpjCED;
	}
	public void setCnpjCED(String cnpjCED) {
		String manipulaCNPJ = cnpjCED;
		//System.out.println(manipulaCNPJ+" -- CNPJ RECEBIDO DO DB");
    	if(manipulaCNPJ.indexOf("/") > 0){
    		manipulaCNPJ = manipulaCNPJ.replaceAll("/", "");
    		//System.out.println(manipulaCNPJ+" > Tirou a BARRA");
    	}
    	if(manipulaCNPJ.indexOf("-") > 0){
    		manipulaCNPJ = manipulaCNPJ.replaceAll("-", "");
    		//System.out.println(manipulaCNPJ+" > Tirou o HÍFEN");
    	}
    	if(manipulaCNPJ.indexOf(".") > 0){
    		manipulaCNPJ = manipulaCNPJ.replaceAll(".", "");
    		//System.out.println(manipulaCNPJ+" > Tirou o PONTO");
    	}
    	//System.out.println(manipulaCNPJ+" -- Antes da Conversão");
    	this.cnpjCED = FuncoesExtras.format("##.###.###/####-##",manipulaCNPJ);
    	//System.out.println(this.cnpjCED+" -- Após Conversão");
	}
	public String getNomeEmpresaCED() {
		return nomeEmpresaCED;
	}
	public void setNomeEmpresaCED(String nomeEmpresaCED) {
		this.nomeEmpresaCED = nomeEmpresaCED;
	}
	public String getEnderecoSAC() {
		return enderecoSAC;
	}
	public void setEnderecoSAC(String enderecoSAC) {
		this.enderecoSAC = enderecoSAC;
	}
	public String getCepSAC() {
		return cepSAC;
	}
	public void setCepSAC(String cepSAC) {
		this.cepSAC = cepSAC;
	}
	public String getCnpjSAC() {
		return cnpjSAC;
	}
	public void setCnpjSAC(String cnpjSAC) {
		String manipulaCNPJ = cnpjSAC;
		//System.out.println(manipulaCNPJ+" -- CNPJ RECEBIDO DO DB");
    	if(manipulaCNPJ.indexOf("/") > 0){
    		manipulaCNPJ = manipulaCNPJ.replaceAll("/", "");
    		//System.out.println(manipulaCNPJ+" > Tirou a BARRA");
    	}
    	if(manipulaCNPJ.indexOf("-") > 0){
    		manipulaCNPJ = manipulaCNPJ.replaceAll("-", "");
    		//System.out.println(manipulaCNPJ+" > Tirou o HÍFEN");
    	}
    	if(manipulaCNPJ.indexOf(".") > 0){
    		manipulaCNPJ = manipulaCNPJ.replaceAll(".", "");
    		//System.out.println(manipulaCNPJ+" > Tirou o PONTO");
    	}
    	//System.out.println(manipulaCNPJ+" -- Antes da Conversão");
    	this.cnpjSAC = FuncoesExtras.format("##.###.###/####-##",manipulaCNPJ);
    	//System.out.println(this.cnpjSAC+" -- Após Conversão");
	}
	public String getNomeEmpresaSAC() {
		return nomeEmpresaSAC;
	}
	public void setNomeEmpresaSAC(String nomeEmpresaSAC) {
		this.nomeEmpresaSAC = nomeEmpresaSAC;
	}
	
	
	/*
	 *  Método para Criação da
	 *		JanelaPrincipal de Cobranças
	 */
	@SuppressWarnings("unchecked")
	public void GerarCobrancas(){
		JFrame JIF = JanelaPrincipal.createFrame("Gerar Cobranças",400,500);
		JIF.setIconImage(FuncoesExtras.buscarIcone("img/zone_money.png").getImage());
		
		JDesktopPane PainelInternoJIF = new JDesktopPane();
		JIF.getContentPane().add(PainelInternoJIF);
		
		
		JLabel lblNumeroEF = new JLabel("Número das Empresas");
		lblNumeroEF.setBounds(30, 17, 140, 14);
		
		// ----- Gerar Cobrança
		JButton btnGerarCB = null;
		btnGerarCB = new JButton("Gerar Cobranças");
		PainelInternoJIF.repaint();
		btnGerarCB.setBounds(340, 37, 140, 25);
		btnGerarCB.setIcon(FuncoesExtras.buscarIcone("img/page_copy.png"));
		PainelInternoJIF.add(btnGerarCB);
		
		// ----- Número da Empresa Inicial
		JTextField numEmpresaI = new JTextField();
		numEmpresaI.setColumns(10);
		numEmpresaI.setBounds(30, 37, 50, 25);
		numEmpresaI.setText("1");
		PainelInternoJIF.add(numEmpresaI);
		numEmpresaI.setToolTipText("Código da Empresa Inicial");
		
		JLabel lblNumeroATE = new JLabel("a");
		lblNumeroATE.setBounds(87, 45, 50, 14);
		PainelInternoJIF.add(lblNumeroATE);	
		
		// ----- Número da Empresa Final
		PainelInternoJIF.add(lblNumeroEF);	
		JTextField numEmpresaF = new JTextField();
		numEmpresaF.setColumns(10);
		numEmpresaF.setBounds(100, 37, 50, 25);
		numEmpresaF.setText("999");
		PainelInternoJIF.add(numEmpresaF);
		numEmpresaF.setToolTipText("Código da Empresa Final");
		
		// ------ Tipo de Cobrança
		JLabel lblTipoCobranca = new JLabel("Tipo de Cobrança");
		lblTipoCobranca.setBounds(30, 77, 140, 14);
		PainelInternoJIF.add(lblTipoCobranca);
		@SuppressWarnings("rawtypes")
		JComboBox tipoCobranca = new JComboBox();
		tipoCobranca.addItem(TipoCobranca.Todos.getNomeReduzido()+" - "
				+TipoCobranca.Todos.getNomeCompleto());
		tipoCobranca.addItem(TipoCobranca.Carteira.getNomeReduzido()+" - "
				+TipoCobranca.Carteira.getNomeCompleto());
		tipoCobranca.addItem(TipoCobranca.Boleto.getNomeReduzido()+" - "
				+TipoCobranca.Boleto.getNomeCompleto());
		tipoCobranca.setBounds(30, 97, 90, 25);
		tipoCobranca.setToolTipText("Selecione o tipo de cobrança");
		PainelInternoJIF.add(tipoCobranca);
		
		// ----- Nosso Número
		JLabel lblnossoNumero = new JLabel("Nosso Número");
		lblnossoNumero.setBounds(30, 137, 90, 14);
		PainelInternoJIF.add(lblnossoNumero);	
		JTextField nossoNumero = new JTextField();
		nossoNumero.setColumns(10);
		nossoNumero.setBounds(30, 157, 90, 25);
		nossoNumero.setBackground(Color.lightGray);
		PainelInternoJIF.add(nossoNumero);
		nossoNumero.setName("Nosso Número");
		nossoNumero.setEnabled(false);
		// ----- Gerar Nosso Número
		JButton btnGerarNN = new JButton();
		btnGerarNN.setBounds(130, 157, 30, 25);
		btnGerarNN.setIcon(FuncoesExtras.buscarIcone("img/sort_number.png"));
		btnGerarNN.setToolTipText("Gerar Nosso Número");
		PainelInternoJIF.add(btnGerarNN);
		
		btnGerarNN.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Random random = new Random();
				nossoNumero.setText(random.toString());
			}
		});
		
		// ------ Empresa Cedente
		JLabel lblEmpresaCED = new JLabel("Empresa Cedente");
		lblEmpresaCED.setBounds(30, 197, 140, 14);
		PainelInternoJIF.add(lblEmpresaCED);
		@SuppressWarnings("rawtypes")
		JComboBox empresaCED = new JComboBox();
		empresaCED.addItem(EmpresaCedente.SemEmpresa.getNumeracao()+
				" - "+EmpresaCedente.SemEmpresa.getNomeEmpresa());
		empresaCED.addItem(EmpresaCedente.Malote.getNumeracao()+
				" - "+EmpresaCedente.Malote.getNomeEmpresa());
		empresaCED.addItem(EmpresaCedente.Contabilidade.getNumeracao()+
				" - "+EmpresaCedente.Contabilidade.getNomeEmpresa());
		empresaCED.addItem(EmpresaCedente.Bureau.getNumeracao()+
				" - "+EmpresaCedente.Bureau.getNomeEmpresa());
		empresaCED.addItem(EmpresaCedente.Pessoal.getNumeracao()+
				" - "+EmpresaCedente.Pessoal.getNomeEmpresa());
		empresaCED.setBounds(30, 217, 190, 25);
		PainelInternoJIF.add(empresaCED);
		empresaCED.setToolTipText("Selecione a Empresa Cedente");
		
		// ------ Situação da Cobrança
		JLabel lblSituacaoCob = new JLabel("Situação");
		lblSituacaoCob.setBounds(30, 257, 140, 14);
		PainelInternoJIF.add(lblSituacaoCob);
		@SuppressWarnings("rawtypes")
		JComboBox SituacaoCob = new JComboBox();
		SituacaoCob.addItem(SituacaoCobranca.Receber.getNomeReduzido()+" - "
				+SituacaoCobranca.Receber.getNomeCompleto());
		SituacaoCob.addItem(SituacaoCobranca.Todas.getNomeReduzido()+" - "
				+SituacaoCobranca.Todas.getNomeCompleto());
		SituacaoCob.addItem(SituacaoCobranca.Baixadas.getNomeReduzido()+" - "
				+SituacaoCobranca.Baixadas.getNomeCompleto());
		SituacaoCob.addItem(SituacaoCobranca.AtualOrc.getNomeReduzido()+" - "
				+SituacaoCobranca.AtualOrc.getNomeCompleto());
		SituacaoCob.setBounds(30, 277, 190, 25);
		PainelInternoJIF.add(SituacaoCob);
		SituacaoCob.setToolTipText("Selecione a Situação da Cobrança");
		
		
		btnGerarCB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String url = "jdbc:sqlserver://192.168.100.204:49996;databaseName=ALTERDATA";
					Connection conn = DriverManager.getConnection(url,Database.userDB,Database.passDB);
					int inteiroInicial = Integer.parseInt(numEmpresaI.getText());
					int inteiroFinal = Integer.parseInt(numEmpresaF.getText());
					
					for(int i = inteiroInicial; i <= inteiroFinal; i++){
					Statement s = conn.createStatement();
					ResultSet rs;
				    rs = s.executeQuery("select * from wphd.Empresa WHERE CdEmpresa='"+i+"'");
				    	while(rs.next()){
				    		//System.out.println(rs.getString("NmEmpresa")+"||"+rs.getInt("CdEmpresa")+"||"+rs.getString("NrCGC"));
				    		if(rs.getString("NmEmpresa").indexOf("/") > 0){
				    			GerarBoletos(rs.getString("NmEmpresa").replaceAll("/", "").replaceAll(".", ""),rs.getInt("CdEmpresa"),rs.getString("NrCGC"));
				    		} else {
				    			GerarBoletos(rs.getString("NmEmpresa"),rs.getInt("CdEmpresa"),rs.getString("NrCGC"));
				    		}
				    	}
					}
					JOptionPane.showMessageDialog(null, "Todos os boletos foram gerados com sucesso!");
				}
				catch (Exception e1){
					System.err.println(e1.getMessage());
			}
			}
		});
	}
	
	/*
	 * Método para Gerar Boletos
	 *    utilizando biblioteca JRIMUM
	 */	
	public void GerarBoletos(String NomeEmpresa, int NumeroEmpresa, String CNPJ){
		try{
			String url = "jdbc:sqlserver://192.168.100.204:49996;databaseName=ALTERDATA";
			Connection conn = DriverManager.getConnection(url,Database.userDB,Database.passDB);
			Statement s = conn.createStatement();
			ResultSet rs;
		    rs = s.executeQuery("select * from wphd.Empresa WHERE CdEmpresa='"+NumeroEmpresa+"'");
		    while(rs.next()){
		    	this.setNomeEmpresaSAC(rs.getString("NmEmpresa"));
		    	this.setCnpjSAC(rs.getString("NrCGC"));
		    	this.setEnderecoSAC(rs.getString("DsEndereco"));
		    	this.setBairroSAC(rs.getString("NmBairro"));
		    	this.setCepSAC(rs.getString("NrCEP"));
		    	this.setCidadeSAC(rs.getString("NmCidade"));
		    }
    		ResultSet rs1;
    		rs1 = s.executeQuery("select * from wphd.Empresa WHERE CdEmpresa='330'");
    		while(rs1.next()){
    			this.setNomeEmpresaCED(rs1.getString("NmEmpresa"));
    			this.setCnpjCED(rs1.getString("NrCGC"));
    		}

        /*
         * INFORMANDO DADOS SOBRE O CEDENTE.
         */
        Cedente cedente = new Cedente(this.getNomeEmpresaCED(), this.getCnpjCED());
        /*
         * INFORMANDO DADOS SOBRE O SACADO.
         */
        Sacado sacado = new Sacado(this.getNomeEmpresaSAC(), this.getCnpjSAC());

        // Informando o endereço do sacado.
        Endereco enderecoSac = new Endereco();
        enderecoSac.setUF(UnidadeFederativa.RJ);
        enderecoSac.setLocalidade(this.getCidadeSAC());
        enderecoSac.setCep(new CEP(this.getCepSAC()));
        enderecoSac.setBairro(this.getBairroSAC());
        enderecoSac.setLogradouro(this.getEnderecoSAC());
        //enderecoSac.setNumero("");
        sacado.addEndereco(enderecoSac);

        /*
         * INFORMANDO DADOS SOBRE O SACADOR AVALISTA.
         */
        SacadorAvalista sacadorAvalista = new SacadorAvalista("JRimum Enterprise", "00.000.000/0001-91");

        // Informando o endereço do sacador avalista.
        //Endereco enderecoSacAval = new Endereco();
        //enderecoSacAval.setUF(UnidadeFederativa.DF);
        //enderecoSacAval.setLocalidade("Brasília");
        //enderecoSacAval.setCep(new CEP("59000-000"));
        //enderecoSacAval.setBairro("Grande Centro");
        //enderecoSacAval.setLogradouro("Rua Eternamente Principal");
        //enderecoSacAval.setNumero("001");
        //sacadorAvalista.addEndereco(enderecoSacAval);

        /*
         * INFORMANDO OS DADOS SOBRE O TÍTULO.
         */
        
        // Informando dados sobre a conta bancária do título.
        ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_DO_BRASIL.create());
        contaBancaria.setNumeroDaConta(new NumeroDaConta(1234, "1"));
        contaBancaria.setCarteira(new Carteira(this.getCarteira()));
        contaBancaria.setAgencia(new Agencia(1234, "1"));
        
        Titulo titulo = new Titulo(contaBancaria, sacado, cedente, sacadorAvalista);
        titulo.setNumeroDoDocumento("123456");
        titulo.setNossoNumero("99345678912");
        titulo.setDigitoDoNossoNumero("5");
        titulo.setValor(BigDecimal.valueOf(19856.23));
        Date hoje = new Date();
        titulo.setDataDoDocumento(hoje);
        titulo.setDataDoVencimento(hoje);
        titulo.setTipoDeDocumento(TipoDeTitulo.DS_DUPLICATA_DE_SERVICO);
        titulo.setAceite(Aceite.A);
        titulo.setDesconto(BigDecimal.ZERO);
        titulo.setDeducao(BigDecimal.ZERO);
        titulo.setMora(BigDecimal.ZERO);
        titulo.setAcrecimo(BigDecimal.ZERO);
        titulo.setValorCobrado(BigDecimal.ZERO);

        /*
         * INFORMANDO OS DADOS SOBRE O BOLETO.
         */
        Boleto boleto = new Boleto(titulo);
        
        boleto.setLocalPagamento("QUALQUER BANCO ATÉ O VENCIMENTO. APÓS VENCIMENTO,"
        		+ " SOMENTE NO BB.");
        boleto.setInstrucaoAoSacado("Após o vencimento, cobrar JUROS definido pelo Banco (FACP)");
        boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
        boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
        boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
        boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
        boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
        boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
        boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
        boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

        /*
         * GERANDO O BOLETO BANCÁRIO.
         */
        // Instanciando um objeto "BoletoViewer", classe responsável pela
        // geração do boleto bancário.
        BoletoViewer boletoViewer = new BoletoViewer(boleto,ContasReceber.class.getClassLoader().getResource("boletoPDF/BoletoSJT.pdf"));

        // Gerando o arquivo. No caso o arquivo mencionado será salvo na mesma
        // pasta do projeto. Outros exemplos:
        // WINDOWS: boletoViewer.getAsPDF("C:/Temp/MeuBoleto.pdf");
        // LINUX: boletoViewer.getAsPDF("/home/temp/MeuBoleto.pdf");
        
        File arquivoPdf = boletoViewer.getPdfAsFile(NomeEmpresa+".pdf");
			
		Calendar cal = Calendar.getInstance();
		String mes = "INDEFINIDO",ano = "INDEFINIDO";
		ano = String.valueOf(cal.get(Calendar.YEAR));
		if((cal.get(Calendar.MONTH) + 1) == 1){ mes = "JANEIRO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 2){ mes = "FEVEREIRO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 3){ mes = "MARÇO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 4){ mes = "ABRIL"; }
		else if((cal.get(Calendar.MONTH) + 1) == 5){ mes = "MAIO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 6){ mes = "JUNHO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 7){ mes = "JULHO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 8){ mes = "AGOSTO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 9){ mes = "SETEMBRO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 10){ mes = "OUTUBRO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 11){ mes = "NOVEMBRO"; }
		else if((cal.get(Calendar.MONTH) + 1) == 12){ mes = "DEZEMBRO"; }
		File anoDiretorio = new File("Boletos/"+ano);
		File empDiretorio = new File("Boletos/"+ano+"/"+NumeroEmpresa);
		File mesDiretorio = new File("Boletos/"+ano+"/"+NumeroEmpresa+"/"+mes);
		if(!anoDiretorio.exists()){
			try {
				anoDiretorio.mkdir();
			} catch(SecurityException se){
		        //handle it
		     }
		}
		if(!empDiretorio.exists()){
			try {
				empDiretorio.mkdir();
			} catch(SecurityException se){
		        //handle it
		     }
		}
		if(!mesDiretorio.exists()){
			try {
				mesDiretorio.mkdir();
			} catch(SecurityException se){
		        //handle it
		     }
		}
		
		//for( int j = 0; j < 1; j++ ){
			File arqNovo = new File("Boletos/"+ano+"/"+NumeroEmpresa+"/"+mes+"/BOLETO_"+NomeEmpresa+"_"+mes+".pdf");
		
			if(arquivoPdf.renameTo(arqNovo)){
				//System.out.println("Rename succesful");
			}else{
				//System.out.println("Rename failed");
			}
		//}

        // Mostrando o boleto gerado na tela.
        // mostreBoletoNaTela(arquivoPdf);
	}
		catch (Exception e1){
			System.err.println(e1.getMessage());
		}

	}
}
