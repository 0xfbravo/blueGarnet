package br.com.blueGarnet.users;

import br.com.blueGarnet.modules.ContasPagar;
import br.com.blueGarnet.modules.ContasReceber;
import br.com.blueGarnet.modules.FluxoCaixa;

public class Financeiro extends Usuario{
	
	private ContasReceber contasReceber;
	private ContasPagar contasPagar;
	private FluxoCaixa fluxoCaixa;

	public Financeiro(String usuario, String senha) {
		super(usuario, senha);
		this.setNivelPermissao(NivelPermissao.Financeiro.getNumPermissao());
	}

	public ContasReceber getContasReceber() {
		return contasReceber;
	}

	public void setContasReceber(ContasReceber contasReceber) {
		this.contasReceber = contasReceber;
	}

	public ContasPagar getContasPagar() {
		return contasPagar;
	}

	public void setContasPagar(ContasPagar contasPagar) {
		this.contasPagar = contasPagar;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

}
