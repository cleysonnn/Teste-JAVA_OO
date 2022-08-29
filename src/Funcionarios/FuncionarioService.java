package Funcionarios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import Cargos.TipoCargo;
import Exceptions.VendaInexitenteException;
import Vendas.Venda;

public class FuncionarioService {

	private List<Funcionario> funcionarioLista;

	public Double getValorTotalPago(List<Funcionario> listaDeFuncionarios, int mes, int ano) {

		funcionarioLista = new ArrayList<Funcionario>();
		Double valorTotal = 0.00;

		LocalDateTime dataSelecionada = LocalDateTime.of(ano, mes, 1, 0, 0, 0);

		for (Funcionario funcionario : listaDeFuncionarios) {

			LocalDateTime dataContratacao = LocalDateTime.of(funcionario.getAnoContratacao(),
					funcionario.getMesContratacao(), 1, 0, 0, 0);

			if (dataSelecionada.isAfter(dataContratacao) || dataContratacao.isEqual(dataSelecionada)) {

				Double salario = calcularSalario(funcionario, mes, ano);
				Double beneficio = 0.00;
				TipoCargo tipoCargo = funcionario.getCargo().getTipoCargo();
				switch (tipoCargo) {

				case VENDEDOR:
					Double vendaValor = getValorDaVendaDoMes(funcionario, mes, ano);
					beneficio = vendaValor * funcionario.getCargo().getBeneficioPercent();
					funcionarioLista.add(funcionario);
					valorTotal += salario + beneficio;
					break;
				case SECRETARIO:
					beneficio = salario * funcionario.getCargo().getBeneficioPercent();
					funcionarioLista.add(funcionario);
					valorTotal += salario + beneficio;
					break;

				case GERENTE:
					beneficio = 0.00;
					funcionarioLista.add(funcionario);
					valorTotal += salario + beneficio;

					break;

				}
			}

		}

		return valorTotal;

	}

	public Double getValorTotalPagoDeSalario(List<Funcionario> listaDeFuncionarios, int mes, int ano) {
		Double ValorPago = 0.00;
		LocalDateTime dataSelecionada = LocalDateTime.of(ano, mes, 1, 0, 0, 0);

		for (Funcionario funcionario : listaDeFuncionarios) {

			LocalDateTime dataContratacao = LocalDateTime.of(funcionario.getAnoContratacao(),
					funcionario.getMesContratacao(), 1, 0, 0, 0);

			if (dataSelecionada.isAfter(dataContratacao) || dataContratacao.isEqual(dataSelecionada)) {
				Double salario = calcularSalario(funcionario, mes, ano);

				ValorPago += salario;

			}

		}

		return ValorPago;

	}

	public Double getValorTotalDeBeneficio(List<Funcionario> listaDeFuncionarios, int mes, int ano) {

		funcionarioLista = new ArrayList<Funcionario>();
		Double valorBeneficio = 0.00;

		LocalDateTime dataSelecionada = LocalDateTime.of(ano, mes, 1, 0, 0, 0);

		for (Funcionario funcionario : listaDeFuncionarios) {

			LocalDateTime dataContratacao = LocalDateTime.of(funcionario.getAnoContratacao(),
					funcionario.getMesContratacao(), 1, 0, 0, 0);

			if (dataSelecionada.isAfter(dataContratacao) || dataContratacao.isEqual(dataSelecionada)) {

				Double beneficio = 0.00;
				TipoCargo tipoCargo = funcionario.getCargo().getTipoCargo();
				switch (tipoCargo) {

				case VENDEDOR:
					Double vendaValor = getValorDaVendaDoMes(funcionario, mes, ano);
					beneficio = vendaValor * funcionario.getCargo().getBeneficioPercent();
					funcionarioLista.add(funcionario);
					valorBeneficio += beneficio;
					break;
				case SECRETARIO:
					Double salario = calcularSalario(funcionario, mes, ano);
					beneficio = salario * funcionario.getCargo().getBeneficioPercent();
					funcionarioLista.add(funcionario);
					valorBeneficio += beneficio;
					break;

				}
			}

		}
		return valorBeneficio;
	}

