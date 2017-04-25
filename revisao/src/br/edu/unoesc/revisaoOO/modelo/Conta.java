package br.edu.unoesc.revisaoOO.modelo;

public class Conta {

	private String numero;
	private Cliente cliente;
	private Double saldo;
	private Double valor;
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	private Agencia agenciaPreferencial;
	private Cliente clientePreferencial;

	// metodo vaxio,sem parametros de inicializaçõa
	public Conta() {
		
	}

	// Metodo construtpr para criar objetos com valores inicializados
	public Conta(String numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}

	// metodo depositar,recebe como parametro um valor e soma esse valor no
	// saldo
	public void depositar(Double valor) {
		this.saldo += valor;
	}

	public boolean sacar(Double valor) {
		if (this.saldo >= valor) {
			this.setSaldo(this.getSaldo()-valor);
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
	

	public Double getSaldo() {
		return saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return this.numero + " " ;
	}

	public Agencia getAgenciaPreferencial() {
		return agenciaPreferencial;
	}

	public void setAgenciaPreferencial(Agencia agenciaPreferencial) {
		this.agenciaPreferencial = agenciaPreferencial;
	}

	public Cliente getClientePreferencial() {
		return clientePreferencial;
	}

	public void setClientePreferencial(Cliente clientePreferencial) {
		this.clientePreferencial = clientePreferencial;
	}
	
	
	
}
