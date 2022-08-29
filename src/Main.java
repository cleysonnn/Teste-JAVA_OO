import java.util.ArrayList;
import java.util.List;

import Cargos.Gerente;
import Cargos.Secretario;
import Cargos.Vendedor;
import Exceptions.VendaInexitenteException;
import Funcionarios.Funcionario;
import Funcionarios.FuncionarioService;
import Vendas.Venda;

public class Main {

	public static void main(String args[]) {

		FuncionarioService funcionarioService = new FuncionarioService();

		Venda venda1 = new Venda(12, 2021, 5200.00);
		Venda venda2 = new Venda(1, 2022, 4000.00);
		Venda venda3 = new Venda(2, 2022, 4200.00);
		Venda venda4 = new Venda(3, 2022, 5850.00);
		Venda venda5 = new Venda(4, 2022, 7000.00);

		Venda venda6 = new Venda(12, 2021, 3400.00);
		Venda venda7 = new Venda(1, 2022, 7700.00);
		Venda venda8 = new Venda(2, 2022, 5000.00);
		Venda venda9 = new Venda(3, 2022, 5900.00);
		Venda venda10 = new Venda(4, 2022, 6500.00);

		List<Venda> vendasList1 = new ArrayList<Venda>();
		List<Venda> vendasList2 = new ArrayList<Venda>();

		vendasList1.add(venda1);
		vendasList1.add(venda2);
		vendasList1.add(venda3);
		vendasList1.add(venda4);
		vendasList1.add(venda5);

		vendasList2.add(venda6);
		vendasList2.add(venda7);
		vendasList2.add(venda8);
		vendasList2.add(venda9);
		vendasList2.add(venda10);

		Secretario secretario = new Secretario(7000.00);
		Vendedor vendedor = new Vendedor(12000.00); 
		Gerente gerente = new Gerente(20000.00);

		Funcionario funcionario1 = new Funcionario("Jorge Carvalho", secretario, 1, 2018);
		Funcionario funcionario2 = new Funcionario("Maria Souza", secretario, 12, 2015);
		Funcionario funcionario3 = new Funcionario("Ana Silva", vendedor, 12, 2021, vendasList1);
		Funcionario funcionario4 = new Funcionario("João Mendes", vendedor, 12, 2021, vendasList2);
		Funcionario funcionario5 = new Funcionario("Juliana Alves", gerente, 7, 2017);
		Funcionario funcionario6 = new Funcionario("Bento Albino", gerente, 3, 2014);

		List<Funcionario> FuncionariosList = new ArrayList<Funcionario>();
		FuncionariosList.add(funcionario1);
		FuncionariosList.add(funcionario2);
		FuncionariosList.add(funcionario3);
		FuncionariosList.add(funcionario4);
		FuncionariosList.add(funcionario5);
		FuncionariosList.add(funcionario6);
		

// 1 )Um método que receba uma lista de funcionários, mês e ano e retorne o valor total pago (salário e benefício) a esses funcionários no mês.
		Double valorPagoOsFuncionario = funcionarioService.getValorTotalPago(FuncionariosList, 12, 2015);
		System.out.println("Total pago aos funcionario foi: " + valorPagoOsFuncionario);

		// 2)  Um método que receba uma lista de funcionários, mês e ano e retorne o total
		// pago somente em salários no mês.

		Double valorPagoSalario = funcionarioService.getValorTotalPagoDeSalario(FuncionariosList, 12, 2015);
		System.out.println("Valor total dos funcionarios, em salario, foi: " + valorPagoSalario);
 
		//3) Um método que receba uma lista somente com os funcionários que recebem
		// benefícios, mês e ano e retorne o total pago em benefícios no mês

		Double valorPagoBeneficio = funcionarioService.getValorTotalDeBeneficio(FuncionariosList, 12, 2017);
		System.out.println("Valor total dos funcionarios, em beneficio, foi: " + valorPagoBeneficio);

		// 4)  Um método que receba uma lista de funcionários, mês e ano e retorne o que
		// recebeu o valor mais alto no mês

		Double MaiorSalario = funcionarioService.getValorMaiorSalario(FuncionariosList, 12, 2016);
		System.out.println("O maior salario foi: " + MaiorSalario);

		// 5) Um método que receba uma lista somente com os funcionários que recebem benefícios, mês e ano e retorne o nome do funcionário que recebeu o valor
		// mais alto em benefícios no mês.

		String nomeMaiorSalario = funcionarioService.getNomeMaiorBeneficio(FuncionariosList, 1, 2022);
		System.out.println("O maior beneficio foi o de: " + nomeMaiorSalario);

		// 6) Um método que receba uma lista de vendedores, mês e ano e retorne o que mais vendeu no mês

		List<Funcionario> VendedorLista = new ArrayList<Funcionario>();
		VendedorLista.add(funcionario3);
		VendedorLista.add(funcionario4);

		try {
		Funcionario FuncionarioQueMaisVendeuNoMes = funcionarioService.getVendedorMaiorVendaMes(VendedorLista, 12, 2021);
		System.out.println("O vendendor que mais vendeu foi: " + FuncionarioQueMaisVendeuNoMes.getNome());
		}catch (VendaInexitenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Funcionario FuncionarioQueMaisVendeuNoMes = funcionarioService.getVendedorMaiorVendaMes(VendedorLista, 12, 2028);
			System.out.println("O vendendor que mais vendeu foi: " + FuncionarioQueMaisVendeuNoMes.getNome());
			}catch (VendaInexitenteException e) {
				System.out.println(e.getMessage());
			}
	}

}
