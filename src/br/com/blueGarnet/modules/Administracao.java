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
import java.awt.Dimension;
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
import java.util.Arrays;
import java.util.Calendar;
import java.util.EnumSet;
import java.util.List;

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
import javax.swing.table.DefaultTableModel;

import br.com.blueGarnet.enums.Ano;
import br.com.blueGarnet.enums.Mes;
import br.com.blueGarnet.enums.Percentuais;
import br.com.blueGarnet.others.FuncoesExtras;
import br.com.blueGarnet.system.Database;
import br.com.blueGarnet.users.NivelPermissao;

public class Administracao{
	static String queryLogin = "SELECT Usuario,Senha,Permissao FROM bg_informacoesLogin";
	static List<NivelPermissao> lstPermissao = Arrays.asList(NivelPermissao.values());

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
			btnAdicionar.setEnabled(false);
			j.add(btnAdicionar);
			
			JLabel lblExiste = new JLabel();
			lblExiste.setBounds(306, 34, 256, 25);
			j.add(lblExiste);
			
			novoUsuario.setColumns(10);
			novoUsuario.setBounds(30, 34, 256, 25);
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
			j.add(novoUsuario);
			
			
			// ----- Senha
			JLabel lblSenhaEmBranco = new JLabel();
			lblSenhaEmBranco.setBounds(306, 81, 256, 25);
			j.add(lblSenhaEmBranco);
			
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setBounds(30, 64, 92, 14);
			j.add(lblSenha);
			
			novaSenha.setBounds(30, 81, 256, 25);
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
			j.add(novaSenha);
			
