package br.com.blueGarnet.users;


public class Administrador extends Usuario{

	public Administrador(String usuario, String senha) {
		super(usuario, senha);
		this.setNivelPermissao(NivelPermissao.Adm.getNumPermissao());
	}
	
	protected void criarUsuario(){
		
	}
	
	protected void editarUsuario(){
		
	}
	
	protected void gerarImportAlterdata(){
		
	}
	
	protected void alterarEmailClientes(){
		
	}
	
	protected void ajustarPercentuais(){
		
	}
	
	protected void cadastrarBanco(){
		
	}
	
	protected void cadastrarAgencia(){
		
	}
	
	protected void cadastrarAtividades(){
		
	}
	
	protected void cadastrarEstados(){
		
	}
	
	protected void cadastrarSM(){
		
	}
	
	protected void cadastrarSindicatos(){
		
	}
	
	protected void cadastrarClientePF(){
		
	}
	
	protected void editarBanco(){
		
	}
	
	protected void editarAgencia(){
		
	}
	
	protected void editarAtividades(){
		
	}
	
	protected void editarEstados(){
		
	}
	
	protected void editarSM(){
		
	}
	
	protected void editarSindicatos(){
		
	}
	
	protected void editarClientePF(){
		
	}

}
