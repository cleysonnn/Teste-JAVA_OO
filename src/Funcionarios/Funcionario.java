package Funcionarios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import Cargos.TipoCargo;
import Interfaces.Cargo;
import Vendas.Venda;

public class Funcionario {
	private String nome;
	private Cargo cargo;
	private int mesContratacao;
	private int anoContratacao;
	private List<Venda> listaDasVendas;
	
	
	
	
	
	
	public Funcionario(String nome, Cargo cargo, int mesContratacao, int anoContratacao) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.mesContratacao = mesContratacao;
		this.anoContratacao = anoContratacao;
	}
	
	
	
	public Funcionario(String nome, Cargo cargo, int mesContratacao, int anoContratacao, List<Venda> listaDasVendas) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.mesContratacao = mesContratacao;
		this.anoContratacao = anoContratacao;
		this.listaDasVendas = listaDasVendas;
	}


	



	public Funcionario() {
		super();
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public int getMesContratacao() {
		return mesContratacao;
	}
	public void setMesContratacao(int mesContratacao) {
		this.mesContratacao = mesContratacao;
	}
	public int getAnoContratacao() {
		return anoContratacao;
	}
	public void setAnoContratacao(int anoContratacao) {
		this.anoContratacao = anoContratacao;
	}


	public List<Venda> getListaDasVendas() {
		return listaDasVendas;
	}


	public void setListaDasVendas(List<Venda> listaDasVendas) {
		this.listaDasVendas = listaDasVendas;
	}

	
	

}
