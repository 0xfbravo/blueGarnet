package br.com.fpimentel.funcextra;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.blueGarnet.enums.OrganizacaoDigital;
import br.com.blueGarnet.graphics.JanelaPrincipal;
import br.com.blueGarnet.others.FileDrop;
import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Database;

public class Digitalizacao {

	public Digitalizacao(){
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
			JFrame JIF = JanelaPrincipal.createFrame("Renomear Digitalizações",390,560);
			JDesktopPane PainelInternoJIF = new JDesktopPane();
			JIF.getContentPane().add(PainelInternoJIF, BorderLayout.CENTER);
			JIF.setIconImage(FuncoesExtras.buscarIcone("img/doc_convert.png").getImage());
			
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

		     new FileDrop(text, new FileDrop.Listener(){
		       public void filesDropped(File[] files){
		    	   for(File arquivoLido : files){
		    		   try{
		    			   text.append(":: "+arquivoLido.getName()+" | Caminho: "+arquivoLido.getCanonicalPath()+ "\n");
		    			   numArquivos.setText(String.valueOf(files.length));
		    			   File arqVelho = new File(arquivoLido.getCanonicalPath());
		    			   btnRenomear.addActionListener(new ActionListener(){
		              			public void actionPerformed(ActionEvent e){
		              				String codEmpresa = new String();
		              				ResultSet rs;
		   						try {
		   							rs = s.executeQuery(query+" WHERE CdEmpresa='"+numEmpresa.getText()+"'");
		   	       				    if(rs.next()){ codEmpresa = rs.getString("CdEmpresa"); }
		   						}
		   						catch (SQLException e1) { e1.printStackTrace(); }
		   						
		          					String unidadeTxt = unidade.getSelectedItem().toString();
		          					String orgUnidadeTxt = orgUnidade.getSelectedItem().toString();
		          					String tipoDocTxt = tipoDoc.getSelectedItem().toString();

		          					if(nomeEmpresa.getText().equals("")){
		              					JOptionPane.showMessageDialog(null, "A empresa não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
		              				}
		          					else if(numEmpresa.getText().equals("")){
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
		         						try { empresaDiretorio.mkdir(); }
		          						catch(SecurityException se){}
		        					}
		         					if(!unidadeDiretorio.exists()){
		         						try { unidadeDiretorio.mkdir();}
		         						catch(SecurityException se){}
		          					}
		         					if(!orgUnidadeDiretorio.exists()){
		         						try { orgUnidadeDiretorio.mkdir();}
		          						catch(SecurityException se){}
		          					}
		          					if(!tipoDocDiretorio.exists()){
		         						try { tipoDocDiretorio.mkdir();}
		         						catch(SecurityException se){}
		         					}

	             					File arqNovo = new File(
	             							caminho+codEmpresa+" - "
	              							+nomeEmpresa.getText()+"/"
	              							+unidadeTxt+"/"
	              							+orgUnidadeTxt+"/"
	              							+tipoDocTxt+"/"
	              							+tipoDocTxt+"_"
	              							+nomeEmpresa.getText()+".pdf");
		             					
	             					if(!arqNovo.exists()){
	             						arqVelho.renameTo(arqNovo);
	             						JOptionPane.showMessageDialog(null, "Você renomeou todos os arquivos com Sucesso!");
	             					} else {
	             						JOptionPane.showMessageDialog(null,
	             								"<html>O <b>"+tipoDocTxt+"</b> da Empresa "+nomeEmpresa.getText()+" já existe!<br>"
	             								+ "<i>Renomear Digitalização não poderá continuar.","Erro",JOptionPane.ERROR_MESSAGE);
	             					}
	            				text.setText("Jogue os arquivos aqui!\n");
	            			}
	              		}
	              	});
	    		   }
	    		   catch( java.io.IOException e ) {}
	    	   }   // end for: through each dropped file
	       }
	     }); // end FileDrop.Listener
		     
		} catch(Exception e1){ System.err.println(e1.getMessage()); }
	}
}
