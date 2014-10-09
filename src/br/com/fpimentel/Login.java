package br.com.fpimentel;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel � 2014 
*/

import javax.swing.JOptionPane;
import java.sql.*;

public class Login extends Janela{
	
	/*
	 * M�todo para verificarSenha
	 * 		recebe a Senha e procura ela no arquivo
	 */
	public boolean verificarSenha(String Usuario,String Senha){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		    Connection conn = DriverManager.getConnection(url,userDB,passDB);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    rs = stmt.executeQuery("SELECT * FROM informacoesLogin");
		    while(rs.next()){
		    	if(rs.getString("Usuario").equals(Usuario) && rs.getString("Senha").equals(Senha)){
		    		//System.out.println("A senha est� ok!");
		    		return true;
		    	}
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	/*
	 * M�todo para realizarLogin
	 * 		recebe o login e a senha e chama os m�todos
	 * 		verificarUsuario() e verificarSenha()
	 */
	public boolean realizarLogin(String Login, String Senha){
		if(verificarUsuario(Login) == true){
			if(verificarSenha(Login ,Senha) == true){
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "A senha est� errada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "O usu�rio � inv�lido.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
}