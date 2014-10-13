package br.com.fpimentel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/
public class Database implements Runnable{
	Thread processo;
	String nomeProcesso;
	
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	
	/* Conexão com SQL */
	// -- Ambiente do SJT (Produção)
	//protected static String url = "jdbc:sqlserver://192.168.100.204:49996;databaseName=SAOJUDAS_JAVA";
	//protected static String userDB = "sa";
	//protected static String passDB = "#abc123#";
	// -- Acesso ao Banco da Alterdata (Produção)
	//public static String urlAlterdata = "jdbc:sqlserver://192.168.100.204:49996;databaseName=ALTERDATA";
	//public static String userDBAlterdata = "sa";
	//public static String passDBAlterdata = "#abc123#";
	
	// -- Ambiente Local (Testes de Novas Funcionalidades)
	public static String url = "jdbc:sqlserver://localhost;databaseName=ProgramaJava";
	public static String userDB = "sa";
	public static String passDB = "java";
	// -- Acesso ao Banco da Alterdata (Ambiente Local)
	public static String urlAlterdata = "jdbc:sqlserver://localhost;databaseName=ALTERDATA";
	public static String userDBAlterdata = "sa";
	public static String passDBAlterdata = "java";

	/*
	 * Método para acessarSistema
	 * 		recebe Usuário & Senha e faz a consulta ao DB
	 */
	public boolean acessarSistema(String Usuario, String Senha){
		String query = "SELECT Usuario,Senha FROM informacoesLogin WHERE Usuario='"+Usuario+"'";
		try{
			rs = Database.consultaDB(query);
		    while(rs.next()){
		    	// -- Debug
		    	//System.out.println("usuário: "+rs.getString("Usuario")+" | Senha: "+rs.getString("Senha"));
		    	if(rs.getString("Usuario").equals(Usuario)){
		    			if(rs.getString("Senha").equals(Senha)){
		    				return true;
		    			} else {
		    				JOptionPane.showMessageDialog(null, "A senha está errada.", "Erro", JOptionPane.ERROR_MESSAGE);
		    				return false;
		    			}
		    	}
			}
		    JOptionPane.showMessageDialog(null, "O usuário é inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		finally{
		      //closing ResultSet,PreparedStatement and Connection object
		}
		return false;
	}	
	
	
	public static ResultSet consultaDB(String Query){
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url,userDB,passDB);
			st = conn.createStatement();
			rs = st.executeQuery(Query);
			return rs;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}
	
	public static ResultSet consultaDB(String Query,boolean Alterdata){
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		if(Alterdata == true){
			conn = DriverManager.getConnection(urlAlterdata,userDBAlterdata,passDBAlterdata);
		}
			st = conn.createStatement();
			rs = st.executeQuery(Query);
			return rs;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}
	
	public static void updateDB(String Query){
		try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(url,userDB,passDB);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Query);
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}