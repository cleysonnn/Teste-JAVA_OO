package FuncionariosTestes;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Cargos.Gerente;
import Cargos.Secretario;
import Cargos.Vendedor;
import Exceptions.VendaInexitenteException;
import Funcionarios.Funcionario;
import Funcionarios.FuncionarioService;
import Vendas.Venda;

class FuncionarioTest {
	
	FuncionarioService service = new FuncionarioService();
	
	List<Funcionario> FuncionariosList = new ArrayList<Funcionario>();
	
	@BeforeEach
	void init() {
		Secretario secretario = new Secretario(3000.00);
		Vendedor vendedor = new Vendedor(2000.00); 
		Gerente gerente = new Gerente(1000.00);
		
		
		
		List<Venda> vendasList = new ArrayList<Venda>();
		Venda venda1 = new Venda(12, 2021, 5200.00);
		Venda venda2 = new Venda(1, 2022, 4000.00);
		vendasList.add(venda1);
		vendasList.add(venda2);
		
		Funcionario funcionario1 = new Funcionario("Jorge Carvalho", secretario, 1, 2020); // 3000 + 1000 + ( 4000 * 0.2 ) = 4800
		Funcionario funcionario3 = new Funcionario("Ana Silva", vendedor, 12, 2020, vendasList); // 2000 + 1800 + ( ( 5200 * 0.3) ) = 5360
		Funcionario funcionario5 = new Funcionario("Juliana Alves", gerente, 7, 2020); // 1000 + 3000 = 4000
		
		List<Funcionario> FuncionariosList = new ArrayList<Funcionario>();
		FuncionariosList.add(funcionario1);
		FuncionariosList.add(funcionario3);
		FuncionariosList.add(funcionario5);
		
		this.FuncionariosList = FuncionariosList;
		System.out.println(FuncionariosList);
	}

	@Test
	void valorTotalPagoTeste() {

		
		Double ValorTotalPago =  service.getValorTotalPago(FuncionariosList, 12, 2021);

		assertEquals(14160, ValorTotalPago);
	}
	
	
	@Test
	void valorTotalPagoDeSalarioTeste() {
		
		
		Double ValorTotalPago =  service.getValorTotalPagoDeSalario(FuncionariosList, 12, 2021);

		assertEquals(11800, ValorTotalPago);
	}
	
	
	@Test
	void valorPagoBeneficioTeste() {
	
		
		
		Double ValorTotalPago =  service.getValorTotalDeBeneficio(FuncionariosList, 12, 2021);
		System.out.println(ValorTotalPago);
		assertEquals(2360, ValorTotalPago);
	}
	
	@Test
	void valorMaiorSalarioTeste() {
		
	
		Double ValorTotalPago =  service.getValorMaiorSalario(FuncionariosList, 12, 2021);
		System.out.println(ValorTotalPago);
		assertEquals(5360, ValorTotalPago);
	}
	
	@Test
	void nomeMaiorBeneficioTeste() {
		
		
		
		
		String ValorTotalPago =  service.getNomeMaiorBeneficio(FuncionariosList, 12, 2021);
		System.out.println(ValorTotalPago);
		assertEquals("Ana Silva", ValorTotalPago);
	}
	
	@Test
	void vendedorMaiorVendaMesTeste() throws VendaInexitenteException {
		
		Vendedor vendedor = new Vendedor(2000.00); 
		
		
		
		List<Venda> vendasList = new ArrayList<Venda>();
		Venda venda1 = new Venda(12, 2021, 5200.00);
		Venda venda2 = new Venda(1, 2022, 4000.00);
		vendasList.add(venda1);
		vendasList.add(venda2);
		
		List<Venda> vendasList2 = new ArrayList<Venda>();
		Venda venda3 = new Venda(12, 2021, 5300.00);
		Venda venda4 = new Venda(1, 2022, 4000.00);
		vendasList2.add(venda3);
		vendasList2.add(venda4);
		
		Funcionario funcionario3 = new Funcionario("Ana Silva", vendedor, 12, 2020, vendasList); //5200
		Funcionario funcionario4 = new Funcionario("cleyson", vendedor, 12, 2020, vendasList2); //5300

		
		List<Funcionario> FuncionariosList = new ArrayList<Funcionario>();
		FuncionariosList.add(funcionario3);
		FuncionariosList.add(funcionario4);
	
		
		
		
		Funcionario ValorTotalPago =  service.getVendedorMaiorVendaMes(FuncionariosList, 12, 2021);
		System.out.println(ValorTotalPago);
		assertEquals("cleyson", ValorTotalPago.getNome());
	}
	
	@Test
	void vendedorMaiorVendaMesExceptionTeste() throws VendaInexitenteException {
		

		Vendedor vendedor = new Vendedor(2000.00); 

		
		
		
		List<Venda> vendasList = new ArrayList<Venda>();
		Venda venda1 = new Venda(12, 2021, 5200.00);
		Venda venda2 = new Venda(1, 2022, 4000.00);
		vendasList.add(venda1);
		vendasList.add(venda2);
		
		List<Venda> vendasList2 = new ArrayList<Venda>();
		Venda venda3 = new Venda(12, 2021, 5300.00);
		Venda venda4 = new Venda(1, 2022, 4000.00);
		vendasList2.add(venda3);
		vendasList2.add(venda4);
		
		Funcionario funcionario3 = new Funcionario("Ana Silva", vendedor, 12, 2020, vendasList); 
		Funcionario funcionario4 = new Funcionario("cleyson", vendedor, 12, 2020, vendasList2); 

		
		List<Funcionario> FuncionariosList = new ArrayList<Funcionario>();
		FuncionariosList.add(funcionario3);
		FuncionariosList.add(funcionario4);
	
		
		
		
		
				
		assertThrows(VendaInexitenteException.class, () -> {
			Funcionario ValorTotalPago =  service.getVendedorMaiorVendaMes(FuncionariosList, 12, 2028);
			
		    });
	}
	

}
