package Cargos;

import java.util.List;

import Interfaces.Cargo;
import Vendas.Venda;

public class Vendedor implements Cargo {

	public TipoCargo tipoCargo = TipoCargo.VENDEDOR;
	private double salario;
	private double bonusPorAno = 1800.00;
	private double beneficioPercent = 0.30;
	private String oi ;


	public String getOi() {
		return oi;
	}

	public void setOi(String oi) {
		this.oi = oi;
	}

	
	
	
	public Vendedor(TipoCargo tipoCargo, double salario, double bonusPorAno, double beneficioPercent, String oi) {
		super();
		this.tipoCargo = tipoCargo;
		this.salario = salario;
		this.bonusPorAno = bonusPorAno;
		this.beneficioPercent = beneficioPercent;
		this.oi = oi;
	}

	public Vendedor(Double salario) {
		super();
		this.salario = salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public double getBonusPorAno() {
		return bonusPorAno;
	}

	public void setBonusPorAno(double bonusPorAno) {
		this.bonusPorAno = bonusPorAno;
	}

	public double getBeneficioPercent() {
		return beneficioPercent;
	}

	public void setBeneficioPercent(double beneficioPercent) {
		this.beneficioPercent = beneficioPercent;
	}

	public TipoCargo getTipoCargo() {
		return tipoCargo;
	}

	
	

}
