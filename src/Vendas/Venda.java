package Vendas;

public class Venda {
	
	private int mes;
	private int ano;
	private Double valorVenda;
	
	
	
	
	
	public Venda(int mes, int ano, Double valorVenda) {
		super();
		this.mes = mes;
		this.ano = ano;
		this.valorVenda = valorVenda;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	
	
	

}
