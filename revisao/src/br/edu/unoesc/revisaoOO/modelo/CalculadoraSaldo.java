package br.edu.unoesc.revisaoOO.modelo;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraSaldo {

	private List<Conta> contas;
	
	
	public CalculadoraSaldo(){
		this.contas = new ArrayList<>();
	}
	
	public void addConta(Conta conta){
		contas.add(conta);
	}
	
	public Double calcular(){
		double saldo =0.0;
		
		for(Conta conta: contas){
			saldo+= conta.getSaldo();
		}
		return saldo;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
