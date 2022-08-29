package Vendas;

import java.util.List;

import Funcionarios.Funcionario;

public class RegistroVenda {
	
	private Funcionario funcionario;
	private List<Venda> vendas;
	
	
	
	public RegistroVenda(Funcionario funcionario, List<Venda> vendas) {
		super();
		this.funcionario = funcionario;
		this.vendas = vendas; 
	}
	public Funcionario getFuncionario() { 
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	
	

}
