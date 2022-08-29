package Cargos;

import Interfaces.Cargo;

public class Gerente implements Cargo {


	private double salario;
	private double bonusPorAno = 3000.00;

	private double beneficioPercent = 0.0;
	public TipoCargo tipoCargo = TipoCargo.GERENTE;

	

	public Gerente(Double salario) {
		super();
		this.salario = salario;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
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
