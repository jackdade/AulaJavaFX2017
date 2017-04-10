package br.edu.unoesc.revisaoOO.modelo;

import java.time.LocalDate;

public class ContaMain {

	public static void main(String[] args) {
		Cliente cliente = new Cliente("jacson",LocalDate.of(1998, 05, 30), "107");
		Conta conta1 = new Conta (123, cliente);
		conta1.depositar(1500.0);
		conta1.sacar(200.0);
		System.out.printf("Conta %s saldo = %.2f",conta1.getCliente().getNome(),conta1.getSaldo());
		System.out.println();
		
		
		
		Cliente cliente2 = new Cliente("trindade",LocalDate.of(1998, 05, 30), "106");
		Conta conta2 =new Conta(123 ,cliente2);
		conta2.depositar(500.0);
		conta2.sacar(100.0);
		System.out.printf("Conta %s saldo= %.2f",conta2.getCliente().getNome(),conta2.getSaldo());
		System.out.println();
		
		
		conta1.transferir(20.0, conta2);
		System.out.printf("Conta %s saldo = %.2f",conta1.getCliente().getNome(),conta1.getSaldo());
		System.out.println();
		System.out.printf("Conta %s saldo= %.2f",conta2.getCliente().getNome(),conta2.getSaldo());
		System.out.println();
		System.out.println();
		System.out.printf("Conta %s saldo= %.2f",conta2.getCliente().getNome(),conta2.getSaldo());
		System.out.println();
		System.out.printf("Conta %s saldo=%.2f",conta1.getCliente().getNome(),conta1.getSaldo());
		
				
		
	}
}
