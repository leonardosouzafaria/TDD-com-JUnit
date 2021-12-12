package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.annotation.processing.RoundEnvironment;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void aplicarReajusteSalario(Funcionario funcionario, Desempenho desempenho) {
		
		BigDecimal percentualReajuste = desempenho.percentualReajuste();
		BigDecimal reajuste = funcionario.getSalario().multiply(percentualReajuste);
		
		funcionario.aplicarReajuste(reajuste);
	}

}
