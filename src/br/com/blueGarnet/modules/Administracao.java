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

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.blueGarnet.enums.Ano;
import br.com.blueGarnet.enums.Mes;
import br.com.blueGarnet.enums.NivelPermissao;
import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Database;

public class Administracao{
	static String queryLogin = "SELECT Usuario,Permissao FROM bg_informacoesLogin";
	
	/*
	 * Gerar Importação para o Alterdata
	 */		
	public static JDesktopPane GerarImportacaoAlterdata(){
		JDesktopPane j = new JDesktopPane();
		j.setBackground(new Color(236, 240, 241));
		try{
			JCheckBox CT = new JCheckBox("Importar dados do Contábil");
			JCheckBox DP = new JCheckBox("Importar dados do Departamento Pessoal");
			JCheckBox EF = new JCheckBox("Importar dados da Escrita Fiscal");
					
			// ----- Botão Gerar
			JButton btnGerar = new JButton("Gerar");
			btnGerar.setBounds(290, 100, 73, 35);
			j.add(btnGerar);
			btnGerar.setEnabled(false);
			
			DP.setBounds(20,20,260,20);
			j.add(DP);
			DP.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(EF.isSelected() == false && CT.isSelected() == false && DP.isSelected() == false){
						btnGerar.setEnabled(false);
					} else {
						btnGerar.setEnabled(true);
					}
				}
			});
			
			CT.setBounds(20,50,190,20);
			j.add(CT);
			CT.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(EF.isSelected() == false && CT.isSelected() == false && DP.isSelected() == false){
						btnGerar.setEnabled(false);
					} else {
						btnGerar.setEnabled(true);
					}
				}
			});
			

			EF.setBounds(20,80,190,20);
			j.add(EF);
			EF.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(EF.isSelected() == false && CT.isSelected() == false && DP.isSelected() == false){
						btnGerar.setEnabled(false);
					} else {
						btnGerar.setEnabled(true);
					}
				}
			});
			
			//ComboBox Mês
			ArrayList<Mes> mes = new ArrayList<Mes>(EnumSet.allOf(Mes.class));
			JComboBox<String> selMes= new JComboBox<String>();
			int numeroMes = Calendar.getInstance().get(Calendar.MONTH) + 1;
			for(int i = 0; i < mes.size(); i++){
				selMes.addItem(mes.get(i).getNomeMes());
				if(numeroMes == mes.get(i).getNumeroMes()){
					selMes.setSelectedItem(mes.get(i).getNomeMes());
				}
			}
			selMes.setBounds(290, 20, 90, 20);
			j.add(selMes);
			
			//ComboBox Ano
			ArrayList<Ano> ano = new ArrayList<Ano>(EnumSet.allOf(Ano.class));
			JComboBox<Integer> selAno= new JComboBox<Integer>();
			int numeroAno = Calendar.getInstance().get(Calendar.YEAR);
			for(int i = 0; i < ano.size(); i++){
				selAno.addItem(ano.get(i).getAno());
				if(numeroAno == ano.get(i).getAno()){
					selAno.setSelectedItem(ano.get(i).getAno());
				}
			}
			selAno.setSelectedItem(numeroAno);
			selAno.setBounds(290, 60, 90, 20);
			j.add(selAno);
			
			btnGerar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int Mes = 0;
					for(int i = 0; i < mes.size(); i++){
						if(selMes.getSelectedItem().toString().equals(mes.get(i).getNomeMes())){
							Mes = mes.get(i).getNumeroMes();
						}
					}
					String MesFormatado = mes.toString();
					if(Mes < 10){
						MesFormatado = String.format("%02d", Mes);
					}
					try{
						File temp = File.createTempFile("temp-file-name", ".tmp");
						//System.out.println(temp.getAbsolutePath());
						PrintWriter bw = new PrintWriter(temp,"UTF-8");
					ResultSet rs = Database.consultaDB("SELECT NR_MES, ID_EMPRESA, NR_ANO,"
							+ " NR_FUNC_ATIVO, NR_LANCAMENTOS_CONTABEIS, NR_LANCAMENTOS_FISCAIS"
							+ " FROM PACKCRM.HistoricoMensal WHERE NR_ANO='"+selAno.getSelectedItem()+"' AND NR_MES='"+Mes+"'"
							+ " ORDER BY ID_EMPRESA",true);
					
					// CT & DP & EF
					if(EF.isSelected() == true && CT.isSelected() == true && DP.isSelected() == true){
						while(rs.next()){
							bw.println(rs.getInt("NR_MES")+"\t"+rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_FUNC_ATIVO")+"\t"+rs.getInt("NR_LANCAMENTOS_CONTABEIS")
									+"\t"+rs.getInt("NR_LANCAMENTOS_FISCAIS"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
					// CT & DP
					else if(EF.isSelected() == false && CT.isSelected() == true && DP.isSelected() == true){
						while(rs.next()){
							System.out.println(rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_MES")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_FUNC_ATIVO")+"\t"+rs.getInt("NR_LANCAMENTOS_CONTABEIS"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
					// DP
					else if(EF.isSelected() == false && CT.isSelected() == false && DP.isSelected() == true){
						while(rs.next()){
							System.out.println(rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_MES")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_FUNC_ATIVO"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
					// CT
					else if(EF.isSelected() == false && CT.isSelected() == true && DP.isSelected() == false){
						while(rs.next()){
							System.out.println(rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_MES")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_LANCAMENTOS_CONTABEIS"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
					// Fiscal & CT
					else if(EF.isSelected() == true && CT.isSelected() == true && DP.isSelected() == false){
						while(rs.next()){
							System.out.println(rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_MES")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_LANCAMENTOS_CONTABEIS")
									+"\t"+rs.getInt("NR_LANCAMENTOS_FISCAIS"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
					// Fiscal
					else if(EF.isSelected() == true && CT.isSelected() == false && DP.isSelected() == false){
						while(rs.next()){
							System.out.println(rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_MES")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_LANCAMENTOS_FISCAIS"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
					// Fiscal & DP
					else if(EF.isSelected() == true && CT.isSelected() == false && DP.isSelected() == true){
						while(rs.next()){
							System.out.println(rs.getInt("ID_EMPRESA")+"\t"+rs.getInt("NR_MES")+"\t"+rs.getInt("NR_ANO")
									+"\t"+rs.getInt("NR_FUNC_ATIVO")
									+"\t"+rs.getInt("NR_LANCAMENTOS_FISCAIS"));
						}
						bw.close();
						temp.renameTo(new File("Alterdata-sjt-"+MesFormatado+"-"+selAno.getSelectedItem()+".txt"));
					}
				}
				catch (Exception e1){
					JOptionPane.showMessageDialog(null, e1, "Erro", JOptionPane.ERROR_MESSAGE);
				}
				}
			});
			
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return j;
	}

	/*
	 * Método de Edição de Usuários do SQL
	 * TODO: Finalizar Edição de Usuários
	 */		
	public static JScrollPane EditarUsuario(){
		try{
			JTable tabela = new JTable(FuncoesExtras.buildTableModel(Database.consultaDB(queryLogin,false),false));
			tabela.setEnabled(false);
			JScrollPane jsp = new JScrollPane(tabela);
			return jsp;
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	/*
	 * Método de Adição de E-mails p/ Empresas do SQL
	 */
	public static JDesktopPane AlteracaoDeEmail(){
		JDesktopPane j = new JDesktopPane();
		j.setBackground(new Color(236, 240, 241));
		try{
			// Conexão com SQL
			Connection conn = DriverManager.getConnection(Database.urlAlterdata,Database.userDBAlterdata,Database.passDBAlterdata);
			Statement s = conn.createStatement();
			String query = "select NmEmpresa,CdEmpresa from wphd.Empresa";
			
			JButton btnAdicionar = new JButton("Alterar");
			JButton btnEditarEmail1 = new JButton();
			JButton btnEditarEmail2 = new JButton();
			JButton btnEditarEmail3 = new JButton();

			// ----- Pesquisar Número
			JButton btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.setBounds(130, 40, 120, 25);
			btnPesquisar.setIcon(FuncoesExtras.buscarIcone("img/magnifier.png"));
			j.add(btnPesquisar);
			// ----- Número da Empresa
			JLabel lblNumeroE = new JLabel("Nº da Empresa:");
			lblNumeroE.setBounds(30, 20, 110, 14);
			j.add(lblNumeroE);	
			JTextField numEmpresa = new JTextField();
			numEmpresa.setColumns(10);
			numEmpresa.setBounds(30, 40, 90, 25);
			j.add(numEmpresa);
			numEmpresa.setName("Numero da Empresa");
			
			// ----- NOME da Empresa
			JTextField nomeEmpresa = new JTextField();
			nomeEmpresa.setColumns(10);
			nomeEmpresa.setBounds(30, 80, 300, 25);
			j.add(nomeEmpresa);
			nomeEmpresa.setName("Nome da Empresa");
			nomeEmpresa.setEnabled(false);
			
			// ----- email1
			JTextField email1 = new JTextField();
			email1.setColumns(10);
			email1.setBounds(30, 120, 200, 25);
			j.add(email1);
			email1.setText("E-mail 1");
			email1.setEnabled(false);
			
			JLabel lblExisteEmail1 = new JLabel();
			j.add(lblExisteEmail1);
			lblExisteEmail1.setBounds(240, 120, 256, 25);

			btnEditarEmail1.setBounds(260, 120, 25, 25);
			j.add(btnEditarEmail1);
			btnEditarEmail1.setVisible(false);
			btnEditarEmail1.setIcon(FuncoesExtras.buscarIcone("img/pencil.png"));
			btnEditarEmail1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					email1.setEnabled(true);
				}
			});
			
			// ----- email2
			JTextField email2 = new JTextField();
			email2.setColumns(10);
			email2.setBounds(30, 150, 200, 25);
			j.add(email2);
			email2.setText("E-mail 2");
			email2.setEnabled(false);
			
			JLabel lblExisteEmail2 = new JLabel();
			j.add(lblExisteEmail2);
			lblExisteEmail2.setBounds(240, 150, 256, 25);
			
			btnEditarEmail2.setBounds(260, 150, 25, 25);
			j.add(btnEditarEmail2);
			btnEditarEmail2.setVisible(false);
			btnEditarEmail2.setIcon(FuncoesExtras.buscarIcone("img/pencil.png"));
			btnEditarEmail2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					email2.setEnabled(true);
				}
			});
			
			
			// ----- email3
			JTextField email3 = new JTextField();
			email3.setColumns(10);
			email3.setBounds(30, 180, 200, 25);
			j.add(email3);
			email3.setText("E-mail 3");
			email3.setEnabled(false);
			
			JLabel lblExisteEmail3 = new JLabel();
			j.add(lblExisteEmail3);
			lblExisteEmail3.setBounds(240, 180, 256, 25);
			
			btnEditarEmail3.setBounds(260, 180, 25, 25);
			j.add(btnEditarEmail3);
			btnEditarEmail3.setVisible(false);
			btnEditarEmail3.setIcon(FuncoesExtras.buscarIcone("img/pencil.png"));
			btnEditarEmail3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					email3.setEnabled(true);
				}
			});

			// ----- Botão Adicionar/Alterar
			btnAdicionar.setBounds(390, 170, 73, 35);
			j.add(btnAdicionar);
			btnAdicionar.setEnabled(false);
			
			/* Botão Adicionar E-mails */
			btnAdicionar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						Database.updateDB("UPDATE bg_relacaoEmailCliente SET Email1='"+email1.getText()+"',Email2='"+email2.getText()+"',Email3='"+email3.getText()+"' WHERE NumEmpresa='"+numEmpresa.getText()+"'");
						JOptionPane.showMessageDialog(null, "Você alterou os e-mails com sucesso.");
					}
					catch (Exception e1){
						JOptionPane.showMessageDialog(null, "A empresa não existe", "Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			
			/* Botão de Pesquisar Empresa */
			btnPesquisar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						try{
							ResultSet rs = s.executeQuery(query+" WHERE CdEmpresa='"+numEmpresa.getText()+"'");
						    if(rs.next()){
						    	nomeEmpresa.setText(rs.getString("NmEmpresa"));
						    	ResultSet rs1 = Database.consultaDB("select * from bg_relacaoEmailCliente WHERE NumEmpresa='"+numEmpresa.getText()+"'",false);
						    	if(rs1.next()){
						    		if(rs1.getString("Email1").equals("")){
						    			lblExisteEmail1.setText("E-mail não cadastrado");
						    			lblExisteEmail1.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						    			email1.setEnabled(true);
						    			email1.setText(rs1.getString("Email1"));
						    			btnEditarEmail1.setVisible(false);
						    		} else {
						    			email1.setEnabled(false);
						    			email1.setText(rs1.getString("Email1"));
						    			lblExisteEmail1.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
						    			lblExisteEmail1.setText("");
						    			btnEditarEmail1.setVisible(true);
						    		}
						    		if(rs1.getString("Email2").equals("")){
						    			lblExisteEmail2.setText("E-mail não cadastrado");
						    			lblExisteEmail2.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						    			email2.setEnabled(true);
						    			email2.setText(rs1.getString("Email2"));
						    			btnEditarEmail2.setVisible(false);
						    		} else {
						    			email2.setEnabled(false);
						    			email2.setText(rs1.getString("Email2"));
						    			lblExisteEmail2.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
						    			lblExisteEmail2.setText("");
						    			btnEditarEmail2.setVisible(true);
						    		}
						    		if(rs1.getString("Email3").equals("")){
						    			lblExisteEmail3.setText("E-mail não cadastrado");
						    			lblExisteEmail3.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						    			email3.setEnabled(true);
						    			email3.setText(rs1.getString("Email3"));
						    			btnEditarEmail3.setVisible(false);
						    		} else {
						    			email3.setEnabled(false);
						    			email3.setText(rs1.getString("Email3"));
						    			lblExisteEmail3.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
						    			lblExisteEmail3.setText("");
						    			btnEditarEmail3.setVisible(true);
						    		}
						    		btnAdicionar.setEnabled(true);
						    		
						    	}
						    } else {
						    	nomeEmpresa.setText("");
						    	email1.setText("E-mail 1");
						    	email1.setEnabled(false);
						    	email2.setText("E-mail 2");
						    	email2.setEnabled(false);
						    	email3.setText("E-mail 3");
						    	email3.setEnabled(false);
						    	JOptionPane.showMessageDialog(null, "A empresa não existe", "Erro", JOptionPane.ERROR_MESSAGE);
						    }
						}
						catch (Exception e1){
							JOptionPane.showMessageDialog(null, "A empresa não existe", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return j;
	}
		
	/*
	 * Método de Criação de Usuários do SQL
	 */
	public static JDesktopPane CriarUsuario(){
		JDesktopPane j = new JDesktopPane();
		j.setBackground(new Color(236, 240, 241));
		try{
			// ----- Usuário
			JLabel lblUsuario = new JLabel("Usuário:");
			lblUsuario.setBounds(30, 17, 52, 14);
			j.add(lblUsuario);	
			JButton btnAdicionar = new JButton("Adicionar");
			JTextField novoUsuario = new JTextField();
			JPasswordField novaSenha = new JPasswordField();
			
			// ----- Botão Adicionar
			btnAdicionar.setBounds(198, 125, 90, 35);
			j.add(btnAdicionar);
			btnAdicionar.setEnabled(false);
			
			JLabel lblExiste = new JLabel();
			j.add(lblExiste);
			lblExiste.setBounds(306, 34, 256, 25);
			
			novoUsuario.setColumns(10);
			novoUsuario.setBounds(30, 34, 256, 25);
			j.add(novoUsuario);
			novoUsuario.setName("Usuário");
			novoUsuario.addKeyListener(new KeyListener(){
				@Override
				public void keyPressed(KeyEvent arg0) {}
				@Override
				public void keyReleased(KeyEvent arg0) {
					//System.out.println("Valor do texto atual: " +novoUsuario.getText());
					String verificarUsuario = queryLogin+" WHERE Usuario='"+novoUsuario.getText()+"'";
					//System.out.println(verificarUsuario);
					ResultSet rs = Database.consultaDB(verificarUsuario,false);
					if(novoUsuario.getText().equals("")){
						  lblExiste.setText("Usuário inválido");
						  lblExiste.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						  btnAdicionar.setEnabled(false);
						  
					} else {
					  try {
						// Verifica se existe próxima linha
						rs.next();
						// -- Se possui linha, logo usuário é inválido
						if(rs.getString("Usuario").equalsIgnoreCase(novoUsuario.getText())){
						// -- Usuário já cadastrado OU campo em branco
						lblExiste.setText("Usuário inválido");
						lblExiste.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						btnAdicionar.setEnabled(false);
						
						}
					  }
					  catch (Exception e1){
						  	// -- Não possui linha, logo usuário é válido
						  	lblExiste.setText("Usuário válido");
					  		lblExiste.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
					  		btnAdicionar.setEnabled(true);
					  		
					  }
					}
				}
				@Override
				public void keyTyped(KeyEvent arg0) {}
			});
			// ----- Senha
			JLabel lblSenhaEmBranco = new JLabel();
			j.add(lblSenhaEmBranco);
			lblSenhaEmBranco.setBounds(306, 81, 256, 25);
			
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setBounds(30, 64, 92, 14);
			j.add(lblSenha);
			novaSenha.setBounds(30, 81, 256, 25);
			j.add(novaSenha);
			novaSenha.setName("Senha");
			novaSenha.addKeyListener(new KeyListener(){
				@Override
				public void keyPressed(KeyEvent arg0) {}
				@Override
				public void keyReleased(KeyEvent arg0) {
					String senha = new String(novaSenha.getPassword());
					if(senha.equals("")){
						lblSenhaEmBranco.setText("Senha inválida");
						lblSenhaEmBranco.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						btnAdicionar.setEnabled(false);
						
					} else {
						lblSenhaEmBranco.setText("");
						lblSenhaEmBranco.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
						btnAdicionar.setEnabled(true);
						
					}
				}
				@Override
				public void keyTyped(KeyEvent arg0) {}
			});
			
			// ------ Tipo de Permissão
			JLabel lblTipoPermissao = new JLabel("Tipo de Permissão");
			lblTipoPermissao.setBounds(30, 111, 180, 14);
			j.add(lblTipoPermissao);
			JComboBox<String> tipoPermissao = new JComboBox<String>();
			tipoPermissao.addItem(NivelPermissao.Dev.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Adm.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Financeiro.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Fiscal.getNomePermissao());
			tipoPermissao.addItem(NivelPermissao.Contabil.getNomePermissao());
			tipoPermissao.setBounds(30, 131, 140, 25);
			tipoPermissao.setToolTipText("Selecione o tipo de Permissão");
			j.add(tipoPermissao);
			
		/*
		 *  Ação ao clicar no botão de Adicionar Usuário
		 */
		btnAdicionar.addActionListener(new ActionListener(){
			String updateDB = "INSERT INTO bg_informacoesLogin(Usuario,Senha,Permissao) VALUES";
			public void actionPerformed(ActionEvent e){
				String senha = new String(novaSenha.getPassword());
				// -----
				//  Criação dos Usuário c/ suas
				//     devidas Permissões
				// -----
				// Desenvolvedor
				if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Dev.getNomePermissao()){
					Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Dev.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
				}
				// Administrador
				if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Adm.getNomePermissao()){
					Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Adm.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
				}
				// Financeiro
				if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Financeiro.getNomePermissao()){
					Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Financeiro.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
				}
				// Fiscal
				if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Fiscal.getNomePermissao()){
					Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Fiscal.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
				}
				// Contábil
				if(tipoPermissao.getSelectedItem().toString() == NivelPermissao.Contabil.getNomePermissao()){
					Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+NivelPermissao.Contabil.getNumPermissao()+")");
					JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
				}
			}
		});
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return j;
	}
	
	/*
	 * Método de Listar EMPRESAS do SQL
	 *    buscando informações do DB da ALTERDATA
	 */	
	public static JScrollPane ListarEmpresas(){
		try{		    
		    JTable tabela = new JTable(FuncoesExtras.buildTableModel(
		    		Database.consultaDB("select CdEmpresa,NmEmpresa from wphd.Empresa order by CdEmpresa ASC",true),false));
		    tabela.setEnabled(false);
		    tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Código");
		    tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
		    tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nome");
		    return new JScrollPane(tabela);
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	/*
	 * Método de Listar Usuários do SQL
	 */	
	public static JScrollPane ListarUsuarios(){
		try{
		    JTable tabela = new JTable(FuncoesExtras.buildTableModel(Database.consultaDB(queryLogin+" order by Permissao ASC",false),true));
		    tabela.setEnabled(false);
		    tabela.getTableHeader().getColumnModel().getColumn(0).setHeaderValue("Usuário");
		    tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(200);
		    tabela.getTableHeader().getColumnModel().getColumn(1).setHeaderValue("Nível de Permissão");
		    return new JScrollPane(tabela);
		}
		catch (Exception e1){
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

}
