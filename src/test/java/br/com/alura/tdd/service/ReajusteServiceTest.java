package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	@Test
	void reajusteDeveSerDe3PorcentoSeDesempenhoForADesejar() {
		
		ReajusteService service = new ReajusteService();
		
		Funcionario funcionario = new Funcionario("Adalberto", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.aplicarReajusteSalario(funcionario, Desempenho.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());	
	}
	
	@Test
	void reajusteDeveSerDe15PorcentoSeDesempenhoForBom() {
		
		ReajusteService service = new ReajusteService();
		
		Funcionario funcionario = new Funcionario("Adalberto", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.aplicarReajusteSalario(funcionario, Desempenho.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());	
	}
	
	@Test
	void reajusteDeveSerDe20PorcentoSeDesempenhoForOtimo() {
		
		ReajusteService service = new ReajusteService();
		
		Funcionario funcionario = new Funcionario("Adalberto", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.aplicarReajusteSalario(funcionario, Desempenho.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());	
	}
	
}
