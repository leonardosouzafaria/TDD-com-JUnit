package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		this.service = new BonusService();
	}

	@Test
	void lançaIllegalArgumentExceptionParaFuncionarioComSalarioMuitoAlto() {
		assertThrows(IllegalArgumentException.class, 
				()-> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
