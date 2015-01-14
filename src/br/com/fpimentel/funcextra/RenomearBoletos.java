package br.com.fpimentel.funcextra;
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
import java.util.Calendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.com.blueGarnet.graphics.JanelaPrincipal;
import br.com.blueGarnet.others.EmailUtil;
import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Database;

public class RenomearBoletos {
	
/*
 * Módulo Desabilitado Temporariamente
 * 
 * 
	public RenomearBoletos(){
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
					JFrame JIF = JanelaPrincipal.createFrame("Renomear Boletos",240,500);
					JanelaPrincipal.PainelInterno.add(JIF);
					JDesktopPane PainelInternoJIF = new JDesktopPane();
					JIF.getContentPane().add(PainelInternoJIF, BorderLayout.CENTER);
					JIF.setIconImage(FuncoesExtras.buscarIcone("img/page_white_stack.png").getImage());

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
				       new FileDrop( System.out, text, new FileDrop.Listener()
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
				            						}
													}
													}
													catch (SQLException e1) { e1.printStackTrace(); }
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
	}*/

}
