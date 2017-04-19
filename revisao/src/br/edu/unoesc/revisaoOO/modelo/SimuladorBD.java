package br.edu.unoesc.revisaoOO.modelo;

import java.util.ArrayList;
import java.util.List;

public class SimuladorBD {
	private static List<Agencia> agencias;
	private static List<Cliente> clientes;
	private static List<Conta> contas;
	static {
		agencias = new ArrayList<>();
		clientes = new ArrayList<>();
		contas = new ArrayList<>();

	}

	public static void insert(Agencia agencia) {
		agencias.add(agencia);
	}

	public static void remover(Agencia agencia) {
		agencias.remove(agencias);
	}

	public static List<Agencia> getAgencias() {
		return agencias;
	}

	public static void insert(Cliente cliente) {
		clientes.add(cliente);
	}

	public static void remover(Cliente cliente) {
		clientes.remove(cliente);
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void insert(Conta conta) {
		contas.add(conta);
	}

	public static void remover(Conta conta) {
		contas.remove(conta);
	}

	public static List<Conta> getContas() {
		return contas;
	}

}