	public Double getValorMaiorSalario(List<Funcionario> listaDeFuncionarios, int mes, int ano) {

		Double salarioMaior = 0.00;
		Double valorTotal = 0.00;

		LocalDateTime dataSelecionada = LocalDateTime.of(ano, mes, 1, 0, 0, 0);

		for (Funcionario funcionario : listaDeFuncionarios) {

			LocalDateTime dataContratacao = LocalDateTime.of(funcionario.getAnoContratacao(),
					funcionario.getMesContratacao(), 1, 0, 0, 0);

			if (dataSelecionada.isAfter(dataContratacao) || dataContratacao.isEqual(dataSelecionada)) {

				Double salario = calcularSalario(funcionario, mes, ano);
				Double beneficio = 0.00;
				TipoCargo tipoCargo = funcionario.getCargo().getTipoCargo();
				switch (tipoCargo) {

				case VENDEDOR:
					Double vendaValor = getValorDaVendaDoMes(funcionario, mes, ano);
					beneficio = vendaValor * funcionario.getCargo().getBeneficioPercent();

					valorTotal = salario + beneficio;
					if (valorTotal > salarioMaior) {
						salarioMaior = valorTotal;

					}
					break;
				case SECRETARIO:
					beneficio = salario * funcionario.getCargo().getBeneficioPercent();

					valorTotal = salario + beneficio;

					if (valorTotal > salarioMaior) {
						salarioMaior = valorTotal;

					}
					break;

				case GERENTE:
					beneficio = 0.00;

					valorTotal = salario + beneficio;
					if (valorTotal > salarioMaior) {
						salarioMaior = valorTotal;

					}

					break;

				}
			}
		}

		return salarioMaior;

	}

	public String getNomeMaiorBeneficio(List<Funcionario> listaDeFuncionarios, int mes, int ano) {

		Double MaiorBeneficio = 0.00;
		Funcionario maiorFuncionario = new Funcionario();

		LocalDateTime dataSelecionada = LocalDateTime.of(ano, mes, 1, 0, 0, 0);

		for (Funcionario funcionario : listaDeFuncionarios) {

			LocalDateTime dataContratacao = LocalDateTime.of(funcionario.getAnoContratacao(),
					funcionario.getMesContratacao(), 1, 0, 0, 0);

			if (dataSelecionada.isAfter(dataContratacao) || dataContratacao.isEqual(dataSelecionada)) {

				Double beneficio = 0.00;
				TipoCargo tipoCargo = funcionario.getCargo().getTipoCargo();
				switch (tipoCargo) {

				case VENDEDOR:
					Double vendaValor = getValorDaVendaDoMes(funcionario, mes, ano);
					beneficio = vendaValor * funcionario.getCargo().getBeneficioPercent();

					if (beneficio > MaiorBeneficio) {
						MaiorBeneficio = beneficio;
						maiorFuncionario = funcionario;

					}
					break;
				case SECRETARIO:
					Double salario = calcularSalario(funcionario, mes, ano);
					beneficio = salario * funcionario.getCargo().getBeneficioPercent();
					if (beneficio > MaiorBeneficio) {
						MaiorBeneficio = beneficio;
						maiorFuncionario = funcionario;
					}
					break;

				}

			}

		}

		return maiorFuncionario.getNome();

	}

	public Funcionario getVendedorMaiorVendaMes(List<Funcionario> listaDeFuncionarios, int mes, int ano)
			throws VendaInexitenteException {
		Double maiorVenda = 0.00;
		Funcionario FuncionarioMaior = null;

		for (Funcionario funcionario : listaDeFuncionarios) {
			
			Double venda = getValorDaVendaDoMes(funcionario, mes, ano);

			if (venda > maiorVenda) {
				maiorVenda = venda;
				FuncionarioMaior = funcionario;

			}

		}
		if (FuncionarioMaior == null) {
			throw new VendaInexitenteException("Não houve vendas neste mês");

		}

		return FuncionarioMaior;

	}

	private long getTempoDeTrabalho(int mesContratacao, int anoContratacao, int mes, int ano) {
		// define datas
		LocalDateTime dataContraracaoFuncionario = LocalDateTime.of(anoContratacao, mesContratacao, 1, 0, 0, 0);
		LocalDateTime dataSelecionada = LocalDateTime.of(ano, mes, 1, 0, 0, 0);

		// calcula diferença
		long anosTrabalhados = dataContraracaoFuncionario.until(dataSelecionada, ChronoUnit.YEARS);
		return anosTrabalhados;
	}
	

	private Double getValorDaVendaDoMes(Funcionario funcionario, int mes, int ano) {

		for (Venda venda : funcionario.getListaDasVendas()) {
			if (venda.getAno() == ano && venda.getMes() == mes) {
				return venda.getValorVenda();

			}

		}

		return 0.00;

	}

	private Double calcularSalario(Funcionario funcionario, int mes, int ano) {
		long anosTrabalhado = getTempoDeTrabalho(funcionario.getMesContratacao(), funcionario.getAnoContratacao(), mes,
				ano);
		Double salario = funcionario.getCargo().getSalario()
				+ (funcionario.getCargo().getBonusPorAno() * anosTrabalhado);
		return salario;

	}

}
