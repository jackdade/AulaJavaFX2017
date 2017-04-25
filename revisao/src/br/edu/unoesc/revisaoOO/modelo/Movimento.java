package br.edu.unoesc.revisaoOO.modelo;

import java.util.ArrayList;
import java.util.List;

import application.MovimentoControle;
import javafx.scene.control.TextField;

public class Movimento {

		private String tipo;
		private Double valor;
		private Conta conta;
		
		public Double getValor() {
			return valor;
		}

		public void setValor(Double valor) {
			this.valor = valor;
		}

		
		public Conta getConta() {
			return conta;
		}

		public void setConta(Conta conta) {
			this.conta = conta;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		private List<Conta> contas;
		
		private MovimentoControle movimentos;
		public Double saldo;
		
		
		
		public Movimento(){
			this.contas = new ArrayList<>();
		}
		
		public void addConta(Conta conta){
			contas.add(conta);
		}
		
		public void calcular(){
			 saldo =0.0d;
			
			Double Valor =  Double.parseDouble(movimentos.tfValor.getText());
			
			for(Conta conta: contas){
				saldo += conta.getSaldo();
		
			}
			
			if(movimentos.rbDeposito.isSelected()){
				saldo = saldo + Valor;
			}
			
			if(movimentos.rbSaque.isSelected() && saldo <= 0){
				saldo = saldo - Valor;
			}
			
		//	movimentos.lbSaldo.setText(String.valueOf(saldo));
			//movimentos.setTfSaldo(String.valueOf(saldo));
		
		}

		public List<Conta> getContas() {
			return contas;
		}

		public void setContas(List<Conta> contas) {
			this.contas = contas;
		}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public MovimentoControle getMovimentos() {
			return movimentos;
		}

		public void setMovimentos(MovimentoControle movimentos) {
			this.movimentos = movimentos;
		}
		
		
		

	

	
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

