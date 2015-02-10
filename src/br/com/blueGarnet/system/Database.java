package br.com.blueGarnet.system;
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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Database{

	static Connection conn;
	static Statement st;
	static ResultSet rs;
	
	/* Conexão com SQL */
	// -- Ambiente do SJT (Produção)
	public static String url = "jdbc:sqlserver://192.168.100.204:49996;databaseName=BLUEGARNET";
	public static String userDB = "sa";
	public static String passDB = "#abc123#";
	// -- Acesso ao Banco da Alterdata (Produção)
	public static String urlAlterdata = "jdbc:sqlserver://192.168.100.200:49398;databaseName=ALTERDATA";
	// SQL RESERVA
	//public static String urlAlterdata = "jdbc:sqlserver://192.168.100.204:49996;databaseName=ALTERDATA";
	public static String userDBAlterdata = "sa";
	public static String passDBAlterdata = "#abc123#";
	
	// -- Ambiente do SJT (REMOTO)
	//public static String url = "jdbc:sqlserver://sjtsqlserver.dyndns.org:49996;databaseName=BLUEGARNET";
	//public static String userDB = "sa";
	//public static String passDB = "#abc123#";
	// -- Acesso ao Banco da Alterdata (REMOTO)
	//public static String urlAlterdata = "jdbc:sqlserver://sjtsqlserver.dyndns.org:49398;databaseName=ALTERDATA";
	// SQL RESERVA
	//public static String urlAlterdata = "jdbc:sqlserver://192.168.100.204:49996;databaseName=ALTERDATA";
	//public static String userDBAlterdata = "sa";
	//public static String passDBAlterdata = "#abc123#";
	
	public static ResultSet consultaDB(String Query,boolean Alterdata){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if(Alterdata == true) conn = DriverManager.getConnection(urlAlterdata,userDBAlterdata,passDBAlterdata);
			else conn = DriverManager.getConnection(url,userDB,passDB);
			st = conn.createStatement();
			rs = st.executeQuery(Query);
			return rs;
		}
		catch (Exception e){ JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); }
		return rs;
	}
	
	public static void updateDB(String Query){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(url,userDB,passDB);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(Query);
		}
		catch (Exception e){ JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); }
	}
}