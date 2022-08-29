package Cargos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import Interfaces.Cargo;

public class Secretario implements Cargo {

	private double salario;
	private double bonusPorAno = 1000.00;
	private double beneficioPercent = 0.20;
	public TipoCargo tipoCargo = TipoCargo.SECRETARIO;

	
	


	public Secretario(Double salario) {
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
