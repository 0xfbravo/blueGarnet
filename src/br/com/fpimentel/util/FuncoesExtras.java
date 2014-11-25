package br.com.fpimentel.util;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Properties;
import java.util.Vector;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.fpimentel.Database;
import br.com.fpimentel.enums.NivelPermissao;
import br.com.fpimentel.enums.OrganizacaoDigital;
import br.com.fpimentel.graf.JanelaPrincipal;
import br.com.fpimentel.graf.Menu;

public class FuncoesExtras{
	/*
	 * Método para criação da Tabelas com SQL
	 */	
	public static DefaultTableModel buildTableModel(ResultSet rs,boolean contemPermissao)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	        		vector.add(rs.getObject(columnIndex));
	            	if(contemPermissao == true){
	            		// -- DEBUG
	            		//System.out.println("Coluna recebendo:"+rs.getInt("Permissao"));
	            		if(rs.getInt("Permissao") == NivelPermissao.Adm.getNumPermissao()){
	            			vector.add(NivelPermissao.Adm.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Financeiro.getNumPermissao()){
	            			vector.add(NivelPermissao.Financeiro.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Fiscal.getNumPermissao()){
	            			vector.add(NivelPermissao.Fiscal.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Contabil.getNumPermissao()){
	            			vector.add(NivelPermissao.Contabil.getNomePermissao());
	            		}
	            		if(rs.getInt("Permissao") == NivelPermissao.Dev.getNumPermissao()){
	            			vector.add(NivelPermissao.Dev.getNomePermissao());
	            		}
	            	}
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}

	/*
	 * Método para formatação de CNPJ, CPF e etc
	 * 		utilizando Máscaras
	 */
	public static String format(String pattern, Object value) {
        MaskFormatter mask;
        try {
            mask = new MaskFormatter(pattern);
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(value);
        } catch (ParseException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            throw new RuntimeException(e);
        }
    }
	/* Buscar Ícones dentro do Projeto */
	public static ImageIcon buscarIcone(String caminho){
		ImageIcon a = new ImageIcon(FuncoesExtras.class.getClassLoader().getResource(caminho));
		return a;
	}

	/* Gerar Relatórios de Documentos Expedição */
	public static void RelatoriosExpedicao(){
		try{
			String documentosExped = "INSERT INTO";
		} catch(Exception e1){
			System.err.println(e1.getMessage());
		}
		
	}
	/* Renomerar Arquivos Digitalizados */
	public static void Digitalizacao(){
		try{
		// Conexão com SQL
		Connection conn = DriverManager.getConnection(Database.urlAlterdata,Database.userDBAlterdata,Database.passDBAlterdata);
		Statement s = conn.createStatement();
		String query = "select NmEmpresa,CdEmpresa from wphd.Empresa";
		// Necessário a criação da pasta
		// 		e modificação do caminho no arquivo
		String caminho = "Y:/CLIENTES/";
		// -----
		
		/*
		 * Método de Renomear Arquivos Digitalizados
		 */	
		OrganizacaoDigital organizacao = new OrganizacaoDigital();
		JInternalFrame JIF = JanelaPrincipal.createFrame("Renomear Arquivos Digitalizados",390,560);
		JanelaPrincipal.PainelInterno.add(JIF);
		JDesktopPane PainelInternoJIF = new JDesktopPane();
		JIF.getContentPane().add(PainelInternoJIF, BorderLayout.CENTER);
		JIF.setFrameIcon(new ImageIcon(Menu.class.getClassLoader().getResource("img/doc_convert.png")));
		
		JComboBox<String> unidade = new JComboBox<String>();
		JComboBox<String> orgUnidade = new JComboBox<String>();
		JComboBox<String> tipoDoc = new JComboBox<String>();

		// ----- Pesquisar Número
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(130, 104, 120, 25);
		btnPesquisar.setIcon(FuncoesExtras.buscarIcone("img/magnifier.png"));
		PainelInternoJIF.add(btnPesquisar);
		
		// ----- Renomear Arquivo
		JButton btnRenomear = new JButton("Renomear");
		btnRenomear.setBounds(400, 315, 130, 25);
		PainelInternoJIF.add(btnRenomear);
		btnRenomear.setIcon(FuncoesExtras.buscarIcone("img/doc_convert.png"));
		btnRenomear.setEnabled(false);
		// ----- Número da Empresa
		JLabel lblNumeroE = new JLabel("Nº da Empresa:");
		lblNumeroE.setBounds(30, 87, 110, 14);
		PainelInternoJIF.add(lblNumeroE);	
		JTextField numEmpresa = new JTextField();
		numEmpresa.setColumns(10);
		numEmpresa.setBounds(30, 104, 90, 25);
		PainelInternoJIF.add(numEmpresa);
		numEmpresa.setName("Numero da Empresa");
		
		JLabel lblNumeroA = new JLabel("Total de Arquivos:");
		lblNumeroA.setBounds(450, 87, 110, 14);
		PainelInternoJIF.add(lblNumeroA);
		JTextField numArquivos = new JTextField();
		numArquivos.setColumns(10);
		numArquivos.setBounds(480, 104, 60, 25);
		PainelInternoJIF.add(numArquivos);
		numArquivos.setName("Numero de Arquivos");
		numArquivos.setEnabled(false);
		
		// ----- NOME da Empresa
		JTextField nomeEmpresa = new JTextField();
		nomeEmpresa.setColumns(10);
		nomeEmpresa.setBounds(30, 134, 300, 25);
		PainelInternoJIF.add(nomeEmpresa);
		nomeEmpresa.setName("Nome da Empresa");
		nomeEmpresa.setEnabled(false);

		// ------ Selecionar Tipo de Documento
		JLabel lblTipoDoc = new JLabel("Tipo de Documento");
		lblTipoDoc.setBounds(30, 290, 190, 25);
		lblTipoDoc.setIcon(FuncoesExtras.buscarIcone("img/page_white_text.png"));
		PainelInternoJIF.add(lblTipoDoc);
		tipoDoc.setBounds(30, 315, 320, 25);
		tipoDoc.setToolTipText("Selecione o Tipo de Documento");
		PainelInternoJIF.add(tipoDoc);
		tipoDoc.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	btnRenomear.setEnabled(true);
		        JIF.repaint();
		    }
		});
		tipoDoc.setEnabled(false);
		// ------ Selecionar Organização da Unidade
		JLabel lblOrgUnidade = new JLabel("Organização da Unidade");
		lblOrgUnidade.setBounds(30, 235, 190, 25);
		lblOrgUnidade.setIcon(FuncoesExtras.buscarIcone("img/inbox.png"));
		PainelInternoJIF.add(lblOrgUnidade);
		orgUnidade.setBounds(30, 260, 190, 25);
		orgUnidade.setToolTipText("Selecione a Organização da Unidade");
		PainelInternoJIF.add(orgUnidade);
		orgUnidade.setEnabled(false);
		orgUnidade.addActionListener (new ActionListener () {
			public void actionPerformed(ActionEvent e) {
		    	tipoDoc.removeAllItems();
		    	tipoDoc.setEnabled(true);
		    	/* Qual Opção de Organização está selecionada? */
		    	switch(orgUnidade.getSelectedIndex()){
		    		/* Primeira */
		    		case 0:
		    			/* Mas, qual é a Unidade Selecionada? */
		    			switch(unidade.getSelectedIndex()){
		    				case 0: /* Societário - Contrato */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socContrato.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socContrato.get(k).getNomeCompleto());
    							}
		    					break;
		    				case 1: /*Financeiro - Cobrança */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoFIN.get(orgUnidade.getSelectedIndex()).finCobrancas.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoFIN.get(orgUnidade.getSelectedIndex()).finCobrancas.get(k).getNomeCompleto());
    							}
    					break;	
		    			}
		    		break;
		    		/* Segunda */
		    		case 1:
		    			/* Mas, qual é a Unidade Selecionada? */
		    			switch(unidade.getSelectedIndex()){
		    				case 0: /* Societário - Federal */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socFederal.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socFederal.get(k).getNomeCompleto());
    							}
		    					break;
		    				case 1: /*Financeiro - Pendência */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoFIN.get(orgUnidade.getSelectedIndex()).finPendencias.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoFIN.get(orgUnidade.getSelectedIndex()).finPendencias.get(k).getNomeCompleto());
		    					}
		    					break;	
		    			}
		    		break;
		    		/* Terceira */
		    		case 2:
		    			/* Mas, qual é a Unidade Selecionada? */
		    			switch(unidade.getSelectedIndex()){
		    				case 0: /* Societário - Estadual */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socEstadual.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socEstadual.get(k).getNomeCompleto());
    							}
		    					break;
		    			}
		    		break;
		    		/* Quarta */
		    		case 3:
		    			/* Mas, qual é a Unidade Selecionada? */
		    			switch(unidade.getSelectedIndex()){
		    				case 0: /* Societário - Municipal */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socMunicipal.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socMunicipal.get(k).getNomeCompleto());
    							}
		    					break;	
		    			}
		    		break;
		    		/* Quinta */
		    		case 4:
		    			/* Mas, qual é a Unidade Selecionada? */
		    			switch(unidade.getSelectedIndex()){
		    				case 0: /* Societário - Outros */
		    					for(int k=0;
		    							k < organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socOutros.size();
		    							k++){
    								tipoDoc.addItem(organizacao.unidade.get(unidade.getSelectedIndex()).organizacaoSOC.get(orgUnidade.getSelectedIndex()).socOutros.get(k).getNomeCompleto());
    							}
		    					break;
		    			}
		    		break;
		    			
		    	}
		    	JIF.repaint();
		    }
		});
		// ------ Selecionar Unidade
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(30, 180, 90, 25);
		lblUnidade.setIcon(FuncoesExtras.buscarIcone("img/box.png"));
		PainelInternoJIF.add(lblUnidade);
		for(int i= 0; i < organizacao.unidade.size(); i++){
			switch(organizacao.unidade.get(i).getID()){
				case 0:
					unidade.addItem(organizacao.unidade.get(i).getNome());
				break;
				case 1:
					unidade.addItem(organizacao.unidade.get(i).getNome());
				break;
			}
		}
		unidade.setBounds(30, 205, 190, 25);
		unidade.setToolTipText("Selecione a Unidade");
		PainelInternoJIF.add(unidade);
		unidade.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	orgUnidade.removeAllItems();
		    	orgUnidade.setEnabled(true);
				switch(unidade.getSelectedIndex()){
				/* Societário */
				case 0:
					for(int i= 0; i < organizacao.unidade.get(0).organizacaoSOC.size(); i++){
						switch(organizacao.unidade.get(0).organizacaoSOC.get(i).getID()){
						default:
							orgUnidade.addItem(organizacao.unidade.get(0).organizacaoSOC.get(i).getNome());
							break;
						}
					}
				break;
				/* Financeiro */
				case 1:
					for(int i= 0; i < organizacao.unidade.get(1).organizacaoFIN.size(); i++){
						switch(organizacao.unidade.get(1).organizacaoFIN.get(i).getID()){
						default:
							orgUnidade.addItem(organizacao.unidade.get(1).organizacaoFIN.get(i).getNome());
							break;
						}
					}
				break;
			}
		        JIF.repaint();
		    }
		});
		/* Botão de Pesquisar Empresa */
		btnPesquisar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						ResultSet rs = s.executeQuery(query+" WHERE CdEmpresa='"+numEmpresa.getText()+"'");
					    if(rs.next()){
					    	nomeEmpresa.setText(rs.getString("NmEmpresa"));
					    } else {
					    	nomeEmpresa.setText("");
					    	JOptionPane.showMessageDialog(null, "A empresa não existe", "Erro", JOptionPane.ERROR_MESSAGE);
					    }
					}
					catch (Exception e1){
						JOptionPane.showMessageDialog(null, "A empresa não existe", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		
		/* Campo para Adicionar Arquivos */
		 final JTextArea text = new JTextArea();
		 JScrollPane text2 = new JScrollPane(text);
		 text2.setSize(JIF.getWidth(), 80);
		 text.setText("Jogue os arquivos aqui!\n");
		 text.setEnabled(false);			
	     PainelInternoJIF.add(text2);
	       new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
	        {   public void filesDropped( java.io.File[] files )
	            {   for( int i = 0; i < files.length; i++ )
	                {   try
	                    {   text.append( files[i].getCanonicalPath()+ "\n");
	                    	numArquivos.setText(String.valueOf(files.length));
	                    	File arqVelho = new File(files[i].getCanonicalPath());
	                    	
	            		    btnRenomear.addActionListener(new ActionListener(){
	            				public void actionPerformed(ActionEvent e){
	            					String codEmpresa = null;
	            					ResultSet rs;
									try {
										rs = s.executeQuery(query+" WHERE CdEmpresa='"+numEmpresa.getText()+"'");
		        					    if(rs.next()){
		        					    	codEmpresa = rs.getString("CdEmpresa");
		        					    }
									} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
            						String unidadeTxt = unidade.getSelectedItem().toString();
            						String orgUnidadeTxt = orgUnidade.getSelectedItem().toString();
            						String tipoDocTxt = tipoDoc.getSelectedItem().toString();
            						//DEBUG
            						//System.out.println(caminho+numEmpresa.getText()+" - "+nomeEmpresa.getText()+"/"+unidadeTxt+"/"+orgUnidadeTxt+"/"+tipoDocTxt+"/"+tipoDocTxt+".pdf");
            						if(nomeEmpresa.getText().equals("")){
	            						JOptionPane.showMessageDialog(null, "A empresa não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
	            					}
	            					if(numEmpresa.getText().equals("")){
	            						JOptionPane.showMessageDialog(null, "O número da empresa não pode "
	            								+ "estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
	            					} else {
	            					// Y:/EMPRESAS/NumeroDaEmpresa
	            					File empresaDiretorio = new File(caminho+codEmpresa+" - "+nomeEmpresa.getText());
	            					// Y:/EMPRESAS/NumeroDaEmpresa/Unidade
	            					File unidadeDiretorio = new File(caminho+codEmpresa+" - "+nomeEmpresa.getText()+"/"+unidadeTxt);
	            					// Y:/EMPRESAS/NumeroDaEmpresa/Unidade/orgUnidade
	            					File orgUnidadeDiretorio = new File(caminho+codEmpresa+" - "+nomeEmpresa.getText()+"/"+unidadeTxt+"/"+orgUnidadeTxt);
	            					// Y:/EMPRESAS/NumeroDaEmpresa/Unidade/orgUnidade/tipoDoc
	            					File tipoDocDiretorio = new File(caminho+codEmpresa+" - "+nomeEmpresa.getText()+"/"+unidadeTxt+"/"+orgUnidadeTxt+"/"+tipoDocTxt);
	            					
	            					if(!empresaDiretorio.exists()){
	            						try {
	            							empresaDiretorio.mkdir();
	            						} catch(SecurityException se){
	            					        //handle it
	            					     }
	            					}
	            					if(!unidadeDiretorio.exists()){
	            						try {
	            							unidadeDiretorio.mkdir();
	            						} catch(SecurityException se){
			            					        //handle it
	            					     }
	            					}
	            					if(!orgUnidadeDiretorio.exists()){
	            						try {
	            							orgUnidadeDiretorio.mkdir();
	            						} catch(SecurityException se){
	            					        //handle it
	            					     }
	            					}
	            					if(!tipoDocDiretorio.exists()){
	            						try {
	            							tipoDocDiretorio.mkdir();
	            						} catch(SecurityException se){
	            					        //handle it
	            					     }
	            					}
           					
	            					for( int j = 0; j < files.length; j++ ){
	            						File arqNovo = new File(caminho+codEmpresa+" - "+nomeEmpresa.getText()+"/"+unidadeTxt+"/"+orgUnidadeTxt+"/"+tipoDocTxt+"/"+tipoDocTxt+"_"+nomeEmpresa.getText()+"_"+j+".pdf");
	            					
	            						if(arqVelho.renameTo(arqNovo)){
	            							//System.out.println("Rename succesful");
	            						}else{
	            							//System.out.println("Rename failed");
	            						}
	            					}
	            				}
	            				}
	            			});
	                    }   // end try
	                    catch( java.io.IOException e ) {}
	                }   // end for: through each dropped file
	            }
   		}); // end FileDrop.Listener 
	    btnRenomear.addActionListener(new ActionListener(){
  				public void actionPerformed(ActionEvent e){
	        	JOptionPane.showMessageDialog(null, "Você renomeou todos os arquivos com Sucesso!");// end filesDropped
  			}
	    });
		} catch(Exception e1){
			System.err.println(e1.getMessage());
		}
	}
	
	/*
	 * Método de Renomear Boletos
	 */	
	public static void RenomearBoletos(){
			// Necessário a criação da pasta
			// 		e modificação do caminho no arquivo
			String caminho = "N:/Boletos/";
			// -----
		 	final String fromEmail = "informatica@saojudastadeu.cnt.br"; // e-mail válido
	        final String password = "S40Jud@s#T4D3u!T1!1"; // senha do e-mail
	         
	        System.out.println("SSLEmail Start");
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "servidor.icnex.com"); //SMTP Host
	        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
	        props.put("mail.smtp.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
	        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
	        props.put("mail.smtp.port", "465"); //SMTP Port
	         
	        Authenticator auth = new Authenticator() {
	            //override the getPasswordAuthentication method
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        };
	         
	        Session session = Session.getDefaultInstance(props, auth);
	        System.out.println("Session created");
		try{
			Connection conn = DriverManager.getConnection(Database.urlAlterdata,Database.userDBAlterdata,Database.passDBAlterdata);	    
			JInternalFrame JIF = JanelaPrincipal.createFrame("Renomear Boletos",240,500);
			JanelaPrincipal.PainelInterno.add(JIF);
			JDesktopPane PainelInternoJIF = new JDesktopPane();
			JIF.getContentPane().add(PainelInternoJIF, BorderLayout.CENTER);
			JIF.setFrameIcon(new ImageIcon(Menu.class.getClassLoader().getResource("img/page_white_stack.png")));

			// ----- Pesquisar Número
			JButton btnAdicionar = new JButton("Pesquisar");
			btnAdicionar.setBounds(130, 104, 90, 25);
			PainelInternoJIF.add(btnAdicionar);
			
			// ----- Renomear Arquivo
			JButton btnRenomear = new JButton("Renomear");
			btnRenomear.setBounds(380, 174, 90, 25);
			PainelInternoJIF.add(btnRenomear);
			// ----- Número da Empresa
			JLabel lblNumeroE = new JLabel("Nº da Empresa:");
			lblNumeroE.setBounds(30, 87, 110, 14);
			PainelInternoJIF.add(lblNumeroE);	
			JTextField numEmpresa = new JTextField();
			numEmpresa.setColumns(10);
			numEmpresa.setBounds(30, 104, 90, 25);
			PainelInternoJIF.add(numEmpresa);
			numEmpresa.setName("Numero da Empresa");
			
			JLabel lblNumeroA = new JLabel("Total de Arquivos:");
			lblNumeroA.setBounds(380, 87, 110, 14);
			PainelInternoJIF.add(lblNumeroA);
			JTextField numArquivos = new JTextField();
			numArquivos.setColumns(10);
			numArquivos.setBounds(420, 104, 60, 25);
			PainelInternoJIF.add(numArquivos);
			numArquivos.setName("Numero de Arquivos");
			numArquivos.setEnabled(false);
			
			// ----- NOME da Empresa
			JTextField nomeEmpresa = new JTextField();
			nomeEmpresa.setColumns(10);
			nomeEmpresa.setBounds(30, 134, 300, 25);
			PainelInternoJIF.add(nomeEmpresa);
			nomeEmpresa.setName("Nome da Empresa");
			nomeEmpresa.setEnabled(false);
			
			 final javax.swing.JTextArea text = new javax.swing.JTextArea();
			 JScrollPane text2 = new JScrollPane(text);
			 text2.setSize(JIF.getWidth(), 80);
			 text.setText("Jogue os Boletos aqui!\n");
			 text.setEnabled(false);

		     PainelInternoJIF.add(text2);
		       new FileDrop( System.out, text, /*dragBorder,*/ new FileDrop.Listener()
		        {   public void filesDropped( java.io.File[] files )
		            {   for( int i = 0; i < files.length; i++ )
		                {   try
		                    {   text.append( files[i].getCanonicalPath()+ "\n");
		                    	numArquivos.setText(String.valueOf(files.length));
		                    	File arqVelho = new File(files[i].getCanonicalPath());
		                    	
		            		    btnRenomear.addActionListener(new ActionListener(){
		            				public void actionPerformed(ActionEvent e){           					
		            					if(numEmpresa.getText().equals("")){
		            						JOptionPane.showMessageDialog(null, "O número da empresa não pode "
		            								+ "estar em branco", "Erro", JOptionPane.ERROR_MESSAGE);
		            					} else {
		            						
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
		            					File anoDiretorio = new File(caminho+ano);
		            					File empDiretorio = new File(caminho+ano+"/"+numEmpresa.getText());
		            					File mesDiretorio = new File(caminho+ano+"/"+numEmpresa.getText()+"/"+mes);
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
		            					
		            					for( int j = 0; j < files.length; j++ ){
		            						File arqNovo = new File(caminho+ano+"/"+numEmpresa.getText()+"/"+mes+"/BOLETO_"+nomeEmpresa.getText()+"_"+mes+"_"+j+".pdf");
		            						ResultSet rs = Database.consultaDB("select * from bg_relacaoEmailCliente WHERE NumEmpresa='"+numEmpresa.getText()+"'",false);		
											try {
											while(rs.next()){
												ResultSetMetaData rsMetaData = rs.getMetaData();
												rsMetaData = rs.getMetaData();
		            						if(arqVelho.renameTo(arqNovo)){
		            							for(int i = 0; i < rsMetaData.getColumnCount(); i++){
		            								if(i >= 1){
		            									if(rs.getString("Email"+i).equals("")){
			            									System.out.println("E-mail inválido. Não enviado.");
			            								} else {
		            									String emailCliente = rs.getString("Email"+i);
		            									EmailUtil.sendEmail(session, emailCliente,"[SJT] Boleto: "+nomeEmpresa.getText()+" Mês: "+mes,arqNovo);
			            								}
			            							}
		            							}
		            						}else{
		            							//System.out.println("Rename failed");
		            						}
											}
											} catch (SQLException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
		            					}
		            				}
		            				}
		            			});
		                    }   // end try
		                    catch( java.io.IOException e ) {}
		                }   // end for: through each dropped file
		            }
    		}); // end FileDrop.Listener 
		    btnRenomear.addActionListener(new ActionListener(){
   				public void actionPerformed(ActionEvent e){
		        	JOptionPane.showMessageDialog(null, "Você renomeou o boleto com sucesso e o mesmo já foi enviado para o e-mail cadastrado do Cliente!");// end filesDropped
   			}
		    });
		       
			btnAdicionar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						Statement s = conn.createStatement();
						ResultSet rs;
					    rs = s.executeQuery("select * from wphd.Empresa WHERE CdEmpresa='"+numEmpresa.getText()+"'");
					    while(rs.next()){
					    	nomeEmpresa.setText(rs.getString("NmEmpresa"));
					    }
					}
					catch (Exception e1){
						System.err.println(e1.getMessage());
					}
				}
			});
		    
		}
		catch (Exception e1){
			System.err.println(e1.getMessage());
		}
	}
}
