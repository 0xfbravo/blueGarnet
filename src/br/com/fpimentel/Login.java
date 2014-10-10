package br.com.fpimentel;
/*
	 _     _             _____                       _   
	| |   | |           / ____|                     | |  
	| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
	| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
	| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
	|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

	Fellipe Pimentel © 2014 
*/

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import br.com.fpimentel.db.Database;

public class Login{
	static ResultSet rs;
	static String queryLogin = "SELECT Usuario, Senha FROM informacoesLogin";
	
	
	/*
	 * Método para verificarLogin
	 * 		recebe o Usuário e procura ele no arquivo
	 */
	public static boolean verificarUsuario(String Usuario){
		try{
			rs = Database.consultaDB(queryLogin);
		    while(rs.next()){
		    	if(rs.getString("Usuario").equals(Usuario)){
		    		//System.out.println("O Usuário está ok!");
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
	 * Método para verificarSenha
	 * 		recebe a Senha e procura ela no arquivo
	 */
	public static boolean verificarSenha(String Usuario,String Senha){
		try{
			rs = Database.consultaDB(queryLogin);
		    while(rs.next()){
		    	if(rs.getString("Usuario").equals(Usuario) &&
		    			rs.getString("Senha").equals(Senha)){
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
}