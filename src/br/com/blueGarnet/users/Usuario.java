package br.com.blueGarnet.users;
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

import br.com.blueGarnet.graphics.JanelaPrincipal;
import br.com.blueGarnet.system.Database;

public class Usuario {
	private int nivelPermissao;
	private String usuario;
	private String senha;
	
	public Usuario(String usuario, String senha){
		this.setUsuario(usuario);
		this.setSenha(senha);
	}

	
	/*
	 * ---------------------------------------------------------------
	 * 							acessarSistema()
	 * ---------------------------------------------------------------
	 *  Cria a Thread da SplashScreen e em conjunto utiliza o método
	 *  + autenticar()
	 *  	Caso resposta verdadeira, é criada a JanelaPrincipal
	 *  com o Menu contendo os módulos permitidos para o Usuário. 
	 * 
	 *					 @author Fellipe Pimentel
	 * 													www.fcode.co
	 * ---------------------------------------------------------------
	 */
	public boolean acessarSistema(){
		this.setNivelPermissao(verificarPermissao(this.getUsuario()));
		// Criação SplashScreen & seu Processo
		//new Thread(() -> new SplashBG()).start();
		if(autenticar()){ new JanelaPrincipal(this); return true;}
		return false;
	}
	
	/*
	 * ---------------------------------------------------------------
	 * 							autenticar()
	 * ---------------------------------------------------------------
	 *  Verifica se o usuário e senha são válidos, de acordo com o DB
	 * 
	 *					 @author Fellipe Pimentel
	 * 													www.fcode.co
	 * ---------------------------------------------------------------
	 */
	public boolean autenticar(){
		ResultSet rs;
		String query = "SELECT Usuario,Senha FROM bg_informacoesLogin WHERE Usuario='"+this.getUsuario()+"'";
		try{
			rs = Database.consultaDB(query,false);
		    if(rs.next()){
		    	if(rs.getString("Usuario").equals(this.getUsuario()))
		    		if(rs.getString("Senha").equals(this.getSenha())) return true;
		    		else
		    			JOptionPane.showMessageDialog(null, "A senha está errada.", "Erro", JOptionPane.ERROR_MESSAGE);
		    			return false;
		    } 
		    else JOptionPane.showMessageDialog(null, "O usuário é inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		catch (Exception e){ JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); }
		return false;
	}
	

	/*
	 * ---------------------------------------------------------------
	 * 					verificarPermissao(String usuario)
	 * ---------------------------------------------------------------
	 *  A partir do Usuário salvo é feita uma busca no banco de dados,
	 * 	verificando qual premissão o mesmo possui, e assim abrindo os
	 * 	repectivos módulos de sua permissão de acesso.
	 * 
	 *					 @author Fellipe Pimentel
	 * 													www.fcode.co
	 * ---------------------------------------------------------------
	 */
	public int verificarPermissao(String user){
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(Database.url,Database.userDB,Database.passDB);
		    Statement stmt = conn.createStatement();
		    ResultSet rs;
		    rs = stmt.executeQuery("SELECT Permissao FROM bg_informacoesLogin WHERE Usuario='"+user+"'");
		    if(rs.next()) return rs.getInt("Permissao");
		}
		catch (Exception e){ JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); }
		return 0;
	}

	
	public int getNivelPermissao() {
		return nivelPermissao;
	}
	public void setNivelPermissao(int nivelPermissao) {
		this.nivelPermissao = nivelPermissao;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
