package br.edu.unoesc.revisaoOO.modelo;

public class Conta {

	private Integer numero;
	private Cliente cliente;
	private Double saldo;

	// metodo vaxio,sem parametros de inicializaçõa
	public Conta() {
		saldo = 0.0;
	}

	// Metodo construtpr para criar objetos com valores inicializados
	public Conta(Integer numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente =cliente;
		this.saldo = 0.0;
	}

	// metodo depositar,recebe como parametro um valor e soma esse valor no
	// saldo
	public void depositar(Double valor) {
		this.saldo += valor;
	}

	public boolean sacar(Double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}
		return false;
	}

	public void transferir(Double valor, Conta destino) {
		this.sacar(valor);
		if (this.sacar(valor)) {
			destino.depositar(valor);
		}

	}

	// get and seteer
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
