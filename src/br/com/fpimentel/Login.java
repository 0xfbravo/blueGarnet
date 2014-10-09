package br.com.fpimentel;

import javax.swing.JOptionPane;
import java.sql.*;

public class Login extends Janela{
	
	/*
	 * Método para verificarSenha
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
		    		//System.out.println("A senha está ok!");
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
	 * Método para realizarLogin
	 * 		recebe o login e a senha e chama os métodos
	 * 		verificarUsuario() e verificarSenha()
	 */
	public boolean realizarLogin(String Login, String Senha){
		if(verificarUsuario(Login) == true){
			if(verificarSenha(Login ,Senha) == true){
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "A senha está errada.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "O usuário é inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
}