package br.edu.unoesc.revisaoOO.modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.edu.unoesc.revisaoOO.dao.ManipuladorArquivo;

public class SimuladorBD {
	private static List<Agencia> agencias;
	private static List<Cliente> clientes;
	private static List<Conta> contas;
	private static List<Movimento> movimentos;
	private static ManipuladorArquivo manipuladorArquivo;
	static {
		agencias = new ArrayList<>();
		clientes = new ArrayList<>();
		contas = new ArrayList<>();
		movimentos = new ArrayList<>();
		manipuladorArquivo = new ManipuladorArquivo();

	}
public static void atualizarAgencias(){
	manipuladorArquivo.gravar(agencias,"agencia.ser");
}
	
	public static void insert(Agencia agencia) {
		agencias.add(agencia);
		atualizarAgencias();
		
		}

	public static void remover(Agencia agencia) {
		agencias.remove(agencia);
		atualizarAgencias();
		
	}

	public static List<Agencia> getAgencias() {
		agencias = manipuladorArquivo.recuperar("agencia.ser");
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

	public static void insert(Movimento movimento) {
		movimentos.add(movimento);
	}

	public static void remover(Movimento movimento) {
		movimentos.remove(movimento);
	}

	public static List<Movimento> getMovimentos() {
		return movimentos;
	}

	public static void gravarArquivo(List<? extends Serializable> dados, String pathFile) {
		try {
			//CRIA O ARQUIVO QUE SERÁ UTILIZADO
			FileOutputStream file = new FileOutputStream(pathFile);
			// cria um manipulador de arquivo
			ObjectOutputStream out = new ObjectOutputStream(file);
			//escreve os objetos dentro do arquivo
			out.writeObject(dados);
			//fecha o manupulador de arquivo
			out.close();
			//fecha o arquivo
			file.close();

		} catch (IOException e) {
			//imprime se deu erro.
			e.printStackTrace();
		}
	}

}