			// ------ Tipo de Permissão
			JLabel lblTipoPermissao = new JLabel("Tipo de Permissão");
			lblTipoPermissao.setBounds(30, 111, 180, 14);
			j.add(lblTipoPermissao);
			JComboBox<String> tipoPermissao = new JComboBox<String>();
			lstPermissao.forEach((NivelPermissao np) -> tipoPermissao.addItem(np.getNomePermissao()));
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
				lstPermissao.forEach((NivelPermissao np) -> {
					if(tipoPermissao.getSelectedItem().toString() == np.getNomePermissao()){
						Database.updateDB(updateDB+" ('"+novoUsuario.getText()+"','"+senha+"',"+np.getNumPermissao()+")");
						JOptionPane.showMessageDialog(null, "Você criou o usuário com sucesso.");
					}
				});
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
	 */		
	public static JDesktopPane EditarUsuario(){
		JDesktopPane j = new JDesktopPane();		
		JLabel lblUsuario = new JLabel("Usuário:");
		JButton btnSalvar = new JButton("Salvar");
		JButton btnExcluir = new JButton("Excluir");
		JTextField novoUsuario = new JTextField();
		JPasswordField novaSenha = new JPasswordField();
		JLabel lblExiste = new JLabel();
		JLabel lblSenhaEmBranco = new JLabel();
		JLabel lblSenha = new JLabel("Senha:");
		JLabel lblTipoPermissao = new JLabel("Tipo de Permissão");
		JComboBox<String> tipoPermissao = new JComboBox<String>();
		JLabel lblSelUsuario = new JLabel("Selecione o Usuário:");
		JComboBox<String> selUsuario = new JComboBox<String>();
		
		try{
			j.setBackground(new Color(236, 240, 241));
			
			// Litagem de Usuários
			lblSelUsuario.setBounds(30, 17, 204, 14);
			j.add(lblSelUsuario);
			selUsuario.setBounds(30, 34, 256, 25);
			ResultSet r = Database.consultaDB(queryLogin, false);
			try{
				while(r.next()){
					selUsuario.addItem(r.getString("Usuario"));
				}
			}
			catch (Exception e1){}
			selUsuario.addActionListener((event) -> {
				try{
					String infos = queryLogin+" WHERE Usuario='"+selUsuario.getSelectedItem().toString()+"'";
					ResultSet rs = Database.consultaDB(infos, false);
					rs.next();
					if(rs.getString("Usuario").equalsIgnoreCase(selUsuario.getSelectedItem().toString())){
						novoUsuario.setText(rs.getString("Usuario"));
						novaSenha.setText(rs.getString("Senha"));
					}
				}
				catch (Exception e1){}
			});
			j.add(selUsuario);
			
			// ----- Usuário	
			lblUsuario.setBounds(lblSelUsuario.getX(), lblSelUsuario.getY()+60, 52, 14);
			j.add(lblUsuario);
			
			novoUsuario.setColumns(10);
			novoUsuario.setBounds(lblUsuario.getX(), lblUsuario.getY()+20, 256, 25);
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
						  btnSalvar.setEnabled(false);
						  
					} else {
					  try {
						// Verifica se existe próxima linha
						rs.next();
						// -- Se possui linha, logo usuário é inválido
						if(rs.getString("Usuario").equalsIgnoreCase(novoUsuario.getText())){
						// -- Usuário já cadastrado OU campo em branco
						lblExiste.setText("Usuário inválido");
						lblExiste.setIcon(FuncoesExtras.buscarIcone("img/cancel.png"));
						btnSalvar.setEnabled(false);
						
						}
					  }
					  catch (Exception e1){
						  	// -- Não possui linha, logo usuário é válido
						  	lblExiste.setText("Usuário válido");
					  		lblExiste.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
					  		btnSalvar.setEnabled(true);
					  		
					  }
					}
				}
				@Override
				public void keyTyped(KeyEvent arg0) {}
			});
			j.add(novoUsuario);
			
			
			// ----- Senha
			
			lblSenha.setBounds(lblUsuario.getX(), lblUsuario.getY()+60, 92, 14);
			j.add(lblSenha);
			
			novaSenha.setBounds(lblSenha.getX(), lblSenha.getY()+20, 256, 25);
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
						btnSalvar.setEnabled(false);
						
					} else {
						lblSenhaEmBranco.setText("");
						lblSenhaEmBranco.setIcon(FuncoesExtras.buscarIcone("img/accept.png"));
						btnSalvar.setEnabled(true);
						
					}
				}
				@Override
				public void keyTyped(KeyEvent arg0) {}
			});
			j.add(novaSenha);
			
			lblSenhaEmBranco.setBounds(novaSenha.getX()+270, novaSenha.getY(), 256, 25);
			j.add(lblSenhaEmBranco);
			
			// ------ Tipo de Permissão
			lblTipoPermissao.setBounds(lblSenha.getX(), lblSenha.getY()+60, 180, 14);
			j.add(lblTipoPermissao);
			lstPermissao.forEach((NivelPermissao np) -> tipoPermissao.addItem(np.getNomePermissao()));
			tipoPermissao.setBounds(lblTipoPermissao.getX(), lblTipoPermissao.getY()+20, 140, 25);
			tipoPermissao.setToolTipText("Selecione o tipo de Permissão");
			j.add(tipoPermissao);
			
			// Salvar
			btnExcluir.setBounds(lblTipoPermissao.getX(), lblTipoPermissao.getY()+60, 90, 35);
			btnExcluir.addActionListener((event) -> {
				Database.updateDB("DELETE FROM bg_informacoesLogin WHERE Usuario='"+selUsuario.getSelectedItem().toString()+"'");
				JOptionPane.showMessageDialog(null, "Você excluiu o usuário com sucesso.");
			});
			j.add(btnExcluir);
			
			// Salvar
			btnSalvar.setBounds(btnExcluir.getX()+120, btnExcluir.getY(), 90, 35);
			btnSalvar.setEnabled(false);
			btnSalvar.addActionListener((event) -> {
				String updateDB = "UPDATE bg_informacoesLogin";
					String senha = new String(novaSenha.getPassword());
					lstPermissao.forEach((NivelPermissao np) -> {
						if(tipoPermissao.getSelectedItem().toString() == np.getNomePermissao()){
							Database.updateDB(updateDB+" SET Usuario='"+novoUsuario.getText()+"', Senha='"+senha+"', Permissao="+np.getNumPermissao()+" WHERE Usuario='"+selUsuario.getSelectedItem().toString()+"'");
							JOptionPane.showMessageDialog(null, "Você editou o usuário com sucesso.");
						}
					});
				});
			j.add(btnSalvar);
			}
			catch (Exception e1){
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			}
			return j;
	}
	
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
			mes.forEach((Mes m) -> {
				selMes.addItem(m.getNomeMes());
				if(numeroMes == m.getNumeroMes()){
					selMes.setSelectedItem(m.getNomeMes());
				}
			});
			selMes.setBounds(290, 20, 90, 20);
			j.add(selMes);
			
			//ComboBox Ano
			ArrayList<Ano> ano = new ArrayList<Ano>(EnumSet.allOf(Ano.class));
			JComboBox<Integer> selAno= new JComboBox<Integer>();
			int numeroAno = Calendar.getInstance().get(Calendar.YEAR);
			ano.forEach((Ano a) -> {
				selAno.addItem(a.getAno());
				if(numeroAno == a.getAno()){
					selAno.setSelectedItem(a.getAno());
				}
			});
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
	 *  Ajuste de Percentuais
	 */
	public static JDesktopPane AjustePercentuais(){
		List<Percentuais> lstPercentuais = Arrays.asList(Percentuais.values());
		JDesktopPane j = new JDesktopPane();
			DefaultTableModel efDTM = new DefaultTableModel();
			lstPercentuais.forEach((Percentuais p) -> {
				
			});
			JTable efTable = new JTable(efDTM);
			JScrollPane escritaFiscal = new JScrollPane(efTable);
			escritaFiscal.setSize(new Dimension(500,500));
			j.add(escritaFiscal);
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
