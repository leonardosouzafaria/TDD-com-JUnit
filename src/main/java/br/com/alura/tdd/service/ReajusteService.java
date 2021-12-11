package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.annotation.processing.RoundEnvironment;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void aplicarReajusteSalario(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal salarioAtual = funcionario.getSalario();
		
		if(desempenho.equals(Desempenho.A_DESEJAR)) {
			funcionario.setSalario(salarioAtual.add( salarioAtual.multiply(new BigDecimal("0.03")).setScale(2,RoundingMode.HALF_UP)));
		}
		
		if(desempenho.equals(Desempenho.BOM)) {
			funcionario.setSalario(salarioAtual.add( salarioAtual.multiply(new BigDecimal("0.15")).setScale(2,RoundingMode.HALF_UP)));
		}
		
		if(desempenho.equals(Desempenho.OTIMO)) {
			funcionario.setSalario(salarioAtual.add( salarioAtual.multiply(new BigDecimal("0.20")).setScale(2,RoundingMode.HALF_UP)));
		}
	}

}
